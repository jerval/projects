package cn.itcast.bbs.utils.converter.compass;

import org.compass.core.converter.ConversionException;
import org.compass.core.converter.basic.AbstractBasicConverter;
import org.compass.core.mapping.ResourcePropertyMapping;
import org.compass.core.marshall.MarshallingContext;

import cn.itcast.bbs.domain.User;

/**
 * 只存储id与nickname。格式为: {id}_{nickname}
 * 
 * @author tyg
 * @deprecated
 */
public class UserConverter extends AbstractBasicConverter<User> {

	@Override
	protected User doFromString(String str, ResourcePropertyMapping resourcePropertyMapping, MarshallingContext context)
			throws ConversionException {
		String[] tokens = str.split("_");
		User user = new User();
		user.setId(tokens[0]);
		user.setNickname(tokens[1]);
		return user;
	}

	@Override
	protected String doToString(User o, ResourcePropertyMapping resourcePropertyMapping, MarshallingContext context) {
		return o.getId() + "_" + o.getNickname();
	}

}
