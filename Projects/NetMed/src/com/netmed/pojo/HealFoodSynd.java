package com.netmed.pojo;

/**
 * 保健食品治证表,字段意义见其配置文件
 * HealFoodSynd entity. @author MyEclipse Persistence Tools
 */

public class HealFoodSynd implements java.io.Serializable {

	// Fields

	private Integer foodSyndId;
	private HealFood healFood;
	private String syndName;
	private String remain;

	// Constructors

	/** default constructor */
	public HealFoodSynd() {
	}

	/** minimal constructor */
	public HealFoodSynd(HealFood healFood) {
		this.healFood = healFood;
	}

	/** full constructor */
	public HealFoodSynd(HealFood healFood, String syndName, String remain) {
		this.healFood = healFood;
		this.syndName = syndName;
		this.remain = remain;
	}

	// Property accessors

	public Integer getFoodSyndId() {
		return this.foodSyndId;
	}

	public void setFoodSyndId(Integer foodSyndId) {
		this.foodSyndId = foodSyndId;
	}

	public HealFood getHealFood() {
		return this.healFood;
	}

	public void setHealFood(HealFood healFood) {
		this.healFood = healFood;
	}

	public String getSyndName() {
		return this.syndName;
	}

	public void setSyndName(String syndName) {
		this.syndName = syndName;
	}

	public String getRemain() {
		return this.remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

}