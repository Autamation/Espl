package com.prakat.model;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "Tenon_ResultsetObj")

public class TenonApiVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "tenon_Id")
	private Long tenon_Id;



	@Column(name = "WCAG_Criteria")
	private String WCAG_Criteria;

	@Column(name = "Level")
	private String level;

	@Column(name = "WCAG_Principle")
	private String WCAG_Principle;

	@Column(name = "Principle_Description")
	private String Principle_Description;

	@Column(name = "Guideline_Description")
	private String Guideline_Description;

	@Column(name = "WCAG_Guideline")
	private String WCAG_Guideline;

	@Column(name = "WCAG_Sublevel")
	private String WCAG_Sublevel;

	@Column(name = "Sublevel_Description")
	private String Sublevel_Description;

	@Column(name = "WCAG_Level")
	private String WCAG_Level;

	@Column(name = "Severity")
	private String Severity;

	@Column(name = "Type")
	private String Type;

	/*public long getuId() {
		return uId;
	}

	public void setuId(long uId) {
		this.uId = uId;
	}*/

	@Column(name = "errorDescription")
	private String errorDescription;
	
	@Column(name = "resultTitle")
	private String resultTitle;
	
	@Column(name = "standards")
	private String standards;
	
	@Column(name = "errorTitle")
	private String errorTitle;
	
	@Column(name = "errorSnippet")
	private String errorSnippet;

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	/**
	 * @return the resultTitle
	 */
	public String getResultTitle() {
		return resultTitle;
	}

	/**
	 * @param resultTitle the resultTitle to set
	 */
	public void setResultTitle(String resultTitle) {
		this.resultTitle = resultTitle;
	}

	/**
	 * @return the standards
	 */
	public String getStandards() {
		return standards;
	}

	/**
	 * @param standards the standards to set
	 */
	public void setStandards(String standards) {
		this.standards = standards;
	}

	/**
	 * @return the errorTitle
	 */
	public String getErrorTitle() {
		return errorTitle;
	}

	/**
	 * @param errorTitle the errorTitle to set
	 */
	public void setErrorTitle(String errorTitle) {
		this.errorTitle = errorTitle;
	}

	/**
	 * @return the errorSnippet
	 */
	public String getErrorSnippet() {
		return errorSnippet;
	}

	/**
	 * @param errorSnippet the errorSnippet to set
	 */
	public void setErrorSnippet(String errorSnippet) {
		this.errorSnippet = errorSnippet;
	}

	public String getWCAG_Criteria() {
		return WCAG_Criteria;
	}

	public void setWCAG_Criteria(String wCAG_Criteria) {
		WCAG_Criteria = wCAG_Criteria;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getWCAG_Principle() {
		return WCAG_Principle;
	}

	public void setWCAG_Principle(String wCAG_Principle) {
		WCAG_Principle = wCAG_Principle;
	}

	public String getPrinciple_Description() {
		return Principle_Description;
	}

	public void setPrinciple_Description(String principle_Description) {
		Principle_Description = principle_Description;
	}

	public String getGuideline_Description() {
		return Guideline_Description;
	}

	public void setGuideline_Description(String guideline_Description) {
		Guideline_Description = guideline_Description;
	}

	public String getWCAG_Guideline() {
		return WCAG_Guideline;
	}

	public void setWCAG_Guideline(String wCAG_Guideline) {
		WCAG_Guideline = wCAG_Guideline;
	}

	public String getWCAG_Sublevel() {
		return WCAG_Sublevel;
	}

	public void setWCAG_Sublevel(String wCAG_Sublevel) {
		WCAG_Sublevel = wCAG_Sublevel;
	}

	public String getSublevel_Description() {
		return Sublevel_Description;
	}

	public void setSublevel_Description(String sublevel_Description) {
		Sublevel_Description = sublevel_Description;
	}

	public String getWCAG_Level() {
		return WCAG_Level;
	}

	public void setWCAG_Level(String wCAG_Level) {
		WCAG_Level = wCAG_Level;
	}

	public String getSeverity() {
		return Severity;
	}

	public void setSeverity(String severity) {
		Severity = severity;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

}