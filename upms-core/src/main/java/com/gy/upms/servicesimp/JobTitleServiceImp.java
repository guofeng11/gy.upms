package com.gy.upms.servicesimp;

import com.gy.upms.component.JacksonUtils;
import com.gy.upms.component.MessageUtils;
import com.gy.upms.dao.JobTitleMapper;
import com.gy.upms.dto.OutPage;
import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.jobTitle.*;
import com.gy.upms.entity.JobTitle;
import com.gy.upms.entity.Pageing;
import com.gy.upms.services.JobTitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName JobTitleServiceImp.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月04日 11:24:00
 */
@RestController
@RequestMapping("/jobTitle")
public class JobTitleServiceImp implements JobTitleService {
    private final static Logger log = LoggerFactory.getLogger(JobTitleServiceImp.class);
    @Autowired
    private MessageUtils messageUtils;
    @Autowired
    private JobTitleMapper jobTitleMapper;

    @PostMapping("/add")
    @Override
    public ResultMessage<String> add(@RequestBody AddJobTitle data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();
            JobTitle searchCondition=new JobTitle();
            searchCondition.setJobTitle(data.getJobTitle());
            int isEexists =jobTitleMapper.select(searchCondition).size();
            if (isEexists>0){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "JOB.TITLE.NAME");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            JobTitle insertJobTitle=new JobTitle();

            insertJobTitle.setJobTitle(data.getJobTitle());
            insertJobTitle.setJobTitleEn(data.getJobTitleEn());
            insertJobTitle.setLevel(data.getLevel());
            insertJobTitle.setRemark(data.getRemark());
            insertJobTitle.setCreateId(data.getUserSecurity().getId());
            insertJobTitle.setCreater(data.getCreater());
            insertJobTitle.setCreateTime(nowTime);

            int row = jobTitleMapper.insert(insertJobTitle);
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
    public ResultMessage<String> edit(@RequestBody EditJobTitle data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();

            JobTitle jobTitleExists =jobTitleMapper.selectByPrimaryKey(data.getId());
            if (jobTitleExists==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "JOB.TITLE.ID");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }

            jobTitleExists.setJobTitle(data.getJobTitle());
            jobTitleExists.setJobTitleEn(data.getJobTitleEn());
            jobTitleExists.setLevel(data.getLevel());
            jobTitleExists.setRemark(data.getRemark());
            jobTitleExists.setCreateId(data.getUserSecurity().getId());
            jobTitleExists.setCreater(data.getCreater());
            jobTitleExists.setCreateTime(nowTime);

            int row = jobTitleMapper.updateByPrimaryKeySelective(jobTitleExists);
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
    public ResultMessage<DetailJobTitleResult> detail(@RequestBody DetailJobTitle data) {
        ResultMessage<DetailJobTitleResult> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"), null);
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();

            JobTitle jobTitleExists = jobTitleMapper.selectByPrimaryKey(data.getId());
            if (jobTitleExists == null) {
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "JOB.TITLE.ID");
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, message, null);
                return resultMessage;
            }
            DetailJobTitleResult detailResult = new DetailJobTitleResult();
            detailResult.setId(jobTitleExists.getId());
            detailResult.setJobTitle(jobTitleExists.getJobTitle());
            detailResult.setJobTitleEn(jobTitleExists.getJobTitleEn());
            detailResult.setLevel(jobTitleExists.getLevel());
            detailResult.setRemark(jobTitleExists.getRemark());


            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS, detailResult);

            return resultMessage;
        }catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/delete")
    @Override
    public ResultMessage<String> delete(@RequestBody DeleteJobTitle data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }


            int row = jobTitleMapper.deleteByPrimaryKey(data.getId());
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
    public ResultMessage<PageResult<SearchJobTitleResult>> search(@RequestBody SearchJobTitle data) {
        ResultMessage<PageResult<SearchJobTitleResult>> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"), null);
                return resultMessage;
            }

            JobTitle searchCondition = new JobTitle();
            searchCondition.setLevel(data.getLevel());
            searchCondition.setJobTitle(data.getJobTitle());

            int offset = (data.getPage().getCurrentPage() - 1) * data.getPage().getPageRows();
            Pageing<JobTitle> searchPageing = jobTitleMapper.selectByPage(searchCondition, offset, data.getPage().getPageRows());
            OutPage outPage = new OutPage();
            outPage.setTotalRows(searchPageing.getRows().getTotalRows());
            outPage.setTotalPage(searchPageing.getRows().getTotalPage());
            List<SearchJobTitleResult> searchResultList = searchPageing.getDataList().stream()
                    .map(c -> new SearchJobTitleResult(c.getId(),c.getJobTitle(),c.getJobTitleEn(),c.getLevel(),c.getRemark()))
                    .collect(Collectors.toList());
            PageResult<SearchJobTitleResult> pageResult = new PageResult<>();
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
}
