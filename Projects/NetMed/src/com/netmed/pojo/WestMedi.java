package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 西药表,字段意义见其配置文件
 * WestMedi entity. @author MyEclipse Persistence Tools
 */

public class WestMedi implements java.io.Serializable {

	// Fields

	private String westMediId;
	private String westMediName;
	private String picture;
	private String ingredient;
	private String shape;
	private String symptom;
	private String specification;
	private String usagDosa;
	private String adveReac;
	private String contraindication;
	private String precaution;
	private String childDrug;
	private String pregnantDrug;
	private String encyesisDrug;
	private String olderDrug;
	private String drugInte;
	private String pharToxi;
	private String drugOver;
	private String pharmacokinetics;
	private String storage;
	private String packaging;
	private String valiPeri;
	private String execNorm;
	private String apprNumb;
	private String enterprise;
	private Set westSymps = new HashSet(0);
	private Set westDises = new HashSet(0);

	// Constructors

	/** default constructor */
	public WestMedi() {
	}

	/** minimal constructor */
	public WestMedi(String westMediId, String westMediName) {
		this.westMediId = westMediId;
		this.westMediName = westMediName;
	}

	/** full constructor */
	public WestMedi(String westMediId, String westMediName, String picture,
			String ingredient, String shape, String symptom,
			String specification, String usagDosa, String adveReac,
			String contraindication, String precaution, String childDrug,
			String pregnantDrug, String encyesisDrug, String olderDrug,
			String drugInte, String pharToxi, String drugOver,
			String pharmacokinetics, String storage, String packaging,
			String valiPeri, String execNorm, String apprNumb,
			String enterprise, Set westSymps, Set westDises) {
		this.westMediId = westMediId;
		this.westMediName = westMediName;
		this.picture = picture;
		this.ingredient = ingredient;
		this.shape = shape;
		this.symptom = symptom;
		this.specification = specification;
		this.usagDosa = usagDosa;
		this.adveReac = adveReac;
		this.contraindication = contraindication;
		this.precaution = precaution;
		this.childDrug = childDrug;
		this.pregnantDrug = pregnantDrug;
		this.encyesisDrug = encyesisDrug;
		this.olderDrug = olderDrug;
		this.drugInte = drugInte;
		this.pharToxi = pharToxi;
		this.drugOver = drugOver;
		this.pharmacokinetics = pharmacokinetics;
		this.storage = storage;
		this.packaging = packaging;
		this.valiPeri = valiPeri;
		this.execNorm = execNorm;
		this.apprNumb = apprNumb;
		this.enterprise = enterprise;
		this.westSymps = westSymps;
		this.westDises = westDises;
	}

	// Property accessors

	public String getWestMediId() {
		return this.westMediId;
	}

	public void setWestMediId(String westMediId) {
		this.westMediId = westMediId;
	}

	public String getWestMediName() {
		return this.westMediName;
	}

	public void setWestMediName(String westMediName) {
		this.westMediName = westMediName;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getShape() {
		return this.shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getUsagDosa() {
		return this.usagDosa;
	}

	public void setUsagDosa(String usagDosa) {
		this.usagDosa = usagDosa;
	}

	public String getAdveReac() {
		return this.adveReac;
	}

	public void setAdveReac(String adveReac) {
		this.adveReac = adveReac;
	}

	public String getContraindication() {
		return this.contraindication;
	}

	public void setContraindication(String contraindication) {
		this.contraindication = contraindication;
	}

	public String getPrecaution() {
		return this.precaution;
	}

	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	public String getChildDrug() {
		return this.childDrug;
	}

	public void setChildDrug(String childDrug) {
		this.childDrug = childDrug;
	}

	public String getPregnantDrug() {
		return this.pregnantDrug;
	}

	public void setPregnantDrug(String pregnantDrug) {
		this.pregnantDrug = pregnantDrug;
	}

	public String getEncyesisDrug() {
		return this.encyesisDrug;
	}

	public void setEncyesisDrug(String encyesisDrug) {
		this.encyesisDrug = encyesisDrug;
	}

	public String getOlderDrug() {
		return this.olderDrug;
	}

	public void setOlderDrug(String olderDrug) {
		this.olderDrug = olderDrug;
	}

	public String getDrugInte() {
		return this.drugInte;
	}

	public void setDrugInte(String drugInte) {
		this.drugInte = drugInte;
	}

	public String getPharToxi() {
		return this.pharToxi;
	}

	public void setPharToxi(String pharToxi) {
		this.pharToxi = pharToxi;
	}

	public String getDrugOver() {
		return this.drugOver;
	}

	public void setDrugOver(String drugOver) {
		this.drugOver = drugOver;
	}

	public String getPharmacokinetics() {
		return this.pharmacokinetics;
	}

	public void setPharmacokinetics(String pharmacokinetics) {
		this.pharmacokinetics = pharmacokinetics;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getPackaging() {
		return this.packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getValiPeri() {
		return this.valiPeri;
	}

	public void setValiPeri(String valiPeri) {
		this.valiPeri = valiPeri;
	}

	public String getExecNorm() {
		return this.execNorm;
	}

	public void setExecNorm(String execNorm) {
		this.execNorm = execNorm;
	}

	public String getApprNumb() {
		return this.apprNumb;
	}

	public void setApprNumb(String apprNumb) {
		this.apprNumb = apprNumb;
	}

	public String getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public Set getWestSymps() {
		return this.westSymps;
	}

	public void setWestSymps(Set westSymps) {
		this.westSymps = westSymps;
	}

	public Set getWestDises() {
		return this.westDises;
	}

	public void setWestDises(Set westDises) {
		this.westDises = westDises;
	}

}