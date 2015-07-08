package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 机构服务订单表,字段意义见其配置文件
 * InstServOrde entity. @author MyEclipse Persistence Tools
 */

public class InstServOrde implements java.io.Serializable {

	// Fields

	private String ordeId;
	private ServInstCent servInstCent;
	private String membId;
	private Timestamp ordeTime;
	private String servType;
	private String servCont;
	private Integer servPric;
	private Boolean payState;
	private String comment;
	private Boolean ordeState;
	private Boolean finishTime;

	// Constructors

	/** default constructor */
	public InstServOrde() {
	}

	/** minimal constructor */
	public InstServOrde(String ordeId, ServInstCent servInstCent,
			String membId, Timestamp ordeTime, Integer servPric,
			Boolean payState, Boolean ordeState) {
		this.ordeId = ordeId;
		this.servInstCent = servInstCent;
		this.membId = membId;
		this.ordeTime = ordeTime;
		this.servPric = servPric;
		this.payState = payState;
		this.ordeState = ordeState;
	}

	/** full constructor */
	public InstServOrde(String ordeId, ServInstCent servInstCent,
			String membId, Timestamp ordeTime, String servType,
			String servCont, Integer servPric, Boolean payState,
			String comment, Boolean ordeState, Boolean finishTime) {
		this.ordeId = ordeId;
		this.servInstCent = servInstCent;
		this.membId = membId;
		this.ordeTime = ordeTime;
		this.servType = servType;
		this.servCont = servCont;
		this.servPric = servPric;
		this.payState = payState;
		this.comment = comment;
		this.ordeState = ordeState;
		this.finishTime = finishTime;
	}

	// Property accessors

	public String getOrdeId() {
		return this.ordeId;
	}

	public void setOrdeId(String ordeId) {
		this.ordeId = ordeId;
	}

	public ServInstCent getServInstCent() {
		return this.servInstCent;
	}

	public void setServInstCent(ServInstCent servInstCent) {
		this.servInstCent = servInstCent;
	}

	public String getMembId() {
		return this.membId;
	}

	public void setMembId(String membId) {
		this.membId = membId;
	}

	public Timestamp getOrdeTime() {
		return this.ordeTime;
	}

	public void setOrdeTime(Timestamp ordeTime) {
		this.ordeTime = ordeTime;
	}

	public String getServType() {
		return this.servType;
	}

	public void setServType(String servType) {
		this.servType = servType;
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

	public Boolean getPayState() {
		return this.payState;
	}

	public void setPayState(Boolean payState) {
		this.payState = payState;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getOrdeState() {
		return this.ordeState;
	}

	public void setOrdeState(Boolean ordeState) {
		this.ordeState = ordeState;
	}

	public Boolean getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Boolean finishTime) {
		this.finishTime = finishTime;
	}

}