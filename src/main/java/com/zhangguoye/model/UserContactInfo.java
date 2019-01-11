package com.zhangguoye.model;

public class UserContactInfo {
	
	private String phoneNo;
	private String address;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserContactInfo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserContactInfo [phoneNo=" + phoneNo + ", address=" + address + "]";
	}

}
