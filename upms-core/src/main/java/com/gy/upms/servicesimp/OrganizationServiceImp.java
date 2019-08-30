package com.gy.upms.servicesimp;

import com.gy.upms.component.JacksonUtils;
import com.gy.upms.component.MessageUtils;
import com.gy.upms.dao.OrganizationMapper;
import com.gy.upms.dao.UserOrgMapper;
import com.gy.upms.dto.organization.*;
import com.gy.upms.dto.OutPage;
import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.entity.Organization;
import com.gy.upms.entity.Pageing;
import com.gy.upms.entity.UserOrg;
import com.gy.upms.services.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
 * @ClassName OrganizationServiceImp.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月26日 14:22:00
 */
@RestController
@RequestMapping("/org")
public class OrganizationServiceImp implements OrganizationService {

    private final static Logger log = LoggerFactory.getLogger(OrganizationServiceImp.class);

    @Autowired
    private MessageUtils messageUtils;
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private UserOrgMapper userOrgMapper;
    private SetOrgUser.UserReadWrite d;

    @PostMapping("/add")
    @Override
    public ResultMessage<String> add(@RequestBody AddOrg data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();
            Organization searchCondition=new Organization();
            searchCondition.setOrgCode(data.getOrgCode());
            int isEexists =organizationMapper.select(searchCondition).size();
            if (isEexists>0){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "ORG.FIELD.CODE");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            Organization insertOrg=new Organization();
            insertOrg.setOrgCode(data.getOrgCode());
            insertOrg.setOrgNameCn(data.getOrgNameCn());
            insertOrg.setOrgNameEn(data.getOrgNameEn());
            insertOrg.setAbbrNameCn(data.getAbbrNameCn());
            insertOrg.setAbbrNameEn(data.getAbbrNameEn());
            insertOrg.setLevel(data.getLevel());
            insertOrg.setOrgType(data.getOrgType());
            insertOrg.setRemark(data.getRemark());
            insertOrg.setCreaterId(data.getUserSecurity().getId());
            insertOrg.setCreater(data.getCreater());
            insertOrg.setCreateTime(nowTime);

            int row = organizationMapper.insert(insertOrg);
            if (row > 0) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.SUCCESS);
            } else {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/edit")
    @Override
    public ResultMessage<String> edit(@RequestBody EditOrg data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();
            Organization searchCondition=new Organization();
            searchCondition.setOrgId(data.getId());
            int isEexists =organizationMapper.select(searchCondition).size();
            if (isEexists>0){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "ORG.FIELD.ID");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            Organization updateOrg=new Organization();
            updateOrg.setOrgId(data.getId());
            updateOrg.setOrgCode(data.getOrgCode());
            updateOrg.setOrgNameCn(data.getOrgNameCn());
            updateOrg.setOrgNameEn(data.getOrgNameEn());
            updateOrg.setAbbrNameCn(data.getAbbrNameCn());
            updateOrg.setAbbrNameEn(data.getAbbrNameEn());
            updateOrg.setOrgType(data.getOrgType());
            updateOrg.setRemark(data.getRemark());
            updateOrg.setCreaterId(data.getUserSecurity().getId());
            updateOrg.setCreater(data.getCreater());
            updateOrg.setCreateTime(nowTime);

            int row = organizationMapper.updateByPrimaryKeyWithBLOBs(updateOrg);
            if (row > 0) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.SUCCESS);
            } else {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }


    @PostMapping("/search")
    @Override
    public ResultMessage<PageResult<SearchOrgResult>> search(@RequestBody SeachOrg data) {
        ResultMessage<PageResult<SearchOrgResult>> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<PageResult<SearchOrgResult>>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"), null);
                return resultMessage;
            }

            Organization organization = new Organization();
            organization.setOrgCode(data.getOrgCode());
            organization.setOrgNameCn(data.getOrgName());
            organization.setOrgType(data.getOrgType());
            organization.setLevel(data.getLevel());

            int offset = (data.getPage().getCurrentPage() - 1) * data.getPage().getPageRows();
            Pageing<Organization> organizationPageing = organizationMapper.selectByPage(organization, offset, data.getPage().getPageRows());
            OutPage outPage = new OutPage();
            outPage.setTotalRows(organizationPageing.getRows().getTotalRows());
            outPage.setTotalPage(organizationPageing.getRows().getTotalPage());
            List<SearchOrgResult> searchResultList = organizationPageing.getDataList().stream()
                    .map(c -> new SearchOrgResult(c.getOrgId(), c.getOrgCode()
                            , c.getOrgNameCn(), c.getOrgNameEn(), c.getAbbrNameCn(), c.getAbbrNameEn(), c.getOrgType(),c.getLevel(),c.getParentId()))
                    .collect(Collectors.toList());
            PageResult<SearchOrgResult> pageResult = new PageResult<SearchOrgResult>();
            pageResult.setPage(outPage);
            pageResult.setData(searchResultList);

            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS, pageResult);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"), null);
            return resultMessage;
        }
    }
    @PostMapping("/delete")
    @Override
    public ResultMessage<String> delete(@RequestBody DeleteOrg data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }


            int row = organizationMapper.deleteByPrimaryKey(data.getId());
            if (row > 0) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.SUCCESS);
            } else {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/detail")
    @Override
    public ResultMessage<DetailOrgResult> detail(@RequestBody DetailOrg data) {
        ResultMessage<DetailOrgResult> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }
            Organization organizationrg =organizationMapper.selectByPrimaryKey(data.getId());
            if (organizationrg==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "ORG.FIELD.ID");
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            DetailOrgResult detailResult=new DetailOrgResult();
            detailResult.setOrgId(data.getId());
            detailResult.setOrgCode(organizationrg.getOrgCode());
            detailResult.setOrgNameCn(organizationrg.getOrgNameCn());
            detailResult.setOrgNameEn(organizationrg.getOrgNameEn());
            detailResult.setAbbrNameCn(organizationrg.getAbbrNameCn());
            detailResult.setAbbrNameEn(organizationrg.getAbbrNameEn());
            detailResult.setOrgType(organizationrg.getOrgType());
            detailResult.setRemark(organizationrg.getRemark());
            detailResult.setCreateId(organizationrg.getCreaterId());
            detailResult.setCreater(organizationrg.getCreater());
            detailResult.setCreateTime(organizationrg.getCreateTime().format(DateTimeFormatter.ofPattern(messageUtils.getMessage("BASE.FORMATE.DATETIME"))));
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS,detailResult);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/user/set")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMessage<String> setOrgUser(@RequestBody SetOrgUser data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            Organization organization=organizationMapper.selectByPrimaryKey(data.getOrgId());
            if(organization==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "ORG.FIELD.CODE");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }

            if (data.getUserReadWrite()==null ||data.getUserReadWrite().size()==0){
                userOrgMapper.delete(data.getOrgId(),null);
            }else {
                //查询授权的权限 去掉本身的组织
                List<UserOrg> userOrgs = userOrgMapper.selectByOrgId(data.getOrgId())
                        .stream().filter(uo->uo.getId()!=null||!uo.getId().isEmpty())
                        .collect(Collectors.toList());
                if (userOrgs == null || userOrgs.size() == 0) {
                    List<UserOrg> inserOrgUser = data.getUserReadWrite().stream()
                            .map(d -> new UserOrg(UUID.randomUUID().toString(), d.getUserId(), data.getOrgId(), d.getIsRead(), d.getIsWrite()))
                            .collect(Collectors.toList());
                    userOrgMapper.bulkInsert(inserOrgUser);
                } else {
                    //删除数据，参数中不在数据库的授权
                    List<String> deleteIds = userOrgs.stream()
                            .filter(uo -> !data.getUserReadWrite().stream()
                                    .anyMatch(d -> d.getUserId() == uo.getUserId() && d.getIsRead() == uo.getIsRead() && d.getIsWrite() == uo.getIsWrite()))
                            .map(au -> au.getId()).collect(Collectors.toList());
                    userOrgMapper.bulkDelete(deleteIds);
                    //新增数据，数据库不在参数中的授权
                    List<UserOrg> inserOrgUser = data.getUserReadWrite().stream()
                            .filter(d -> !userOrgs.stream().anyMatch(uo -> d.getUserId() == uo.getUserId() && d.getIsRead() == uo.getIsRead() && d.getIsWrite() == uo.getIsWrite()))
                            .map(a -> new UserOrg(UUID.randomUUID().toString(), d.getUserId(), data.getOrgId(), d.getIsRead(), d.getIsWrite()))
                            .collect(Collectors.toList());
                    userOrgMapper.bulkInsert(inserOrgUser);
                    //更新数据
                    List<UserOrg> updateOrgUser = userOrgs.stream()
                            .filter(uo-> data.getUserReadWrite().stream().anyMatch(d -> d.getUserId() == uo.getUserId() &&( d.getIsRead() != uo.getIsRead() || d.getIsWrite() != uo.getIsWrite())))
                            .map(a -> new UserOrg(a.getId(),a.getUserId(), a.getOrgId(), d.getIsRead(), d.getIsWrite()))
                            .collect(Collectors.toList());
                    userOrgMapper.bulkUpdate(updateOrgUser);
                }
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/user/get")
    @Override
    public ResultMessage<List<GetOrgUserResult>> getOrgUser(@RequestBody GetOrgUser data) {
        ResultMessage<List<GetOrgUserResult>> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<List<GetOrgUserResult>>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            //查询授权的权限
            List<UserOrg> userOrgs=userOrgMapper.selectByOrgId(data.getOrgId());

            GetOrgUserResult getAppResult=new GetOrgUserResult();

            List<GetOrgUserResult> appResults=userOrgs.stream()
                    .map(p-> new GetOrgUserResult(p.getUserId(),p.getIsRead(),p.getIsWrite()))
                    .collect(Collectors.toList());


            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS,appResults);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
}
