package com.netmed.pojo;

/**
 * 专家类型表,字段意义见其配置文件
 * ExpeType entity. @author MyEclipse Persistence Tools
 */

public class ExpeType implements java.io.Serializable {

	// Fields

	private Integer id;
	private ExpeRegi expeRegi;
	private ExpeTypeComp expeTypeComp;
	private String qualCode;
	private String picture;
	private Boolean state;

	// Constructors

	/** default constructor */
	public ExpeType() {
	}

	/** minimal constructor */
	public ExpeType(ExpeRegi expeRegi, ExpeTypeComp expeTypeComp) {
		this.expeRegi = expeRegi;
		this.expeTypeComp = expeTypeComp;
	}

	/** full constructor */
	public ExpeType(ExpeRegi expeRegi, ExpeTypeComp expeTypeComp,
			String qualCode, String picture, Boolean state) {
		this.expeRegi = expeRegi;
		this.expeTypeComp = expeTypeComp;
		this.qualCode = qualCode;
		this.picture = picture;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ExpeRegi getExpeRegi() {
		return this.expeRegi;
	}

	public void setExpeRegi(ExpeRegi expeRegi) {
		this.expeRegi = expeRegi;
	}

	public ExpeTypeComp getExpeTypeComp() {
		return this.expeTypeComp;
	}

	public void setExpeTypeComp(ExpeTypeComp expeTypeComp) {
		this.expeTypeComp = expeTypeComp;
	}

	public String getQualCode() {
		return this.qualCode;
	}

	public void setQualCode(String qualCode) {
		this.qualCode = qualCode;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}