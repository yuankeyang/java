package com.netmed.pojo;

/**
 * 中西医病名对照表,字段意义见其配置文件
 * ChinWestCont entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class ChinWestCont implements java.io.Serializable {

	// Fields

	private Integer chinWestId;
	private ChinDiseSyno chinDiseSyno;
	private WestDiseSyno westDiseSyno;

	// Constructors

	/** default constructor */
	public ChinWestCont() {
	}

	/** full constructor */
	public ChinWestCont(ChinDiseSyno chinDiseSyno, WestDiseSyno westDiseSyno) {
		this.chinDiseSyno = chinDiseSyno;
		this.westDiseSyno = westDiseSyno;
	}

	// Property accessors

	public Integer getChinWestId() {
		return this.chinWestId;
	}

	public void setChinWestId(Integer chinWestId) {
		this.chinWestId = chinWestId;
	}

	public ChinDiseSyno getChinDiseSyno() {
		return this.chinDiseSyno;
	}

	public void setChinDiseSyno(ChinDiseSyno chinDiseSyno) {
		this.chinDiseSyno = chinDiseSyno;
	}

	public WestDiseSyno getWestDiseSyno() {
		return this.westDiseSyno;
	}

	public void setWestDiseSyno(WestDiseSyno westDiseSyno) {
		this.westDiseSyno = westDiseSyno;
	}

}