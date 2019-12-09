package com.prakat.model;

import java.io.Serializable;
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
@Table(name = "AChecker_Accesibility")
public class ACheckerVo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "urlId")
	private int urlId;

	@Column(name = "url")
	private String url;

	@Column(name = "NumOfErrors")
	private String NumOfErrors;

	@Column(name = "NumOfLikelyProblems")
	private String NumOfLikelyProblems;

	@Column(name = "NumOfPotentialProblems")
	private String NumOfPotentialProblems;

	@Column(name = "guidelines")
	private String guidelines;

	@Column(name = "sessionID")
	private String sessionID;

	@Column(name = "status")
	private String status;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "AChecker_Accesibility_Achecker_Resultset_Obj", joinColumns = {
			@JoinColumn(name = "urlId") }, inverseJoinColumns = { @JoinColumn(name = "achecker_Id") })

	@Column(name = "achecker_Id")

	// @ElementCollection(targetClass = ResultsetVo.class)
	private List<AcheckerResultsetVo> achekerObj;

	public List<AcheckerResultsetVo> getAchekerObj() {
		return achekerObj;
	}

	public void setAchekerObj(List<AcheckerResultsetVo> achekerObj) {
		this.achekerObj = achekerObj;
	}

	public String getNumOfErrors() {
		return NumOfErrors;
	}

	public void setNumOfErrors(String numOfErrors) {
		NumOfErrors = numOfErrors;
	}

	public String getNumOfLikelyProblems() {
		return NumOfLikelyProblems;
	}

	public void setNumOfLikelyProblems(String numOfLikelyProblems) {
		NumOfLikelyProblems = numOfLikelyProblems;
	}

	public String getNumOfPotentialProblems() {
		return NumOfPotentialProblems;
	}

	public void setNumOfPotentialProblems(String numOfPotentialProblems) {
		NumOfPotentialProblems = numOfPotentialProblems;
	}

	public String getGuidelines() {
		return guidelines;
	}

	public void setGuidelines(String guidelines) {
		this.guidelines = guidelines;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
