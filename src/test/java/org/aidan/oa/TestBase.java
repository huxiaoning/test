package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "5667fa3de7c1403daa519c9b2eeeecee";

    // 测试基本信息接口
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "41");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试扩展信息接口
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/extend/" + id;
        Map<String, Object> params = new HashMap<>();
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试表单审批记录
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/oa/form/approval-record-list/" + id;
        Map<String, Object> params = new HashMap<>();
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
