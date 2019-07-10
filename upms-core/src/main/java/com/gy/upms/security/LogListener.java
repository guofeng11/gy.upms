package com.gy.upms.security;


import com.gy.upms.component.MessageUtils;
import com.gy.upms.dao.ServerLogMapper;
import com.gy.upms.entity.ServerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


/**
 * @Auther: guofeng
 * @Date: 2019/5/28 14:41
 * @Description:
 */
@Component
public class LogListener implements ServletRequestListener {

    private  final  static Logger log= LoggerFactory.getLogger(LogListener.class);

    @Autowired
    private ServerLogMapper serverLogMapper;
    @Autowired
    private MessageUtils messageUtils;

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        try {
            HttpServletRequest request=(HttpServletRequest) sre.getServletRequest();
            ServerLog serverLog=new ServerLog();

            serverLog.setHttpMethod(request.getMethod());
            serverLog.setStateTime(LocalDateTime.now());
            serverLog.setGateWay(request.getLocalAddr()+":"+request.getLocalPort());//服务地址
            serverLog.setRemoteAddr(request.getRemoteAddr()+":"+request.getRemotePort());
            serverLog.setAddress(request.getRequestURI());//请求地址

            serverLogMapper.insert(serverLog);
        }catch (Exception ex){
            log.error(messageUtils.getMessage("BASE.EXCEPTION.LISTENER"), ex);
        }

    }
}
