package com.netmed.pojo;

/**
 * 中药浴方治症表
 * BathSymp entity. @author MyEclipse Persistence Tools
 */

public class BathSymp implements java.io.Serializable {

	// Fields

	private Integer bathSympId;
	private ChinMediBath chinMediBath;
	private String sympName;
	private String remain;

	// Constructors

	/** default constructor */
	public BathSymp() {
	}

	/** minimal constructor */
	public BathSymp(ChinMediBath chinMediBath) {
		this.chinMediBath = chinMediBath;
	}

	/** full constructor */
	public BathSymp(ChinMediBath chinMediBath, String sympName, String remain) {
		this.chinMediBath = chinMediBath;
		this.sympName = sympName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getBathSympId() {
		return this.bathSympId;
	}

	public void setBathSympId(Integer bathSympId) {
		this.bathSympId = bathSympId;
	}

	public ChinMediBath getChinMediBath() {
		return this.chinMediBath;
	}

	public void setChinMediBath(ChinMediBath chinMediBath) {
		this.chinMediBath = chinMediBath;
	}

	public String getSympName() {
		return this.sympName;
	}

	public void setSympName(String sympName) {
		this.sympName = sympName;
	}

	public String getRemain() {
		return this.remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

}