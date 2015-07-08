package com.netmed.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.Collection;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.ExpeServCont;
import com.netmed.pojo.ExpeType;
import com.netmed.pojo.MembConsInfo;

/**
 * 专家DAO
 * 5-11
 * 通过专家服务内容约定表和专家注册表得到医师列表，这里还没有考虑专家的类别
 */

public class DoctorDAO {
	
	/**
	 * 通过专家ID在专家注册表中查找相关专家
	 * @param expertId
	 * @return 专家列表
	 */
	 public List<ExpeRegi> queryExpeRegi(String expertId) {			
	        Session session=HibernateSessionFactory.getSession();
	        Criteria criteria=session.createCriteria(ExpeRegi.class);
			criteria.add(Restrictions.eq("expeId", expertId));
			List<ExpeRegi> expert=criteria.list();
			session.close();
	 		return expert;
		} 
	 
	 /**
	  * 通过专家ID在专家注册表中查找专家
	  * @param expertId
	  * @return 专家对象
	  */
	 public ExpeRegi getExpeRegi(String expertId){
		 Session session=HibernateSessionFactory.getSession();
		 ExpeRegi expert=(ExpeRegi) session.get(ExpeRegi.class,expertId);
		 session.close();
		 return expert;
	 }
		
	 /**
	  * 通过输入关键词在服务内容约定表中查找专家
	  * @param inputStr
	  * @return 服务内容约定中的专家列表
	  */
	 public List<ExpeServCont> queryExpertId(String inputStr){
			 Session session=HibernateSessionFactory.getSession();
		     Criteria criteria=session.createCriteria(ExpeServCont.class);
			 criteria.add(Restrictions.ilike("diseType", inputStr,MatchMode.ANYWHERE));
			 List<ExpeServCont> result=criteria.list();
			 session.close();
			 return result;
	    }
	
	 /**
	  * 通过专家ID在专家类型表中查找专家
	  * @param expertId
	  * @return 专家类型的专家列表
	  */
	public List<ExpeType> queryExpertById(String expertId){
		Session session=HibernateSessionFactory.getSession();
	    Criteria criteria=session.createCriteria(ExpeType.class);
	    criteria.add(Restrictions.eq("expeRegi.expeId", expertId));
	    List<ExpeType> expertList=criteria.list();
	    session.close();
	    return expertList;
	}
	
		
	 /**
	  * 通过专家ID判断专家是否在线
	  * 因hibernate缓存的问题，这里采用jdbc实现
	  * @param expertId
	  * @return 布尔型,在线true
	  */
	 public boolean isOnline(String expertId){
		    boolean flag=false;
			String url = "jdbc:mysql://localhost:3306/netmed";
			String sql="select state from expe_regi t where t.expe_id=?";
			try {
				Connection connect = DriverManager.getConnection(url,"root","xianggen");
				PreparedStatement st=connect.prepareStatement(sql);
				st.setString(1,expertId);     /**将参数设置到查询语句中 **/
				ResultSet rs = st.executeQuery();  /**得到查询结果集**/
				while(rs.next()){
					flag=rs.getBoolean("state");    /**判断专家是否在线**/
				}
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
				flag=false;
			}
			
		   /* boolean flag=false;  缓存问题，先缓着
			Session session=HibernateSessionFactory.getSession();
			ExpeRegi doctor=(ExpeRegi) session.get(ExpeRegi.class, expertId);
			flag=doctor.getState();
			session.close();
			*/
			
			System.out.println(expertId+"在线："+flag);
			return flag;
		}
	
	/**
	 * 通过专家id和用户id判断该专家是否被该用户收藏
	 * @param userId
	 * @param expertId
	 * @return String类型:收藏或取消收藏
	 * 05-12 
	 */
	public String isCollect(String userId,String expertId){
		String isCollect="收藏";
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(Collection.class);
		criteria.add(Restrictions.and(Restrictions.eq("membRegi.membId", userId),Restrictions.eq("expeRegi.expeId", expertId)));
		List<Collection> result=criteria.list();
		if(result.size()!=0){   /**已收藏,则取消收藏**/
			isCollect="取消收藏";
		}	
		session.close();
		return isCollect;
	}
	
	
	/**
	 * 通过会员id查找其互动专家及专家类型
	 * @param userId
	 * @param expertType
	 * @return 离线咨询的专家列表  
	 * 05-12 
	 */
	public List<MembConsInfo> MyExpert(String userId,int expertTypeId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(MembConsInfo.class);
		criteria.add(Restrictions.and(Restrictions.eq("membRegi.membId", userId),Restrictions.eq("expeTypeComp.expeTypeId", expertTypeId)));
		List<MembConsInfo> result=criteria.list();
		session.close();
		return result;
	}
		
}
