package org.aidan.common;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestHoliday {

    private static final String ADDR = "http://localhost:8085";
//    private static final String ADDR = "http://10.50.8.18:8081";
//    private static final String ADDR = "http://10.50.8.18";

    private static final String id = "492254686394499588a4296d64ca5e3d";

    // 保存假期列表
    @Test
    public void test3() {
        String url = ADDR + "/recon/check/common/holiday?userId=01649da50b3b45a7b27be92b85a901db";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "01649da50b3b45a7b27be92b85a901db");
        params.put("year", "2018");
        params.put("holidayList", new ArrayList<Date>() {{
            add(new Date());
            add(new Date());
            add(new Date());
        }});
        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 查询假期列表
    @Test
    public void test4() {
        String url = ADDR + "/recon/check/common/holiday";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "01649da50b3b45a7b27be92b85a901db");
        params.put("year", "2018");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }


}
