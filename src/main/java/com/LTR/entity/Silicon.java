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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="silicon",uniqueConstraints={@UniqueConstraint(columnNames = {"silicon_visual_id"})})
@EnableTransactionManagement
@DynamicUpdate
public class Silicon implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="mir", unique = false, nullable = true)
	private Long mir;
	
	@Column(name = "silicon_name", nullable = false, length= 45)
	private String siliconName;
	
	@Column(name = "type_silicon", nullable = false, length= 45)
	private String typeSilicon;
	
	@Column(name = "qdf", nullable = true, length= 45)
	private String qdf;
	
	@Column(name = "silicon_visual_id", nullable = false, length= 45)
	private String siliconVisualId;
	
	@Column(name = "cpu_id", nullable = true, length= 45)
	private String cpuId;
	
	@Column(name = "stepping", nullable = true, length= 45)
	private String stepping;
	
	@Column(name = "socket", nullable = true, length= 45)
	private String socket;
	
	@Column(name = "status_silicon", nullable = false,length= 45)
	private String statusSilicon;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_owner", nullable = false)
	private User userOwner;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_admission", nullable = false)
	private Date dateAdmission;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_request", nullable = true)
	private User userRequest;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_last_returned", nullable = true)
	private User userLastReturned;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_delivered", nullable = true)
	private Date dateDelivered;
				
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="platform", nullable = true)
	private Platform platform;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="platform_own", nullable = true,updatable= false)
	private Platform platformOwn;
		
	/*GETTERS AND SETTERS*/

	public Silicon() {
		super();
	}
	
	public Silicon(Long id, Long mir, String siliconName, String typeSilicon, String qdf, String siliconVisualId,
			String cpuId, String stepping, String socket, String statusSilicon, User userOwner, Date dateAdmission,
			User userRequest, User userLastReturned, Date dateDelivered, Platform platform, Platform platformOwn) {
		super();
		this.id = id;
		this.mir = mir;
		this.siliconName = siliconName;
		this.typeSilicon = typeSilicon;
		this.qdf = qdf;
		this.siliconVisualId = siliconVisualId;
		this.cpuId = cpuId;
		this.stepping = stepping;
		this.socket = socket;
		this.statusSilicon = statusSilicon;
		this.userOwner = userOwner;
		this.dateAdmission = dateAdmission;
		this.userRequest = userRequest;
		this.userLastReturned = userLastReturned;
		this.dateDelivered = dateDelivered;
		this.platform = platform;
		this.platformOwn = platformOwn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMir() {
		return mir;
	}

	public void setMir(Long mir) {
		this.mir = mir;
	}

	public String getSiliconName() {
		return siliconName;
	}

	public void setSiliconName(String siliconName) {
		this.siliconName = siliconName;
	}

	public String getTypeSilicon() {
		return typeSilicon;
	}

	public void setTypeSilicon(String typeSilicon) {
		this.typeSilicon = typeSilicon;
	}

	public String getQdf() {
		return qdf;
	}

	public void setQdf(String qdf) {
		this.qdf = qdf;
	}

	public String getSiliconVisualId() {
		return siliconVisualId;
	}

	public void setSiliconVisualId(String siliconVisualId) {
		this.siliconVisualId = siliconVisualId;
	}

	public String getCpuId() {
		return cpuId;
	}

	public void setCpuId(String cpuId) {
		this.cpuId = cpuId;
	}

	public String getStepping() {
		return stepping;
	}

	public void setStepping(String stepping) {
		this.stepping = stepping;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public User getUserOwner() {
		return userOwner;
	}

	public void setUserOwner(User userOwner) {
		this.userOwner = userOwner;
	}

	public Date getDateAdmission() {
		return dateAdmission;
	}

	public void setDateAdmission(Date dateAdmission) {
		this.dateAdmission = dateAdmission;
	}

	public User getUserRequest() {
		return userRequest;
	}

	public void setUserRequest(User userRequest) {
		this.userRequest = userRequest;
	}

	public Date getDateDelivered() {
		return dateDelivered;
	}

	public void setDateDelivered(Date dateDelivered) {
		this.dateDelivered = dateDelivered;
	}
	
	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public String getStatusSilicon() {
		return statusSilicon;
	}

	public void setStatusSilicon(String statusSilicon) {
		this.statusSilicon = statusSilicon;
	}


	public User getUserLastReturned() {
		return userLastReturned;
	}


	public void setUserLastReturned(User userLastReturned) {
		this.userLastReturned = userLastReturned;
	}
	
	
	public Platform getPlatformOwn() {
		return platformOwn;
	}

	public void setPlatformOwn(Platform platformOwn) {
		this.platformOwn = platformOwn;
	}

	@Override
	public String toString() {
		return "Silicon [id=" + id + ", mir=" + mir + ", siliconName=" + siliconName + ", typeSilicon=" + typeSilicon
				+ ", qdf=" + qdf + ", siliconVisualId=" + siliconVisualId + ", cpuId=" + cpuId + ", stepping="
				+ stepping + ", socket=" + socket + ", statusSilicon=" + statusSilicon + ", userOwner=" + userOwner
				+ ", dateAdmission=" + dateAdmission + ", userRequest=" + userRequest + ", userLastReturned="
				+ userLastReturned + ", dateDelivered=" + dateDelivered + ", platform=" + platform + ", platformOwn="
				+ platformOwn + "]";
	}
	
	
		
	
}
