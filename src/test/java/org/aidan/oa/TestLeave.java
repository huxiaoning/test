package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试请假接口
 */
public class TestLeave {
    private static final String ADDR = "http://localhost:8080";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "d4e4ebe03e61459da4e3d88b40beeede";

    // 测试新增请假申请
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/leave?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("applyUserId", "5ff6b2eaf861409fbdd8ca675fd4ed13");
        params.put("applyName", "研发部员工");
        params.put("orgId", "b144b26b908b425fbd13bc1786859496");
        params.put("orgName", "研发部");
        params.put("quarter", 1123);
        params.put("quarterName", "研发部员工");
        params.put("urgentAddr", "随便写一个地址");
        params.put("urgentTel", "随便写一个电话");
        params.put("leaveType", 100);
        params.put("leaveTypeName", "病假");
        params.put("leaveStartTime", new Date());
        params.put("leaveEndTime", new Date());
        params.put("totalDays", 1);
        params.put("explains", "随便说明一下");
        params.put("prove", "/a/b/c.jpg");
        params.put("hasTransfer", "1");
        params.put("transfer", "eqfewqfewq");
        params.put("transferName", "eqfewqfewq");
        params.put("ifSubmit", "1");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试查询请假申请单
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "91");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 测试职位下拉列表
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/oa/org-user/quarterList?userId=527f98fdbaad48a99b50081512941bd9";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }
}
