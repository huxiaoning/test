package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestTemplate {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "459ec507100d4dac909620602242b12a";

    // 测试编辑模板
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/template?userId=1";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", 1);
        params.put("flowId", "b90b118052d948dfb59480cbd657be1b");
        params.put("type", 41);
        params.put("typeName", "出差申请表单");
//        params.put("org", "c6ad133cc96a4aaba9a464f9f613a8c2");
//        params.put("orgName", "睿康集团");
//        params.put("extend", "");
        params.put("ifSend", Boolean.TRUE);
        String result = HttpUtil.put(url, params, null);
        System.out.println(result);

    }

    // 测试获取模板信息
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/template";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", 1);
        params.put("type", 41);
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

}
