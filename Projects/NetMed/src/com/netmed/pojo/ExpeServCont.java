package com.netmed.pojo;

/**
 * 专家服务内容约定表,字段意义见其配置文件
 * ExpeServCont entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class ExpeServCont implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private ExpeRegi expeRegi;
	private String diseType;
	private Boolean chinWestId;

	// Constructors

	/** default constructor */
	public ExpeServCont() {
	}

	/** minimal constructor */
	public ExpeServCont(ExpeRegi expeRegi, String diseType) {
		this.expeRegi = expeRegi;
		this.diseType = diseType;
	}

	/** full constructor */
	public ExpeServCont(ExpeRegi expeRegi, String diseType, Boolean chinWestId) {
		this.expeRegi = expeRegi;
		this.diseType = diseType;
		this.chinWestId = chinWestId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ExpeRegi getExpeRegi() {
		return this.expeRegi;
	}

	public void setExpeRegi(ExpeRegi expeRegi) {
		this.expeRegi = expeRegi;
	}

	public String getDiseType() {
		return this.diseType;
	}

	public void setDiseType(String diseType) {
		this.diseType = diseType;
	}

	public Boolean getChinWestId() {
		return this.chinWestId;
	}

	public void setChinWestId(Boolean chinWestId) {
		this.chinWestId = chinWestId;
	}

}