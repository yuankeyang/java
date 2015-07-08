package com.netmed.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.Chat;

/**
 * 在线咨询DAO，用来创建在线咨询对话框，查询是否有在线咨询
 * @author Administrator
 */
public class ChatDao {

	/**
	 * 新增一次在线聊天记录
	 * @param chat
	 * 无返回值
	 */
	public void AddChat(Chat chat) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.save(chat);
		tran.commit();
		session.close();
	}

	/**
	 * 更新某一次在线聊天记录
	 * @param chat
	 * @return 该次聊天记录的id
	 */
	public int UpdateChat(Chat chat) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.update(chat);
		tran.commit();
		session.close();
		return chat.getChatId(); 
	}

	/**
	 * 通过专家id查找未处理的在线咨询列表
	 * @param expertId
	 * @return 在线咨询列表
	 */
	public List<Chat> FindInfoByExpertId(String expertId) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Chat.class);
		criteria.add(Restrictions.and(
				Restrictions.eq("expeRegi.expeId", expertId),
				Restrictions.eq("state", false)));
		List<Chat> chats = criteria.list();
		session.close();
		return chats;
	}

    /**
     * 通过会员id查询未处理的在线咨询
     * @param memberId
     * @return 在线咨询列表
     */
	public List<Chat> FindInfoByMemberId(String memberId) {
		List<Chat> chats = new ArrayList<Chat>();
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Chat.class);
		criteria.add(Restrictions.and(
				Restrictions.eq("membRegi.membId", memberId),
				Restrictions.eq("state", false)));
		chats = criteria.list();
		session.close();
		return chats;
	}
}