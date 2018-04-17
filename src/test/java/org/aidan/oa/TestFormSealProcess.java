package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.*;

public class TestFormSealProcess {

    private static final String ADDR = "http://localhost:8084";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "63b48f211ad44c4bbe855d2d2ce9d85e";

    // 新增
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/seal-process?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("flowNum", "");
        params.put("startTime", new Date());
        params.put("applyUserId", "111");
        params.put("applyName", "111");
        params.put("quarter", 55);
        params.put("quarterName", "1111");
        params.put("orgId", "1");
        params.put("orgName", "dw   qfeww");
        params.put("sealId", "111");
        params.put("sealName", "222");
        params.put("reason", "11111v");
        params.put("predictExecuteTime", new Date());
        params.put("ifSubmit", "0");

        List<Map<String, Object>> itemList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("sealType", 51);
            item.put("sealTypeValue", "wwww");
            item.put("sealTypeName", "111");
            itemList.add(item);
        }
        params.put("itemList", itemList);

        List<Map<String, Object>> processList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("sealProcessType", 52);
            item.put("sealProcessTypeValue", "wwww");
            item.put("sealProcessTypeName", "111");
            processList.add(item);
        }
        params.put("processList", processList);

        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 查询
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", 143);
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
