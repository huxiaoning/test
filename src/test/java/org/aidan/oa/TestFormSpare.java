package org.aidan.oa;

import com.alibaba.fastjson.JSONObject;
import org.aidan.entity.User;
import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 测试备用金申请单（2）
 */
public class TestFormSpare {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "6a1dc7410a0442359b33101fce358174";

    // 测试新增
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/spare?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("applyUserId", "111");
        params.put("applyName", "111");
        params.put("orgId", "111");
        params.put("orgName", "111");
        params.put("borrowTime", new Date());
        params.put("openAccountBank", "111");
        params.put("cardAccount", "111");
        params.put("amountWords", "111");
        params.put("amount", 999);
        params.put("ifSubmit", "0");
        List<Map<String, Object>> itemList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("reason", "111");
            item.put("orgId", "111");
            item.put("orgName", "111");
            item.put("projectId", "111");
            item.put("projectName", "111");
            item.put("amount", 777);
            itemList.add(item);
        }
        params.put("itemList", itemList);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试备用金申请单（2）
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "98");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试汇报上级接口
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/oa/org-user/superiorList";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    // 测试补岗职位列表
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/oa/org-user/allQuarterList";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    // 测试差旅费与出差单关联的列表接口
    @Test
    public void test5() {
        String url = ADDR + "/recon/check/oa/evection-apply/myFormList";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "527f98fdbaad48a99b50081512941bd9");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    @Test
    public void testJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "1");
        User user = new User();
        copyProperties(jsonObject, user);
        System.out.println(user);
    }

    private void copyProperties(JSONObject jsonObject, Object object) {
        try {
            org.apache.commons.beanutils.BeanUtils.populate(object, jsonObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
