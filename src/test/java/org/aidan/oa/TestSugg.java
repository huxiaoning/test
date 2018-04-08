package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSugg {

    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "8798a55e7f8d4120b86a4810f62b8693";

    // 测试新增接口
    @Test
    public void test1() {
        String url = ADDR + "/recon/open/oa/sugg?userId=8adbb02043ee452c8c00fafd0741a6cc";
        Map<String, Object> params = new HashMap<>();
        params.put("sugg", "我是打酱油的，随便提点意见！");
        List<String> attachmentList = new ArrayList<>();
        attachmentList.add("a/b/c");
        attachmentList.add("a/b/d");
        attachmentList.add("a/b/e");
        params.put("attachmentList", attachmentList);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 反馈
    @Test
    public void test2() {
        String url = ADDR + "/recon/open/oa/sugg?userId=8adbb02043ee452c8c00fafd0741a6cc";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("response", "已解决");
        String result = HttpUtil.put(url, params, null);
        System.out.println(result);
    }

    // 删除
    @Test
    public void test3() {
        String url = ADDR + "/recon/open/oa/sugg/" + id + "?userId=8adbb02043ee452c8c00fafd0741a6cc";
        String result = HttpUtil.delete(url, null, null);
        System.out.println(result);
    }

    // 详情
    @Test
    public void test4() {
        String url = ADDR + "/recon/open/oa/sugg/" + id + "?userId=8adbb02043ee452c8c00fafd0741a6cc";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    // 分页
    @Test
    public void test5() {
        String url = ADDR + "/recon/open/oa/sugg/?userId=8adbb02043ee452c8c00fafd0741a6cc";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }
}
