package com.netmed.pojo;

/**
 * 中药材治病表,字段意义见其配置文件
 * MediMateDise entity. @author MyEclipse Persistence Tools
 */

public class MediMateDise  implements java.io.Serializable {


    // Fields    

     private Integer mateDiseId;
     private ChinMediMate chinMediMate;
     private String chinDiseName;
     private String westDiseName;


    // Constructors

    /** default constructor */
    public MediMateDise() {
    }

	/** minimal constructor */
    public MediMateDise(ChinMediMate chinMediMate) {
        this.chinMediMate = chinMediMate;
    }
    
    /** full constructor */
    public MediMateDise(ChinMediMate chinMediMate, String chinDiseName, String westDiseName) {
        this.chinMediMate = chinMediMate;
        this.chinDiseName = chinDiseName;
        this.westDiseName = westDiseName;
    }

   
    // Property accessors

    public Integer getMateDiseId() {
        return this.mateDiseId;
    }
    
    public void setMateDiseId(Integer mateDiseId) {
        this.mateDiseId = mateDiseId;
    }

    public ChinMediMate getChinMediMate() {
        return this.chinMediMate;
    }
    
    public void setChinMediMate(ChinMediMate chinMediMate) {
        this.chinMediMate = chinMediMate;
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