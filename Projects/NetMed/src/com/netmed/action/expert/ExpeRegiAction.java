package com.netmed.action.expert;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ExpeRegiDAO;
import com.netmed.dao.ExpeTypeDAO;
import com.netmed.pojo.ExpeTypeComp;
import com.opensymphony.xwork2.ActionSupport;

/**类<code>ExpeRegiAction</code>
 * 专家注册Action
 * @author 远客
 *
 */
public class ExpeRegiAction extends ActionSupport{

	/**
	 * 专家注册action
	 */
	private static final long serialVersionUID = 7195502502697238891L;
	
	private String username;
	private String realname;
	private String password;
	private String sex;
	private String id_card_numb;
	private String email;
	private String phone;
	private String telephone;
	private String referrer;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		try {
			this.realname = new String(realname.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId_card_numb() {
		return id_card_numb;
	}
	public void setId_card_numb(String id_card_numb) {
		this.id_card_numb = id_card_numb;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	/**方法<code>isInvalide</code>
	 * 验证输入的数据是否合法
	 * @return
	 */
	public boolean isInvalide(){
		return true;
	}
	@Override
	public String execute() throws Exception {
		Boolean sex_=Boolean.TRUE;
		if(this.getSex().equals("male"))
			sex_=Boolean.FALSE;
		
		/**Spring调用DAO：专家注册DAO和专家类型DAO**/
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ExpeRegiDAO dao=(ExpeRegiDAO)otx.getBean("ExpeRegiDAO");
		ExpeTypeDAO dao1=(ExpeTypeDAO)otx.getBean("ExpeTypeDAO");
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		String[] s=new String[6];
		s[0]=(String)request.getParameter("1");
		s[1]=(String)request.getParameter("2");
		s[2]=(String)request.getParameter("3");
		s[3]=(String)request.getParameter("4");
		s[4]=(String)request.getParameter("5");
		s[5]=(String)request.getParameter("6");
		ExpeTypeComp temp1=null;
		System.out.println(s[0]);
		System.out.println(s[1]);
		System.out.println(s[2]);
		System.out.println(s[3]);
		System.out.println(s[4]);
		System.out.println(s[5]);
		String[] t={"医师","药师","按摩理疗师","心理咨询师","健康管理师","营养师"};
		
		if(dao.regiExpe(username, realname, password, sex_, id_card_numb, email, phone, 
				telephone, referrer))
		{
			for(int i=0;i<s.length;i++){
				if(s[i]!=null){
					temp1=new ExpeTypeComp();
					
					temp1.setExpeTypeId((new Integer(i+1)));
					temp1.setExpeTypeName(t[i]);
					dao1.SaveExpeType(dao.getExpeinfoById(username), temp1);
					System.out.println("SaveExpeType");
				}
			}
			
			return SUCCESS;
		}else{
		return ERROR;
		}
	}
	
}
