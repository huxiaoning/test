package org.aidan;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class TestSuppleScene {
    private static final String ADDR = "http://localhost:8080";
    //            private static final String ADDR = "http://10.50.8.18:8080";
//    private static final String ADDR = "http://10.50.8.18";
    private static final String id = "5e5ec436ee6f4aeaa2d27ff3e186d07f";


    // 测试新增/编辑供应商接口
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/scene";
        Map<String, Object> params = new HashMap<>();
//        params.put("id", id);
        params.put("suppleId", "a18d8a3e423c487992451bae42bdcd0f");
        params.put("name", "name3334");
        params.put("code", "code1");
        params.put("type", "type1");
        params.put("network", "network1");
        params.put("apiIds", "1,2,3,4,5,6");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    @Test
    public void testConfigSceneApiList() {
        String url = ADDR + "/recon/check/scene/configSceneApiList";
        Map<String, Object> params = new HashMap<>();
        params.put("sceneId", "xxx");
        params.put("apiIds", "1,2,3,4,5,6");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试应用场景分页接口
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/scene";
        Map<String, Object> params = new HashMap<>();
        params.put("currentPage", 1);
        params.put("pageSize", 10);
//        params.put("areaId", "320506");
//        params.put("cityId", "320500");
        params.put("provinceId", "320000");
//        params.put("type", "type1");
//        params.put("network", "network1");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    /**
     * 测试应用场景详情接口
     */
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/scene/" + id;
        String json = HttpUtil.get(url, null, null);
        System.out.println(json);
    }

    /**
     * 测试应用场景删除接口
     */
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/scene/" + id;
        String json = HttpUtil.delete(url, null, null);
        System.out.println(json);
    }


    /**
     * 测试：应用场景已配置的api列表
     */
    @Test
    public void test7() {
        String url = ADDR + "/recon/check/scene/getSceneConfiguredAPIList";
        Map<String, Object> params = new HashMap<>();
        params.put("sceneId", "6bc142d55d2e4137b358461c86c25aec");
        String json = HttpUtil.get(url, params, null);
        System.out.println(json);
    }

    /**
     * 测试：查询当前用户所有的api列表
     */
    @Test
    public void test8() {
        String url = ADDR + "/recon/check/scene/getUserAPIList";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "11");
        String json = HttpUtil.get(url, params, null);
        System.out.println(json);
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        System.out.println(timeZone);
        System.out.println(System.getProperty("user.timezone"));
    }

}
