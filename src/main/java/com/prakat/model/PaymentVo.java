package com.prakat.model;

import java.io.Serializable;
import java.security.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "paymentDetails")
public class PaymentVo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transactionId",unique = true, nullable = false)
	private Long 		transactionId;
	
	@Column(name = "feeId")
	private Long feeId;
	
	@Column(name = "feeAmount")
	private Double 	feeAmount;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "transactionStatus")
	private String transactionStatus;
	
	@Column(name = "userComment")
	private String 	userComment;
	
	@Column(name = "createdDate")
	private Timestamp createdDate ;
	
	@Column(name = "createdBy")
	private String 	createdBy ;
	
	@Column(name = "modifiedDate")
	private Timestamp modifiedDate ;
	
	@Column(name = "modifiedBy")
	private String 	modifiedBy;
	
	@Column(name = "feeType")
	private String 	feeType;
	
	@Column(name = "msg")
	private String	msg;
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getFeeId() {
		return feeId;
	}
	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}
	public Double getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(Double feeAmount) {
		this.feeAmount = feeAmount;
	}
	
	public int setUserId(int userId) {
		return this.userId=userId;
	}
	public int getUserId() {
		return userId;
	}
	
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getUserComment() {
		return userComment;
	}
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
