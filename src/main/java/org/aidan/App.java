package org.aidan;

/**
 * 求 5! = 5 * 4 * 3 * 2 * 1
 */
public class App {
    public static void main(String[] args) {
        int aaa = aaa(10);
        System.out.println(aaa);
    }

    public static int aaa(int n) {
        if (n > 1) {
            return n * aaa(n - 1);
        } else {
            return n;
        }
    }
}
