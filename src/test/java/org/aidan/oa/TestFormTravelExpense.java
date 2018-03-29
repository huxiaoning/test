package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.*;

/**
 * 测试差旅费报销单
 */
public class TestFormTravelExpense {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "e9d4f4cdbcb34f0999678017c6e0d251";

    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/travel-expense?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("applyUserId", "111");
        params.put("applyName", "111");
        params.put("orgId", "111");
        params.put("orgName", "111");
        params.put("tel", "111");
        params.put("reimbursementTime", new Date());
        params.put("cardName", "111");
        params.put("amount", 55);
        params.put("cardAccount", "111");
        params.put("openAccountBank", "111");
        params.put("overspend", 33);
        params.put("loan", 33);
        params.put("reimbursementAmount", 33);
        params.put("amountWords", "SSSS");
        params.put("ifSubmit", "0");
        List<Map<String, Object>> itemList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("formBaseId", "111");
            item.put("formLabel", "111");
            item.put("projectId", "111");
            item.put("time", new Date());
            item.put("businessTravelerName", "1233");
            item.put("quarter", 5);
            item.put("quarterName", "222");
            item.put("sourceSite", "222");
            item.put("targetSite", "222");
            item.put("days", 2);
            item.put("planeTicket", 22);
            item.put("trainTicket", 22);
            item.put("coach", 22);
            item.put("targetPlaceTraffic", 22);
            item.put("hotelExpense", 22);
            item.put("urbanTraffic", 22);
            item.put("mealAllowance", 22);
            item.put("subtotal", 22);
            itemList.add(item);
        }
        params.put("itemList", itemList);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试查询差旅费报销单
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "95");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
