package com.example.productstore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="users_tb")
//@Table(name="users_tb")
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 Long id;
	 private String firstname;
	 private String lastname;
	 private String emailId;
	 private String Password;
	 private String confirmPassword;
	 private String mobNumber;
	 private String firstLineAddress;
	 private String lastLineAddress;
	 String otp;
		
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}
	public String getFirstLineAddress() {
		return firstLineAddress;
	}
	public void setFirstLineAddress(String firstLineAddress) {
		this.firstLineAddress = firstLineAddress;
	}
	public String getLastLineAddress() {
		return lastLineAddress;
	}
	public void setLastLineAddress(String lastLineAddress) {
		this.lastLineAddress = lastLineAddress;
	}
	
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", emailId=" + emailId
				+ ", Password=" + Password + ", confirmPassword=" + confirmPassword + ", mobNumber=" + mobNumber
				+ ", firstLineAddress=" + firstLineAddress + ", lastLineAddress=" + lastLineAddress + "]";
	}
	
}
