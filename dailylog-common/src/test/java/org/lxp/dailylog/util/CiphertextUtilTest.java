package org.lxp.dailylog.util;

import org.junit.Assert;
import org.junit.Test;

public class CiphertextUtilTest {

    @Test
    public void testDecode() throws Exception {
        Assert.assertEquals("YWFhO2xlZQ", CiphertextUtil.encode("aaa"));
    }

    @Test
    public void testEncode() throws Exception {
        Assert.assertEquals("aaa,lee", String.join(",", CiphertextUtil.decode("YWFhO2xlZQ")));
    }

}
