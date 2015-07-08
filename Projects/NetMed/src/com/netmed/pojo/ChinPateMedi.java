package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 中成药表,字段意义见其配置文件
 * ChinPateMedi entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class ChinPateMedi implements java.io.Serializable {

	// Fields

	private String pateMediId;
	private String pateMediName;
	private String ingredient;
	private String function;
	private String picture;
	private String specification;
	private String place;
	private String usagDosa;
	private String adveActi;
	private String contraindication;
	private String precaution;
	private String drugInte;
	private String valiPeri;
	private String storage;
	private String apprNumb;
	private String enterprise;
	private String institution;
	private Set pateMediSymps = new HashSet(0);
	private Set pateMediSynds = new HashSet(0);
	private Set pateMediDises = new HashSet(0);

	// Constructors

	/** default constructor */
	public ChinPateMedi() {
	}

	/** minimal constructor */
	public ChinPateMedi(String pateMediId, String pateMediName) {
		this.pateMediId = pateMediId;
		this.pateMediName = pateMediName;
	}

	/** full constructor */
	public ChinPateMedi(String pateMediId, String pateMediName,
			String ingredient, String function, String picture,
			String specification, String place, String usagDosa,
			String adveActi, String contraindication, String precaution,
			String drugInte, String valiPeri, String storage, String apprNumb,
			String enterprise, String institution, Set pateMediSymps,
			Set pateMediSynds, Set pateMediDises) {
		this.pateMediId = pateMediId;
		this.pateMediName = pateMediName;
		this.ingredient = ingredient;
		this.function = function;
		this.picture = picture;
		this.specification = specification;
		this.place = place;
		this.usagDosa = usagDosa;
		this.adveActi = adveActi;
		this.contraindication = contraindication;
		this.precaution = precaution;
		this.drugInte = drugInte;
		this.valiPeri = valiPeri;
		this.storage = storage;
		this.apprNumb = apprNumb;
		this.enterprise = enterprise;
		this.institution = institution;
		this.pateMediSymps = pateMediSymps;
		this.pateMediSynds = pateMediSynds;
		this.pateMediDises = pateMediDises;
	}

	// Property accessors

	public String getPateMediId() {
		return this.pateMediId;
	}

	public void setPateMediId(String pateMediId) {
		this.pateMediId = pateMediId;
	}

	public String getPateMediName() {
		return this.pateMediName;
	}

	public void setPateMediName(String pateMediName) {
		this.pateMediName = pateMediName;
	}

	public String getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getUsagDosa() {
		return this.usagDosa;
	}

	public void setUsagDosa(String usagDosa) {
		this.usagDosa = usagDosa;
	}

	public String getAdveActi() {
		return this.adveActi;
	}

	public void setAdveActi(String adveActi) {
		this.adveActi = adveActi;
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

	public String getDrugInte() {
		return this.drugInte;
	}

	public void setDrugInte(String drugInte) {
		this.drugInte = drugInte;
	}

	public String getValiPeri() {
		return this.valiPeri;
	}

	public void setValiPeri(String valiPeri) {
		this.valiPeri = valiPeri;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
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

	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Set getPateMediSymps() {
		return this.pateMediSymps;
	}

	public void setPateMediSymps(Set pateMediSymps) {
		this.pateMediSymps = pateMediSymps;
	}

	public Set getPateMediSynds() {
		return this.pateMediSynds;
	}

	public void setPateMediSynds(Set pateMediSynds) {
		this.pateMediSynds = pateMediSynds;
	}

	public Set getPateMediDises() {
		return this.pateMediDises;
	}

	public void setPateMediDises(Set pateMediDises) {
		this.pateMediDises = pateMediDises;
	}

}