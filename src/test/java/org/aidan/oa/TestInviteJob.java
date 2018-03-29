package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试招聘需求申请表
 */
public class TestInviteJob {

    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "c9f35e7267204d7993bfffd4bfa0dd42";

    // 测试新增招聘需求
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/invite-job?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("orgId", "111");
        params.put("orgName", "111");
        params.put("reportSuperior", 1001);
        params.put("reportSuperiorName", "111");
        params.put("count", 1);
        params.put("authorizedStrength", "1");
        params.put("inviteQuarter", 1001);
        params.put("inviteQuarterName", "1111");
        params.put("urgency", "0");
        params.put("requires", "01111");
        params.put("specialRequire", "11111999");
        params.put("ifSubmit", "0");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试查询招聘需求
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "93");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
