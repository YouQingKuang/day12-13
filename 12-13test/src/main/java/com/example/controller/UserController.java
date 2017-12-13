package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.RedisService;
import com.example.User;

@Controller
public class UserController {
	
	@Autowired
	private RedisService redisService;
	
	@GetMapping("list")
	public String toList() {
		return "userlist";
	}
	
	@PostMapping("saveUser")
	public String saveUser(User user) {
		//System.out.println(user);
		redisService.saveUser(user);
		return "userlist";
	}

	
	@RequestMapping("showUser")
	@ResponseBody
	public Map showUser(Model model) {
		Map<String, Object> map = new HashMap<>();
		List<User> list = redisService.showUser();
		map.put("list", list);
		return map;
	}
	
}
