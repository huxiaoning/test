package org.aidan.test;

import org.junit.Test;

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
}
