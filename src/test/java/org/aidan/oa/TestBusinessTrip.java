package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试因公外出
 */
public class TestBusinessTrip {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "4be4634dac774de6bc273914afd3ef77";

    // 测试新增
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/business-trip?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("applyUserId", "5ff6b2eaf861409fbdd8ca675fd4ed13");
        params.put("applyName", "研发部员工");
        params.put("orgId", "b144b26b908b425fbd13bc1786859496");
        params.put("orgName", "研发部");
        params.put("quarter", 1123);
        params.put("quarterName", "研发部员工");
        params.put("outStartTime", new Date());
        params.put("outEndTime", new Date());
        params.put("totalTime", "1.5");
        params.put("explains", "说明一下");
        params.put("prove", "/a/b/c.png");
        params.put("extend", "/a/b/c.png");
        params.put("ifSubmit", "1");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试查询因公外出申请单
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "90");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
