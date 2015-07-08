package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 按摩方表,字段意义见其配置文件
 * MassPres entity. @author MyEclipse Persistence Tools
 */

public class MassPres implements java.io.Serializable {

	// Fields

	private String massId;
	private String massName;
	private String function;
	private String operMeth;
	private String picture;
	private String vedio;
	private String institution;
	private Set massSymps = new HashSet(0);
	private Set massDises = new HashSet(0);
	private Set massSynds = new HashSet(0);

	// Constructors

	/** default constructor */
	public MassPres() {
	}

	/** minimal constructor */
	public MassPres(String massId, String massName) {
		this.massId = massId;
		this.massName = massName;
	}

	/** full constructor */
	public MassPres(String massId, String massName, String function,
			String operMeth, String picture, String vedio, String institution,
			Set massSymps, Set massDises, Set massSynds) {
		this.massId = massId;
		this.massName = massName;
		this.function = function;
		this.operMeth = operMeth;
		this.picture = picture;
		this.vedio = vedio;
		this.institution = institution;
		this.massSymps = massSymps;
		this.massDises = massDises;
		this.massSynds = massSynds;
	}

	// Property accessors

	public String getMassId() {
		return this.massId;
	}

	public void setMassId(String massId) {
		this.massId = massId;
	}

	public String getMassName() {
		return this.massName;
	}

	public void setMassName(String massName) {
		this.massName = massName;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getOperMeth() {
		return this.operMeth;
	}

	public void setOperMeth(String operMeth) {
		this.operMeth = operMeth;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getVedio() {
		return this.vedio;
	}

	public void setVedio(String vedio) {
		this.vedio = vedio;
	}

	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Set getMassSymps() {
		return this.massSymps;
	}

	public void setMassSymps(Set massSymps) {
		this.massSymps = massSymps;
	}

	public Set getMassDises() {
		return this.massDises;
	}

	public void setMassDises(Set massDises) {
		this.massDises = massDises;
	}

	public Set getMassSynds() {
		return this.massSynds;
	}

	public void setMassSynds(Set massSynds) {
		this.massSynds = massSynds;
	}

}