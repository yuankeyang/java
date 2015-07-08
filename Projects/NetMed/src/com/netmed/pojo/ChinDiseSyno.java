package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 中医病名同义词表
 * ChinDiseSyno entity. @author MyEclipse Persistence Tools
 * 05-20
 */

public class ChinDiseSyno implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chinDiseId;
	private String chinDiseName;
	private String chinDiseClas;
	private String synonymy;
	private Set diseSympConts = new HashSet(0);
	private Set chinDiagDises = new HashSet(0);
	private Set chinWestConts = new HashSet(0);
	private Set mediKnows = new HashSet(0);

	// Constructors

	/** default constructor */
	public ChinDiseSyno() {
	}

	/** minimal constructor */
	public ChinDiseSyno(String chinDiseName) {
		this.chinDiseName = chinDiseName;
	}

	/** full constructor */
	public ChinDiseSyno(String chinDiseName, String chinDiseClas,
			String synonymy, Set diseSympConts, Set chinDiagDises,
			Set chinWestConts, Set mediKnows) {
		this.chinDiseName = chinDiseName;
		this.chinDiseClas = chinDiseClas;
		this.synonymy = synonymy;
		this.diseSympConts = diseSympConts;
		this.chinDiagDises = chinDiagDises;
		this.chinWestConts = chinWestConts;
		this.mediKnows = mediKnows;
	}

	// Property accessors

	public String getChinDiseId() {
		return this.chinDiseId;
	}

	public void setChinDiseId(String chinDiseId) {
		this.chinDiseId = chinDiseId;
	}

	public String getChinDiseName() {
		return this.chinDiseName;
	}

	public void setChinDiseName(String chinDiseName) {
		this.chinDiseName = chinDiseName;
	}

	public String getChinDiseClas() {
		return this.chinDiseClas;
	}

	public void setChinDiseClas(String chinDiseClas) {
		this.chinDiseClas = chinDiseClas;
	}

	public String getSynonymy() {
		return this.synonymy;
	}

	public void setSynonymy(String synonymy) {
		this.synonymy = synonymy;
	}

	public Set getDiseSympConts() {
		return this.diseSympConts;
	}

	public void setDiseSympConts(Set diseSympConts) {
		this.diseSympConts = diseSympConts;
	}

	public Set getChinDiagDises() {
		return this.chinDiagDises;
	}

	public void setChinDiagDises(Set chinDiagDises) {
		this.chinDiagDises = chinDiagDises;
	}

	public Set getChinWestConts() {
		return this.chinWestConts;
	}

	public void setChinWestConts(Set chinWestConts) {
		this.chinWestConts = chinWestConts;
	}

	public Set getMediKnows() {
		return this.mediKnows;
	}

	public void setMediKnows(Set mediKnows) {
		this.mediKnows = mediKnows;
	}

}