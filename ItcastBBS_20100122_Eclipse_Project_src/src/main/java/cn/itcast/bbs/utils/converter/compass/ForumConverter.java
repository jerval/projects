package cn.itcast.bbs.utils.converter.compass;

import org.compass.core.converter.ConversionException;
import org.compass.core.converter.basic.AbstractBasicConverter;
import org.compass.core.mapping.ResourcePropertyMapping;
import org.compass.core.marshall.MarshallingContext;

import cn.itcast.bbs.domain.Forum;

/**
 * FIXME 如果使用了这个ForumConverter，那怎么在某版面中搜索呢？
 * 
 * Forum只存储id与name。格式为: {id}_{name}
 * @author tyg
 *@deprecated
 */
public class ForumConverter extends AbstractBasicConverter<Forum> {

	@Override
	protected Forum doFromString(String str, ResourcePropertyMapping resourcePropertyMapping, MarshallingContext context)
			throws ConversionException {
		String[] tokens = str.split("_");
		Forum forum = new Forum();
		forum.setId(tokens[0]);
		forum.setName(tokens[1]);
		return forum;
	}

	@Override
	protected String doToString(Forum o, ResourcePropertyMapping resourcePropertyMapping, MarshallingContext context) {
		return o.getId() + "_" + o.getName();
	}

}
