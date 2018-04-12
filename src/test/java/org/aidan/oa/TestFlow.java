package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestFlow {
        private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "f6db9096785c41b2903fe0d020aedc96";

    // 测试新增流程
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/flow?userId=1";
        Map<String, Object> params = new HashMap<>();
        params.put("name", "出差申请表默认流程");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试编辑流程
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/flow?userId=111";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", "出差申请表默认流程");
        String result = HttpUtil.put(url, params, null);
        System.out.println(result);
    }

    // 测试删除流程
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/oa/flow/" + id + "?userId=222";
        String result = HttpUtil.delete(url, null, null);
        System.out.println(result);
    }

    // 测试流程详情
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/oa/flow/" + id + "?userId=1";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    // 测试流程列表
    @Test
    public void test5() {
        String url = ADDR + "/recon/check/oa/flow/?userId=1";
        Map<String, String> headers = new HashMap<>();
        headers.put("token", "MTo2NDY1YTJhOWIwYzg1Zjk2MGM0NzU3YmRlOGVkNDg2MTNmMmUyZjVmYWI4NWE0NjkyZGQ2NTkxMmI1MGEzNDVhOjE1MjA0NzQyMjMzMzk");
        String result = HttpUtil.get(url, null, headers);
        System.out.println(result);
    }

    // 测试批量删除接口
    @Test
    public void test55() {
        String url = ADDR + "/recon/check/oa/flow/batch?userId=1&ids=,5bc3d0e11ee04f8b9225c821b34d6b43,e0a7011352b748d9a5bfb622ab941744,";
//        Map<String, Object> params = new HashMap<>();
//        params.put("ids", ",5bc3d0e11ee04f8b9225c821b34d6b43,e0a7011352b748d9a5bfb622ab941744,");
        String result = HttpUtil.delete(url, null, null);
        System.out.println(result);
    }

    @Test
    public void test6() {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }

    @Test
    public void test7() {
        String ids = ",1,2,3,4,";
        if (ids.startsWith(",")) {
            ids = ids.substring(1);
        }
        if (ids.endsWith(",")) {
            ids = ids.substring(0, ids.length() - 1);
        }
        System.out.println(ids);
    }
}
