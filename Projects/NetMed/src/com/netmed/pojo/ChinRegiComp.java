package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 中药养生复方表,字段意义见其配置文件
 * ChinRegiComp entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class ChinRegiComp implements java.io.Serializable {

	// Fields

	private String compId;
	private DietClasStru dietClasStru;
	private String compName;
	private String function;
	private String foodMate;
	private String makeMeth;
	private String usagDosa;
	private String picture;
	private String apprCrow;
	private String noAdapCrow;
	private String precaution;
	private String source;
	private String institution;
	private Set compSynds = new HashSet(0);
	private Set compSymps = new HashSet(0);

	// Constructors

	/** default constructor */
	public ChinRegiComp() {
	}

	/** minimal constructor */
	public ChinRegiComp(String compId, String compName) {
		this.compId = compId;
		this.compName = compName;
	}

	/** full constructor */
	public ChinRegiComp(String compId, DietClasStru dietClasStru,
			String compName, String function, String foodMate, String makeMeth,
			String usagDosa, String picture, String apprCrow,
			String noAdapCrow, String precaution, String source,
			String institution, Set compSynds, Set compSymps) {
		this.compId = compId;
		this.dietClasStru = dietClasStru;
		this.compName = compName;
		this.function = function;
		this.foodMate = foodMate;
		this.makeMeth = makeMeth;
		this.usagDosa = usagDosa;
		this.picture = picture;
		this.apprCrow = apprCrow;
		this.noAdapCrow = noAdapCrow;
		this.precaution = precaution;
		this.source = source;
		this.institution = institution;
		this.compSynds = compSynds;
		this.compSymps = compSymps;
	}

	// Property accessors

	public String getCompId() {
		return this.compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public DietClasStru getDietClasStru() {
		return this.dietClasStru;
	}

	public void setDietClasStru(DietClasStru dietClasStru) {
		this.dietClasStru = dietClasStru;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getFoodMate() {
		return this.foodMate;
	}

	public void setFoodMate(String foodMate) {
		this.foodMate = foodMate;
	}

	public String getMakeMeth() {
		return this.makeMeth;
	}

	public void setMakeMeth(String makeMeth) {
		this.makeMeth = makeMeth;
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

	public String getApprCrow() {
		return this.apprCrow;
	}

	public void setApprCrow(String apprCrow) {
		this.apprCrow = apprCrow;
	}

	public String getNoAdapCrow() {
		return this.noAdapCrow;
	}

	public void setNoAdapCrow(String noAdapCrow) {
		this.noAdapCrow = noAdapCrow;
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

	public Set getCompSynds() {
		return this.compSynds;
	}

	public void setCompSynds(Set compSynds) {
		this.compSynds = compSynds;
	}

	public Set getCompSymps() {
		return this.compSymps;
	}

	public void setCompSymps(Set compSymps) {
		this.compSymps = compSymps;
	}

}