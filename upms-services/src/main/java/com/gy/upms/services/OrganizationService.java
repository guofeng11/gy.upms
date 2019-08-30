package com.gy.upms.services;

import com.gy.upms.dto.organization.*;
import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;


/**
 * @Auther: guofeng
 * @Date: 2019/6/10 13:53
 * @Description:
 */
@Validated
public interface OrganizationService {
    public ResultMessage<String> add (@Valid AddOrg data);
    public ResultMessage<String> edit (@Valid EditOrg data);
    public ResultMessage<PageResult<SearchOrgResult>> search (@Valid SeachOrg data);
    public ResultMessage<String> delete (@Valid  DeleteOrg data);
    public ResultMessage<DetailOrgResult> detail (@Valid  DetailOrg data);
    public ResultMessage<String> setOrgUser (@Valid  SetOrgUser data);
    public ResultMessage<List<GetOrgUserResult>> getOrgUser (@Valid  GetOrgUser data);
}
