package cn.itcast.bbs.dd;


/**
 * 数据字典中用到的Key常量
 * 
 * @author tyg
 */
public class DDConstants {

	/** 临时文件的目录的相对路径（相对于应用程序根据目） */
	public static final String TEMP_DIRECTORY_RELATIVE_PATH = "TEMP_DIRECTORY_RELATIVE_PATH";

	/** 会员头像的最大宽度 */
	public static final String AVATAR_MAX_WIDTH = "AVATAR_MAX_WIDTH";

	/** 会员头像的最大高度 */
	public static final String AVATAR_MAX_HEIGHT = "AVATAR_MAX_HEIGHT";

	// ---

	/** 会员登录的地址 */
	public static final String LOGIN_USER_URL = "LOGIN_USER_URL";

	/** 默认的页面大小（一页显示的数据的条数） */
	public static final String DEFAULT_PAGE_SIZE = "DEFAULT_PAGE_SIZE";

	/** 主题类型 */
	public static final String TOPIC_TYPE = "TOPIC_TYPE";

	/** 分页信息中要显示的页码的数量 */
	public static final String DISPALY_PAGE_NUMBER_COUNT = "DISPALY_PAGE_NUMBER_COUNT";

	/** 系统资源 */
	public static final String PRIVILEGE_SYSTEM_RESOURCE = "PRIVILEGE_SYSTEM_RESOURCE";

	/** 对系统资源的操作 */
	public static final String PRIVILEGE_RESOURCE_ACTION = "PRIVILEGE_RESOURCE_ACTION";

	/** 系统日志的类型 */
	public static final String SYSTEM_LOG_TYPE = "SYSTEM_LOG_TYPE";

	/** 不要记录痕迹的后台管理操作的方法名表达式（正则表达式） */
	public static final String MANAGE_METHOD_NAME_REGEX_TO_EXCLUDE_LOG_TRACE = "MANAGE_METHOD_NAME_REGEX_TO_EXCLUDE_LOG_TRACE";

}