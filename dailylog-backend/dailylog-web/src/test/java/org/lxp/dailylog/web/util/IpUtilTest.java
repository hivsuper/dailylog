package org.lxp.dailylog.web.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IpUtilTest {
    private static final String X_REAL_IP = "X-Real-IP";
    private static final String X_FORWARDED_FOR = "X-Forwarded-For";
    private static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    private static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    private static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    private static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";
    private static final String IP = "10.10.10.1";
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnIPWhenXRealIPNotNull() {
        doReturn(IP).when(request).getHeader(X_REAL_IP);
        assertEquals(IP, IpUtil.getIpAddress(request));
        verify(request, times(1)).getHeader(eq(X_REAL_IP));
        verify(request, times(0)).getHeader(eq(X_FORWARDED_FOR));
        verify(request, times(0)).getHeader(eq(PROXY_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(WL_PROXY_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(HTTP_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(HTTP_X_FORWARDED_FOR));
    }

    @Test
    public void shouldReturnIPWhenXForwardedForNotNull() {
        doReturn(IP).when(request).getHeader(X_FORWARDED_FOR);
        assertEquals(IP, IpUtil.getIpAddress(request));
        verify(request, times(1)).getHeader(eq(X_REAL_IP));
        verify(request, times(1)).getHeader(eq(X_FORWARDED_FOR));
        verify(request, times(0)).getHeader(eq(PROXY_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(WL_PROXY_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(HTTP_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(HTTP_X_FORWARDED_FOR));
    }

    @Test
    public void shouldReturnIPWhenProxyClientIPNotNull() {
        doReturn(IP).when(request).getHeader(PROXY_CLIENT_IP);
        assertEquals(IP, IpUtil.getIpAddress(request));
        verify(request, times(1)).getHeader(eq(X_REAL_IP));
        verify(request, times(1)).getHeader(eq(X_FORWARDED_FOR));
        verify(request, times(1)).getHeader(eq(PROXY_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(WL_PROXY_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(HTTP_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(HTTP_X_FORWARDED_FOR));
    }

    @Test
    public void shouldReturnIPWhenWLProxyClientIPNotNull() {
        doReturn(IP).when(request).getHeader(WL_PROXY_CLIENT_IP);
        assertEquals(IP, IpUtil.getIpAddress(request));
        verify(request, times(1)).getHeader(eq(X_REAL_IP));
        verify(request, times(1)).getHeader(eq(X_FORWARDED_FOR));
        verify(request, times(1)).getHeader(eq(PROXY_CLIENT_IP));
        verify(request, times(1)).getHeader(eq(WL_PROXY_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(HTTP_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(HTTP_X_FORWARDED_FOR));
    }

    @Test
    public void shouldReturnIPWhenHTTP_CLIENT_IPNotNull() {
        doReturn(IP).when(request).getHeader(HTTP_CLIENT_IP);
        assertEquals(IP, IpUtil.getIpAddress(request));
        verify(request, times(1)).getHeader(eq(X_REAL_IP));
        verify(request, times(1)).getHeader(eq(X_FORWARDED_FOR));
        verify(request, times(1)).getHeader(eq(PROXY_CLIENT_IP));
        verify(request, times(1)).getHeader(eq(WL_PROXY_CLIENT_IP));
        verify(request, times(1)).getHeader(eq(HTTP_CLIENT_IP));
        verify(request, times(0)).getHeader(eq(HTTP_X_FORWARDED_FOR));
    }

    @Test
    public void shouldReturnIPWhenHTTP_X_FORWARDED_FORNotNull() {
        doReturn(IP).when(request).getHeader(HTTP_X_FORWARDED_FOR);
        assertEquals(IP, IpUtil.getIpAddress(request));
        verify(request, times(1)).getHeader(eq(X_REAL_IP));
        verify(request, times(1)).getHeader(eq(X_FORWARDED_FOR));
        verify(request, times(1)).getHeader(eq(PROXY_CLIENT_IP));
        verify(request, times(1)).getHeader(eq(WL_PROXY_CLIENT_IP));
        verify(request, times(1)).getHeader(eq(HTTP_CLIENT_IP));
        verify(request, times(1)).getHeader(eq(HTTP_X_FORWARDED_FOR));
    }

    @Test
    public void shouldReturnIPWhenGetRemoteAddrNotNull() {
        doReturn(IP).when(request).getRemoteAddr();
        assertEquals(IP, IpUtil.getIpAddress(request));
        verify(request, times(1)).getRemoteAddr();
    }

    @Test
    public void shouldReturnHostNameWhenInetAddressNotNull() {
        final String hostname = "hostname";
        InetAddress inetAddress = Mockito.mock(InetAddress.class);
        doReturn(hostname).when(inetAddress).getHostName();
        assertEquals(hostname, IpUtil.getHostName(inetAddress));
        verify(inetAddress, times(1)).getHostName();
    }

    @Test
    public void shouldReturnNullWhenInetAddressIsNull() {
        assertNull(IpUtil.getHostName(null));
    }
}
