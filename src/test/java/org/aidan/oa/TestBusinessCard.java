package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试因公外出
 */
public class TestBusinessCard {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "8262608d10654f298da41847297255fd";

    // 测试新增
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/business-card?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("applyUserId", "5ff6b2eaf861409fbdd8ca675fd4ed13");
        params.put("applyName", "研发部员工");
        params.put("orgId", "b144b26b908b425fbd13bc1786859496");
        params.put("orgName", "研发部");
        params.put("companyName", "xxxx");
        params.put("chineseName", "中文名称");
        params.put("englishName", "englishName");
        params.put("chineseOrgName", "部门中文名");
        params.put("englishOrgName", "englishOrgName");
        params.put("chineseQuarterName", "职位中文名称");
        params.put("englishQuarterName", "englishQuarterName");
        params.put("tel", "11111");
        params.put("mobile", "11111");
        params.put("fax", "11111");
        params.put("email", "11111");
        params.put("chinesePrintQuantity", "4");
        params.put("englishPrintQuantity", "5");
        params.put("quarterChange", "0");
        params.put("specialRequire", "这个是什么破要求");
        params.put("ifSubmit", "1");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试查询因公外出申请单
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "117");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
