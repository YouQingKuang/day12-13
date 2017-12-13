package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisApplicationTests {

	@Autowired
	private RedisService redisService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void stringTest() {
		redisService.test();
	}
	
	@Test
	public void getString() {
		redisService.getString();
	}
	

}
