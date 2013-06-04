package cn.itcast.bbs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.BlogLink;

import cn.itcast.bbs.service.BlogLinkService;
import cn.itcast.bbs.service.base.ServiceImplBase;

@Service("blogLinkService")
@Transactional
public class BlogLinkServiceImpl extends ServiceImplBase<BlogLink> implements BlogLinkService {

}
