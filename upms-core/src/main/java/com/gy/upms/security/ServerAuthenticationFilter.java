package com.gy.upms.security;


import com.gy.upms.ApplicationProperties;
import com.gy.upms.component.JacksonUtils;
import com.gy.upms.component.MessageUtils;
import com.gy.upms.component.VerifyUtils;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.entity.AppAndAuthInfo;
import com.gy.upms.entity.AppAuthInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.FilterConfig;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Auther: guofeng
 * @Date: 2019/5/16 13:34
 * @Description:
 */
@Component
public class ServerAuthenticationFilter implements Filter {

    private  final  static Logger log= LoggerFactory.getLogger(ServerAuthenticationFilter.class);

    @Autowired
    private MessageUtils messageUtils;

    @Override
    public void  init(FilterConfig filterConfig) throws ServletException {
    }
        @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

            String requestUrl = httpRequest.getRequestURI().toLowerCase();

            if (requestUrl.equals("/favicon.ico") || requestUrl.equals("/")) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            // 获取服务器token

            String authorizationToken = httpRequest.getHeader("Authorization");

            if (authorizationToken == null || authorizationToken.isEmpty()) {
                sendError(httpResponse, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.NOAUTHORIZATION"));
                return;
            }
            log.debug("应用授权：{}", authorizationToken);
            // 验证
            AppAndAuthInfo appAuthInfos = VerifyUtils.getAppAuth(ApplicationProperties.getAppToken());
            if (appAuthInfos == null) {
                sendError(httpResponse, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.NOAUTHORIZATION"));
                return;
            } else {
                List<AppAuthInfo> authInfos = appAuthInfos.getAuthInfos();
                boolean authTrue = authInfos.stream().anyMatch(c -> c.getAppToken().toLowerCase().equals(authorizationToken.toLowerCase()));
                if (!authTrue) {
                    sendError(httpResponse, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.NOAUTHORIZATION"));
                    log.debug("应用没有授权：{}", authorizationToken);
                    return;
                }
                //判断API权限
                boolean authPermTrue = authInfos.stream().anyMatch(c ->c.getPermUrl()!=null && c.getPermUrl().toLowerCase().startsWith(requestUrl));
                if (!ApplicationProperties.getSetPermDefault() && !authPermTrue) {
                    sendError(httpResponse, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.NOAUTHORIZATION"));
                    log.debug("应用API没有授权：{}", authorizationToken);
                    return;
                }
            }
            //post 封装流
            // 防止流读取一次后就没有了, 所以需要将流继续写出去
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
            filterChain.doFilter(requestWrapper, servletResponse);


        }
    /**
     * 输出信息
     * @param httpResponse
     * @param status 状态码
     * @param message 状态信息
     * @throws IOException
     */
    private void sendError(HttpServletResponse httpResponse,int status,String message) throws IOException {
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(status);
        ResultMessage<String> resultMessage=new ResultMessage<String>(ResultMessage.ResultType.UNAUTHORIZED,message,null);
        PrintWriter out = httpResponse.getWriter();
        out.write(JacksonUtils.obj2json(resultMessage));
    }
}
