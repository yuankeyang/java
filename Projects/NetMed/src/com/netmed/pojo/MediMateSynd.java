package com.netmed.pojo;

/**
 * 中药材治证表,字段意义见其配置文件
 * MediMateSynd entity. @author MyEclipse Persistence Tools
 */

public class MediMateSynd implements java.io.Serializable {

	// Fields

	private Integer mateSyndId;
	private ChinMediMate chinMediMate;
	private String syndName;
	private String remain;

	// Constructors

	/** default constructor */
	public MediMateSynd() {
	}

	/** minimal constructor */
	public MediMateSynd(ChinMediMate chinMediMate) {
		this.chinMediMate = chinMediMate;
	}

	/** full constructor */
	public MediMateSynd(ChinMediMate chinMediMate, String syndName,
			String remain) {
		this.chinMediMate = chinMediMate;
		this.syndName = syndName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getMateSyndId() {
		return this.mateSyndId;
	}

	public void setMateSyndId(Integer mateSyndId) {
		this.mateSyndId = mateSyndId;
	}

	public ChinMediMate getChinMediMate() {
		return this.chinMediMate;
	}

	public void setChinMediMate(ChinMediMate chinMediMate) {
		this.chinMediMate = chinMediMate;
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