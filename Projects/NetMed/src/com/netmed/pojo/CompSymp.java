package com.netmed.pojo;

/**
 * 养生复方治症表,字段意义见其配置文件
 * CompSymp entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class CompSymp implements java.io.Serializable {

	// Fields

	private Integer compSympId;
	private ChinRegiComp chinRegiComp;
	private String sympName;
	private String remain;

	// Constructors

	/** default constructor */
	public CompSymp() {
	}

	/** minimal constructor */
	public CompSymp(ChinRegiComp chinRegiComp) {
		this.chinRegiComp = chinRegiComp;
	}

	/** full constructor */
	public CompSymp(ChinRegiComp chinRegiComp, String sympName, String remain) {
		this.chinRegiComp = chinRegiComp;
		this.sympName = sympName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getCompSympId() {
		return this.compSympId;
	}

	public void setCompSympId(Integer compSympId) {
		this.compSympId = compSympId;
	}

	public ChinRegiComp getChinRegiComp() {
		return this.chinRegiComp;
	}

	public void setChinRegiComp(ChinRegiComp chinRegiComp) {
		this.chinRegiComp = chinRegiComp;
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