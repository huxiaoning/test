package org.aidan;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestRole {

    private static final String ADDR = "http://localhost:8082";
//    private static final String ADDR = "http://10.50.8.18:8081";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "1ca13d8a307642d7b51dccc445280030";


    @Test
    public void test1() {
        String url = ADDR + "/recon/check/org/role";
        Map<String, Object> params = new HashMap<>();
        params.put("name", "超级管理员");
        params.put("menuIds", "52e8bd51049a4d85b8737d490b9fdb6d,594341cc65a14e28b2dc8e58d97e9b16");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    @Test
    public void test2() {
        String url = ADDR + "/recon/check/org/role/" + id;
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    @Test
    public void test3() {
        String url = ADDR + "/recon/check/org/role";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    @Test
    public void test4() {
        String url = ADDR + "/recon/check/org/role/authorize";
        String result = HttpUtil.post(url, "{}", null);
        System.out.println(result);
    }
}
