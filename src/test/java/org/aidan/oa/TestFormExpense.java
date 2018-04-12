package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.*;

/**
 * 测试费用报销单
 */
public class TestFormExpense {

    private static final String ADDR = "http://localhost:8084";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "84be2b66bc2a4e73a936fb83e15705bd";

    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/expense?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("cardAccount", "111");
        params.put("reimbursementer", "111");
        params.put("openAccountBank", "111");
        params.put("cardName", "111");
        params.put("reimbursementTime", new Date());
        params.put("attachmentCount", 1);
        params.put("cashierMode", "1");
        params.put("costCapital", "dw   qfeww");
        params.put("cost", 44);
        params.put("loanNum", "2efdewf");
        params.put("cancelVerification", 324);
        params.put("ifSubmit", "0");
        List<Map<String, Object>> itemList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("abstracts", "111");
            item.put("orgId", "111");
            item.put("orgName", "111");
            item.put("projectId", "111");
            item.put("projectName", "111");
            item.put("expenseType", 44);
            item.put("expenseTypeValue", "aaaa");
            item.put("expenseTypeName", "aaaaaaaa");
            item.put("amount", 4325);
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
        params.put("type", "117");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
