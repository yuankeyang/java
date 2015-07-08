package com.netmed.pojo;

/**
 * 中药材治症表,字段意义见其配置文件
 * MediMateSymp entity. @author MyEclipse Persistence Tools
 */

public class MediMateSymp implements java.io.Serializable {

	// Fields

	private Integer mateSympId;
	private ChinMediMate chinMediMate;
	private String sympName;
	private String remain;

	// Constructors

	/** default constructor */
	public MediMateSymp() {
	}

	/** minimal constructor */
	public MediMateSymp(ChinMediMate chinMediMate) {
		this.chinMediMate = chinMediMate;
	}

	/** full constructor */
	public MediMateSymp(ChinMediMate chinMediMate, String sympName,
			String remain) {
		this.chinMediMate = chinMediMate;
		this.sympName = sympName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getMateSympId() {
		return this.mateSympId;
	}

	public void setMateSympId(Integer mateSympId) {
		this.mateSympId = mateSympId;
	}

	public ChinMediMate getChinMediMate() {
		return this.chinMediMate;
	}

	public void setChinMediMate(ChinMediMate chinMediMate) {
		this.chinMediMate = chinMediMate;
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