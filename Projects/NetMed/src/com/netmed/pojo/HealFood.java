package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 保健食品表,字段意义见其配置文件
 * HealFood entity. @author MyEclipse Persistence Tools
 */

public class HealFood implements java.io.Serializable {

	// Fields

	private String healFoodId;
	private String healFoodName;
	private String function;
	private String picture;
	private String mainRawMate;
	private String funcIngrCont;
	private String apprCrow;
	private String noAdapCrow;
	private String edibMeth;
	private String guarPeri;
	private String storMeth;
	private String precaution;
	private String apprNumb;
	private String execNorm;
	private String hygiLice;
	private String enterprise;
	private Set healFoodSynds = new HashSet(0);
	private Set healFoodDises = new HashSet(0);
	private Set healFoodSymps = new HashSet(0);

	// Constructors

	/** default constructor */
	public HealFood() {
	}

	/** minimal constructor */
	public HealFood(String healFoodId, String healFoodName) {
		this.healFoodId = healFoodId;
		this.healFoodName = healFoodName;
	}

	/** full constructor */
	public HealFood(String healFoodId, String healFoodName, String function,
			String picture, String mainRawMate, String funcIngrCont,
			String apprCrow, String noAdapCrow, String edibMeth,
			String guarPeri, String storMeth, String precaution,
			String apprNumb, String execNorm, String hygiLice,
			String enterprise, Set healFoodSynds, Set healFoodDises,
			Set healFoodSymps) {
		this.healFoodId = healFoodId;
		this.healFoodName = healFoodName;
		this.function = function;
		this.picture = picture;
		this.mainRawMate = mainRawMate;
		this.funcIngrCont = funcIngrCont;
		this.apprCrow = apprCrow;
		this.noAdapCrow = noAdapCrow;
		this.edibMeth = edibMeth;
		this.guarPeri = guarPeri;
		this.storMeth = storMeth;
		this.precaution = precaution;
		this.apprNumb = apprNumb;
		this.execNorm = execNorm;
		this.hygiLice = hygiLice;
		this.enterprise = enterprise;
		this.healFoodSynds = healFoodSynds;
		this.healFoodDises = healFoodDises;
		this.healFoodSymps = healFoodSymps;
	}

	// Property accessors

	public String getHealFoodId() {
		return this.healFoodId;
	}

	public void setHealFoodId(String healFoodId) {
		this.healFoodId = healFoodId;
	}

	public String getHealFoodName() {
		return this.healFoodName;
	}

	public void setHealFoodName(String healFoodName) {
		this.healFoodName = healFoodName;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getMainRawMate() {
		return this.mainRawMate;
	}

	public void setMainRawMate(String mainRawMate) {
		this.mainRawMate = mainRawMate;
	}

	public String getFuncIngrCont() {
		return this.funcIngrCont;
	}

	public void setFuncIngrCont(String funcIngrCont) {
		this.funcIngrCont = funcIngrCont;
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

	public String getEdibMeth() {
		return this.edibMeth;
	}

	public void setEdibMeth(String edibMeth) {
		this.edibMeth = edibMeth;
	}

	public String getGuarPeri() {
		return this.guarPeri;
	}

	public void setGuarPeri(String guarPeri) {
		this.guarPeri = guarPeri;
	}

	public String getStorMeth() {
		return this.storMeth;
	}

	public void setStorMeth(String storMeth) {
		this.storMeth = storMeth;
	}

	public String getPrecaution() {
		return this.precaution;
	}

	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	public String getApprNumb() {
		return this.apprNumb;
	}

	public void setApprNumb(String apprNumb) {
		this.apprNumb = apprNumb;
	}

	public String getExecNorm() {
		return this.execNorm;
	}

	public void setExecNorm(String execNorm) {
		this.execNorm = execNorm;
	}

	public String getHygiLice() {
		return this.hygiLice;
	}

	public void setHygiLice(String hygiLice) {
		this.hygiLice = hygiLice;
	}

	public String getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public Set getHealFoodSynds() {
		return this.healFoodSynds;
	}

	public void setHealFoodSynds(Set healFoodSynds) {
		this.healFoodSynds = healFoodSynds;
	}

	public Set getHealFoodDises() {
		return this.healFoodDises;
	}

	public void setHealFoodDises(Set healFoodDises) {
		this.healFoodDises = healFoodDises;
	}

	public Set getHealFoodSymps() {
		return this.healFoodSymps;
	}

	public void setHealFoodSymps(Set healFoodSymps) {
		this.healFoodSymps = healFoodSymps;
	}

}