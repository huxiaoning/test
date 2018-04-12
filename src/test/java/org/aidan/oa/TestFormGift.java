package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.*;

/**
 * 测试礼品申请表
 */
public class TestFormGift {

//    private static final String ADDR = "http://localhost:8084";
    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "ae2d7e6ba5c848c2b9f8ed93a45a70f1";


    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/gift?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("flowNum", "");
        params.put("startTime", new Date());
        params.put("applyUserId", "111");
        params.put("applyName", "111");
        params.put("quarter", 55);
        params.put("quarterName", "1111");
        params.put("orgId", "1");
        params.put("orgName", "dw   qfeww");
        params.put("masterOrgId", "1111");
        params.put("masterOrgName", "2efdewf");
        params.put("masterOrgUserId", "111");
        params.put("masterOrgUserName", "111");
        params.put("projectId", "111");
        params.put("projectName", "111");
        params.put("projectNum", "111");
        params.put("master", "111");
        params.put("masterName", "1111");
        params.put("subtotal", 22);
        params.put("ifSubmit", "0");
        List<Map<String, Object>> itemList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("giftName", "111");
            item.put("amount", 22);
            item.put("purpose", "111");
            item.put("require", "111");
            itemList.add(item);
        }
        params.put("itemList", itemList);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }


    // 测试查询费用报销单
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "127");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
