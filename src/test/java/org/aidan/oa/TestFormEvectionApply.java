package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试出差申请接口
 */
public class TestFormEvectionApply {

    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.18";

    private static final String id = "37c6e8b693ee4ff7b4a61fcb1aff8c4c";

    // 新增出差申请
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/evection-apply?userId=1";
        Map<String, Object> params = new HashMap<>();
        params.put("applyUserId", "1");
        params.put("applyName", "张三");
        params.put("orgId", "1");
        params.put("orgName", "组织机构管理");
        params.put("project", "苏州智慧社区");
        params.put("expectDepartTime", System.currentTimeMillis());
        params.put("expectReturnTime", System.currentTimeMillis());
        params.put("expectDays", 5);
        params.put("ifAbroad", "0");
        params.put("expectCost", 33.33);
        params.put("expectCostCapital", "叁拾叁圆叁角三分");
        params.put("tripDayPlain", "先到江苏省委听个报告，再去中央开个会");
        params.put("ifNeedBookTicket", "1");
        params.put("flightSeatPreference", "一等座,靠窗");
        params.put("ifNeedBookHotel", "1");
        params.put("hotelPreference", "五星级就行，不需要太高级");
//        params.put("ifSubmit", "1");

        params.put("formEvectionApplyTripList", new ArrayList() {{
            add(new HashMap<String, Object>() {{
                put("sourceSite", "苏州北站");
                put("targetSite", "北京南站");
                put("expectStartTime", System.currentTimeMillis());
                put("expectEndTime", System.currentTimeMillis());
                put("vehicle", 100);
                put("vehicleName", "高铁");
                put("urbanTraffic", 101);
                put("urbanTrafficName", "出租车");
            }});
            add(new HashMap<String, Object>() {{
                put("sourceSite", "北京南站");
                put("targetSite", "苏州北站");
                put("expectStartTime", System.currentTimeMillis());
                put("expectEndTime", System.currentTimeMillis());
                put("vehicle", 100);
                put("vehicleName", "高铁");
                put("urbanTraffic", 101);
                put("urbanTrafficName", "出租车");
            }});

        }});

        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试编辑出差申请接口
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/evection-apply";
        Map<String, Object> params = new HashMap<>();
        params.put("id", "4fcabb32dccf4d33b2ef219b990b09d7");
        params.put("applyUserId", "1");
        params.put("applyName", "张三5");
        params.put("orgId", "1");
        params.put("orgName", "组织机构管理");
        params.put("project", "苏州智慧社区5");
        params.put("expectDepartTime", System.currentTimeMillis());
        params.put("expectReturnTime", System.currentTimeMillis());
        params.put("expectDays", 5);
        params.put("ifAbroad", "0");
        params.put("expectCost", 33.33);
        params.put("expectCostCapital", "叁拾叁圆叁角三分");
        params.put("tripDayPlain", "先到江苏省委听个报告，再去中央开个会");
        params.put("ifNeedBookTicket", "1");
        params.put("flightSeatPreference", "一等座,靠窗");
        params.put("ifNeedBookHotel", "1");
        params.put("hotelPreference", "五星级就行，不需要太高级");

        params.put("formEvectionApplyTripList", new ArrayList() {{
            add(new HashMap<String, Object>() {{
                put("sourceSite", "苏州北站");
                put("targetSite", "北京南站");
                put("expectStartTime", System.currentTimeMillis());
                put("expectEndTime", System.currentTimeMillis());
                put("vehicle", 100);
                put("vehicleName", "高铁1");
                put("urbanTraffic", 101);
                put("urbanTrafficName", "出租车");
            }});
            add(new HashMap<String, Object>() {{
                put("sourceSite", "北京南站");
                put("targetSite", "苏州北站");
                put("expectStartTime", System.currentTimeMillis());
                put("expectEndTime", System.currentTimeMillis());
                put("vehicle", 100);
                put("vehicleName", "高铁2");
                put("urbanTraffic", 101);
                put("urbanTrafficName", "出租车");
            }});

        }});

        String result = HttpUtil.put(url, params, null);
        System.out.println(result);
    }

    // 测试删除接口
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/oa/evection-apply/" + id;
        String result = HttpUtil.delete(url, null, null);
        System.out.println(result);
    }

    // 测试详情接口
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/oa/evection-apply/" + id;
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    // 测试分页接口
    @Test
    public void test5() {
        String url = ADDR + "/recon/check/oa/evection-apply";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }
}
