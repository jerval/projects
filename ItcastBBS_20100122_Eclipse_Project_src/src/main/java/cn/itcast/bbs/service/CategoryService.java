package cn.itcast.bbs.service;

import cn.itcast.bbs.domain.Category;
import cn.itcast.bbs.service.base.ServiceBase;

/**
 * 
 * @author 传智播客.汤阳光 Dec 15, 2008
 */
public interface CategoryService extends ServiceBase<Category> {

	/**
	 * 上/下移动指定的分类
	 * 
	 * @param id
	 * @param isUp true表示向上移动；false表示向下移动
	 * @return 是否移动了。 有两种情况返回false: 1. 最下面的下移; 2. 最上面的上移
	 */
	boolean move(String id, boolean isUp);

}
