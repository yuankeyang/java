package com.netmed.pojo;

/**
 * 方剂治症表,字段意义见其配置文件
 * PresSymp entity. @author MyEclipse Persistence Tools
 */

public class PresSymp implements java.io.Serializable {

	// Fields

	private Integer presSympId;
	private Prescription prescription;
	private String sympName;
	private String remain;

	// Constructors

	/** default constructor */
	public PresSymp() {
	}

	/** minimal constructor */
	public PresSymp(Prescription prescription) {
		this.prescription = prescription;
	}

	/** full constructor */
	public PresSymp(Prescription prescription, String sympName, String remain) {
		this.prescription = prescription;
		this.sympName = sympName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getPresSympId() {
		return this.presSympId;
	}

	public void setPresSympId(Integer presSympId) {
		this.presSympId = presSympId;
	}

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
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