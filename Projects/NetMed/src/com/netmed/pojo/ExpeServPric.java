package com.netmed.pojo;

/**
 * 专家服务价格表,字段意义见其配置文件
 * ExpeServPric entity. @author MyEclipse Persistence Tools
 */

public class ExpeServPric implements java.io.Serializable {

	// Fields

	private Integer pricId;
	private ExpeTypeComp expeTypeComp;
	private ChargePlan chargePlan;
	private Integer expeRank;
	private Integer price;

	// Constructors

	/** default constructor */
	public ExpeServPric() {
	}

	/** full constructor */
	public ExpeServPric(ExpeTypeComp expeTypeComp, ChargePlan chargePlan,
			Integer expeRank, Integer price) {
		this.expeTypeComp = expeTypeComp;
		this.chargePlan = chargePlan;
		this.expeRank = expeRank;
		this.price = price;
	}

	// Property accessors

	public Integer getPricId() {
		return this.pricId;
	}

	public void setPricId(Integer pricId) {
		this.pricId = pricId;
	}

	public ExpeTypeComp getExpeTypeComp() {
		return this.expeTypeComp;
	}

	public void setExpeTypeComp(ExpeTypeComp expeTypeComp) {
		this.expeTypeComp = expeTypeComp;
	}

	public ChargePlan getChargePlan() {
		return this.chargePlan;
	}

	public void setChargePlan(ChargePlan chargePlan) {
		this.chargePlan = chargePlan;
	}

	public Integer getExpeRank() {
		return this.expeRank;
	}

	public void setExpeRank(Integer expeRank) {
		this.expeRank = expeRank;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}