package org.aidan;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestRedis {

    @Test
    public void test1() {
        Jedis jedis = new Jedis("10.50.8.25", 6379);
        jedis.connect();
        jedis.select(0);
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key + "-" + jedis.get(key));
        }
        jedis.disconnect();
    }

    @Test
    public void test2() {
        Jedis jedis = new Jedis("10.50.8.25", 6379);
        jedis.connect();
//        jedis.set("name","胡小宁1");
        jedis.set("aaa", "bbb1");
        jedis.disconnect();
    }
}
