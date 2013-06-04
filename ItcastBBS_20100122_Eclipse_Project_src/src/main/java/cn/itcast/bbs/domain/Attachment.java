package cn.itcast.bbs.domain;

import java.util.Date;

/**
 * 附件
 * 
 * @author 传智博客.汤阳光 Jun 19, 2008
 */
public class Attachment {
	private String id;
	private String path;// 在服务器端保存的路径
	private Article article;// 所属文章

	private String fileName;// 文件名
	private int fileSize;// 文件大小, 单位B(字节)
	private String description;// 附件说明

	private Date creationTime;// 创建(上传)时间
	private int downloadCount; // 被下载/查看 的次数

	// private InputStream inputStream;// FIXME 附件文件的内容, 不对应数据库中的列.

	public Attachment() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

}
