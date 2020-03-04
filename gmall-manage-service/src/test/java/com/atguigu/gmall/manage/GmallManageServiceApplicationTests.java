package com.atguigu.gmall.manage;

import com.atguigu.gmall.config.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageServiceApplicationTests {

    @Test
    public void contextLoads() {
        RedisUtil redisUtil = new RedisUtil();
        String s = "0";

        redisUtil.initJedisPool("122.51.97.164",6379, 0);
        Jedis jedis = redisUtil.getJedis();
        jedis.set("ok","没毛病");
        jedis.close();
    }



}
