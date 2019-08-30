package com.gy.upms.servicesimp;

import com.gy.upms.component.JacksonUtils;
import com.gy.upms.dto.InPage;
import com.gy.upms.dto.organization.AddOrg;
import com.gy.upms.dto.organization.SeachOrg;
import com.gy.upms.dto.UserSecurity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName OrganizationServiceImpTest.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月28日 14:55:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Transactional
public class OrganizationServiceImpTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void add() throws Exception{
        AddOrg data=new AddOrg();
        data.setOrgCode("88888888");
        data.setOrgNameCn("测试");
        data.setOrgNameEn("test");
        data.setAbbrNameCn("ceshi");
        data.setAbbrNameEn("test");
        data.setLevel(1);
        data.setOrgType("D");
        data.setParentId(0);
        data.setCreater("admin");

        data.setUserSecurity(new UserSecurity(4,"ba22e870-c3d1-11e9-85bf-c85b762eb0b1"));
        String jsonParam= JacksonUtils.obj2json(data);

        this.mockMvc.perform(post("/org/add")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .header("Authorization", "732E2D2A-7934-4679-B0FB-45E565D3303D")
                .content(jsonParam))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(0)))//jsonPath
                .andDo(print())
                .andDo(document("org/add",
                        requestHeaders(headerWithName("Authorization").description("应用程序凭证")),
                        relaxedRequestFields(
                                fieldWithPath("orgCode").description("组织代码").type(JsonFieldType.STRING).optional(),
                                fieldWithPath("orgType").description("组织类型D或O").type(JsonFieldType.STRING).optional()
                        ),
                        responseFields(
                                fieldWithPath("result").description("返回结果").type(JsonFieldType.NUMBER),
                                fieldWithPath("message").description("返回结果描述").type(JsonFieldType.STRING),
                                subsectionWithPath ("data").description("请求成功返回数据").type(JsonFieldType.OBJECT).optional()
                        )
                ));
    }
    @Test
    public void search() throws Exception {


        SeachOrg data=new SeachOrg();
        data.setOrgType("D");
        data.setPage(new InPage(1,10));
        data.setUserSecurity(new UserSecurity(4,"ba22e870-c3d1-11e9-85bf-c85b762eb0b1"));
        String jsonParam= JacksonUtils.obj2json(data);

        this.mockMvc.perform(post("/org/search")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .header("Authorization", "732E2D2A-7934-4679-B0FB-45E565D3303D")
                .content(jsonParam))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(0)))//jsonPath
                .andDo(print())
                .andDo(document("org/search",
                        requestHeaders(headerWithName("Authorization").description("应用程序凭证")),
                        relaxedRequestFields(
                                fieldWithPath("orgCode").description("组织代码").type(JsonFieldType.STRING).optional(),
                                fieldWithPath("orgType").description("组织类型D或O").type(JsonFieldType.STRING).optional()
                        ),
                        responseFields(
                                fieldWithPath("result").description("返回结果").type(JsonFieldType.NUMBER),
                                fieldWithPath("message").description("返回结果描述").type(JsonFieldType.STRING),
                                subsectionWithPath ("data").description("请求成功返回数据").type(JsonFieldType.OBJECT)
                        ),
                        relaxedResponseFields(
                                beneathPath("data"),
                                fieldWithPath("orgId").description("组织编号").type(JsonFieldType.NUMBER).optional()
                        )
                ));
    }

}