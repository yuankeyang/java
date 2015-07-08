package com.netmed.pojo;

/**
 * 中成药治证表,字段意义见其配置文件
 * PateMediSynd entity. @author MyEclipse Persistence Tools
 */

public class PateMediSynd implements java.io.Serializable {

	// Fields

	private Integer pateSyndId;
	private ChinPateMedi chinPateMedi;
	private String syndName;
	private String remain;

	// Constructors

	/** default constructor */
	public PateMediSynd() {
	}

	/** minimal constructor */
	public PateMediSynd(ChinPateMedi chinPateMedi) {
		this.chinPateMedi = chinPateMedi;
	}

	/** full constructor */
	public PateMediSynd(ChinPateMedi chinPateMedi, String syndName,
			String remain) {
		this.chinPateMedi = chinPateMedi;
		this.syndName = syndName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getPateSyndId() {
		return this.pateSyndId;
	}

	public void setPateSyndId(Integer pateSyndId) {
		this.pateSyndId = pateSyndId;
	}

	public ChinPateMedi getChinPateMedi() {
		return this.chinPateMedi;
	}

	public void setChinPateMedi(ChinPateMedi chinPateMedi) {
		this.chinPateMedi = chinPateMedi;
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