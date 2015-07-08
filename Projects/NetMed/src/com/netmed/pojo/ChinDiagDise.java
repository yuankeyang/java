package com.netmed.pojo;

/**
 * 离线咨询辨病结果
 * ChinDiagDise entity. @author MyEclipse Persistence Tools
 * 05-20
 */

public class ChinDiagDise implements java.io.Serializable {

	// Fields

	private Integer diagDiseId;
	private MembConsInfo membConsInfo;
	private String disease;
	private String pathogeny;

	// Constructors

	/** default constructor */
	public ChinDiagDise() {
	}

	/** minimal constructor */
	public ChinDiagDise(MembConsInfo membConsInfo) {
		this.membConsInfo = membConsInfo;
	}

	/** full constructor */
	public ChinDiagDise(MembConsInfo membConsInfo, String disease,
			String pathogeny) {
		this.membConsInfo = membConsInfo;
		this.disease = disease;
		this.pathogeny = pathogeny;
	}

	// Property accessors

	public Integer getDiagDiseId() {
		return this.diagDiseId;
	}

	public void setDiagDiseId(Integer diagDiseId) {
		this.diagDiseId = diagDiseId;
	}

	public MembConsInfo getMembConsInfo() {
		return this.membConsInfo;
	}

	public void setMembConsInfo(MembConsInfo membConsInfo) {
		this.membConsInfo = membConsInfo;
	}

	public String getDisease() {
		return this.disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getPathogeny() {
		return this.pathogeny;
	}

	public void setPathogeny(String pathogeny) {
		this.pathogeny = pathogeny;
	}

}