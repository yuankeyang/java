package com.netmed.pojo;

/**
 * 中成药治症表,字段意义见其配置文件
 * PateMediSymp entity. @author MyEclipse Persistence Tools
 */

public class PateMediSymp implements java.io.Serializable {

	// Fields

	private Integer pateSympId;
	private ChinPateMedi chinPateMedi;
	private String sympName;
	private String remain;

	// Constructors

	/** default constructor */
	public PateMediSymp() {
	}

	/** minimal constructor */
	public PateMediSymp(ChinPateMedi chinPateMedi) {
		this.chinPateMedi = chinPateMedi;
	}

	/** full constructor */
	public PateMediSymp(ChinPateMedi chinPateMedi, String sympName,
			String remain) {
		this.chinPateMedi = chinPateMedi;
		this.sympName = sympName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getPateSympId() {
		return this.pateSympId;
	}

	public void setPateSympId(Integer pateSympId) {
		this.pateSympId = pateSympId;
	}

	public ChinPateMedi getChinPateMedi() {
		return this.chinPateMedi;
	}

	public void setChinPateMedi(ChinPateMedi chinPateMedi) {
		this.chinPateMedi = chinPateMedi;
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