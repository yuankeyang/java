package com.netmed.pojo;

/**
 * 保健食品治症表,字段意义见其配置文件
 * HealFoodSymp entity. @author MyEclipse Persistence Tools
 */

public class HealFoodSymp implements java.io.Serializable {

	// Fields

	private Integer foodSympId;
	private HealFood healFood;
	private String sympName;
	private String remain;

	// Constructors

	/** default constructor */
	public HealFoodSymp() {
	}

	/** minimal constructor */
	public HealFoodSymp(HealFood healFood) {
		this.healFood = healFood;
	}

	/** full constructor */
	public HealFoodSymp(HealFood healFood, String sympName, String remain) {
		this.healFood = healFood;
		this.sympName = sympName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getFoodSympId() {
		return this.foodSympId;
	}

	public void setFoodSympId(Integer foodSympId) {
		this.foodSympId = foodSympId;
	}

	public HealFood getHealFood() {
		return this.healFood;
	}

	public void setHealFood(HealFood healFood) {
		this.healFood = healFood;
	}

	public String getSympName() {
		return this.sympName;
	}

	public void setSympName(String sympName) {
		this.sympName = sympName;
	}

	public String getRemain() {
		return this.remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

}