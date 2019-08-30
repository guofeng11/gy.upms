package com.gy.upms.servicesimp;

import com.gy.upms.component.JacksonUtils;
import com.gy.upms.component.MessageUtils;
import com.gy.upms.dao.AppAuthorizedMapper;
import com.gy.upms.dao.ApplicationMapper;
import com.gy.upms.dto.OutPage;
import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.application.*;
import com.gy.upms.entity.AppAuthorized;
import com.gy.upms.entity.Application;
import com.gy.upms.entity.Pageing;
import com.gy.upms.services.ApplicatinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Auther: guofeng
 * @Date: 2019/6/13 14:31
 * @Description:
 */
@RestController
@RequestMapping("/app")
public class ApplicationServiceImp implements ApplicatinService {

    private final static Logger log = LoggerFactory.getLogger(ApplicationServiceImp.class);

    @Autowired
    private MessageUtils messageUtils;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private AppAuthorizedMapper appAuthorizedMapper;


    @PostMapping("/add")
    @Override
    public ResultMessage<String> add(@RequestBody  AddApp addApp) {
        ResultMessage<String> resultMessage = null;
        try {
            if (addApp == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();

            String appToken=addApp.getAppToken();
            if (StringUtils.isEmpty(appToken)){
                appToken= UUID.randomUUID().toString();
            }
            Application application=new Application();
            application.setAppName(addApp.getAppName());
            application.setAppNameEn(addApp.getAppNameEn());
            application.setAppToken(addApp.getAppToken());
            application.setIpv4(addApp.getIpv4());
            application.setStatus(ApplicationEnum.ApplicationStatus.NORMAL.getStatus());
            application.setRemark(addApp.getRemark());
            application.setCreaterId(addApp.getUserSecurity().getId());
            application.setCreater(addApp.getCreater());
            application.setCreateTime(nowTime);

            int row = applicationMapper.insert(application);
            if (row > 0) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.SUCCESS);
            } else {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(addApp);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }

    @PostMapping("/search")
    @Override
    public ResultMessage<PageResult<SearchAppResult>> search(@RequestBody  SearchApp searchApp) {
        ResultMessage<PageResult<SearchAppResult>> resultMessage = null;
        try {
            if (searchApp == null) {
                resultMessage = new ResultMessage<PageResult<SearchAppResult>>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"), null);
                return resultMessage;
            }

            Application application = new Application();
            application.setAppName(searchApp.getAppName());
            application.setAppToken(searchApp.getAppToken());
            application.setIpv4(searchApp.getIpv4());
            application.setStatus(searchApp.getStatus());

            int offset = (searchApp.getPage().getCurrentPage() - 1) * searchApp.getPage().getPageRows();
            Pageing<Application> applicationPageing = applicationMapper.selectByPage(application, offset, searchApp.getPage().getPageRows());
            OutPage outPage = new OutPage();
            outPage.setTotalRows(applicationPageing.getRows().getTotalRows());
            outPage.setTotalPage(applicationPageing.getRows().getTotalPage());
            List<SearchAppResult> searchAppResultList = applicationPageing.getDataList().stream()
                    .map(c -> new SearchAppResult(c.getId(), c.getAppName(), c.getAppNameEn(), c.getAppToken(), c.getIpv4(), c.getStatus(), c.getRemark()))
                    .collect(Collectors.toList());
            PageResult<SearchAppResult> pageResult = new PageResult<SearchAppResult>();
            pageResult.setPage(outPage);
            pageResult.setData(searchAppResultList);

            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS, pageResult);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(searchApp);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"), null);
            return resultMessage;
        }
    }

    @PostMapping("/update")
    @Override
    public ResultMessage<String> update(@RequestBody  UpdateApp updateApp) {
        ResultMessage<String> resultMessage = null;
        try {
            if (updateApp == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            Application application=applicationMapper.selectByPrimaryKey(updateApp.getAppId());
            if(application==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.NOTEXISTS", "APP.FIELD.ID");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            LocalDateTime nowTime = LocalDateTime.now();
            application.setId(updateApp.getAppId());
            application.setAppName(updateApp.getAppName());
            application.setAppNameEn(updateApp.getAppNameEn());
            application.setAppToken(updateApp.getAppToken());
            application.setIpv4(updateApp.getIpv4());
            application.setRemark(updateApp.getRemark());
            application.setCreaterId(updateApp.getUserSecurity().getId());
            application.setCreater(updateApp.getCreater());
            application.setCreateTime(nowTime);

            int row = applicationMapper.updateByPrimaryKeySelective(application);
            if (row > 0) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.SUCCESS);
            } else {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(updateApp);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }

    @PostMapping("/delete")
    @Override
    public ResultMessage<String> delete(@RequestBody  DeleteApp deleteApp) {
        ResultMessage<String> resultMessage = null;
        try {
            if (deleteApp == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            Application application=applicationMapper.selectByPrimaryKey(deleteApp.getId());
            if(application==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.NOTEXISTS", "APP.FIELD.ID");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }

            int row = applicationMapper.deleteByPrimaryKey(deleteApp.getId());
            if (row > 0) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.SUCCESS);
            } else {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(deleteApp);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }

    @PostMapping("/detail")
    @Override
    public ResultMessage<DetailAppResult> detail(@RequestBody DetailApp detailApp) {
        ResultMessage<DetailAppResult> resultMessage = null;
        try {
            if (detailApp == null) {
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            Application application=applicationMapper.selectByPrimaryKey(detailApp.getId());
            if(application==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.NOTEXISTS", "APP.FIELD.ID");
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            DetailAppResult detailAppResult=new DetailAppResult();
            detailAppResult.setId(application.getId());
            detailAppResult.setAppName(application.getAppName());
            detailAppResult.setAppNameEn(application.getAppNameEn());
            detailAppResult.setAppToken(application.getAppToken());
            detailAppResult.setIpv4(application.getIpv4());
            detailAppResult.setStatus(application.getStatus());
            detailAppResult.setRemark(application.getRemark());
            detailAppResult.setCreaterId(application.getCreaterId());
            detailAppResult.setCreater(application.getCreater());
            detailAppResult.setCreateTime(application.getCreateTime().format(DateTimeFormatter.ofPattern(messageUtils.getMessage("BASE.FORMATE.DATETIME"))));

            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS,detailAppResult);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(detailApp);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }

    @PostMapping("/auth/set")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMessage<String> setAuth(@RequestBody  SetApp setApp) {
        ResultMessage<String> resultMessage = null;
        try {
            if (setApp == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }


            Application application=applicationMapper.selectByPrimaryKey(setApp.getAppId());
            if(application==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.NOTEXISTS", "APP.FIELD.ID");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            Application authApplication=applicationMapper.selectByPrimaryKey(setApp.getAuthAppId());
            if(application==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.NOTEXISTS", "APP.FIELD.AUTH.ID");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }

            //查询授权的权限
            List<AppAuthorized> appAuthorizeds=appAuthorizedMapper.select(setApp.getAppId(),setApp.getAuthAppId());

            if (setApp.getPermIds()==null ||setApp.getPermIds().size()==0){
               appAuthorizedMapper.delete(appAuthorizeds.stream().map(c->c.getId()).collect(Collectors.toList()));
            }else {
                //删除数据，参数中不在数据库的授权
              List<String> deleteIds=  appAuthorizeds.stream()
                      .filter(au->!setApp.getPermIds().contains(au.getPermId())||au.getPermId()==null )
                      .map(au->au.getId()).collect(Collectors.toList());
              appAuthorizedMapper.delete(deleteIds)  ;
              //新增数据，数据库不在参数中的授权
                List<Integer> authAppPerms=appAuthorizeds.stream().map(a->a.getPermId()).collect(Collectors.toList());
                List<AppAuthorized> inserAppAuths= setApp.getPermIds().stream().distinct().filter(a->!authAppPerms.contains(a))
                        .map(a->new AppAuthorized(setApp.getAppId(),setApp.getAuthAppId(),a))
                        .collect(Collectors.toList());
                appAuthorizedMapper.bulkInsert(inserAppAuths);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(setApp);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }

    @PostMapping("/auth/get")
    @Override
    public ResultMessage<List<GetAppResult>> getAuth(@RequestBody GetApp getApp) {
        ResultMessage<List<GetAppResult>> resultMessage = null;
        try {
            if (getApp == null) {
                resultMessage = new ResultMessage<List<GetAppResult>>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            //查询授权的权限
            List<AppAuthorized> appAuthorizeds=appAuthorizedMapper.select(getApp.getAppId(),getApp.getAuthAppId());

            GetAppResult getAppResult=new GetAppResult();

            List<GetAppResult> appResults=appAuthorizeds.stream()
                    .map(p-> new GetAppResult(p.getAppId(),p.getAuthAppId(),p.getPermId()))
                    .collect(Collectors.toList());


            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS,appResults);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(getApp);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
}
