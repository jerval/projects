package cn.itcast.bbs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.SystemLog;
import cn.itcast.bbs.service.SystemLogService;
import cn.itcast.bbs.service.base.ServiceImplBase;

/**
 * 
 * @author 传智播客.汤阳光 Dec 15, 2008
 */
@Service("systemLogService")
@Transactional
public class SystemLogServiceImpl extends ServiceImplBase<SystemLog> implements SystemLogService {

}
