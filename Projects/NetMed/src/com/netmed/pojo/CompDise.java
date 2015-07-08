package com.netmed.pojo;

/**
 * 养生复方治病表,字段意义见其配置文件
 * CompDise entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class CompDise implements java.io.Serializable {

	// Fields

	private Integer compDiseId;
	private ChinRegiComp chinRegiComp;
	private String chinDiseName;
	private String westDiseName;

	// Constructors

	/** default constructor */
	public CompDise() {
	}

	/** full constructor */
	public CompDise(ChinRegiComp chinRegiComp, String chinDiseName,
			String westDiseName) {
		this.chinRegiComp = chinRegiComp;
		this.chinDiseName = chinDiseName;
		this.westDiseName = westDiseName;
	}

	// Property accessors

	public Integer getCompDiseId() {
		return this.compDiseId;
	}

	public void setCompDiseId(Integer compDiseId) {
		this.compDiseId = compDiseId;
	}

	public ChinRegiComp getChinRegiComp() {
		return this.chinRegiComp;
	}

	public void setChinRegiComp(ChinRegiComp chinRegiComp) {
		this.chinRegiComp = chinRegiComp;
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