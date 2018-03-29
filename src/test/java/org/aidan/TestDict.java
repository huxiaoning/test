package org.aidan;

import com.alibaba.fastjson.JSON;
import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class TestDict {
//    private static final String ADDR = "http://localhost:8080";
    private static final String ADDR = "http://10.50.8.29:8081";
//    private static final String ADDR = "http://10.50.8.29";

    private static final Integer id = 2;


    // 测试新增字典项接口
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/dict";
        Map<String, Object> params = new HashMap<>();
        params.put("value", "value1");
        params.put("label", "label1");
        params.put("type", "type1");
        params.put("description", "description1");
//        params.put("sort", 10);
        params.put("parentId", null);
        params.put("remarks", "remarks1");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试编辑字典项接口
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/dict";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("value", "44444");
//        params.put("label", "label12");
//        params.put("type", "type12");
        params.put("description", "description12");
        params.put("sort", 20);
        params.put("remarks", "remarks12");
        String result = HttpUtil.put(url, params, null);
        System.out.println(result);
    }

    // 测试删除字典项接口
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/dict/" + id;
        String result = HttpUtil.delete(url, null, null);
        System.out.println(result);
    }

    //
//    // 测试审核供应商信息接口
//    @Test
//    public void test3() {
//        boolean flag = false; // 通过/不通过
//        String url = ADDR + "/recon/check/supple/audit";
//        AuditVO auditVO = new AuditVO();
//        Map<String, Object> params = new HashMap<>();
//        params.put("checker", "checker1");
//        if (flag) {
//            params.put("state", 1);
//        } else {
//            params.put("state", -1);
//            params.put("module", "供应商管理模块");
//            params.put("reason", "资源不齐全，照片模糊");
//        }
//        params.put("suppleId", id);
//        String result = HttpUtil.put(url, params, null);
//        System.out.println(result);
//    }
//
    // 测试数据字典构造树接口
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/dict/dict";
        Map<String, Object> params = new HashMap<>();
        params.put("type", "oa_form_type");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    //
    // 测试字典项详情接口
    @Test
    public void test5() {
        String url = ADDR + "/recon/check/dict/" + id;
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    /**
     * 根据type查询列表
     */
    @Test
    public void test6() {
        String url = ADDR + "/recon/check/dict/byType";
        Map<String, Object> params = new HashMap<>();
        params.put("type", "scene_industry");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    /**
     * 根据parentId查询列表
     */
    @Test
    public void test7() {
        String url = ADDR + "/recon/check/dict/byParentId";
        Map<String, Object> params = new HashMap<>();
        params.put("parentId", 18);
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
//
//
//    // 测试省市区数据接口
//    @Test
//    public void test6() {
//        String url = ADDR + "/recon/check/area/all";
//        String result = HttpUtil.get(url, null, null);
//        System.out.println(result);
//    }
//
//
//    // 初始化供应商数据，供分页查询
//    @Test
//    public void test7() {
//        for (int i = 0; i < 2; i++) {
//            test1();
//        }
//    }

    /**
     * 根据类型查询子字典列表 测试
     */
    @Test
    public void test8() {
        String url = ADDR + "/recon/check/dict/dict/byParentType";
        Map<String, Object> params = new HashMap<>();
        params.put("type", "oa_form_type");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    /**
     * 根据类型查询子字典列表 测试
     */
    @Test
    public void test9() {
        String url = ADDR + "/recon/check/dict/saveList";
        Map<String, Object> dictVO = new HashMap<>();
        List<Map<String, Object>> dicts = new ArrayList<>();

        Map<String, Object> dict = new HashMap<>();
//        dict.put("value", "");
        dict.put("id", "76");
        dict.put("label", "性别");
        dict.put("type", "sex");
//        dict.put("description", "性别父字典项");
//        dict.put("sort", 10);
//        dict.put("parentId", 0);
//        dict.put("remarks", "性别父字典项");


        Map<String, Object> dict1 = new HashMap<>();
        dict1.put("value", "man");
        dict1.put("label", "男1");
//        dict1.put("type", "");
//        dict1.put("description", "性别字典项-男");
//        dict1.put("sort", 10);
//        dict1.put("parentId", 0);
//        dict1.put("remarks", "性别字典项-男");

        Map<String, Object> dict2 = new HashMap<>();
        dict2.put("value", "woman");
        dict2.put("label", "女");
//        dict2.put("type", "");
//        dict2.put("description", "性别字典项-女");
//        dict2.put("sort", 10);
//        dict2.put("parentId", 0);
//        dict2.put("remarks", "性别字典项-女");

        dicts.add(dict1);
//        dicts.add(dict2);

        dictVO.put("parentDict", dict);
        dictVO.put("childList", dicts);
        String json = JSON.toJSONString(dictVO);

        String result = HttpUtil.post(url, json, null);
        System.out.println(result);
    }

}
