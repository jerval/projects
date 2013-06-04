package cn.itcast.bbs.init;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bbs.domain.Role;
import cn.itcast.bbs.domain.SystemPrivilege;
import cn.itcast.bbs.domain.User;

public class InitPrivilegeAndRoleAndUser {

	@SuppressWarnings("unchecked")
	@Test
	public void init() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// 删除所有信息
		// session.createQuery("DELETE FROM User").executeUpdate();
		// session.createQuery("DELETE FROM SystemPrivilege").executeUpdate();
		// session.createQuery("DELETE FROM Role").executeUpdate();

		// 添加权限数据
		session.save(new SystemPrivilege("发表主题", "Topic", "Create"));
		session.save(new SystemPrivilege("查看主题", "Topic", "Retrieval"));
		session.save(new SystemPrivilege("修改主题", "Topic", "Update"));
		session.save(new SystemPrivilege("删除主题", "Topic", "Delete"));
		session.save(new SystemPrivilege("移动主题", "Topic", "Move"));

		session.save(new SystemPrivilege("发表回复", "Reply", "Create"));
		session.save(new SystemPrivilege("查看回复", "Reply", "Retrieval"));
		session.save(new SystemPrivilege("修改回复", "Reply", "Update"));
		session.save(new SystemPrivilege("删除回复", "Reply", "Delete"));

		session.save(new SystemPrivilege("发表附件", "Attachment", "Create"));
		session.save(new SystemPrivilege("查看附件", "Attachment", "Retrieval"));
		session.save(new SystemPrivilege("更新附件", "Attachment", "Update"));
		session.save(new SystemPrivilege("删除附件", "Attachment", "Delete"));
		session.save(new SystemPrivilege("下载附件", "Attachment", "Download"));

		session.save(new SystemPrivilege("发表投票", "Poll", "Create"));
		session.save(new SystemPrivilege("查看投票", "Poll", "Retrieval"));
		session.save(new SystemPrivilege("修改投票", "Poll", "Update"));
		session.save(new SystemPrivilege("删除投票", "Poll", "Delete"));
		session.save(new SystemPrivilege("参与投票", "Poll", "Vote"));

		session.save(new SystemPrivilege("管理系统", "System", "Manage"));

		// 添加角色数据
		Role adminRole = new Role("管理员"); // 管理员有所有的权限
		adminRole.getSystemPrivileges().addAll(session.createCriteria(SystemPrivilege.class).list());
		session.save(adminRole);

		Role commonRole = new Role("普通会员"); // 普通会员，由管理员在自行设置权限
		commonRole.setDefaultForNewUser(true);
		session.save(commonRole);
		
		// 添加管理员用户
		User user = new User();
		user.setLoginName("superman");
		user.setPassword(DigestUtils.md5Hex("itcast"));
		user.setRegistrationTime(new Date());
		user.setNickname("超级管理员");
		user.getRoles().add(adminRole);
		session.save(user);

		tx.commit();
		session.close();
	}
}
