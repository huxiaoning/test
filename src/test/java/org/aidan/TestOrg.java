package org.aidan;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestOrg {

    private static final String ADDR = "http://localhost:8082";
//    private static final String ADDR = "http://10.50.8.18:8081";
//    private static final String ADDR = "http://10.50.8.18";

    private static final String id = "492254686394499588a4296d64ca5e3d";


    // 保存 编辑
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/zuul/org";
        Map<String, Object> params = new HashMap<>();
//        params.put("id", "1");
        params.put("parentId", "0");
        params.put("depNum", UUID.randomUUID().toString().replaceAll("-", ""));
        params.put("name", UUID.randomUUID().toString().replaceAll("-", ""));
        params.put("simpleName", UUID.randomUUID().toString().replaceAll("-", ""));
//        params.put("sort", 20);
        params.put("area", 320506);
        params.put("type", 7);
        params.put("orgCode", UUID.randomUUID().toString().replaceAll("-", ""));
        params.put("creditCode", UUID.randomUUID().toString().replaceAll("-", ""));
        params.put("address", UUID.randomUUID().toString().replaceAll("-", ""));
        params.put("master", UUID.randomUUID().toString().replaceAll("-", ""));
        params.put("phone", "13140994779");
//        params.put("userable", "1");
        params.put("remarks", UUID.randomUUID().toString().replaceAll("-", ""));
//        params.put("delFlag", "0");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 删除
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/zuul/org/" + id;
        String result = HttpUtil.delete(url, null, null);
        System.out.println(result);
    }

    // 详情
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/org/" + id;
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    // 分页
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/org";
        Map<String, Object> params = new HashMap<>();
//        params.put("currentPage", 1);
//        params.put("pageSize", 2);
//        params.put("depNum", "76d364437c584ff6a398fff59016a616");
//        params.put("name", "");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 组织架构树加载子节点接口
    @Test
    public void test5() {
        String url = ADDR + "/recon/check/org/loadChildList";
        Map<String, Object> params = new HashMap<>();
        params.put("parentId", null);
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 修改节点的从属关系
    @Test
    public void test6() {
        String url = ADDR + "/recon/check/org/updateParent";
        Map<String, Object> params = new HashMap<>();
        params.put("id", "492254686394499588a4296d64ca5");
        params.put("parentId", "492254686394499588a4296d64ca5e3d");
        String result = HttpUtil.put(url, params, null);
        System.out.println(result);
    }

    // 更新
    @Test
    public void test7() {
        String url = ADDR + "/recon/check/org/updateOrg";
        Map<String, Object> params = new HashMap<>();
        params.put("id", "492254686394499588a4296d64ca5");
        params.put("sort", 40);
//        params.put("userable", "0");
        String result = HttpUtil.put(url, params, null);
        System.out.println(result);
    }

    // 更新
    @Test
    public void test8() {
        String url = ADDR + "/recon/check/org/org/tree";
        Map<String, Object> params = new HashMap<>();
//        params.put("id", "492254686394499588a4296d64ca5");
//        params.put("sort", 40);
//        params.put("userable", "0");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

}
