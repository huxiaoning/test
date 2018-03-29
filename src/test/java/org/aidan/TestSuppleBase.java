package org.aidan;

import org.aidan.util.HttpUtil;
import org.aidan.vo.AuditVO;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class TestSuppleBase {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.18:8080";
//    private static final String ADDR = "http://10.50.8.18:80";

    private static final String id = "09afa5e49043454ca579a0d2a03f5aa4";


    // 测试新增/编辑供应商接口
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/supple";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("icon", "55555555");
        params.put("linker", "linker1");
        params.put("phone", "phone1");
        params.put("industry", "industry1");
        params.put("area", "320506");
        params.put("web", "web1");
        params.put("type", 2);
        if (params.get("type").equals(1)) {
            params.put("company", "company1");
            params.put("legalPerson", "legalPerson1");
            params.put("creditCode", "creditCode1");
        } else if (params.get("type").equals(2)) {
            params.put("personName", "personName1");
            params.put("idCard", "idCard1");
        }
        params.put("imgUrl", "imgUrl1");
//        params.put("state", 1);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试删除供应商接口
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/supple/" + id;
        String result = HttpUtil.delete(url, null, null);
        System.out.println(result);
    }

    // 测试审核供应商信息接口
    @Test
    public void test3() {
        boolean flag = false; // 通过/不通过
        String url = ADDR + "/recon/check/supple/audit";
        AuditVO auditVO = new AuditVO();
        Map<String, Object> params = new HashMap<>();
        params.put("checker", "checker1");
        if (flag) {
            params.put("state", 1);
        } else {
            params.put("state", -1);
            params.put("module", "供应商管理模块");
            params.put("reason", "资源不齐全，照片模糊");
        }
        params.put("suppleId", id);
        String result = HttpUtil.put(url, params, null);
        System.out.println(result);
    }

    // 测试供应商分页列表接口
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/supple";
        Map<String, Object> params = new HashMap<>();
        params.put("currentPage", 1);
        params.put("pageSize", 4);
        params.put("areaId", "320506");
        params.put("cityId", "320500");
        params.put("provinceId", "320000");
        params.put("areaType", 1);
        params.put("state", 0);
        params.put("name", "personName1");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试供应商详情接口
    @Test
    public void test5() {
//        String url = ADDR + "/recon/check/supple/" + id;
        String url = ADDR + "/recon/check/supple/" + id;
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }


    // 测试省市区数据接口
    @Test
    public void test6() {
        String url = ADDR + "/recon/check/area/all";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }


    // 初始化供应商数据，供分页查询
    @Test
    public void test7() {
        for (int i = 0; i < 2; i++) {
            test1();
        }
    }

}
