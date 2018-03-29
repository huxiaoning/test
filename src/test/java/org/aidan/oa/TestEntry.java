package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试入职申请
 */
public class TestEntry {

    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "99c784d19d86455f96d2d7a39881d97e";

    // 测试新增入职申请
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/entry?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("name", "李七夜");
        params.put("entryOrgId", "111");
        params.put("entryOrgName", "111");
        params.put("entryQuarter", "111");
        params.put("entryQuarterName", "111");
        params.put("entryTime", new Date());
        params.put("reportSuperior", "111");
        params.put("reportSuperiorName", "111");
        params.put("approvalSuperior", "111");
        params.put("approvalSuperiorName", "111");
        params.put("jobNum", 111);
        params.put("specialRequire", "111");
        params.put("equipmentRequire", "111");
        params.put("stationNum", "111");
        params.put("office", "111");
        params.put("computerNum", "111");
        params.put("email", "111");
        params.put("emailPassword", "111");
        params.put("oaAccount", "111");
        params.put("oaAccountPassword", "111");
        params.put("extNum", "111");
        params.put("cloudAccount", "111");
        params.put("cloudAccountPassword", "111");
        params.put("personalData", "1");
        params.put("contract", "1");
        params.put("roster", "1");
        params.put("entryNotice", "1");
        params.put("officeSupplies", "1");
        params.put("entranceGuardFingerprint", "1");
        params.put("businessCard", "1");
        params.put("ifSubmit", "0");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试查询入职申请单详情
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "92");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试用户列表，顶岗用户下拉列表框用
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/oa/org-user/userList?userId=527f98fdbaad48a99b50081512941bd9";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }
}
