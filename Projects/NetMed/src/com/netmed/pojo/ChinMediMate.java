package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 中药材表,字段意义见其配置文件
 * ChinMediMate entity. @author MyEclipse Persistence Tools
 * 05-20
 * hibernate自动生成
 */

public class ChinMediMate implements java.io.Serializable {

	// Fields

	private String mediMateId;
	private String mediMateName;
	private String mediProp;
	private String picture;
	private String place;
	private String function;
	private String majorFunction;
	private String usagDosa;
	private String precaution;
	private String anciBookSumm;
	private String chemIngr;
	private String pharActi;
	private String institution;
	private Set mediMateDises = new HashSet(0);
	private Set prescriptionIngredients = new HashSet(0);
	private Set mediMateSymps = new HashSet(0);
	private Set mediMateSynds = new HashSet(0);

	// Constructors

	/** default constructor */
	public ChinMediMate() {
	}

	/** minimal constructor */
	public ChinMediMate(String mediMateId, String mediMateName) {
		this.mediMateId = mediMateId;
		this.mediMateName = mediMateName;
	}

	/** full constructor */
	public ChinMediMate(String mediMateId, String mediMateName,
			String mediProp, String picture, String place, String function,
			String majorFunction, String usagDosa, String precaution,
			String anciBookSumm, String chemIngr, String pharActi,
			String institution, Set mediMateDises, Set prescriptionIngredients,
			Set mediMateSymps, Set mediMateSynds) {
		this.mediMateId = mediMateId;
		this.mediMateName = mediMateName;
		this.mediProp = mediProp;
		this.picture = picture;
		this.place = place;
		this.function = function;
		this.majorFunction = majorFunction;
		this.usagDosa = usagDosa;
		this.precaution = precaution;
		this.anciBookSumm = anciBookSumm;
		this.chemIngr = chemIngr;
		this.pharActi = pharActi;
		this.institution = institution;
		this.mediMateDises = mediMateDises;
		this.prescriptionIngredients = prescriptionIngredients;
		this.mediMateSymps = mediMateSymps;
		this.mediMateSynds = mediMateSynds;
	}

	// Property accessors

	public String getMediMateId() {
		return this.mediMateId;
	}

	public void setMediMateId(String mediMateId) {
		this.mediMateId = mediMateId;
	}

	public String getMediMateName() {
		return this.mediMateName;
	}

	public void setMediMateName(String mediMateName) {
		this.mediMateName = mediMateName;
	}

	public String getMediProp() {
		return this.mediProp;
	}

	public void setMediProp(String mediProp) {
		this.mediProp = mediProp;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getMajorFunction() {
		return this.majorFunction;
	}

	public void setMajorFunction(String majorFunction) {
		this.majorFunction = majorFunction;
	}

	public String getUsagDosa() {
		return this.usagDosa;
	}

	public void setUsagDosa(String usagDosa) {
		this.usagDosa = usagDosa;
	}

	public String getPrecaution() {
		return this.precaution;
	}

	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	public String getAnciBookSumm() {
		return this.anciBookSumm;
	}

	public void setAnciBookSumm(String anciBookSumm) {
		this.anciBookSumm = anciBookSumm;
	}

	public String getChemIngr() {
		return this.chemIngr;
	}

	public void setChemIngr(String chemIngr) {
		this.chemIngr = chemIngr;
	}

	public String getPharActi() {
		return this.pharActi;
	}

	public void setPharActi(String pharActi) {
		this.pharActi = pharActi;
	}

	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Set getMediMateDises() {
		return this.mediMateDises;
	}

	public void setMediMateDises(Set mediMateDises) {
		this.mediMateDises = mediMateDises;
	}

	public Set getPrescriptionIngredients() {
		return this.prescriptionIngredients;
	}

	public void setPrescriptionIngredients(Set prescriptionIngredients) {
		this.prescriptionIngredients = prescriptionIngredients;
	}

	public Set getMediMateSymps() {
		return this.mediMateSymps;
	}

	public void setMediMateSymps(Set mediMateSymps) {
		this.mediMateSymps = mediMateSymps;
	}

	public Set getMediMateSynds() {
		return this.mediMateSynds;
	}

	public void setMediMateSynds(Set mediMateSynds) {
		this.mediMateSynds = mediMateSynds;
	}

}