package com.netmed.pojo;

/**
 * 养生复方治证表,字段意义见其配置文件
 * CompSynd entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class CompSynd implements java.io.Serializable {

	// Fields

	private Integer compSyndId;
	private ChinRegiComp chinRegiComp;
	private String syndName;
	private String remain;

	// Constructors

	/** default constructor */
	public CompSynd() {
	}

	/** minimal constructor */
	public CompSynd(ChinRegiComp chinRegiComp) {
		this.chinRegiComp = chinRegiComp;
	}

	/** full constructor */
	public CompSynd(ChinRegiComp chinRegiComp, String syndName, String remain) {
		this.chinRegiComp = chinRegiComp;
		this.syndName = syndName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getCompSyndId() {
		return this.compSyndId;
	}

	public void setCompSyndId(Integer compSyndId) {
		this.compSyndId = compSyndId;
	}

	public ChinRegiComp getChinRegiComp() {
		return this.chinRegiComp;
	}

	public void setChinRegiComp(ChinRegiComp chinRegiComp) {
		this.chinRegiComp = chinRegiComp;
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