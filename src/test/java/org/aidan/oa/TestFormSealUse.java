package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.*;

public class TestFormSealUse {

    private static final String ADDR = "http://localhost:8084";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "5c6893e3fbfc48b4ae43fe73cf4dd99b";

    // 新增
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/seal-use?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
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
        params.put("sealUseType", 44);
        params.put("sealUseTypeValue", "44");
        params.put("sealUseTypeName", "44");
        params.put("useCount", 5);
        params.put("reason", "11111v");
        params.put("predictLendOutTime", new Date());
        params.put("predictReturnBackTime", new Date());
        params.put("ifSubmit", "0");
        List<Map<String, Object>> itemList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("sealType", 5);
            item.put("sealTypeValue", "wwww");
            item.put("sealTypeName", "111");
            itemList.add(item);
        }
        params.put("itemList", itemList);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 查询
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "132");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

}
