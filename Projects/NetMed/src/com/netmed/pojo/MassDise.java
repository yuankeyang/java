package com.netmed.pojo;

/**
 * 按摩方治病表,字段意义见其配置文件
 * MassDise entity. @author MyEclipse Persistence Tools
 */

public class MassDise implements java.io.Serializable {

	// Fields

	private Integer massDiseId;
	private MassPres massPres;
	private String chinDiseName;
	private String westDiseName;

	// Constructors

	/** default constructor */
	public MassDise() {
	}

	/** minimal constructor */
	public MassDise(MassPres massPres) {
		this.massPres = massPres;
	}

	/** full constructor */
	public MassDise(MassPres massPres, String chinDiseName, String westDiseName) {
		this.massPres = massPres;
		this.chinDiseName = chinDiseName;
		this.westDiseName = westDiseName;
	}

	// Property accessors

	public Integer getMassDiseId() {
		return this.massDiseId;
	}

	public void setMassDiseId(Integer massDiseId) {
		this.massDiseId = massDiseId;
	}

	public MassPres getMassPres() {
		return this.massPres;
	}

	public void setMassPres(MassPres massPres) {
		this.massPres = massPres;
	}

	public String getChinDiseName() {
		return this.chinDiseName;
	}

	public void setChinDiseName(String chinDiseName) {
		this.chinDiseName = chinDiseName;
	}

	public String getWestDiseName() {
		return this.westDiseName;
	}

	public void setWestDiseName(String westDiseName) {
		this.westDiseName = westDiseName;
	}

}