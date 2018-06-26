package com.dev.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XmlRootElement
@Entity
@Table(name="user_master")
public class User_Master {
	@XmlAttribute
	@Column(name="UserId")
	@Id
	String userId;
	
	@Column(name="UserName")
	String userName;
	
	@Column(name="UserPassword")
	String userPassword;
	
	@Column(name="UserType")
	String userType;
	
	public String getUserId() {
		return userId;
	}
@XmlElement
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	@XmlElement
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}
	@XmlElement
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}
	@XmlElement
	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	
	
}