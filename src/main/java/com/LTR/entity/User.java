package com.LTR.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="username",nullable=false,unique=true,length=45)
	private String userName;
	
	@Column(name="name",nullable=false,length=50)
	private String name;
	
	@Column(name="lastname",nullable=false,length=50)
	private String lastName;
	
	@Column(name="age",nullable=false)
	private int age;
	
	@Column(name="enable",nullable=false)
	private boolean enable;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>();
	
	public User() {
		super();
	}

	public User(String userName, boolean enable, String password) {
		super();
		this.userName = userName;
		this.enable = enable;
		this.password = password;
	}

	public User(String userName, String name, String lastName, int age, boolean enable, String password,
			Set<UserRole> userRole) {
		super();
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.enable = enable;
		this.password = password;
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	
	
	/*@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="image",nullable=false)
	private byte[] image;*/
	

	/*//return the string code
    public String getImageEncoded() {
    	byte[] encodeImage = Base64.getEncoder().encode(this.image);
        return new String(encodeImage);
    }*/


    
}
