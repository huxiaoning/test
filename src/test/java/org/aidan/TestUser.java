package org.aidan;

import org.aidan.util.HttpUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUser {

    private static final String ADDR = "http://localhost:8082";
//    private static final String ADDR = "http://10.50.8.23:8081";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "5ff6b2eaf861409fbdd8ca675fd4ed13";

    // 新增
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/org/user";
        Map<String, Object> params = new HashMap<>();
        params.put("nickName", "十佳菜鸟");
        params.put("password", "6465a2a9b0c85f960c4757bde8ed48613f2e2f5fab85a4692dd65912b50a345a");
        params.put("email", "a2@sina.com");
        params.put("mobile", "13270008624");
        params.put("remarks", "备注信息1");
        params.put("no", "002");
        params.put("name", "研发部员工");
        params.put("phone", "1123");
        params.put("userType", null);
        params.put("photo", "aaa/bbb/ccc.png");
//        params.put("roleIds", "1,2,3,4");
        List<Map<String, Object>> orgQuarterList = new ArrayList<>();
        orgQuarterList.add(new HashMap() {{
            put("orgId", 1);
            put("quarter", 100);
        }});
        orgQuarterList.add(new HashMap() {{
            put("orgId", 2);
            put("quarter", 3);
        }});
        params.put("orgQuarterList", orgQuarterList);
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 编辑
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/org/user";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("nickName", "十佳菜鸟1");
        params.put("password", "6465a2a9b0c85f960c4757bde8ed48613f2e2f5fab85a4692dd65912b50a345a");
        params.put("email", "a2@sina.com");
        params.put("mobile", "13270008624");
        params.put("remarks", "备注信息1");
        params.put("no", "002");
        params.put("name", "研发部员工1");
        params.put("phone", "1123");
        params.put("userType", null);
        params.put("photo", "aaa/bbb/ccc.png1");
//        params.put("roleIds", "1,2,3,4");
        List<Map<String, Object>> orgQuarterList = new ArrayList<>();
        orgQuarterList.add(new HashMap() {{
            put("orgId", 1);
            put("quarter", 100);
        }});
        orgQuarterList.add(new HashMap() {{
            put("orgId", 2);
            put("quarter", 3);
        }});
        params.put("orgQuarterList", orgQuarterList);
        String result = HttpUtil.put(url, params, null);
        System.out.println(result);
    }

    // 删除
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/org/user/" + id;
        String result = HttpUtil.delete(url, null, null);
        System.out.println(result);
    }

    // 详情
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/org/user/" + id;
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    // 详情2
    @Test
    public void test42() {
        String url = ADDR + "/recon/check/org/user/inf0";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "5ce74ec4f70e41a5a7db3e55ff67e423");
        params.put("parentId", "a7a99cdd756d4da8b87aac399516142b");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

    // 分页
    @Test
    public void test5() {
        String url = ADDR + "/recon/check/org/user";
        String result = HttpUtil.get(url, null, null);
        System.out.println(result);
    }

    // 生成默认密码"000000"六个零
    @Test
    public void test6() {
        String password = "000000";
        String pwd = DigestUtils.sha256Hex(DigestUtils.md5Hex(password));
        System.out.println(pwd);
    }
}
