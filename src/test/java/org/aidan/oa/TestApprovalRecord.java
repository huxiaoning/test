package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试供应商
 */
public class TestApprovalRecord {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "e0a7011352b748d9a5bfb622ab941744";

    // 测试待办列表
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/approval-record/todo";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "1");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试流程追踪列表
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/approval-record/flow-trace";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "5ff6b2eaf861409fbdd8ca675fd4ed13");
        params.put("status", "1");
        params.put("currentPage", 1);
        params.put("pageSize", 22);
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
