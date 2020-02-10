package com.prakat.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tenon_Accesibility")
public class EQualityLabsVo implements Serializable {

	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "urlId")
	private int urlId;

	@Column(name = "url")
	private String url;

	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Column(name = "tenon_reportCreatedDate")
	private String createDate;
	
	

	@Column(name = "totalIssues")
	private String totalIssues;

	@Column(name = "totalErrors")
	private String totalErrors;

	@Column(name = "totalWarnings")
	private String totalWarnings;

	@Column(name = "totalNoOfTests")
	private String totalNoOfTests;

	@Column(name = "failedTests")
	private String failedTests;

	@Column(name = "passedTests")
	private String passedTests;

	/*
	 * Issues by level A
	 */
	private String pctBylevelA;
	private String countBylevelA;

	/*
	 * Issues by level AA
	 */
	private String pctBylevelAA;
	private String countBylevelAA;

	/*
	 * Issues by level AAA
	 */
	private String pctBylevelAAA;
	private String countBylevelAAA;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Tenon_Accesibility_Tenon_Resultset_Obj", joinColumns = { @JoinColumn(name = "urlId") }, inverseJoinColumns = { @JoinColumn(name = "resultset_Id") })

	@Column(name = "resultset_Id")
	
	//@ElementCollection(targetClass = ResultsetVo.class)
	private List<ResultsetVo> tenonObj2;

	public String getPctBylevelAA() {
		return pctBylevelAA;
	}

	public void setPctBylevelAA(String pctBylevelAA) {
		this.pctBylevelAA = pctBylevelAA;
	}

	public String getCountBylevelAA() {
		return countBylevelAA;
	}

	public void setCountBylevelAA(String countBylevelAA) {
		this.countBylevelAA = countBylevelAA;
	}

	public String getPctBylevelA() {
		return pctBylevelA;
	}

	public void setPctBylevelA(String pctBylevelA) {
		this.pctBylevelA = pctBylevelA;
	}

	public String getCountBylevelA() {
		return countBylevelA;
	}

	public void setCountBylevelA(String countBylevelA) {
		this.countBylevelA = countBylevelA;
	}

	public String getPctBylevelAAA() {
		return pctBylevelAAA;
	}

	public void setPctBylevelAAA(String pctBylevelAAA) {
		this.pctBylevelAAA = pctBylevelAAA;
	}

	public String getCountBylevelAAA() {
		return countBylevelAAA;
	}

	public void setCountBylevelAAA(String countBylevelAAA) {
		this.countBylevelAAA = countBylevelAAA;
	}

	public String getTotalIssues() {
		return totalIssues;
	}

	public void setTotalIssues(String totalIssues) {
		this.totalIssues = totalIssues;
	}

	public String getTotalErrors() {
		return totalErrors;
	}

	public void setTotalErrors(String totalErrors) {
		this.totalErrors = totalErrors;
	}

	public String getTotalWarnings() {
		return totalWarnings;
	}

	public void setTotalWarnings(String totalWarnings) {
		this.totalWarnings = totalWarnings;
	}

	public String getTotalNoOfTests() {
		return totalNoOfTests;
	}

	public void setTotalNoOfTests(String totalNoOfTests) {
		this.totalNoOfTests = totalNoOfTests;
	}

	public String getFailedTests() {
		return failedTests;
	}

	public void setFailedTests(String failedTests) {
		this.failedTests = failedTests;
	}

	public String getPassedTests() {
		return passedTests;
	}

	public void setPassedTests(String passedTests) {
		this.passedTests = passedTests;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<ResultsetVo> getResultSetObj() {
		return tenonObj2;
	}

	public void setResultSetObj(List<ResultsetVo> tenonObjs) {
		this.tenonObj2 = tenonObjs;
	}

}
