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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Tenon_By_WCAG")
public class TenonByWCAG implements Serializable {

	private static final long serialVersionUID = 1L;


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "url_id")
	private Integer urlId;
	
	
	
	@Column(name = "user_Id")
	private int userId;


	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "urlId")
	private int urlId;*/

	@Column(name = "url")
	private String url;

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

	private String countBylevelAA;

	/*
	 * Issues by level AAA
	 */
	private String pctBylevelAAA;
	private String countBylevelAAA;

	/*public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}*/

	/*@Column(name = "reportCreatedDate")
	private String createDate;
*/
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TenonByWcag_TenonResultSet", joinColumns = { @JoinColumn(name = "url_id") }, inverseJoinColumns = { @JoinColumn(name = "tenon_Id") })

	//@Column(name = "resultsetId")
	private List<TenonApiVo> tenonByWCAG;

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<TenonApiVo> getResultSetObj() {
		return tenonByWCAG;
	}

	public void setResultSetObj(List<TenonApiVo> tenonObjs) {
		this.tenonByWCAG = tenonObjs;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

}
