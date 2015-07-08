package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 中药浴方表
 * ChinMediBath entity. @author MyEclipse Persistence Tools
 * 05-20
 * hibernate自动生成
 */

public class ChinMediBath implements java.io.Serializable {

	// Fields

	private String bathId;
	private String bathName;
	private String function;
	private String symptom;
	private String ingredient;
	private String usagDosa;
	private String picture;
	private String precaution;
	private String source;
	private String institution;
	private Set bathSymps = new HashSet(0);
	private Set bathSynds = new HashSet(0);
	private Set bathDises = new HashSet(0);

	// Constructors

	/** default constructor */
	public ChinMediBath() {
	}

	/** minimal constructor */
	public ChinMediBath(String bathId, String bathName) {
		this.bathId = bathId;
		this.bathName = bathName;
	}

	/** full constructor */
	public ChinMediBath(String bathId, String bathName, String function,
			String symptom, String ingredient, String usagDosa, String picture,
			String precaution, String source, String institution,
			Set bathSymps, Set bathSynds, Set bathDises) {
		this.bathId = bathId;
		this.bathName = bathName;
		this.function = function;
		this.symptom = symptom;
		this.ingredient = ingredient;
		this.usagDosa = usagDosa;
		this.picture = picture;
		this.precaution = precaution;
		this.source = source;
		this.institution = institution;
		this.bathSymps = bathSymps;
		this.bathSynds = bathSynds;
		this.bathDises = bathDises;
	}

	// Property accessors

	public String getBathId() {
		return this.bathId;
	}

	public void setBathId(String bathId) {
		this.bathId = bathId;
	}

	public String getBathName() {
		return this.bathName;
	}

	public void setBathName(String bathName) {
		this.bathName = bathName;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getUsagDosa() {
		return this.usagDosa;
	}

	public void setUsagDosa(String usagDosa) {
		this.usagDosa = usagDosa;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPrecaution() {
		return this.precaution;
	}

	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Set getBathSymps() {
		return this.bathSymps;
	}

	public void setBathSymps(Set bathSymps) {
		this.bathSymps = bathSymps;
	}

	public Set getBathSynds() {
		return this.bathSynds;
	}

	public void setBathSynds(Set bathSynds) {
		this.bathSynds = bathSynds;
	}

	public Set getBathDises() {
		return this.bathDises;
	}

	public void setBathDises(Set bathDises) {
		this.bathDises = bathDises;
	}

}