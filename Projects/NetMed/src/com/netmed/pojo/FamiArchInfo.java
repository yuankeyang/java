package com.netmed.pojo;

import java.util.Date;

/**
 * 家属电子健康档案表,字段意义见其配置文件
 * FamiArchInfo entity. @author MyEclipse Persistence Tools
 */

public class FamiArchInfo implements java.io.Serializable {

	// Fields

	private Integer archId;
	private MembFami membFami;
	private String famiName;
	private String sex;
	private Date birthDate;
	private String idCardNumb;
	private String mobiPhonNumb;
	private String lineTele;
	private String mediInsuClas;
	private String censRegiProv;
	private String censRegiCity;
	private String censRegiCoun;
	private String membAddr;
	private String membOccu;
	private String mariStat;
	private String drugFoodAlle;
	private String famiHist;
	private String persHist;
	private String auxiExam;

	// Constructors

	/** default constructor */
	public FamiArchInfo() {
	}

	/** minimal constructor */
	public FamiArchInfo(MembFami membFami, String famiName) {
		this.membFami = membFami;
		this.famiName = famiName;
	}

	/** full constructor */
	public FamiArchInfo(MembFami membFami, String famiName, String sex,
			Date birthDate, String idCardNumb, String mobiPhonNumb,
			String lineTele, String mediInsuClas, String censRegiProv,
			String censRegiCity, String censRegiCoun, String membAddr,
			String membOccu, String mariStat, String drugFoodAlle,
			String famiHist, String persHist, String auxiExam) {
		this.membFami = membFami;
		this.famiName = famiName;
		this.sex = sex;
		this.birthDate = birthDate;
		this.idCardNumb = idCardNumb;
		this.mobiPhonNumb = mobiPhonNumb;
		this.lineTele = lineTele;
		this.mediInsuClas = mediInsuClas;
		this.censRegiProv = censRegiProv;
		this.censRegiCity = censRegiCity;
		this.censRegiCoun = censRegiCoun;
		this.membAddr = membAddr;
		this.membOccu = membOccu;
		this.mariStat = mariStat;
		this.drugFoodAlle = drugFoodAlle;
		this.famiHist = famiHist;
		this.persHist = persHist;
		this.auxiExam = auxiExam;
	}

	// Property accessors

	public Integer getArchId() {
		return this.archId;
	}

	public void setArchId(Integer archId) {
		this.archId = archId;
	}

	public MembFami getMembFami() {
		return this.membFami;
	}

	public void setMembFami(MembFami membFami) {
		this.membFami = membFami;
	}

	public String getFamiName() {
		return this.famiName;
	}

	public void setFamiName(String famiName) {
		this.famiName = famiName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getIdCardNumb() {
		return this.idCardNumb;
	}

	public void setIdCardNumb(String idCardNumb) {
		this.idCardNumb = idCardNumb;
	}

	public String getMobiPhonNumb() {
		return this.mobiPhonNumb;
	}

	public void setMobiPhonNumb(String mobiPhonNumb) {
		this.mobiPhonNumb = mobiPhonNumb;
	}

	public String getLineTele() {
		return this.lineTele;
	}

	public void setLineTele(String lineTele) {
		this.lineTele = lineTele;
	}

	public String getMediInsuClas() {
		return this.mediInsuClas;
	}

	public void setMediInsuClas(String mediInsuClas) {
		this.mediInsuClas = mediInsuClas;
	}

	public String getCensRegiProv() {
		return this.censRegiProv;
	}

	public void setCensRegiProv(String censRegiProv) {
		this.censRegiProv = censRegiProv;
	}

	public String getCensRegiCity() {
		return this.censRegiCity;
	}

	public void setCensRegiCity(String censRegiCity) {
		this.censRegiCity = censRegiCity;
	}

	public String getCensRegiCoun() {
		return this.censRegiCoun;
	}

	public void setCensRegiCoun(String censRegiCoun) {
		this.censRegiCoun = censRegiCoun;
	}

	public String getMembAddr() {
		return this.membAddr;
	}

	public void setMembAddr(String membAddr) {
		this.membAddr = membAddr;
	}

	public String getMembOccu() {
		return this.membOccu;
	}

	public void setMembOccu(String membOccu) {
		this.membOccu = membOccu;
	}

	public String getMariStat() {
		return this.mariStat;
	}

	public void setMariStat(String mariStat) {
		this.mariStat = mariStat;
	}

	public String getDrugFoodAlle() {
		return this.drugFoodAlle;
	}

	public void setDrugFoodAlle(String drugFoodAlle) {
		this.drugFoodAlle = drugFoodAlle;
	}

	public String getFamiHist() {
		return this.famiHist;
	}

	public void setFamiHist(String famiHist) {
		this.famiHist = famiHist;
	}

	public String getPersHist() {
		return this.persHist;
	}

	public void setPersHist(String persHist) {
		this.persHist = persHist;
	}

	public String getAuxiExam() {
		return this.auxiExam;
	}

	public void setAuxiExam(String auxiExam) {
		this.auxiExam = auxiExam;
	}

}