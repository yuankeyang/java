package com.Bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ExpeRegiDAO;
import com.netmed.pojo.ExpeRegi;

public class ExpeRegister {
	private db_manager dbmanager;
	private ExpeBean expeBean;

	public boolean checkref(String ref) throws SQLException {
		// System.out.print(ref);
		String sql = "select * from expe_regi where expe_name='" + ref + "'";
		ResultSet rs = dbmanager.query(sql);
		if (rs.next()) {
			dbmanager.dbclose();
			return true;
		} else {
			dbmanager.dbclose();
			return false;
		}
	}

	public void setExpeBean(ExpeBean expeBean) {
		this.expeBean = expeBean;
	}

	public ExpeRegister() {
		// TODO Auto-generated constructor stub
		dbmanager = new db_manager();
	}

	public boolean register() {
		System.out.println(expeBean.getExpe_line_phone());
		System.out.println(expeBean.getExpe_mobi_phone());
		String sql = "INSERT INTO expe_regi(expe_id,expe_name,expe_pass,expe_sex,id_card_numb,id_pict,expe_emai,"
				+ "expe_line_phon,expe_mobi_phon,referrer,refe_conf)"
				+ " VALUES('"
				+ expeBean.getExpe_id()
				+ "','"
				+ expeBean.getExpe_name()
				+ "','"
				+ expeBean.getExpe_pass()
				+ "',"
				+ expeBean.isExpe_sex()
				+ ",'"
				+ expeBean.getExpe_card()
				+ "','"
				+ expeBean.getExpe_pict()
				+ "','"
				+ expeBean.getExpe_emai()
				+ "','"
				+ expeBean.getExpe_line_phone()
				+ "','"
				+ expeBean.getExpe_mobi_phone()
				+ "','"
				+ expeBean.getReferrer() + "'," + expeBean.getRefe_conf() + ")";
		if (dbmanager.update(sql) == 1) {
			dbmanager.dbclose();
			return true;
		} else {
			dbmanager.dbclose();
			return false;
		}
	}

	public boolean uploadImg(String url, String id) {
		ApplicationContext otx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ExpeRegiDAO dao = (ExpeRegiDAO) otx.getBean("ExpeRegiDAO");
		ExpeRegi expe = dao.getExpeinfoById(id);
		expe.setPhoto(url);
		dao.UpdateExpeRegi(expe);
		return true;
	}
}
