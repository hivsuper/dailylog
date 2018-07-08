package org.lxp.dailylog.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxp.dailylog.config.MemoryDBTest;
import org.lxp.dailylog.vo.UserVo;
import org.lxp.dailylog.web.util.SessionHelper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@MemoryDBTest
public class AccountControllerTest {
    @Resource
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testAdd() throws Exception {
        // given
        MockHttpSession session = new MockHttpSession();
        session.putValue(SessionHelper.USER_KEY, new UserVo());
        // execute
        ResultActions action = mockMvc.perform(post("/account/add.json").header("sessionId", "1111")
                .param("username", "1").param("remail", "2").param("fpemail", "3").param("phone", "4")
                .param("productname", "5").param("producturl", "6").param("joindate", "2018-06-24").session(session));
        // verify
        action.andExpect(status().isOk());
        action.andExpect(jsonPath("$.code").value(Matchers.is(200)));
        action.andExpect(jsonPath("$.content").exists());
        action.andExpect(jsonPath("$.content.username").value(Matchers.is("1")));
        action.andExpect(jsonPath("$.content.remail").value(Matchers.is("2")));
        action.andExpect(jsonPath("$.content.fpemail").value(Matchers.is("3")));
        action.andExpect(jsonPath("$.content.phone").value(Matchers.is("4")));
        action.andExpect(jsonPath("$.content.productname").value(Matchers.is("5")));
        action.andExpect(jsonPath("$.content.producturl").value(Matchers.is("6")));
        action.andExpect(jsonPath("$.content.joindate").value(Matchers.is("2018-06-24 00:00:00")));
    }

}
