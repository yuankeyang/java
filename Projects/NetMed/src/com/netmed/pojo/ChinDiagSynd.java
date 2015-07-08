package com.netmed.pojo;

/**
 * 离线咨询病证结果
 * ChinDiagSynd entity. @author MyEclipse Persistence Tools
 * 05-20
 */

public class ChinDiagSynd implements java.io.Serializable {

	// Fields

	private Integer diagSyndId;
	private MembConsInfo membConsInfo;
	private String syndrome;
	private String pathogeny;

	// Constructors

	/** default constructor */
	public ChinDiagSynd() {
	}

	/** minimal constructor */
	public ChinDiagSynd(MembConsInfo membConsInfo) {
		this.membConsInfo = membConsInfo;
	}

	/** full constructor */
	public ChinDiagSynd(MembConsInfo membConsInfo, String syndrome,
			String pathogeny) {
		this.membConsInfo = membConsInfo;
		this.syndrome = syndrome;
		this.pathogeny = pathogeny;
	}

	// Property accessors

	public Integer getDiagSyndId() {
		return this.diagSyndId;
	}

	public void setDiagSyndId(Integer diagSyndId) {
		this.diagSyndId = diagSyndId;
	}

	public MembConsInfo getMembConsInfo() {
		return this.membConsInfo;
	}

	public void setMembConsInfo(MembConsInfo membConsInfo) {
		this.membConsInfo = membConsInfo;
	}

	public String getSyndrome() {
		return this.syndrome;
	}

	public void setSyndrome(String syndrome) {
		this.syndrome = syndrome;
	}

	public String getPathogeny() {
		return this.pathogeny;
	}

	public void setPathogeny(String pathogeny) {
		this.pathogeny = pathogeny;
	}

}