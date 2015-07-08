package com.Bean;

public class InstRegister {
	private db_manager dbmanager;
	private InstBean instBean;
	public void setInstBean(InstBean instBean) {
		this.instBean=instBean;
	}
	public InstRegister() {
		// TODO Auto-generated constructor stub
		dbmanager=new db_manager();
	}
	public boolean register() {
		String sql="INSERT INTO serv_inst_regi(inst_id,inst_name,inst_pass,inst_clas,busi_scop,lega_repr_name,lega_repr_id,"
				+ "busi_lice,orga_code,inst_prov,inst_city,inst_coun,inst_over,inst_emai,inst_line_phon,inst_mobi_phon) VALUES('"+instBean.getInst_id()+"','"
				+instBean.getInst_name()+"','"+instBean.getInst_pass()+"','"+instBean.getInst_clas()+"','"+instBean.getBusi_scop()+"','"
				+instBean.getLega_repr_name()+"','"+instBean.getLega_repr_id()+"','"+instBean.getBusi_lice()+"','"+instBean.getOrga_code()
				+"','"+instBean.getInst_prov()+"','"+instBean.getInst_city()+"','"+instBean.getInst_coun()+"','"+instBean.getInst_over()
				+"','"+instBean.getInst_emai()+"','"+instBean.getInst_line_phon()+"','"+instBean.getInst_mobi_phon()+"')";
				
		//dbmanager.query(sql);
		if(dbmanager.update(sql)==1) {
			dbmanager.dbclose();
			return true;
			}
		else{
			dbmanager.dbclose();
			return false;
		}
	}
	
}
