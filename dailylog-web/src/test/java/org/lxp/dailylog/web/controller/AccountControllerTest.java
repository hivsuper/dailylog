package org.lxp.dailylog.web.controller;

import static org.junit.Assert.assertTrue;
import static org.lxp.dailylog.config.PowerMockHelper.MANAGEMENT_PACKAGE;
import static org.lxp.dailylog.config.PowerMockHelper.SSL_PACKAGE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxp.dailylog.vo.UserVo;
import org.lxp.dailylog.web.util.SessionHelper;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@PowerMockIgnore({ MANAGEMENT_PACKAGE, SSL_PACKAGE })
@PrepareForTest(SessionHelper.class)
@SpringBootTest
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
        PowerMockito.mockStatic(SessionHelper.class);
        PowerMockito.when(SessionHelper.getUser(Mockito.any(HttpSession.class))).thenReturn(new UserVo());
        // execute
        String responseString = mockMvc
                .perform(post("/account/add.json").header("sessionId", "1").param("username", "username")
                        .param("remail", "remail").param("fpemail", "fpemail").param("phone", "phone")
                        .param("productname", "productname").param("producturl", "producturl")
                        .param("joindate", "2018-06-24"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        // verify
        assertTrue(responseString.contains(
                "\"username\":\"username\",\"remail\":\"remail\",\"fpemail\":\"fpemail\",\"phone\":\"phone\",\"productname\":\"productname\",\"producturl\":\"producturl\",\"joindate\":\"2018-06-24 00:00\""));
    }

}
