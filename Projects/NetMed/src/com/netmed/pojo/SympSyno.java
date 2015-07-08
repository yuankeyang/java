package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * 症状同义词表,字段意义见其配置文件
 * SympSyno entity. @author MyEclipse Persistence Tools
 */

public class SympSyno  implements java.io.Serializable {


    // Fields    

     private String sympId;
     private String chinSympName;
     private String synonymy;
     private Set mediKnows = new HashSet(0);
     private Set syndSympConts = new HashSet(0);
     private Set diseSympConts = new HashSet(0);


    // Constructors

    /** default constructor */
    public SympSyno() {
    }

	/** minimal constructor */
    public SympSyno(String sympId, String chinSympName) {
        this.sympId = sympId;
        this.chinSympName = chinSympName;
    }
    
    /** full constructor */
    public SympSyno(String sympId, String chinSympName, String synonymy, Set mediKnows, Set syndSympConts, Set diseSympConts) {
        this.sympId = sympId;
        this.chinSympName = chinSympName;
        this.synonymy = synonymy;
        this.mediKnows = mediKnows;
        this.syndSympConts = syndSympConts;
        this.diseSympConts = diseSympConts;
    }

   
    // Property accessors

    public String getSympId() {
        return this.sympId;
    }
    
    public void setSympId(String sympId) {
        this.sympId = sympId;
    }

    public String getChinSympName() {
        return this.chinSympName;
    }
    
    public void setChinSympName(String chinSympName) {
        this.chinSympName = chinSympName;
    }

    public String getSynonymy() {
        return this.synonymy;
    }
    
    public void setSynonymy(String synonymy) {
        this.synonymy = synonymy;
    }

    public Set getMediKnows() {
        return this.mediKnows;
    }
    
    public void setMediKnows(Set mediKnows) {
        this.mediKnows = mediKnows;
    }

    public Set getSyndSympConts() {
        return this.syndSympConts;
    }
    
    public void setSyndSympConts(Set syndSympConts) {
        this.syndSympConts = syndSympConts;
    }

    public Set getDiseSympConts() {
        return this.diseSympConts;
    }
    
    public void setDiseSympConts(Set diseSympConts) {
        this.diseSympConts = diseSympConts;
    }
   








}