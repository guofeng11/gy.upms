package com.gy.upms.servicesimp;

import com.gy.commons.encrypt.Base64_GY;
import com.gy.upms.component.JacksonUtils;
import com.gy.upms.dto.user.Login;
import com.gy.upms.dto.user.Register;
import com.gy.upms.dto.user.UserEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * @Auther: guofeng
 * @Date: 2019/6/3 14:32
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(UserServiceImp.class)
//@Import(MessageUtils.class)
@AutoConfigureRestDocs
@Transactional //回滚测试数据
public  class UserServiceImpTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void register() throws Exception {

        String pwd= Base64_GY.encrypt("123456");
        Register register=new Register("admin3","admin3",pwd,"admin3@email.com","18800000002");

        String jsonParam= JacksonUtils.obj2json(register);

        //参数验证
        ConstrainedFields fields=new ConstrainedFields(Register.class);

        this.mockMvc.perform(post("/user/register")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .header("Authorization", "732E2D2A-7934-4679-B0FB-45E565D3303D")
                .content(jsonParam))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(0)))//jsonPath
                .andDo(print())
                .andDo(document("/user/register",
                        requestHeaders(headerWithName("Authorization").description("应用程序凭证")),
                        requestFields(
                                fields.withPath("username").description("用户名").type(JsonFieldType.STRING),
                                fieldWithPath("nickname").description("昵称").type(JsonFieldType.STRING).optional(),
                                fieldWithPath("password").description("密码").type(JsonFieldType.STRING),
                                fieldWithPath("email").description("邮件").type(JsonFieldType.STRING),
                                fieldWithPath("phone").description("手机").type(JsonFieldType.STRING)
                        ),
                        responseFields(
                                fieldWithPath("result").description("返回结果").type(JsonFieldType.NUMBER),
                                fieldWithPath("message").description("返回结果描述").type(JsonFieldType.STRING),
                                subsectionWithPath ("data").description("请求成功返回数据").type(JsonFieldType.OBJECT)
                        ),
                        relaxedResponseFields(
                                beneathPath("data"),
                                fieldWithPath("id").description("用户编号").type(JsonFieldType.NUMBER)
                        )
                        ));
    }

    @Test
    public void  login() throws Exception {

        String pwd= Base64_GY.encrypt("123456");

        Login login=new Login();
        login.setUserName("admin1");
        login.setPassword(pwd);

        String jsonParam= JacksonUtils.obj2json(login);

        ConstrainedFields fields=new ConstrainedFields(Login.class);

        this.mockMvc.perform(post("/user/login/{type}", UserEnum.UserType.C.getUserType())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .header("Authorization", "732E2D2A-7934-4679-B0FB-45E565D3303D")
                .content(jsonParam))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(0)))//jsonPath
                .andDo(print())
                .andDo(document("user/login",
                        requestHeaders(headerWithName("Authorization").description("应用程序凭证")),
                        pathParameters(
                                parameterWithName("type").description("C 客户登录 M 后端用户 S 系统管理用户")
                        ),
                        requestFields(
                                fields.withPath("userName").description("用户名").type(JsonFieldType.STRING),
                                fields.withPath("password").description("密码").type(JsonFieldType.STRING)
                        ),
                        responseFields(
                                fieldWithPath("result").description("返回结果").type(JsonFieldType.NUMBER),
                                fieldWithPath("message").description("返回结果描述").type(JsonFieldType.STRING),
                                subsectionWithPath ("data").description("请求成功返回数据").type(JsonFieldType.OBJECT)
                        ),
                        relaxedResponseFields(
                                beneathPath("data"),
                                fieldWithPath("id").description("用户编号").type(JsonFieldType.NUMBER)
                        )
                ));
    }

    private static class ConstrainedFields {

        private final ConstraintDescriptions constraintDescriptions;

        ConstrainedFields(Class<?> input) {
            this.constraintDescriptions = new ConstraintDescriptions(input);
        }

        private FieldDescriptor withPath(String path) {
            return fieldWithPath(path).attributes(key("constraints").value(StringUtils
                    .collectionToDelimitedString(this.constraintDescriptions
                            .descriptionsForProperty(path), ". ")));
        }
    }

}
