package cn.itcast.bbs.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.Role;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.exception.ServiceException;
import cn.itcast.bbs.service.UserService;
import cn.itcast.bbs.service.base.ServiceImplBase;
import cn.itcast.bbs.utils.domain.MemberUtils;

/**
 * @author 传智播客.汤阳光 Date 2008-4-7
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends ServiceImplBase<User> implements UserService {

	public boolean checkLoginName(String loginName) {
		// 去掉用户名两端的空格并转为小写
		loginName = loginName.trim().toLowerCase();
		return getSession().createCriteria(getEntityName())//
				.add(Restrictions.eq("loginName", loginName))//
				.uniqueResult() == null;
	}

	public boolean checkNickname(String nickname) {
		// 去掉用户名两端的空格并转为小写
		nickname = nickname.trim().toLowerCase();
		return getSession().createCriteria(getEntityName())//
				.add(Restrictions.eq("nickname", nickname))//
				.uniqueResult() == null;
	}

	public User findByLoginNameAndPassword(String loginName, String password) {
		// 去掉用户名两端的空格并转为小写
		loginName = loginName.trim().toLowerCase();
		// 使用明文密码的MD5摘要
		password = DigestUtils.md5Hex(password);

		return (User) getSession().createCriteria(getEntityName())//
				.add(Restrictions.eq("loginName", loginName))//
				.add(Restrictions.eq("password", password))//
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void save(User user) {
		if (user.getPassword() == null) {
			throw new ServiceException("用户的密码不能为 null");
		}

		// 去掉用户名两端的空格并转为小写
		String loginName = user.getLoginName().trim().toLowerCase();

		// 设置基本信息
		user.setLoginName(loginName); // 保存为小写的用户名
		user.setPassword(DigestUtils.md5Hex(user.getPassword())); // 使用md5摘要作为密码
		user.setLocked(false); // 新注册即可使用
		user.setRegistrationTime(new Date());

		// 新注册用户有默认的角色
		List<Role> defaultRoleList = getSession().createCriteria(Role.class)//
				.add(Restrictions.eq("defaultForNewUser", true))//
				.setCacheable(true)//
				.list();
		user.getRoles().addAll(defaultRoleList);

		// 保存用户
		super.save(user);
	}

	public User changePassword(String id, String newPassword) {
		User user = (User) getSession().get(User.class, id);
		user.setPassword(DigestUtils.md5Hex(newPassword)); // 使用md5摘要作为密码
		getSession().merge(user);
		return user;
	}

	public void lock(String id) {
		User user = (User) getSession().get(User.class, id);
		if (!MemberUtils.isSuperman(user)) { // 不能锁定超级管理员
			user.setLocked(true);
			getSession().merge(user);
		}
	}

	public void unlock(String id) {
		User user = (User) getSession().get(User.class, id);
		user.setLocked(false);
		getSession().merge(user);
	}

}
