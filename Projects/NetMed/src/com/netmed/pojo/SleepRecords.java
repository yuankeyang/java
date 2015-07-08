package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 睡眠记录表,字段意义见其配置文件
 * SleepRecords entity. @author MyEclipse Persistence Tools
 */

public class SleepRecords implements java.io.Serializable {

	// Fields

	private Integer sleepRecordId;
	private MembRegi membRegi;
	private Timestamp time;
	private String firstSleepTime;
	private String sleepDuration;
	private String deepDuration;
	private String simpleDuration;
	private String dreamDuration;
	private Float breathIndex;

	// Constructors

	/** default constructor */
	public SleepRecords() {
	}

	/** minimal constructor */
	public SleepRecords(MembRegi membRegi, Timestamp time) {
		this.membRegi = membRegi;
		this.time = time;
	}

	/** full constructor */
	public SleepRecords(MembRegi membRegi, Timestamp time,
			String firstSleepTime, String sleepDuration, String deepDuration,
			String simpleDuration, String dreamDuration, Float breathIndex) {
		this.membRegi = membRegi;
		this.time = time;
		this.firstSleepTime = firstSleepTime;
		this.sleepDuration = sleepDuration;
		this.deepDuration = deepDuration;
		this.simpleDuration = simpleDuration;
		this.dreamDuration = dreamDuration;
		this.breathIndex = breathIndex;
	}

	// Property accessors

	public Integer getSleepRecordId() {
		return this.sleepRecordId;
	}

	public void setSleepRecordId(Integer sleepRecordId) {
		this.sleepRecordId = sleepRecordId;
	}

	public MembRegi getMembRegi() {
		return this.membRegi;
	}

	public void setMembRegi(MembRegi membRegi) {
		this.membRegi = membRegi;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getFirstSleepTime() {
		return this.firstSleepTime;
	}

	public void setFirstSleepTime(String firstSleepTime) {
		this.firstSleepTime = firstSleepTime;
	}

	public String getSleepDuration() {
		return this.sleepDuration;
	}

	public void setSleepDuration(String sleepDuration) {
		this.sleepDuration = sleepDuration;
	}

	public String getDeepDuration() {
		return this.deepDuration;
	}

	public void setDeepDuration(String deepDuration) {
		this.deepDuration = deepDuration;
	}

	public String getSimpleDuration() {
		return this.simpleDuration;
	}

	public void setSimpleDuration(String simpleDuration) {
		this.simpleDuration = simpleDuration;
	}

	public String getDreamDuration() {
		return this.dreamDuration;
	}

	public void setDreamDuration(String dreamDuration) {
		this.dreamDuration = dreamDuration;
	}

	public Float getBreathIndex() {
		return this.breathIndex;
	}

	public void setBreathIndex(Float breathIndex) {
		this.breathIndex = breathIndex;
	}

}