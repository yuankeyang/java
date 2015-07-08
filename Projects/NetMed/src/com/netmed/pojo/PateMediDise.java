package com.netmed.pojo;



/**
 * 中成药治病表,字段意义见其配置文件
 * PateMediDise entity. @author MyEclipse Persistence Tools
 */

public class PateMediDise  implements java.io.Serializable {


    // Fields    

     private Integer pateDiseId;
     private ChinPateMedi chinPateMedi;
     private String chinDiseName;
     private String westDiseName;


    // Constructors

    /** default constructor */
    public PateMediDise() {
    }

	/** minimal constructor */
    public PateMediDise(ChinPateMedi chinPateMedi) {
        this.chinPateMedi = chinPateMedi;
    }
    
    /** full constructor */
    public PateMediDise(ChinPateMedi chinPateMedi, String chinDiseName, String westDiseName) {
        this.chinPateMedi = chinPateMedi;
        this.chinDiseName = chinDiseName;
        this.westDiseName = westDiseName;
    }

   
    // Property accessors

    public Integer getPateDiseId() {
        return this.pateDiseId;
    }
    
    public void setPateDiseId(Integer pateDiseId) {
        this.pateDiseId = pateDiseId;
    }

    public ChinPateMedi getChinPateMedi() {
        return this.chinPateMedi;
    }
    
    public void setChinPateMedi(ChinPateMedi chinPateMedi) {
        this.chinPateMedi = chinPateMedi;
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