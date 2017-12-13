package com.example;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * Description:
	 * @author xxx
	 */
	private static final long serialVersionUID = 6622525543885544282L;
	
	private int id;
	private String name;
	private int age;
	private int score;
	
	public User() {
		super();
	}

	public User(int id, String name, int age, int score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	
	
}
