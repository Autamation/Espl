package com.prakat.model;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "Tenon_Resultset_Obj")

public class ResultsetVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resultset_Id")
	private long resultset_Id;

	@Column(name = "bpID")
	private String bpID;

	@Column(name = "certainty")
	private String certainty;

	@Column(name = "errordescription")
	private String errorDescription;

	@Column(name = "errorsnippet")
	private String errorSnippet;

	@Column(name = "errorTitle")
	private String errorTitle;

	@Column(name = "issueID")
	private String issueID;

	@Column(name = "position")
	private String position;

	@Column(name = "priority")
	private String priority;

	@Column(name = "ref")
	private String ref;

	@Column(name = "resultTitle")
	private String resultTitle;

	@Column(name = "signature")
	private String signature;

	@Column(name = "standards")
	private String standards;

	@Column(name = "tID")
	private String tID;

	@Column(name = "viewPortLocation")
	private String viewPortLocation;

	public String getBpID() {
		return bpID;
	}

	public void setBpID(String bpID) {
		this.bpID = bpID;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getErrorSnippet() {
		return errorSnippet;
	}

	public void setErrorSnippet(String errorSnippet) {
		this.errorSnippet = errorSnippet;
	}

	public String getErrorTitle() {
		return errorTitle;
	}

	public void setErrorTitle(String errorTitle) {
		this.errorTitle = errorTitle;
	}

	public String getIssueID() {
		return issueID;
	}

	public void setIssueID(String issueID) {
		this.issueID = issueID;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getResultTitle() {
		return resultTitle;
	}

	public void setResultTitle(String resultTitle) {
		this.resultTitle = resultTitle;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getStandards() {
		return standards;
	}

	public void setStandards(String standards) {
		this.standards = standards;
	}

	public String gettID() {
		return tID;
	}

	public void settID(String tID) {
		this.tID = tID;
	}

	public String getViewPortLocation() {
		return viewPortLocation;
	}

	public void setViewPortLocation(String viewPortLocation) {
		this.viewPortLocation = viewPortLocation;
	}

	public String getCertainty() {
		return certainty;
	}

	public void setCertainty(String certainty) {
		this.certainty = certainty;
	}

}
