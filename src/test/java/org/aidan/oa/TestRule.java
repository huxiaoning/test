package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestRule {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "459ec507100d4dac909620602242b12a";

    // 测试新增接口
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/rule?userId=1";
        Map<String, Object> params = new HashMap<>();
        params.put("flowId", "e0a7011352b748d9a5bfb622ab941744");
        params.put("min", 0);
        params.put("max", 1);
        params.put("unit", "天");
        params.put("step", 2);
        params.put("quarter", 1);
        params.put("quarterName", "总裁");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试编辑接口
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/rule?userId=1";
        Map<String, Object> params = new HashMap<>();
        params.put("id", "459ec507100d4dac909620602242b12a");
//        params.put("flowId", "e0a7011352b748d9a5bfb622ab941744");
//        params.put("min", 0);
//        params.put("max", 1);
//        params.put("unit", "天");
//        params.put("step", 2);
//        params.put("quarter", 1);
        params.put("quarterName", "总裁1");
        String result = HttpUtil.put(url, params, null);
        System.out.println(result);
    }

    // 测试删除接口
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/oa/rule/" + id + "?userId=1";
        String result = HttpUtil.delete(url, null, null);
        System.out.println(result);
    }

    // 测试规则详情
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/oa/rule/" + id + "?userId=1";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    // 测试规则列表
    @Test
    public void test5() {
        String url = ADDR + "/recon/check/oa/rule";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", 1);
        params.put("flowId", "b1707e05c2b94176ae8b7972ac10a57e");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试批量删除接口
    @Test
    public void test6() {
        String url = ADDR + "/recon/check/oa/rule/batch";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "1");
        params.put("ids", ",459ec507100d4dac909620602242b12a,7505adccb5384412a5cb1f79a63d1b2f,");
        String result = HttpUtil.delete(url, params, null);
        System.out.println(result);
    }
}
