package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 医疗器械表,字段意义见其配置文件
 * HomeMediEqui entity. @author MyEclipse Persistence Tools
 */

public class HomeMediEqui implements java.io.Serializable {

	// Fields

	private String prodId;
	private String prodName;
	private String function;
	private String typeSpec;
	private String prodLiceNumb;
	private String regiCertNumb;
	private String prodStanNumb;
	private String picture;
	private String description;
	private String structure;
	private String apply;
	private String contraindication;
	private String install;
	private String usage;
	private String careMain;
	private String storCondMeth;
	private String valiPeri;
	private String enterprise;
	private String institution;
	private Set equiDises = new HashSet(0);
	private Set equiSymps = new HashSet(0);

	// Constructors

	/** default constructor */
	public HomeMediEqui() {
	}

	/** minimal constructor */
	public HomeMediEqui(String prodId, String prodName) {
		this.prodId = prodId;
		this.prodName = prodName;
	}

	/** full constructor */
	public HomeMediEqui(String prodId, String prodName, String function,
			String typeSpec, String prodLiceNumb, String regiCertNumb,
			String prodStanNumb, String picture, String description,
			String structure, String apply, String contraindication,
			String install, String usage, String careMain, String storCondMeth,
			String valiPeri, String enterprise, String institution,
			Set equiDises, Set equiSymps) {
		this.prodId = prodId;
		this.prodName = prodName;
		this.function = function;
		this.typeSpec = typeSpec;
		this.prodLiceNumb = prodLiceNumb;
		this.regiCertNumb = regiCertNumb;
		this.prodStanNumb = prodStanNumb;
		this.picture = picture;
		this.description = description;
		this.structure = structure;
		this.apply = apply;
		this.contraindication = contraindication;
		this.install = install;
		this.usage = usage;
		this.careMain = careMain;
		this.storCondMeth = storCondMeth;
		this.valiPeri = valiPeri;
		this.enterprise = enterprise;
		this.institution = institution;
		this.equiDises = equiDises;
		this.equiSymps = equiSymps;
	}

	// Property accessors

	public String getProdId() {
		return this.prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getTypeSpec() {
		return this.typeSpec;
	}

	public void setTypeSpec(String typeSpec) {
		this.typeSpec = typeSpec;
	}

	public String getProdLiceNumb() {
		return this.prodLiceNumb;
	}

	public void setProdLiceNumb(String prodLiceNumb) {
		this.prodLiceNumb = prodLiceNumb;
	}

	public String getRegiCertNumb() {
		return this.regiCertNumb;
	}

	public void setRegiCertNumb(String regiCertNumb) {
		this.regiCertNumb = regiCertNumb;
	}

	public String getProdStanNumb() {
		return this.prodStanNumb;
	}

	public void setProdStanNumb(String prodStanNumb) {
		this.prodStanNumb = prodStanNumb;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStructure() {
		return this.structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getApply() {
		return this.apply;
	}

	public void setApply(String apply) {
		this.apply = apply;
	}

	public String getContraindication() {
		return this.contraindication;
	}

	public void setContraindication(String contraindication) {
		this.contraindication = contraindication;
	}

	public String getInstall() {
		return this.install;
	}

	public void setInstall(String install) {
		this.install = install;
	}

	public String getUsage() {
		return this.usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getCareMain() {
		return this.careMain;
	}

	public void setCareMain(String careMain) {
		this.careMain = careMain;
	}

	public String getStorCondMeth() {
		return this.storCondMeth;
	}

	public void setStorCondMeth(String storCondMeth) {
		this.storCondMeth = storCondMeth;
	}

	public String getValiPeri() {
		return this.valiPeri;
	}

	public void setValiPeri(String valiPeri) {
		this.valiPeri = valiPeri;
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

	public Set getEquiDises() {
		return this.equiDises;
	}

	public void setEquiDises(Set equiDises) {
		this.equiDises = equiDises;
	}

	public Set getEquiSymps() {
		return this.equiSymps;
	}

	public void setEquiSymps(Set equiSymps) {
		this.equiSymps = equiSymps;
	}

}