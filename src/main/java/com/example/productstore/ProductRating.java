package com.example.productstore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="prod_rating_tb")
@Table(name="prod_rating_tb")
public class ProductRating {

	@Id
	 private Long prodId;
	 private Long noOfVotes;
	 private Long rateVal;
	 private double ratingAvg;
	 private String pageURL;
	
	 public Long getProdId() {
			return prodId;
		}
		public void setProdId(Long prodId) {
			this.prodId = prodId;
		}
	public Long getRateVal() {
		return rateVal;
	}
	public void setRateVal(Long rateVal) {
		this.rateVal = rateVal;
	}
	public Long getNoOfVotes() {
		return noOfVotes;
	}
	public void setNoOfVotes(Long noOfVotes) {
		this.noOfVotes = noOfVotes;
	}
	public double getRatingAvg() {
		return ratingAvg;
	}
	public void setRatingAvg(double ratingAvg) {
		this.ratingAvg = ratingAvg;
	}
	public String getPageURL() {
		return pageURL;
	}
	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}
	
	@Override
	public String toString() {
		return "ProductRating [noOfVotes=" + noOfVotes + ", rateVal=" + rateVal + ", ratingAvg=" + ratingAvg
				+ ", pageURL=" + pageURL + ", prodId=" + prodId + "]";
	}
	
}
