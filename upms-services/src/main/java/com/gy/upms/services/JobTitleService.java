package com.gy.upms.services;

import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.jobTitle.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @ClassName JobTitleService.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月02日 14:55:00
 */
@Validated
public interface JobTitleService {
    ResultMessage<String> add(@Valid AddJobTitle data);
    ResultMessage<String> edit(@Valid EditJobTitle data);
    ResultMessage<DetailJobTitleResult> detail(@Valid DetailJobTitle data);
    ResultMessage<String> delete(@Valid DeleteJobTitle data);
    ResultMessage<PageResult<SearchJobTitleResult>> search(@Valid SearchJobTitle data);
}
