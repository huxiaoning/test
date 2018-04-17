package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.*;

public class TestFormPurchase {

        private static final String ADDR = "http://localhost:8084";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "558f0a2ba3d34164aade0281e833012b";

    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/purchase?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
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
        params.put("cardAccount", "111");
        params.put("openAccountBank", "111");
        params.put("purchaseType", 111);
        params.put("purchaseTypeValue", "111");
        params.put("purchaseTypeName", "111");
        params.put("subtotal", 22);
        params.put("ifSubmit", "0");
        List<Map<String, Object>> itemList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", "111");
            item.put("amount", 22);
            item.put("purpose", "111");
            item.put("nedeTime", new Date());
            itemList.add(item);
        }
        params.put("itemList", itemList);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试查询采购申请单
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "128");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
