package com.gy.upms.security;

import com.gy.upms.ApplicationProperties;
import com.gy.upms.component.JacksonUtils;
import com.gy.upms.component.MessageUtils;
import com.gy.upms.component.VerifyUtils;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.TrueFalse;
import com.gy.upms.entity.Permission;
import com.gy.upms.entity.UserLoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Auther: guofeng
 * @Date: 2019/5/16 13:35
 * @Description:对访问请求的服务器 验证
 */
@Component
public class UserAuthenticationInterceptor extends HandlerInterceptorAdapter {

    private final static Logger log = LoggerFactory.getLogger(UserAuthenticationInterceptor.class);


    @Autowired
    private MessageUtils messageUtils;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            //根据应用权限配置 判断是否要登录
            BodyReaderHttpServletRequestWrapper bodyRequest = new BodyReaderHttpServletRequestWrapper(request);
            String url = bodyRequest.getRequestURI().toLowerCase();

            List<Permission> appPerms = VerifyUtils.getAppPerm(ApplicationProperties.getAppToken());
            Optional<Permission> optionalPermission = appPerms.stream().filter(c -> c.getPermUrl().toLowerCase().equals(url)).findAny();

            //权限中不存在访问的url 默认允许访问
            if (!optionalPermission.isPresent()) {
                if (ApplicationProperties.getSetPermDefault() ){
                    return  true;
                }
                else {
                    sendError(response, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.ERROR.HTTPMETHOD"));
                    return false;
                }
            } else {
                Permission permUrl = optionalPermission.get();
                String requestMethod = request.getMethod().toUpperCase();
                //请求http method 与app perm 设置相同
                if (permUrl.getHttpMethod().toUpperCase().contains(requestMethod)) {
                    //判断是否需要登录
                    if (TrueFalse.valueOf(permUrl.getIsLogin()).getBooleanValue() ) {

                        Integer userId = null;
                        String token = null;
                        switch (requestMethod) {
                            case "POST":
                                Map<String, Object> params = JacksonUtils.json2map(bodyRequest.getBodyString());
                                if (params == null) {
                                    sendError(response, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.ERROR.PARAMS"));
                                    return false;
                                }
                                //权限授权节点 "userSecurity"
                                Map<String, Object> userSecurity = (Map<String, Object>) params.get("userSecurity");
                                if (userSecurity == null) {
                                    sendError(response, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.ERROR.PARAMS"));
                                    return false;
                                }
                                userId = (Integer) userSecurity.get("id");
                                token = (String) userSecurity.get("token");
                                break;
                            case "GET":
                                userId = Integer.parseInt(request.getParameter("id"));
                                token = request.getParameter("token");
                                break;
                            default:
                                return false;
                        }

                        //用户编号为空
                        if (userId == null || userId < 1) {
                            sendError(response, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.ERROR.PARAMS"));
                            return false;
                        }
                        //用户令牌为空
                        if (token == null || token.isEmpty()) {
                            sendError(response, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.ERROR.PARAMS"));
                            return false;
                        }
                        UserLoginInfo userLoginInfo = VerifyUtils.getUserLogin(userId, LocalDateTime.now());
                        if (userLoginInfo == null) {
                            sendError(response, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.LOGIN.EXPRIED"));
                            return false;
                        }
                        //判断令牌是否正确
                        if (userLoginInfo.getToken().toLowerCase().equals(token.toLowerCase())) {
                            sendError(response, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.LOGIN.EXPRIED"));
                            return false;
                        }
                        else{
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else {
                    sendError(response, HttpServletResponse.SC_UNAUTHORIZED, messageUtils.getMessage("BASE.ERROR.HTTPMETHOD"));
                    return false;
                }
            }
        } catch (Exception ex) {
            log.error(messageUtils.getMessage("BASE.EXCEPTION.USER.SECURITY"), ex);
            sendError(response, HttpServletResponse.SC_EXPECTATION_FAILED, messageUtils.getMessage("BASE.EXCEPTION.USER.SECURITY"));
            return false;
        }
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
