package com.gy.upms.servicesimp.duplexImp;

import com.gy.upms.dto.application.AppRegisterResult;
import com.gy.upms.services.duplex.AppService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: guofeng
 * @Date: 2019/6/28 10:14
 * @Description:
 */
@Service(version = "${duplex.service.version}")
public class appServiceImp implements AppService {

    private final static Logger log= LoggerFactory.getLogger(appServiceImp.class);

    @Override
    public AppRegisterResult register(String appToken) {
        log.debug("test");
        AppRegisterResult appRegisterResult=null;
        try {
            appRegisterResult =new AppRegisterResult(1,"test","t","xxkssss","1.1.1.1");
            return appRegisterResult;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public void destroy(String appToken) {

    }

    @Override
    public void getAppPerms(String appToken) {

    }
}
