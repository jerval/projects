package cn.itcast.bbs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.Attachment;
import cn.itcast.bbs.service.AttachmentService;
import cn.itcast.bbs.service.base.ServiceImplBase;

/**
 * @author 传智播客.汤阳光 Dec 15, 2008
 */
@Service("attachmentService")
@Transactional
public class AttachmentServiceImpl extends ServiceImplBase<Attachment> implements AttachmentService {

	// public void saveAll(List<Attachment> attachmentList) {
	// for (Attachment att : attachmentList) {
	// Article article = att.getArticle();
	// article.getAttachments().add(att);
	// super.update(article); // 使用设置的级联保存附件
	//
	// // int attachmentMaxAmount = SystemGlobals.getSettings().getAttachmentMaxAmount();
	// // if (article.getAttachments().size() > attachmentMaxAmount) {
	// // throw new ItcastException("一篇文章中最多允许" + attachmentMaxAmount + "个附件, 但此文章中有" + article.getAttachments().size() + "个附件");
	// // }
	// }
	//
	// // 保存附件到服务器的文件系统中
	// AttachmentHelper.storeAttachmentFiles(attachmentList);
	// }
	//
	// @Override
	// public void delete(Serializable id) {
	// Attachment att = super.get(id);
	//	
	// // 1, 删除数据库中的记录
	// // 要先移除关联关系, 否则报错:deleted object would be re-saved by cascade
	// // FIXME 可以设为 all-delete-orphan
	// att.getArticle().getAttachments().remove(att);
	// super.delete(att);
	//	
	// // 2, 删除文件
	// String basePath = SystemGlobals.getSettings().getAttachmentStorePath();
	// File file = new File(basePath + "/" + att.getPath());
	// file.delete();
	// }

}
