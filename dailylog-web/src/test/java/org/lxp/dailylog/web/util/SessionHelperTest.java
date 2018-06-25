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
    public void shouldRetrunSessionIdWhenSessionIdParameterIsNull() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        Mockito.doReturn(null).when(request).getHeader(SessionHelper.SESSION_ID);
        Mockito.doReturn(session).when(request).getSession();
        final String sessionId = "sessionId";
        Mockito.doReturn(sessionId).when(session).getId();
        Assert.assertEquals(sessionId, SessionHelper.getRequestId(request));
    }

    @Test
    public void shouldRetrunSessionIdWhenSessionIdParameterNotNull() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final String requestId = "requestId";
        Mockito.doReturn(requestId).when(request).getHeader(SessionHelper.SESSION_ID);
        Assert.assertEquals(requestId, SessionHelper.getRequestId(request));
    }
}
