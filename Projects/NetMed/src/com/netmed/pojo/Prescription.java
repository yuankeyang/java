package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 方剂表,字段意义见其配置文件
 * Prescription entity. @author MyEclipse Persistence Tools
 */

public class Prescription implements java.io.Serializable {

	// Fields

	private String presId;
	private String presName;
	private String type;
	private String composition;
	private String picture;
	private String usagDosa;
	private String function;
	private String majorFunction;
	private String detail;
	private String diagSyndPoin;
	private String precaution;
	private String clinSubt;
	private String identify;
	private String modernApply;
	private String presSong;
	private String knowSour;
	private String institution;
	private Set prescriptionIngredients = new HashSet(0);
	private Set presDises = new HashSet(0);
	private Set presSynds = new HashSet(0);
	private Set presSymps = new HashSet(0);

	// Constructors

	/** default constructor */
	public Prescription() {
	}

	/** minimal constructor */
	public Prescription(String presId, String presName, String composition,
			String function, String majorFunction) {
		this.presId = presId;
		this.presName = presName;
		this.composition = composition;
		this.function = function;
		this.majorFunction = majorFunction;
	}

	/** full constructor */
	public Prescription(String presId, String presName, String type,
			String composition, String picture, String usagDosa,
			String function, String majorFunction, String detail,
			String diagSyndPoin, String precaution, String clinSubt,
			String identify, String modernApply, String presSong,
			String knowSour, String institution, Set prescriptionIngredients,
			Set presDises, Set presSynds, Set presSymps) {
		this.presId = presId;
		this.presName = presName;
		this.type = type;
		this.composition = composition;
		this.picture = picture;
		this.usagDosa = usagDosa;
		this.function = function;
		this.majorFunction = majorFunction;
		this.detail = detail;
		this.diagSyndPoin = diagSyndPoin;
		this.precaution = precaution;
		this.clinSubt = clinSubt;
		this.identify = identify;
		this.modernApply = modernApply;
		this.presSong = presSong;
		this.knowSour = knowSour;
		this.institution = institution;
		this.prescriptionIngredients = prescriptionIngredients;
		this.presDises = presDises;
		this.presSynds = presSynds;
		this.presSymps = presSymps;
	}

	// Property accessors

	public String getPresId() {
		return this.presId;
	}

	public void setPresId(String presId) {
		this.presId = presId;
	}

	public String getPresName() {
		return this.presName;
	}

	public void setPresName(String presName) {
		this.presName = presName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComposition() {
		return this.composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getUsagDosa() {
		return this.usagDosa;
	}

	public void setUsagDosa(String usagDosa) {
		this.usagDosa = usagDosa;
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

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDiagSyndPoin() {
		return this.diagSyndPoin;
	}

	public void setDiagSyndPoin(String diagSyndPoin) {
		this.diagSyndPoin = diagSyndPoin;
	}

	public String getPrecaution() {
		return this.precaution;
	}

	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	public String getClinSubt() {
		return this.clinSubt;
	}

	public void setClinSubt(String clinSubt) {
		this.clinSubt = clinSubt;
	}

	public String getIdentify() {
		return this.identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getModernApply() {
		return this.modernApply;
	}

	public void setModernApply(String modernApply) {
		this.modernApply = modernApply;
	}

	public String getPresSong() {
		return this.presSong;
	}

	public void setPresSong(String presSong) {
		this.presSong = presSong;
	}

	public String getKnowSour() {
		return this.knowSour;
	}

	public void setKnowSour(String knowSour) {
		this.knowSour = knowSour;
	}

	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Set getPrescriptionIngredients() {
		return this.prescriptionIngredients;
	}

	public void setPrescriptionIngredients(Set prescriptionIngredients) {
		this.prescriptionIngredients = prescriptionIngredients;
	}

	public Set getPresDises() {
		return this.presDises;
	}

	public void setPresDises(Set presDises) {
		this.presDises = presDises;
	}

	public Set getPresSynds() {
		return this.presSynds;
	}

	public void setPresSynds(Set presSynds) {
		this.presSynds = presSynds;
	}

	public Set getPresSymps() {
		return this.presSymps;
	}

	public void setPresSymps(Set presSymps) {
		this.presSymps = presSymps;
	}

}