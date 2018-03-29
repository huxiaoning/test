package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.*;

/**
 * 测试借款申请单(2)
 */
public class TestFormLoan {

    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "2a500028feb44f7d8bd3ba18290cb408";

    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/loan?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("applyTime", new Date());
        params.put("attachmentCount", 5);
        params.put("reimbursementer", "111");
        params.put("openAccountBank", "111");
        params.put("cardAccount", "111");
        params.put("payMethod", "1");
        params.put("invoice", "1");
        params.put("paid", 44);
        params.put("prepay", 0);
        params.put("contractAmount", 44);
        params.put("invoiceAmount", 44);
        params.put("amountWords", "QQQ");
        params.put("amount", 444);
        params.put("ifSubmit", "0");
        List<Map<String, Object>> itemList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("explains", "111");
            item.put("orgId", "111");
            item.put("orgName", "111");
            item.put("projectId", "111");
            item.put("projectName", "111");
            item.put("expenseType", 33);
            item.put("expenseTypeValue", "dsa");
            item.put("expenseTypeName", "22");
            item.put("amount", 33);
            itemList.add(item);
        }
        params.put("itemList", itemList);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试查询借款申请单2
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "97");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试 获取当前用户所属部门列表
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/oa/org-user/myOrgList";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "527f98fdbaad48a99b50081512941bd9");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
