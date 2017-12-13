package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	public String test() {
		String uuid = UUID.randomUUID().toString();
		
		//stringRedisTemplate.opsForValue().m
//		redisTemplate.opsForValue().set(uuid, "redis测试",1L);
//		stringRedisTemplate.opsForValue().set(uuid, "string测试",1L);
//	    redisTemplate.opsForValue().set("redis姓名", "张三1");
//		stringRedisTemplate.opsForValue().set("string姓名2", "张三2");
		
		Map<String,User> map = new HashMap<String,User>();
		List<User> list = new ArrayList<>();
		User user = new User(2, "xxx", 16, 90);
		map.put(user.getId()+"", user);
		list.add(user);
		redisTemplate.opsForList().leftPush("userslist:001", list);
		redisTemplate.opsForHash().putAll("users:099", map);
		//stringRedisTemplate.opsForHash().putAll("users:002", map);
		
		return null;
		
	}
	
	public void getString() {
		
		List<User> list = redisTemplate.opsForList().range("userslist:001", 0L, -1L);
		
		System.out.println(list.get(0));
		
		//System.out.println(redisTemplate.opsForHash().get("Stu:003", "name"));
		
		//System.out.println(stringRedisTemplate.opsForHash().get("Stu:003", "name"));
	}

	public void saveUser(User user) {
		redisTemplate.opsForValue().set("UserList:"+user.getId(), user);
	}

	public List<User> showUser() {
		List<User> listAll = new ArrayList<User>();
		for(int i=1;i<10;i++) {
			System.out.println(redisTemplate.opsForValue().get("UserList:"+i));
			User user = (User) redisTemplate.opsForValue().get("UserList:"+i);
			System.out.println(user);
			if(user!=null) {
//				System.out.println(list.get(0).getId());
//				System.out.println(list.get(0).getId());
				listAll.add(user);
			}
		}		
		return listAll;
	}
	
}
