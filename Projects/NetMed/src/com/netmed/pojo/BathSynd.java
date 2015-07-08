package com.netmed.pojo;

/**
 * 中药浴方治证表
 * BathSynd entity. @author MyEclipse Persistence Tools
 */

public class BathSynd implements java.io.Serializable {

	// Fields

	private Integer bathSyndId;
	private ChinMediBath chinMediBath;
	private String syndName;
	private String remain;

	// Constructors

	/** default constructor */
	public BathSynd() {
	}

	/** minimal constructor */
	public BathSynd(ChinMediBath chinMediBath) {
		this.chinMediBath = chinMediBath;
	}

	/** full constructor */
	public BathSynd(ChinMediBath chinMediBath, String syndName, String remain) {
		this.chinMediBath = chinMediBath;
		this.syndName = syndName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getBathSyndId() {
		return this.bathSyndId;
	}

	public void setBathSyndId(Integer bathSyndId) {
		this.bathSyndId = bathSyndId;
	}

	public ChinMediBath getChinMediBath() {
		return this.chinMediBath;
	}

	public void setChinMediBath(ChinMediBath chinMediBath) {
		this.chinMediBath = chinMediBath;
	}

	public String getSyndName() {
		return this.syndName;
	}

	public void setSyndName(String syndName) {
		this.syndName = syndName;
	}

	public String getRemain() {
		return this.remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

}