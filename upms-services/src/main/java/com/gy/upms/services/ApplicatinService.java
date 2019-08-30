package com.gy.upms.services;

import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.application.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: guofeng
 * @Date: 2019/6/10 13:52
 * @Description:
 */
@Validated
public interface ApplicatinService {
    ResultMessage<String> add (@Valid AddApp addApp);
    ResultMessage<PageResult<SearchAppResult> > search (@Valid SearchApp searchApp);
    ResultMessage<String> update (@Valid UpdateApp updateApp);
    ResultMessage<String> delete (@Valid DeleteApp deleteApp);
    ResultMessage<DetailAppResult> detail (@Valid DetailApp detailApp);

    ResultMessage<String> setAuth (@Valid SetApp setApp);
    ResultMessage<List<GetAppResult>> getAuth (@Valid GetApp getApp);
}
