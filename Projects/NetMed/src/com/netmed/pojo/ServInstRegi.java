package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 服务机构注册表,字段意义见其配置文件
 * ServInstRegi entity. @author MyEclipse Persistence Tools
 */

public class ServInstRegi implements java.io.Serializable {

	// Fields

	private String instId;
	private String instName;
	private String instPass;
	private String instClas;
	private String busiScop;
	private String legaReprName;
	private String legaReprId;
	private String busiLice;
	private String orgaCode;
	private String instProv;
	private String instCity;
	private String instCoun;
	private String instOver;
	private String instEmai;
	private String instLinePhon;
	private String instMobiPhon;
	private Set servInstCents = new HashSet(0);

	// Constructors

	/** default constructor */
	public ServInstRegi() {
	}

	/** minimal constructor */
	public ServInstRegi(String instId, String instName, String instPass,
			String instClas, String busiScop, String legaReprName,
			String legaReprId, String busiLice, String orgaCode,
			String instProv, String instCity, String instCoun, String instEmai,
			String instLinePhon, String instMobiPhon) {
		this.instId = instId;
		this.instName = instName;
		this.instPass = instPass;
		this.instClas = instClas;
		this.busiScop = busiScop;
		this.legaReprName = legaReprName;
		this.legaReprId = legaReprId;
		this.busiLice = busiLice;
		this.orgaCode = orgaCode;
		this.instProv = instProv;
		this.instCity = instCity;
		this.instCoun = instCoun;
		this.instEmai = instEmai;
		this.instLinePhon = instLinePhon;
		this.instMobiPhon = instMobiPhon;
	}

	/** full constructor */
	public ServInstRegi(String instId, String instName, String instPass,
			String instClas, String busiScop, String legaReprName,
			String legaReprId, String busiLice, String orgaCode,
			String instProv, String instCity, String instCoun, String instOver,
			String instEmai, String instLinePhon, String instMobiPhon,
			Set servInstCents) {
		this.instId = instId;
		this.instName = instName;
		this.instPass = instPass;
		this.instClas = instClas;
		this.busiScop = busiScop;
		this.legaReprName = legaReprName;
		this.legaReprId = legaReprId;
		this.busiLice = busiLice;
		this.orgaCode = orgaCode;
		this.instProv = instProv;
		this.instCity = instCity;
		this.instCoun = instCoun;
		this.instOver = instOver;
		this.instEmai = instEmai;
		this.instLinePhon = instLinePhon;
		this.instMobiPhon = instMobiPhon;
		this.servInstCents = servInstCents;
	}

	// Property accessors

	public String getInstId() {
		return this.instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
	}

	public String getInstName() {
		return this.instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public String getInstPass() {
		return this.instPass;
	}

	public void setInstPass(String instPass) {
		this.instPass = instPass;
	}

	public String getInstClas() {
		return this.instClas;
	}

	public void setInstClas(String instClas) {
		this.instClas = instClas;
	}

	public String getBusiScop() {
		return this.busiScop;
	}

	public void setBusiScop(String busiScop) {
		this.busiScop = busiScop;
	}

	public String getLegaReprName() {
		return this.legaReprName;
	}

	public void setLegaReprName(String legaReprName) {
		this.legaReprName = legaReprName;
	}

	public String getLegaReprId() {
		return this.legaReprId;
	}

	public void setLegaReprId(String legaReprId) {
		this.legaReprId = legaReprId;
	}

	public String getBusiLice() {
		return this.busiLice;
	}

	public void setBusiLice(String busiLice) {
		this.busiLice = busiLice;
	}

	public String getOrgaCode() {
		return this.orgaCode;
	}

	public void setOrgaCode(String orgaCode) {
		this.orgaCode = orgaCode;
	}

	public String getInstProv() {
		return this.instProv;
	}

	public void setInstProv(String instProv) {
		this.instProv = instProv;
	}

	public String getInstCity() {
		return this.instCity;
	}

	public void setInstCity(String instCity) {
		this.instCity = instCity;
	}

	public String getInstCoun() {
		return this.instCoun;
	}

	public void setInstCoun(String instCoun) {
		this.instCoun = instCoun;
	}

	public String getInstOver() {
		return this.instOver;
	}

	public void setInstOver(String instOver) {
		this.instOver = instOver;
	}

	public String getInstEmai() {
		return this.instEmai;
	}

	public void setInstEmai(String instEmai) {
		this.instEmai = instEmai;
	}

	public String getInstLinePhon() {
		return this.instLinePhon;
	}

	public void setInstLinePhon(String instLinePhon) {
		this.instLinePhon = instLinePhon;
	}

	public String getInstMobiPhon() {
		return this.instMobiPhon;
	}

	public void setInstMobiPhon(String instMobiPhon) {
		this.instMobiPhon = instMobiPhon;
	}

	public Set getServInstCents() {
		return this.servInstCents;
	}

	public void setServInstCents(Set servInstCents) {
		this.servInstCents = servInstCents;
	}

}