package com.prakat.model;

import java.io.Serializable;
import java.sql.Timestamp;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "user_details")
public class UserDetailsVo implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="jobTitile")
	private String jobTitile;
	
	@Column(name="websiteUrl")
	private String  websiteUrl;
	
	@Column(name="country")
	private String country;
	
	@Column(name="timeZone")
	private String timeZone;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name = "gender")
	private String gender;
	
	@Column(name = "contactNo")
	private String contactNumber;
	
	@Column(name = "verification_code")
	private String verificationCode;
	
	@Column(name = "verification_status")
	private String verificationStatus;
	
	@Column(name = "registered_date")
	private Timestamp registeredDate;
	
	/* joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "urlId") })
	
	 @OneToOne(cascade = CascadeType.ALL)
	*/
	/*@OneToOne(cascade = CascadeType.ALL, targetEntity=TenonByWCAG.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "urlId")
	*/
	/*@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Tenon_By_WCAG_arrayObject_userDetails", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "urlId",columnDefinition = "int default 100") })
*/
	/*
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL,targetEntity=TenonByWCAG.class)
	@JoinTable(name = "Tenon_By_WCAG_arrayObject_userDetails", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "urlId") })
	*/

/*	@Column(name = "userListId")
	private List<TenonByWCAG> urlList;

	public List<TenonByWCAG> getUrlList() {
		return urlList;
	}
	
*/
	

	/*public void setUrlList(List<TenonByWCAG> urlList) {
		this.urlList = urlList;
	}*/

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobTitile() {
		return jobTitile;
	}

	public void setJobTitile(String jobTitile) {
		this.jobTitile = jobTitile;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Timestamp getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Timestamp registeredDate) {
		this.registeredDate = registeredDate;
	}
	
}


