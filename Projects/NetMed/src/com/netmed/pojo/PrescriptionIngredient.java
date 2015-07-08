package com.netmed.pojo;

/**
 * 方及组成表,字段意义见其配置文件
 * PrescriptionIngredient entity. @author MyEclipse Persistence Tools
 */

public class PrescriptionIngredient implements java.io.Serializable {

	// Fields

	private Integer presIngrId;
	private Prescription prescription;
	private ChinMediMate chinMediMate;
	private String dose;

	// Constructors

	/** default constructor */
	public PrescriptionIngredient() {
	}

	/** minimal constructor */
	public PrescriptionIngredient(Prescription prescription,
			ChinMediMate chinMediMate) {
		this.prescription = prescription;
		this.chinMediMate = chinMediMate;
	}

	/** full constructor */
	public PrescriptionIngredient(Prescription prescription,
			ChinMediMate chinMediMate, String dose) {
		this.prescription = prescription;
		this.chinMediMate = chinMediMate;
		this.dose = dose;
	}

	// Property accessors

	public Integer getPresIngrId() {
		return this.presIngrId;
	}

	public void setPresIngrId(Integer presIngrId) {
		this.presIngrId = presIngrId;
	}

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public ChinMediMate getChinMediMate() {
		return this.chinMediMate;
	}

	public void setChinMediMate(ChinMediMate chinMediMate) {
		this.chinMediMate = chinMediMate;
	}

	public String getDose() {
		return this.dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

}