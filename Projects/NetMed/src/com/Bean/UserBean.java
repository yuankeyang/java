package com.Bean;

public class UserBean {
	private String user_name;
	private boolean sex;
	private String password;
	private String user_email;
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public void setSex(boolean sex) {
		this.sex=sex;
	}
	public boolean getSex() {
		return sex;
	}
	public void setUser_name(String user_name) {
		this.user_name=user_name;
	}
	public void setPasswprd(String password) {
		this.password=password;
	}
	public String getUser_name() {
		return this.user_name;
	}
	public String getPassword(){
		return this.password;
	}
}
