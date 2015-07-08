package com.netmed.pojo;

/**
 * 方剂治证表,字段意义见其配置文件
 * PresSynd entity. @author MyEclipse Persistence Tools
 */

public class PresSynd implements java.io.Serializable {

	// Fields

	private Integer presSyndId;
	private Prescription prescription;
	private String syndName;
	private String remain;

	// Constructors

	/** default constructor */
	public PresSynd() {
	}

	/** minimal constructor */
	public PresSynd(Prescription prescription) {
		this.prescription = prescription;
	}

	/** full constructor */
	public PresSynd(Prescription prescription, String syndName, String remain) {
		this.prescription = prescription;
		this.syndName = syndName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getPresSyndId() {
		return this.presSyndId;
	}

	public void setPresSyndId(Integer presSyndId) {
		this.presSyndId = presSyndId;
	}

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
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