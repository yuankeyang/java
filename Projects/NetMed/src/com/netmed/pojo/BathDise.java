package com.netmed.pojo;

/**
 * 中药浴方治病表
 * BathDise entity. @author MyEclipse Persistence Tools
 */

public class BathDise implements java.io.Serializable {

	// Fields

	private Integer bathDiseId;
	private ChinMediBath chinMediBath;
	private String chinDiseName;
	private String westDiseName;

	// Constructors

	/** default constructor */
	public BathDise() {
	}

	/** minimal constructor */
	public BathDise(ChinMediBath chinMediBath) {
		this.chinMediBath = chinMediBath;
	}

	/** full constructor */
	public BathDise(ChinMediBath chinMediBath, String chinDiseName,
			String westDiseName) {
		this.chinMediBath = chinMediBath;
		this.chinDiseName = chinDiseName;
		this.westDiseName = westDiseName;
	}

	// Property accessors

	public Integer getBathDiseId() {
		return this.bathDiseId;
	}

	public void setBathDiseId(Integer bathDiseId) {
		this.bathDiseId = bathDiseId;
	}

	public ChinMediBath getChinMediBath() {
		return this.chinMediBath;
	}

	public void setChinMediBath(ChinMediBath chinMediBath) {
		this.chinMediBath = chinMediBath;
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