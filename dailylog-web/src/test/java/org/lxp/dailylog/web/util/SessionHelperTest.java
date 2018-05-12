package org.lxp.dailylog.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SessionHelperTest {

    @Test
    public void getRequestId() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        Mockito.doReturn(null).when(request).getParameter(SessionHelper.SESSION_ID);
        Mockito.doReturn(session).when(request).getSession();
        Mockito.doReturn("sessionId").when(session).getId();

        Assert.assertEquals("sessionId", SessionHelper.getRequestId(request));
    }
}
