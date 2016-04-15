package com.jlfex.hutu.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class Tuser extends IdEntity implements Serializable {

	private static final long serialVersionUID = -806460426139468454L;

	private String userCode;
	private String userName;
	private String userSex;
	private int userAge;
	private String userAddress;
	private String userIconPath;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserIconPath() {
		return userIconPath;
	}

	public void setUserIconPath(String userIconPath) {
		this.userIconPath = userIconPath;
	}

	@Override
	public String toString() {
		return "Tuser [userCode=" + userCode + ", userName=" + userName
				+ ", userSex=" + userSex + ", userAge=" + userAge
				+ ", userAddress=" + userAddress + ", userIconPath="
				+ userIconPath + "]";
	}

	
}
