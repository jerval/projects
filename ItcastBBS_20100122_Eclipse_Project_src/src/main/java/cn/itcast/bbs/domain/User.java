package cn.itcast.bbs.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户(会员)
 * 
 * @author 传智博客.汤阳光 Jun 19, 2008
 */
public class User {
	// --- 基本信息
	private String id;
	private String loginName;// 登录名
	private String password;// 密码
	private String email;// Email地址

	// --- 个人信息
	private String nickname;// 昵称
	private Gender gender; // 性别
	private byte[] avatar;// 头像
	private String signature;// 签名

	// --- 其他
	private Date registrationTime;// 注册时间
	private Date lastVisitTime; // 最后(上次)访问时间
	private String lastVisitIpAddr; // 最后(上次)访问时所使用的ip地址

	private int topicCount;// 发表的总主题数
	private int articleCount;// 发表的总文章数

	private boolean locked;// 是否被锁定
	private String autoLoginAuthKey;// 用于自动登陆的一个认证的字符串

	// private String activationKey;// 锁定用户自己激活帐号所用的激活码
	private Set<Role> roles = new HashSet<Role>(0);// 所拥有的角色（权限）

	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Date getLastVisitTime() {
		return lastVisitTime;
	}

	public void setLastVisitTime(Date lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}

	public String getLastVisitIpAddr() {
		return lastVisitIpAddr;
	}

	public void setLastVisitIpAddr(String lastVisitIpAddr) {
		this.lastVisitIpAddr = lastVisitIpAddr;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public String getAutoLoginAuthKey() {
		return autoLoginAuthKey;
	}

	public void setAutoLoginAuthKey(String autoLoginAuthKey) {
		this.autoLoginAuthKey = autoLoginAuthKey;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("[User: ")//
				.append("id=").append(id)//
				.append(",loginName=").append(loginName)//
				.append(",email=").append(email)//
				.append(",registrationTime=").append(registrationTime)//
				.append(",nickname=").append(nickname)//
				.append(",topicCount=").append(topicCount)//
				.append(",articleCount=").append(articleCount)//
				.append("]")//
				.toString();
	}
}
