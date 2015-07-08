package com.netmed.pojo;

/**
 * 保健食品治病表,字段意义见其配置文件
 * HealFoodDise entity. @author MyEclipse Persistence Tools
 */

public class HealFoodDise implements java.io.Serializable {

	// Fields

	private Integer foodDiseId;
	private HealFood healFood;
	private String chinDiseName;
	private String westDiseName;

	// Constructors

	/** default constructor */
	public HealFoodDise() {
	}

	/** minimal constructor */
	public HealFoodDise(HealFood healFood) {
		this.healFood = healFood;
	}

	/** full constructor */
	public HealFoodDise(HealFood healFood, String chinDiseName,
			String westDiseName) {
		this.healFood = healFood;
		this.chinDiseName = chinDiseName;
		this.westDiseName = westDiseName;
	}

	// Property accessors

	public Integer getFoodDiseId() {
		return this.foodDiseId;
	}

	public void setFoodDiseId(Integer foodDiseId) {
		this.foodDiseId = foodDiseId;
	}

	public HealFood getHealFood() {
		return this.healFood;
	}

	public void setHealFood(HealFood healFood) {
		this.healFood = healFood;
	}

	public String getChinDiseName() {
		return this.chinDiseName;
	}

	public void setChinDiseName(String chinDiseName) {
		this.chinDiseName = chinDiseName;
	}

	public String getWestDiseName() {
		return this.westDiseName;
	}

	public void setWestDiseName(String westDiseName) {
		this.westDiseName = westDiseName;
	}

}