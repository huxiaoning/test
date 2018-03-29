package org.aidan;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestSuppleSolution {

    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.18:8080";

    private static final String id = "8683edb2a2da4797ac822a7baa04bd26";


    // 测试解决方案新增、编辑接口
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/solution";
        Map<String, Object> params = new HashMap<>();
//        params.put("id", id);
        params.put("suppleId", "3cb88428fc8e44a38b09077af00e8326");
        params.put("name", "方案名称222333");
        params.put("code", "解决方案代码222");
        params.put("icon", "solution/181ac9c511584c168d1cb1533fddeaa2/a85828e6c25341199ea194963af5d386.png");
        params.put("frameImg", "solution/4f39b4b3b5f14a819eeaa483444245b3/0273bd776a924acd93fd445967c3f5c2.png");
        params.put("description", "description1");
        params.put("industry", ",2,3,");
        params.put("industryName", "采矿业,制造业");
        params.put("area", "110101");
        params.put("type", 12);
//        params.put("sceneIds", "1,2,3,4,5,6");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    @Test
    public void testConfigSolutionSceneList() {
        String url = ADDR + "/recon/check/solution/configSolutionSceneList";
        Map<String, Object> params = new HashMap<>();
        params.put("solutionId", "xxx");
        params.put("sceneIds", "1,2,3,4,5,6");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试供应商列表接口
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/solution";
        Map<String, Object> params = new HashMap<>();
        params.put("currentPage", 1);
        params.put("pageSize", 5);
//        params.put("areaId", "320506");
//        params.put("cityId", "320500");
//        params.put("provinceId", "320000");
//        params.put("type", "type1");
//        params.put("industry", "2");
        params.put("name", "案名称");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试解决方案详情接口
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/solution/" + id;
        String json = HttpUtil.get(url, null, null);
        System.out.println(json);
    }

    // 测试解决方案删除接口
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/solution/" + id;
        String json = HttpUtil.delete(url, null, null);
        System.out.println(json);
    }


    /**
     * 测试方案的已配置场景列表
     */
    @Test
    public void test5() {

        String url = ADDR + "/recon/check/solution/getSolutionConfiguredSceneList";
        Map<String, Object> params = new HashMap<>();
        params.put("solutionId", "9e8d8db71ff143c7b1945f6b43b198fb");
        String json = HttpUtil.get(url, params, null);
        System.out.println(json);
    }

    /**
     * 测试:供应所有的场景列表
     */
    @Test
    public void test6() {

        String url = ADDR + "/recon/check/solution/getSuppleSceneList";
        Map<String, Object> params = new HashMap<>();
        params.put("suppleId", "4d3a72082c3845cda0f45cbf823d5fa2");
        String json = HttpUtil.get(url, params, null);
        System.out.println(json);
    }
}
