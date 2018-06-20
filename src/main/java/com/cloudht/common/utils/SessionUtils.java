package com.cloudht.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;

import com.cloudht.system.domain.UserDO;

public class SessionUtils {
	//获取session
	private static Session session = SecurityUtils.getSubject().getSession();
	/**
	 * 获取当前登录用户的id
	 * @return 当前登录用户的id
	 * @author Hzof
	 */
	public static Long getUserId() {
		SimplePrincipalCollection principalCollection = (SimplePrincipalCollection)session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
    	UserDO ud = (UserDO) principalCollection.getPrimaryPrincipal();
    	return ud.getUserId();
	}
	/**
	 * @return 当前登录用户的对象
	 */
	public static UserDO getUserDO() {
		SimplePrincipalCollection principalCollection = (SimplePrincipalCollection)session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
    	return (UserDO) principalCollection.getPrimaryPrincipal();
	}
}
