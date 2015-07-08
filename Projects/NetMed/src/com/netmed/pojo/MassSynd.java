package com.netmed.pojo;

/**
 * 按摩方治证表,字段意义见其配置文件
 * MassSynd entity. @author MyEclipse Persistence Tools
 */

public class MassSynd implements java.io.Serializable {

	// Fields

	private Integer massSyndId;
	private MassPres massPres;
	private String syndName;
	private String remain;

	// Constructors

	/** default constructor */
	public MassSynd() {
	}

	/** minimal constructor */
	public MassSynd(MassPres massPres) {
		this.massPres = massPres;
	}

	/** full constructor */
	public MassSynd(MassPres massPres, String syndName, String remain) {
		this.massPres = massPres;
		this.syndName = syndName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getMassSyndId() {
		return this.massSyndId;
	}

	public void setMassSyndId(Integer massSyndId) {
		this.massSyndId = massSyndId;
	}

	public MassPres getMassPres() {
		return this.massPres;
	}

	public void setMassPres(MassPres massPres) {
		this.massPres = massPres;
	}

	public String getSyndName() {
		return this.syndName;
	}

	public void setSyndName(String syndName) {
		this.syndName = syndName;
	}

	public String getRemain() {
		return this.remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

}