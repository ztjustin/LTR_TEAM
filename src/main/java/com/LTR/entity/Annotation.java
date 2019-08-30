package com.LTR.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="annotation")
public class Annotation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="annotation_id", unique = true, nullable = false)
	private int annotationId;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "description", nullable = false, length= 500)
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="platform_id", nullable=false)
	private Platform platform;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="username", nullable=false)
	private User user;
	
	
	/*GETTERS AND SETTERS*/
	
	public Annotation() {
		super();
	}
	
	public Annotation(Date date, String description, Platform platform) {
		super();
		this.date = date;
		this.description = description;
		this.platform = platform;
	}
	
	public int getAnnotationId() {
		return annotationId;
	}
	
	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
