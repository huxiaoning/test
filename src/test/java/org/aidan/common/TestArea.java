package org.aidan.common;

import org.aidan.util.HttpUtil;
import org.junit.Test;

public class TestArea {

    private static final String ADDR = "http://localhost:8085";
//    private static final String ADDR = "http://10.50.8.18:8081";
//    private static final String ADDR = "http://10.50.8.18";

    private static final String id = "492254686394499588a4296d64ca5e3d";

    // area树
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/common/area/all";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }
}
