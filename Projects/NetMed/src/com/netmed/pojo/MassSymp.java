package com.netmed.pojo;

/**
 * 按摩方治症表,字段意义见其配置文件
 * MassSymp entity. @author MyEclipse Persistence Tools
 */

public class MassSymp implements java.io.Serializable {

	// Fields

	private Integer massSympId;
	private MassPres massPres;
	private String sympName;
	private String remain;

	// Constructors

	/** default constructor */
	public MassSymp() {
	}

	/** minimal constructor */
	public MassSymp(MassPres massPres) {
		this.massPres = massPres;
	}

	/** full constructor */
	public MassSymp(MassPres massPres, String sympName, String remain) {
		this.massPres = massPres;
		this.sympName = sympName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getMassSympId() {
		return this.massSympId;
	}

	public void setMassSympId(Integer massSympId) {
		this.massSympId = massSympId;
	}

	public MassPres getMassPres() {
		return this.massPres;
	}

	public void setMassPres(MassPres massPres) {
		this.massPres = massPres;
	}

	public String getSympName() {
		return this.sympName;
	}

	public void setSympName(String sympName) {
		this.sympName = sympName;
	}

	public String getRemain() {
		return this.remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

}