package org.aidan;

import org.aidan.util.HttpUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestGateway {

    private static final String ADDR = "http://localhost:8083";
//    private static final String ADDR = "http://10.50.8.29:8083";
//    private static final String ADDR = "http://10.50.8.29";
//    private static final String ADDR = "http://123.59.38.12";

    // 测试登录
    @Test
    public void test1() {
        String url = ADDR + "/recon/open/login";
        Map<String, Object> params = new HashMap<>();
        params.put("username", "1001");
        params.put("password", "6465a2a9b0c85f960c4757bde8ed48613f2e2f5fab85a4692dd65912b50a345a");
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 测试过滤器
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/org/menu/tree";
        Map<String, String> headers = new HashMap<>();
        headers.put("token", "MTQyY2QzZjFlMmRiNDI2NDgzZjJhYmQ0NTUzMmFiYWQ6NjQ2NWEyYTliMGM4NWY5NjBjNDc1N2JkZThlZDQ4NjEzZjJlMmY1ZmFiODVhNDY5MmRkNjU5MTJiNTBhMzQ1YToxNTE4NTAyNzc4OTg4");

        Map<String, Object> params = new HashMap<>();
        params.put("aaa", 111);
        String result = HttpUtil.get(url, params, headers);
        System.out.println(result);
    }

    @Test
    public void test3() {
        String uri = "/recon/check/org/menu/tree/02e471881bcb4ff9972cf6bdd8c44e48";
        System.out.println(analysisURI(uri));
    }

    // TODO 解析URI
    public String analysisURI(String requestURI) {
        String uriSeparator = "/";
        String[] split = requestURI.split(uriSeparator);
        String uri = "";
        for (int i = 0; i < split.length; i++) {
            String item = split[i];
            if (StringUtils.isNotBlank(item)) {
                Matcher m1 = Pattern.compile("^[0-9]{1,}$").matcher(item);
                Matcher m2 = Pattern.compile("^[0-9a-zA-Z]{32}$").matcher(item);
                if (m1.matches() || m2.matches()) { // restfull api id处理
                    item = "{id}";
                }
                uri += (uriSeparator + item);
            }
        }
        return uri;
    }


    @Test
    public void test4() {
        String md5 = DigestUtils.md5Hex("1001");
        String sha256Hex = DigestUtils.sha256Hex(md5);

        System.out.println(sha256Hex);
    }


    // 测试初始化权限接口
    @Test
    public void test5() {
        String uri = ADDR + "/recon/check/init/uriRoleHash";
        String result = HttpUtil.get(uri, null, null);
        System.out.println(result);
    }

    // 测试登出接口
    @Test
    public void test6() {
        String url = ADDR + "/recon/open/logout";
        Map<String, Object> params = new HashMap<>();
        params.put("token", "NWZmNmIyZWFmODYxNDA5ZmJkZDhjYTY3NWZkNGVkMTM6NjQ2NWEyYTliMGM4NWY5NjBjNDc1N2JkZThlZDQ4NjEzZjJlMmY1ZmFiODVhNDY5MmRkNjU5MTJiNTBhMzQ1YToxNTIzOTYwNTYxNjEw");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }
}
