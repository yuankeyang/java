package com.netmed.pojo;

/**
 * 会员电子健康档案表,字段意义见其配置文件
 * MembArchInfo entity. @author MyEclipse Persistence Tools
 */

public class MembArchInfo implements java.io.Serializable {

	// Fields

	private Integer archId;
	private MembRegi membRegi;
	private String relationship;
	private String name;
	private Boolean sex;
	private Integer age;
	private String licenceType;
	private String idCardNumb;
	private String mobiPhonNumb;
	private String lineTele;
	private String insuranceType;
	private String province;
	private String city;
	private String county;
	private String address;
	private String occupation;
	private Boolean mariStat;
	private String drugFoodAlle;
	private String famiHist;
	private String tcmConstitution;
	private String persHist;
	private String auxiExam;
	private Boolean ifcheck;

	// Constructors

	/** default constructor */
	public MembArchInfo() {
	}

	/** minimal constructor */
	public MembArchInfo(MembRegi membRegi, String name, String licenceType) {
		this.membRegi = membRegi;
		this.name = name;
		this.licenceType = licenceType;
	}

	/** full constructor */
	public MembArchInfo(MembRegi membRegi, String relationship, String name,
			Boolean sex, Integer age, String licenceType, String idCardNumb,
			String mobiPhonNumb, String lineTele, String insuranceType,
			String province, String city, String county, String address,
			String occupation, Boolean mariStat, String drugFoodAlle,
			String famiHist, String tcmConstitution, String persHist,
			String auxiExam, Boolean ifcheck) {
		this.membRegi = membRegi;
		this.relationship = relationship;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.licenceType = licenceType;
		this.idCardNumb = idCardNumb;
		this.mobiPhonNumb = mobiPhonNumb;
		this.lineTele = lineTele;
		this.insuranceType = insuranceType;
		this.province = province;
		this.city = city;
		this.county = county;
		this.address = address;
		this.occupation = occupation;
		this.mariStat = mariStat;
		this.drugFoodAlle = drugFoodAlle;
		this.famiHist = famiHist;
		this.tcmConstitution = tcmConstitution;
		this.persHist = persHist;
		this.auxiExam = auxiExam;
		this.ifcheck = ifcheck;
	}

	// Property accessors

	public Integer getArchId() {
		return this.archId;
	}

	public void setArchId(Integer archId) {
		this.archId = archId;
	}

	public MembRegi getMembRegi() {
		return this.membRegi;
	}

	public void setMembRegi(MembRegi membRegi) {
		this.membRegi = membRegi;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLicenceType() {
		return this.licenceType;
	}

	public void setLicenceType(String licenceType) {
		this.licenceType = licenceType;
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

	public String getInsuranceType() {
		return this.insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Boolean getMariStat() {
		return this.mariStat;
	}

	public void setMariStat(Boolean mariStat) {
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

	public String getTcmConstitution() {
		return this.tcmConstitution;
	}

	public void setTcmConstitution(String tcmConstitution) {
		this.tcmConstitution = tcmConstitution;
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

	public Boolean getIfcheck() {
		return this.ifcheck;
	}

	public void setIfcheck(Boolean ifcheck) {
		this.ifcheck = ifcheck;
	}

}