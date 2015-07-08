package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * BlooPres entity. @author MyEclipse Persistence Tools
 */


/**
 * @author Administrator
 * 血压记录表
 * 05-20
 */
public class BlooPres implements java.io.Serializable {

	// Fields

	private Integer blooPresId;
	private MembRegi membRegi;
	private String name;
	private Timestamp measTime;
	private Integer systPres;
	private Integer diasPres;
	private Integer blooOxyg;
	private Double temperature;
	private Boolean ifsafe;

	// Constructors

	/** default constructor */
	public BlooPres() {
	}

	/** minimal constructor */
	public BlooPres(MembRegi membRegi, String name, Timestamp measTime) {
		this.membRegi = membRegi;
		this.name = name;
		this.measTime = measTime;
	}

	/** full constructor */
	public BlooPres(MembRegi membRegi, String name, Timestamp measTime,
			Integer systPres, Integer diasPres, Integer blooOxyg,
			Double temperature, Boolean ifsafe) {
		this.membRegi = membRegi;
		this.name = name;
		this.measTime = measTime;
		this.systPres = systPres;
		this.diasPres = diasPres;
		this.blooOxyg = blooOxyg;
		this.temperature = temperature;
		this.ifsafe = ifsafe;
	}

	// Property accessors

	public Integer getBlooPresId() {
		return this.blooPresId;
	}

	public void setBlooPresId(Integer blooPresId) {
		this.blooPresId = blooPresId;
	}

	public MembRegi getMembRegi() {
		return this.membRegi;
	}

	public void setMembRegi(MembRegi membRegi) {
		this.membRegi = membRegi;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getMeasTime() {
		return this.measTime;
	}

	public void setMeasTime(Timestamp measTime) {
		this.measTime = measTime;
	}

	public Integer getSystPres() {
		return this.systPres;
	}

	public void setSystPres(Integer systPres) {
		this.systPres = systPres;
	}

	public Integer getDiasPres() {
		return this.diasPres;
	}

	public void setDiasPres(Integer diasPres) {
		this.diasPres = diasPres;
	}

	public Integer getBlooOxyg() {
		return this.blooOxyg;
	}

	public void setBlooOxyg(Integer blooOxyg) {
		this.blooOxyg = blooOxyg;
	}

	public Double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Boolean getIfsafe() {
		return this.ifsafe;
	}

	public void setIfsafe(Boolean ifsafe) {
		this.ifsafe = ifsafe;
	}

}