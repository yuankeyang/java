package com.netmed.pojo;

/**
 * 会员家属表,字段意义见其配置文件
 * MembFami entity. @author MyEclipse Persistence Tools
 */

public class MembFami implements java.io.Serializable {

	// Fields

	private Integer famiId;
	private MembRegi membRegi;
	private String famiName;
	private Boolean sex;
	private Integer age;
	private String relationship;
	private String mobiPhon;
	private String linePhon;
	private String address;

	// Constructors

	/** default constructor */
	public MembFami() {
	}

	/** minimal constructor */
	public MembFami(String famiName, String mobiPhon) {
		this.famiName = famiName;
		this.mobiPhon = mobiPhon;
	}

	/** full constructor */
	public MembFami(MembRegi membRegi, String famiName, Boolean sex,
			Integer age, String relationship, String mobiPhon, String linePhon,
			String address) {
		this.membRegi = membRegi;
		this.famiName = famiName;
		this.sex = sex;
		this.age = age;
		this.relationship = relationship;
		this.mobiPhon = mobiPhon;
		this.linePhon = linePhon;
		this.address = address;
	}

	// Property accessors

	public Integer getFamiId() {
		return this.famiId;
	}

	public void setFamiId(Integer famiId) {
		this.famiId = famiId;
	}

	public MembRegi getMembRegi() {
		return this.membRegi;
	}

	public void setMembRegi(MembRegi membRegi) {
		this.membRegi = membRegi;
	}

	public String getFamiName() {
		return this.famiName;
	}

	public void setFamiName(String famiName) {
		this.famiName = famiName;
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

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getMobiPhon() {
		return this.mobiPhon;
	}

	public void setMobiPhon(String mobiPhon) {
		this.mobiPhon = mobiPhon;
	}

	public String getLinePhon() {
		return this.linePhon;
	}

	public void setLinePhon(String linePhon) {
		this.linePhon = linePhon;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}