package com.netmed.pojo;

/**
 * 医疗器械治病表,字段意义见其配置文件
 * EquiDise entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class EquiDise implements java.io.Serializable {

	// Fields

	private Integer equiDiseId;
	private HomeMediEqui homeMediEqui;
	private String chinDiseName;
	private String westDiseName;

	// Constructors

	/** default constructor */
	public EquiDise() {
	}

	/** minimal constructor */
	public EquiDise(HomeMediEqui homeMediEqui) {
		this.homeMediEqui = homeMediEqui;
	}

	/** full constructor */
	public EquiDise(HomeMediEqui homeMediEqui, String chinDiseName,
			String westDiseName) {
		this.homeMediEqui = homeMediEqui;
		this.chinDiseName = chinDiseName;
		this.westDiseName = westDiseName;
	}

	// Property accessors

	public Integer getEquiDiseId() {
		return this.equiDiseId;
	}

	public void setEquiDiseId(Integer equiDiseId) {
		this.equiDiseId = equiDiseId;
	}

	public HomeMediEqui getHomeMediEqui() {
		return this.homeMediEqui;
	}

	public void setHomeMediEqui(HomeMediEqui homeMediEqui) {
		this.homeMediEqui = homeMediEqui;
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