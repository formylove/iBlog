package main.src.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import main.src.common.ImageUtils;
import main.src.common.Log;
import main.src.common.MessageUtils;
import main.src.common.MsgConstants;
import main.src.service.ImageService;

import org.apache.struts2.ServletActionContext;

/**
 * @author Administrator
 *
 */
public class ImageAction {
	private File upload; // �ļ�
	private File file ; // �ļ�
	private String fileFileName ; // ��Ҳ��֪����ô��õĶ�
	private String imgName; // �ļ�
	private String uploadContentType; // �ļ�����
	private String uploadFileName; // �ļ���
	private String filesize;
	private String filetype;
	private String filedim;
	private float w;
	private float h;
	private float x1;
	private float y1;
	private float x2;
	private float y2;

	public String upLoadCropedImg() throws IOException {
		Log.print("type" + filetype);
		Log.print("w" + w);
		Log.print(h);
		Log.print(x1);
		Log.print(y1);
		Log.print(x2);
		Log.print(y2);
		return "test";
	}

	public String upLoadImg() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		imgName = ImageUtils.saveTemp(file, fileFileName);
		return MsgConstants.DONE;
	}
	public String upLoadImg4Editor() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		imgName = ImageUtils.saveImage4Editor(upload, uploadFileName);
		PrintWriter out =response.getWriter();
		String callback =ServletActionContext.getRequest().getParameter("CKEditorFuncNum");   
		out.println("<script type=\"text/javascript\">");  
		out.println("window.parent.CKEDITOR.tools.callFunction("+ callback + ",'" +"img/depot/"+ imgName + "','')");   
		out.println("</script>");  
		return null;
	}


	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getFiledim() {
		return filedim;
	}

	public void setFiledim(String filedim) {
		this.filedim = filedim;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public float getX1() {
		return x1;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	public float getY1() {
		return y1;
	}

	public void setY1(float y1) {
		this.y1 = y1;
	}

	public float getX2() {
		return x2;
	}

	public void setX2(float x2) {
		this.x2 = x2;
	}

	public float getY2() {
		return y2;
	}

	public void setY2(float y2) {
		this.y2 = y2;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

}
