package com.netmed.pojo;

/**
 * 医疗器械治症表,字段意义见其配置文件
 * EquiSymp entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class EquiSymp implements java.io.Serializable {

	// Fields

	private Integer equiSympId;
	private HomeMediEqui homeMediEqui;
	private String sympName;
	private String remain;

	// Constructors

	/** default constructor */
	public EquiSymp() {
	}

	/** minimal constructor */
	public EquiSymp(HomeMediEqui homeMediEqui) {
		this.homeMediEqui = homeMediEqui;
	}

	/** full constructor */
	public EquiSymp(HomeMediEqui homeMediEqui, String sympName, String remain) {
		this.homeMediEqui = homeMediEqui;
		this.sympName = sympName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getEquiSympId() {
		return this.equiSympId;
	}

	public void setEquiSympId(Integer equiSympId) {
		this.equiSympId = equiSympId;
	}

	public HomeMediEqui getHomeMediEqui() {
		return this.homeMediEqui;
	}

	public void setHomeMediEqui(HomeMediEqui homeMediEqui) {
		this.homeMediEqui = homeMediEqui;
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