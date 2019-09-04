package com.LTR.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="locationId", unique = true, nullable = false)
	private String locationId;
	
    @Enumerated(EnumType.STRING)
    @Column(name = "bussinessUnit", nullable = false, length= 45)
    private BussinessUnit bussinessUnit;
    
    @OneToMany(mappedBy = "location")
    private List<Platform> platforms;

	public Location() {
		super();
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public BussinessUnit getBussinessUnit() {
		return bussinessUnit;
	}

	public void setBussinessUnit(BussinessUnit bussinessUnit) {
		this.bussinessUnit = bussinessUnit;
	}
       
}
