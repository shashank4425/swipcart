package com.example.productstore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.util.UriComponentsBuilder;

@Entity
@Table(name="trending_prod")
public class trendingproduct {

	  @Id
      //@GeneratedValue(strategy = GenerationType.AUTO)
	   Long id;
	   String prodid;
	   String prodName;
	   String prodTitle;
	   String prodPath;
	   String prodUri;
	   String prodCamara;
	   String prodBattery;
	   String prodOfferPrice;
	   String prodPrevPrice;
	   String prodRam;
	   String prodRom;
	   String prodDisplaySize;
	   String prodColor;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProdid() {
		return prodid;
	}


	public void setProdid(String prodid) {
		this.prodid = prodid;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public String getProdTitle() {
		return prodTitle;
	}


	public void setProdTitle(String prodTitle) {
		this.prodTitle = prodTitle;
	}


	public String getProdPath() {
		return prodPath;
	}


	public void setProdPath(String prodPath) {
		this.prodPath = prodPath;
	}


	public String getProdUri() {
		return prodUri;
	}


	public void setProdUri(String prodUri) {
		this.prodUri = prodUri;
	}


	public String getProdCamara() {
		return prodCamara;
	}


	public void setProdCamara(String prodCamara) {
		this.prodCamara = prodCamara;
	}


	public String getProdBattery() {
		return prodBattery;
	}


	public void setProdBattery(String prodBattery) {
		this.prodBattery = prodBattery;
	}


	public String getProdOfferPrice() {
		return prodOfferPrice;
	}


	public void setProdOfferPrice(String prodOfferPrice) {
		this.prodOfferPrice = prodOfferPrice;
	}


	public String getProdPrevPrice() {
		return prodPrevPrice;
	}


	public void setProdPrevPrice(String prodPrevPrice) {
		this.prodPrevPrice = prodPrevPrice;
	}


	public String getProdRam() {
		return prodRam;
	}


	public void setProdRam(String prodRam) {
		this.prodRam = prodRam;
	}


	public String getProdRom() {
		return prodRom;
	}


	public void setProdRom(String prodRom) {
		this.prodRom = prodRom;
	}


	public String getProdDisplaySize() {
		return prodDisplaySize;
	}


	public void setProdDisplaySize(String prodDisplaySize) {
		this.prodDisplaySize = prodDisplaySize;
	}


	public String getProdColor() {
		return prodColor;
	}


	public void setProdColor(String prodColor) {
		this.prodColor = prodColor;
	}


	@Override
	public String toString() {
		return "trendingproduct [id=" + id + ", prodid=" + prodid + ", prodName=" + prodName + ", prodTitle="
				+ prodTitle + ", prodPath=" + prodPath + ", prodUri=" + prodUri + ", prodCamara=" + prodCamara
				+ ", prodBattery=" + prodBattery + ", prodOfferPrice=" + prodOfferPrice + ", prodPrevPrice="
				+ prodPrevPrice + ", prodRam=" + prodRam + ", prodRom=" + prodRom + ", prodDisplaySize="
				+ prodDisplaySize + ", prodColor=" + prodColor + "]";
	}
	
}
