package com.starv.firstspringboot.bean;

public class Medicine {
	private Integer yid;
	private String projectNumber;
	private String projectName;
	private Integer price;
	private Integer proCount;
	private Integer costPrice;
	private String medType;
	
	
	public String getMedType() {
		return medType;
	}
	public void setMedType(String medType) {
		this.medType = medType;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getProCount() {
		return proCount;
	}
	public void setProCount(Integer proCount) {
		this.proCount = proCount;
	}
	public Integer getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}
	
	public Integer getYid() {
		return yid;
	}
	public void setYid(Integer yid) {
		this.yid = yid;
	}
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Medicine [yid=" + yid + ", projectNumber=" + projectNumber + ", projectName=" + projectName + ", price="
				+ price + ", proCount=" + proCount + ", costPrice=" + costPrice + ", medType=" + medType + "]";
	}

	
	
	
}
