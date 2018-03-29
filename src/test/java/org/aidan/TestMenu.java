package org.aidan;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMenu {

    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.18:8081";
//    private static final String ADDR = "http://10.50.8.18";

    private static final String id = "492254686394499588a4296d64ca5e3d";


    @Test
    public void test1() {
        String url = ADDR + "/recon/check/org/menu";
        Map<String, Object> params = new HashMap<>();
        params.put("name", "菜单管理");
        params.put("menuId", 1);
        params.put("service", 1);
        params.put("module", 1);
        params.put("opt", 1);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    @Test
    public void test2() {
        String url = ADDR + "/recon/check/org/menu/2fb619d45a6c4bfd858dd2cc89aeedc8";
        String result = HttpUtil.delete(url, null, null);
        System.out.println(result);
    }

    @Test
    public void test3() {
        String url = ADDR + "/recon/check/org/menu/2fb619d45a6c4bfd858dd2cc89aeedc8";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    @Test
    public void test4() {
        String url = ADDR + "/recon/check/org/menu";
        Map<String, Object> params = new HashMap<>();
//        params.put("parentId", "1");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    @Test
    public void test5() {
        String url = ADDR + "/recon/check/org/menu/tree";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "1");
//        params.put("isShow", "1");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试系统入口
    @Test
    public void test6() {
        String url = ADDR + "/recon/check/org/menu/sys";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "1");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
