package com.LTR.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="host")
public class Host {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="host_id", unique = true, nullable = false)
	private Long hostId;
	
	@Column(name="name",nullable=false,length=80,unique = true)
	private String name;
	
	@Column(name="ip",nullable=false,length=50)
	private String ip;
	
	@Column(name="dal")
	private Boolean dal;
		
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "platform_id", nullable = true)
	private Platform platform;
	
	
	public Host() {
		super();
	}

	public Host(Long hostId, String name, String ip, Boolean dal, Platform platform) {
		super();
		this.hostId = hostId;
		this.name = name;
		this.ip = ip;
		this.dal = dal;
		this.platform = platform;
	}


	public Long getHostId() {
		return hostId;
	}

	public void setHostId(Long hostId) {
		this.hostId = hostId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Boolean getDal() {
		return dal;
	}

	public void setDal(Boolean dal) {
		this.dal = dal;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return "Host [hostId=" + hostId + ", name=" + name + ", ip=" + ip + ", dal=" + dal + ", platform=" + platform
				+ "]";
	}
	
		
}
