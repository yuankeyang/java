package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 专家服务订单表,字段意义见其配置文件
 * ExpeServOrde entity. @author MyEclipse Persistence Tools
 */

public class ExpeServOrde implements java.io.Serializable {

	// Fields

	private String ordeId;
	private ExpeRegi expeRegi;
	private ExpeTypeComp expeTypeComp;
	private MembRegi membRegi;
	private Timestamp ordeTime;
	private String servCont;
	private Integer servPric;
	private Boolean payStat;
	private String servType;
	private String comment;
	private Boolean state;

	// Constructors

	/** default constructor */
	public ExpeServOrde() {
	}

	/** minimal constructor */
	public ExpeServOrde(String ordeId, ExpeTypeComp expeTypeComp,
			MembRegi membRegi, Timestamp ordeTime) {
		this.ordeId = ordeId;
		this.expeTypeComp = expeTypeComp;
		this.membRegi = membRegi;
		this.ordeTime = ordeTime;
	}

	/** full constructor */
	public ExpeServOrde(String ordeId, ExpeRegi expeRegi,
			ExpeTypeComp expeTypeComp, MembRegi membRegi, Timestamp ordeTime,
			String servCont, Integer servPric, Boolean payStat,
			String servType, String comment, Boolean state) {
		this.ordeId = ordeId;
		this.expeRegi = expeRegi;
		this.expeTypeComp = expeTypeComp;
		this.membRegi = membRegi;
		this.ordeTime = ordeTime;
		this.servCont = servCont;
		this.servPric = servPric;
		this.payStat = payStat;
		this.servType = servType;
		this.comment = comment;
		this.state = state;
	}

	// Property accessors

	public String getOrdeId() {
		return this.ordeId;
	}

	public void setOrdeId(String ordeId) {
		this.ordeId = ordeId;
	}

	public ExpeRegi getExpeRegi() {
		return this.expeRegi;
	}

	public void setExpeRegi(ExpeRegi expeRegi) {
		this.expeRegi = expeRegi;
	}

	public ExpeTypeComp getExpeTypeComp() {
		return this.expeTypeComp;
	}

	public void setExpeTypeComp(ExpeTypeComp expeTypeComp) {
		this.expeTypeComp = expeTypeComp;
	}

	public MembRegi getMembRegi() {
		return this.membRegi;
	}

	public void setMembRegi(MembRegi membRegi) {
		this.membRegi = membRegi;
	}

	public Timestamp getOrdeTime() {
		return this.ordeTime;
	}

	public void setOrdeTime(Timestamp ordeTime) {
		this.ordeTime = ordeTime;
	}

	public String getServCont() {
		return this.servCont;
	}

	public void setServCont(String servCont) {
		this.servCont = servCont;
	}

	public Integer getServPric() {
		return this.servPric;
	}

	public void setServPric(Integer servPric) {
		this.servPric = servPric;
	}

	public Boolean getPayStat() {
		return this.payStat;
	}

	public void setPayStat(Boolean payStat) {
		this.payStat = payStat;
	}

	public String getServType() {
		return this.servType;
	}

	public void setServType(String servType) {
		this.servType = servType;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}