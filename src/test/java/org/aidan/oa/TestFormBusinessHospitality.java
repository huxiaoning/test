package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.*;

public class TestFormBusinessHospitality {

    private static final String ADDR = "http://localhost:8084";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "64725e8d4f1a49f29ecd399d6dc6af31";

    // 新增
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/business-hospitality?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("flowNum", "11111");
        params.put("startTime", new Date());
        params.put("applyUserId", "111");
        params.put("applyName", "111");
        params.put("quarter", 55);
        params.put("quarterName", "1111");
        params.put("orgId", "1");
        params.put("orgName", "dw   qfeww");

        params.put("cardAccount", "111");
        params.put("openAccountBank", "111");
        params.put("projectId", "222");
        params.put("projectName", "222");
        params.put("projectNum", "222");
        params.put("master", "222");
        params.put("masterName", "222");
        params.put("amountWords", "222");
        params.put("amount", 999);
        params.put("ifSubmit", "0");
        List<Map<String, Object>> itemList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("dates", new Date());
            item.put("address", "wwww");
            item.put("participants", "111");
            item.put("reason", "111");
            item.put("amount", 333);
            itemList.add(item);
        }
        params.put("itemList", itemList);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

}
