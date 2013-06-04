package cn.itcast.bbs.web.struts.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts.upload.FormFile;

import cn.itcast.bbs.dd.DDConstants;
import cn.itcast.bbs.dd.DataDict;
import cn.itcast.bbs.utils.ImageUtils;
import cn.itcast.bbs.utils.web.WebAppUtils;

/**
 * 
 * @author 传智播客.汤阳光 Jul 7, 2008
 */
public class UserActionHelper {

	/**
	 * 压缩上传的用户头像到指定的像素大小
	 * 
	 * @param formFile
	 * @return
	 * @throws IOException
	 */
	@Deprecated
	public static byte[] handleAvatar(HttpServletRequest request, FormFile formFile) throws IOException {
		if (formFile.getFileSize() == 0) {
			return null;
		}

		String imgName = formFile.getFileName();
		String extension = FilenameUtils.getExtension(imgName).toLowerCase();

		int type = ImageUtils.IMAGE_UNKNOWN;
		if (extension.equals("jpg") || extension.equals("jpeg")) {
			type = ImageUtils.IMAGE_JPEG;
		} else if (extension.equals("png") || extension.equals("gif")) {
			type = ImageUtils.IMAGE_PNG;
			extension = "png";
		}

		if (type == ImageUtils.IMAGE_UNKNOWN) {
			return null;
		}

		String tempFilename = WebAppUtils.getBaseRealPath(request) + imgName;
		try { // 先保存为临时文件到临时文件夹中
			saveAvatarFile(formFile.getInputStream(), tempFilename);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		int maxWidth = DataDict.getInt(DDConstants.AVATAR_MAX_WIDTH);
		int maxHeight = DataDict.getInt(DDConstants.AVATAR_MAX_HEIGHT);
		BufferedImage image = ImageUtils.resizeImage(tempFilename, ImageUtils.IMAGE_GIF, maxWidth, maxHeight);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(image, type == ImageUtils.IMAGE_JPEG ? "jpg" : "png", out);

		try { // 删除临时文件
			new File(tempFilename).delete();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return out.toByteArray();
	}

	/**
	 * 保存头像文件
	 * 
	 * @param inputStream
	 * @param filename
	 */
	private static void saveAvatarFile(InputStream inputStream, String filename) {
		FileOutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(filename);

			int c;
			byte[] b = new byte[4096];
			while ((c = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, c);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
