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
    ResultMessage<String> add(@Valid AddOrg data);
    ResultMessage<String> edit(@Valid EditOrg data);
    ResultMessage<PageResult<SearchOrgResult>> search(@Valid SeachOrg data);
    ResultMessage<String> delete(@Valid DeleteOrg data);
    ResultMessage<DetailOrgResult> detail(@Valid DetailOrg data);
    ResultMessage<String> setOrgUser(@Valid SetOrgUser data);
    ResultMessage<List<GetOrgUserResult>> getOrgUser(@Valid GetOrgUser data);
}
