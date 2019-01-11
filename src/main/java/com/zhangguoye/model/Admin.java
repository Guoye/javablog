package com.zhangguoye.model;

public class Admin {
	
	private String id;
	private String name;
	private Integer age;
	private UserContactInfo userContactInfo;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UserContactInfo getUserContactInfo() {
		return userContactInfo;
	}

	public void setUserContactInfo(UserContactInfo userContactInfo) {
		this.userContactInfo = userContactInfo;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", age=" + age + ", userContactInfo=" + userContactInfo + "]";
	}

}
