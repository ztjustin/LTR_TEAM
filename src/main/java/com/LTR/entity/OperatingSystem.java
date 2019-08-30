package com.LTR.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="operating_system")
public class OperatingSystem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="operating_system_id", unique = true, nullable = false)
	private int operatingSystemId;
	
    @Enumerated(EnumType.STRING)
    private TypeSystem typeSystem;
    
	@Column(name = "name_System", nullable = false, length= 45)
	private String nameSystem;
	

	/*GETTERS AND SETTERS*/
	
	public OperatingSystem() {
		super();
	}

	public OperatingSystem(TypeSystem typeSystem, String nameSystem) {
		super();
		this.typeSystem = typeSystem;
		this.nameSystem = nameSystem;
	}

	public int getOperatingSystemId() {
		return operatingSystemId;
	}

	public void setOperatingSystemId(int operatingSystemId) {
		this.operatingSystemId = operatingSystemId;
	}

	public TypeSystem getTypeSystem() {
		return typeSystem;
	}

	public void setTypeSystem(TypeSystem typeSystem) {
		this.typeSystem = typeSystem;
	}

	public String getNameSystem() {
		return nameSystem;
	}

	public void setNameSystem(String nameSystem) {
		this.nameSystem = nameSystem;
	}

	
	
	
	
}
