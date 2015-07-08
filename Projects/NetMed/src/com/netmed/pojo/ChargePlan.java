package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 收费套餐表
 * ChargePlan entity. @author MyEclipse Persistence Tools
 * 05-20
 */

public class ChargePlan implements java.io.Serializable {

	// Fields

	private Integer planTypeId;
	private String planDetail;
	private Set expeServPrics = new HashSet(0);

	// Constructors

	/** default constructor */
	public ChargePlan() {
	}

	/** minimal constructor */
	public ChargePlan(String planDetail) {
		this.planDetail = planDetail;
	}

	/** full constructor */
	public ChargePlan(String planDetail, Set expeServPrics) {
		this.planDetail = planDetail;
		this.expeServPrics = expeServPrics;
	}

	// Property accessors

	public Integer getPlanTypeId() {
		return this.planTypeId;
	}

	public void setPlanTypeId(Integer planTypeId) {
		this.planTypeId = planTypeId;
	}

	public String getPlanDetail() {
		return this.planDetail;
	}

	public void setPlanDetail(String planDetail) {
		this.planDetail = planDetail;
	}

	public Set getExpeServPrics() {
		return this.expeServPrics;
	}

	public void setExpeServPrics(Set expeServPrics) {
		this.expeServPrics = expeServPrics;
	}

}