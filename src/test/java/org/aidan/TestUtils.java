package org.aidan;

import org.junit.Test;

public class TestUtils {

    @Test
    public void test1() {
        String a = ",a,f,b,";
        if (a.startsWith(",")) {
            a = a.substring(1);
        }
        System.out.println(a);
        if (a.endsWith(",")) {
            a = a.substring(0, a.length() - 1);
        }
        System.out.println(a);
    }
}
