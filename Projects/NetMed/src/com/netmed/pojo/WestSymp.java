package com.netmed.pojo;

/**
 * 西药治症表,字段意义见其配置文件
 * WestSymp entity. @author MyEclipse Persistence Tools
 */

public class WestSymp implements java.io.Serializable {

	// Fields

	private Integer mediSympId;
	private WestMedi westMedi;
	private String sympName;
	private String remain;

	// Constructors

	/** default constructor */
	public WestSymp() {
	}

	/** minimal constructor */
	public WestSymp(WestMedi westMedi) {
		this.westMedi = westMedi;
	}

	/** full constructor */
	public WestSymp(WestMedi westMedi, String sympName, String remain) {
		this.westMedi = westMedi;
		this.sympName = sympName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getMediSympId() {
		return this.mediSympId;
	}

	public void setMediSympId(Integer mediSympId) {
		this.mediSympId = mediSympId;
	}

	public WestMedi getWestMedi() {
		return this.westMedi;
	}

	public void setWestMedi(WestMedi westMedi) {
		this.westMedi = westMedi;
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