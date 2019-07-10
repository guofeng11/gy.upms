package com.gy.upms.servicesimp;

import com.gy.upms.dto.application.*;
import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.services.ApplicatinService;

/**
 * @Auther: guofeng
 * @Date: 2019/6/13 14:31
 * @Description:
 */
public class ApplicationServiceImp implements ApplicatinService {
    @Override
    public ResultMessage<String> add(AddApp addApp) {
        return null;
    }

    @Override
    public ResultMessage<PageResult<SearchAppResult>> search(SearchApp searchApp) {
        return null;
    }

    @Override
    public ResultMessage<String> update(UpdateApp updateApp) {
        return null;
    }

    @Override
    public ResultMessage<String> delete(DeleteApp deleteApp) {
        return null;
    }

    @Override
    public ResultMessage<DetailAppResult> detail(DetailApp detailApp) {
        return null;
    }

    @Override
    public ResultMessage<String> setAuth(SetApp setApp) {
        return null;
    }

    @Override
    public ResultMessage<GetAppResult> getAuth(GetApp getApp) {
        return null;
    }
}
