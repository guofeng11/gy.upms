package com.gy.upms.services;

import com.gy.upms.dto.application.*;
import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;

/**
 * @Auther: guofeng
 * @Date: 2019/6/10 13:52
 * @Description:
 */
public interface ApplicatinService {
    ResultMessage<String> add (AddApp addApp);
    ResultMessage<PageResult<SearchAppResult> > search (SearchApp searchApp);
    ResultMessage<String> update (UpdateApp updateApp);
    ResultMessage<String> delete (DeleteApp deleteApp);
    ResultMessage<DetailAppResult> detail (DetailApp detailApp);

    ResultMessage<String> setAuth (SetApp setApp);
    ResultMessage<GetAppResult> getAuth (GetApp getApp);
}
