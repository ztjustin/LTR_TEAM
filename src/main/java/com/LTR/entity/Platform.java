package com.LTR.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="platform", uniqueConstraints={@UniqueConstraint(columnNames = {"serialPlatform","name"})})
public class Platform implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="platform_id", unique = true, nullable = false)
	private Long platformId;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="locationId", nullable = false)
	private Location location;
	
	@Column(name = "locationIsShared", nullable = false, length= 45)
	private boolean locationIsShared;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idLocationShared", nullable = true)
	private Location locationShared;
	
	@Enumerated(EnumType.STRING)
	@JoinColumn(name="bussinessUnit", nullable = true)
	private BussinessUnit bussinessUnit;
	
	@Column(name = "name", nullable = false, length= 45)
	private String name;
	
	@Column(name = "project", nullable = false, length= 45)
	private String project;
	
	@Column(name = "serialPlatform", nullable = false, length= 45)
	private String serialPlatform;
	
	@Column(name = "model", nullable = false, length= 45)
	private String model;
	
	@Column(name = "chasisSerial", nullable = false, length= 45)
	private String chasisSerial;
	
	@Column(name = "chasisModel", nullable = false, length= 45)
	private String chasisModel;
	
	@Column(name = "ismpKitName", nullable = false, length= 45)
	private String ismpKitName;
	
	@Column(name = "ismpSerialNumber", nullable = false, length= 45)
	private String ismpSerialNumber;
	
	@Column(name = "assignedTo", nullable = false, length= 45)
	private String assignedTo;
	
	@Column(name = "OwnedBy", nullable = false, length= 45)
	private String OwnedBy;
	
	@Column(name = "ismNumber", nullable = false, length= 45)
	private int ismNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "receivedDate", nullable = false)
	private Date receivedDate;
	
	@Column(name = "asset", nullable = false, length= 45)
	private int asset;
	
	@Column(name = "startStatus", nullable = false, length= 45)
	private boolean startStatus;
	
	@Column(name = "finalStatus", nullable = false, length= 45)
	private boolean finalStatus;
	
	@Column(name = "cloudReady", nullable = false, length= 45)
	private boolean cloudReady;
		
	@OneToMany(mappedBy="platform")
	private List<Annotation> annotations;
	
	/*GETTERS AND SETTERS*/
	
	public Platform() {
		super();
	}
	
	public Platform(Long platformId, Location location, boolean locationIsShared, Location locationShared,
			BussinessUnit bussinessUnit, String name, String project, String serialPlatform, String model,
			String chasisSerial, String chasisModel, String ismpKitName, String ismpSerialNumber, String assignedTo,
			String ownedBy, int ismNumber, Date receivedDate, int asset, boolean startStatus, boolean finalStatus,
			boolean cloudReady, List<Annotation> annotations) {
		super();
		this.platformId = platformId;
		this.location = location;
		this.locationIsShared = locationIsShared;
		this.locationShared = locationShared;
		this.bussinessUnit = bussinessUnit;
		this.name = name;
		this.project = project;
		this.serialPlatform = serialPlatform;
		this.model = model;
		this.chasisSerial = chasisSerial;
		this.chasisModel = chasisModel;
		this.ismpKitName = ismpKitName;
		this.ismpSerialNumber = ismpSerialNumber;
		this.assignedTo = assignedTo;
		this.OwnedBy = ownedBy;
		this.ismNumber = ismNumber;
		this.receivedDate = receivedDate;
		this.asset = asset;
		this.startStatus = startStatus;
		this.finalStatus = finalStatus;
		this.cloudReady = cloudReady;
		this.annotations = annotations;
	}



	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

	public Location getLocationId() {
		return location;
	}

	public void setLocationId(Location locationId) {
		this.location = locationId;
	}

	public boolean isLocationIsShared() {
		return locationIsShared;
	}

	public void setLocationIsShared(boolean locationIsShared) {
		this.locationIsShared = locationIsShared;
	}

	public Location getLocationShared() {
		return locationShared;
	}

	public void setLocationShared(Location locationShared) {
		this.locationShared = locationShared;
	}

	public BussinessUnit getBussinessUnit() {
		return bussinessUnit;
	}

	public void setBussinessUnit(BussinessUnit bussinessUnit) {
		this.bussinessUnit = bussinessUnit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialPlatform() {
		return serialPlatform;
	}

	public void setSerialPlatform(String serialPlatform) {
		this.serialPlatform = serialPlatform;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getChasisSerial() {
		return chasisSerial;
	}

	public void setChasisSerial(String chasisSerial) {
		this.chasisSerial = chasisSerial;
	}

	public String getChasisModel() {
		return chasisModel;
	}

	public void setChasisModel(String chasisModel) {
		this.chasisModel = chasisModel;
	}

	public String getIsmpKitName() {
		return ismpKitName;
	}

	public void setIsmpKitName(String ismpKitName) {
		this.ismpKitName = ismpKitName;
	}

	public String getIsmpSerialNumber() {
		return ismpSerialNumber;
	}

	public void setIsmpSerialNumber(String ismpSerialNumber) {
		this.ismpSerialNumber = ismpSerialNumber;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getOwnedBy() {
		return OwnedBy;
	}

	public void setOwnedBy(String ownedBy) {
		OwnedBy = ownedBy;
	}

	public int getIsmNumber() {
		return ismNumber;
	}

	public void setIsmNumber(int ismNumber) {
		this.ismNumber = ismNumber;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public int getAsset() {
		return asset;
	}

	public void setAsset(int asset) {
		this.asset = asset;
	}

	public boolean isStartStatus() {
		return startStatus;
	}

	public void setStartStatus(boolean startStatus) {
		this.startStatus = startStatus;
	}

	public boolean isFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(boolean finalStatus) {
		this.finalStatus = finalStatus;
	}

	public boolean isCloudReady() {
		return cloudReady;
	}

	public void setCloudReady(boolean cloudReady) {
		this.cloudReady = cloudReady;
	}


	public List<Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<Annotation> annotations) {
		this.annotations = annotations;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Platform [platformId=" + platformId + ", location=" + location + ", locationIsShared="
				+ locationIsShared + ", locationShared=" + locationShared + ", bussinessUnit=" + bussinessUnit
				+ ", name=" + name + ", project=" + project + ", serialPlatform=" + serialPlatform + ", model=" + model
				+ ", chasisSerial=" + chasisSerial + ", chasisModel=" + chasisModel + ", ismpKitName=" + ismpKitName
				+ ", ismpSerialNumber=" + ismpSerialNumber + ", assignedTo=" + assignedTo + ", OwnedBy=" + OwnedBy
				+ ", ismNumber=" + ismNumber + ", receivedDate=" + receivedDate + ", asset=" + asset + ", startStatus="
				+ startStatus + ", finalStatus=" + finalStatus + ", cloudReady=" + cloudReady + ", annotations="
				+ annotations + "]";
	}

	
}
