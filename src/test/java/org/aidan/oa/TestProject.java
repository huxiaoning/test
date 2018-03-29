package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

public class TestProject {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "e0a7011352b748d9a5bfb622ab941744";

    // 测试项目列表
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/project";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }
}
