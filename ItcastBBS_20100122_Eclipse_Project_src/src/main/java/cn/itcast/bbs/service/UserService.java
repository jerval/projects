package cn.itcast.bbs.service;

import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.service.base.ServiceBase;

/**
 * @author 传智播客.汤阳光 Dec 15, 2008
 */
public interface UserService extends ServiceBase<User> {

	/**
	 * 检测登录名是否可用。<br>
	 * 用户名不区分大小写, 用户名ABC和abc是相同的
	 * 
	 * @param loginName
	 * @return 指定的用户名是否可以使用（未注册）
	 */
	boolean checkLoginName(String loginName);

	/**
	 * 检测昵称是否可用。<br>
	 * 不区分大小写, ABC和abc是相同的 *
	 * 
	 * @param nickname
	 * @return 指定的用户名是否可以使用（未注册）
	 */
	boolean checkNickname(String nickname);

	/**
	 * 使用用户名和密码查询一个唯一的用户<br>
	 * 用户名不区分大小写, 用户名ABC和abc是相同的
	 * 
	 * @param loginName
	 * @param password 明文密码
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);

	/**
	 * 锁定指定用户<br>
	 * 不会锁定超级管理员用户, 也不会锁定anonymous用户
	 * 
	 * @param id
	 */
	void lock(String id);

	/**
	 * 解锁指定用户
	 * 
	 * @param id
	 */
	void unlock(String id);

	/**
	 * 修改密码
	 * @param id
	 * @param newPassword
	 * @return 修改后的User
	 */
	User changePassword(String id, String newPassword);

}
