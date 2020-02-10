package com.prakat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wave_aim_wcag")

public class WaveApiByWCAG implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wave_id")
	private Integer waveId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "user_Id")
	private int userId;
	
	@Column(name="featureCount")
	private int featureCount;
	
	@Column(name="featureDescription")
	private String featureDescription;
	
	@Column(name="ariaCount")
	private int ariaCount;
	
	@Column(name="ariaDescription")
	private String ariaDescription;
	
	@Column(name="alertCount")
	private int alertCount;
	
	@Column(name="alertDescription")
	private String alertDescription;
	
	@Column(name="contrastCount")
	private int contrastCount;
	
	@Column(name="contrastDescription")
	private String contrastDescription;
	
	@Column(name="errorCount")
	private int errorCount;
	
	@Column(name="errorDescription")
	private String errorDescription;
	
	@Column(name="structureCount")
	private int structureCount;
	
	@Column(name="structureDescription")
	private String structureDescription;
	
												///----getter and setter methodss---///
	
	public int getFeatureCount() {
		return featureCount;
	}

	public void setFeatureCount(int featureCount) {
		this.featureCount = featureCount;
	}

	public String getFeatureDescription() {
		return featureDescription;
	}

	public void setFeatureDescription(String featureDescription) {
		this.featureDescription = featureDescription;
	}

	public int getAriaCount() {
		return ariaCount;
	}

	public void setAriaCount(int ariaCount) {
		this.ariaCount = ariaCount;
	}

	public String getAriaDescription() {
		return ariaDescription;
	}

	public void setAriaDescription(String ariaDescription) {
		this.ariaDescription = ariaDescription;
	}

	public int getAlertCount() {
		return alertCount;
	}

	public void setAlertCount(int alertCount) {
		this.alertCount = alertCount;
	}

	public String getAlertDescription() {
		return alertDescription;
	}

	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}

	public int getContrastCount() {
		return contrastCount;
	}

	public void setContrastCount(int contrastCount) {
		this.contrastCount = contrastCount;
	}

	public String getContrastDescription() {
		return contrastDescription;
	}

	public void setContrastDescription(String contrastDescription) {
		this.contrastDescription = contrastDescription;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public int getStructureCount() {
		return structureCount;
	}

	public void setStructureCount(int structureCount) {
		this.structureCount = structureCount;
	}

	public String getStructureDescription() {
		return structureDescription;
	}

	public void setStructureDescription(String structureDescription) {
		this.structureDescription = structureDescription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
											//---end of getter and setter---////

}
