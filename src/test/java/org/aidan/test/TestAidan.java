package org.aidan.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TestAidan {

    @Test
    public void test1() {
        Set<String> set = new HashSet<>();
        set.add("111111111");

        for (String id : set) {
            System.out.println(id);
        }
    }

    @Test
    public void test2() {
        String uri = "/recon/open/api/api";
        if (uri.contains("/open/")) {
            System.out.println("11111333");
        }
    }

    @Test
    public void testUUID() {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }

    @Test
    public void testDecimal() {
        System.out.println(new BigDecimal(-1).equals(new BigDecimal(-1)));

    }

    @Test
    public void test111() {
        String line = "invite_job01";
        // 去掉末尾的数字
        String reg = "[0-9]{2}$";
        line = line.replaceAll(reg, "");
        System.out.println(line);
    }

    @Test
    public void testDate() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1522747000000L)));
    }
}
