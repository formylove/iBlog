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

import main.src.common.Log;
import main.src.service.ImageService;

import org.apache.struts2.ServletActionContext;

public class ImageAction {
	private File upload; // 文件
	private File file; // 文件
private String test;

	public String getTest() {
	return test;
}
public void setTest(String test) {
	this.test = test;
}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

	private String uploadContentType; // 文件类型

	private String uploadFileName; // 文件名
	
private String filesize;
private String filetype;
private String filedim;
private float w;
private float h;
private float x1;
private float y1;
private float x2;
private float y2;

public String upLoadCropedImg() throws IOException{
	Log.print("type"+filetype);
	Log.print("test"+test);
	Log.print("w"+w);
	Log.print(h);
	Log.print(x1);
	Log.print(y1);
	Log.print(x2);
	Log.print(y2);
	String name=ImageService.cut(upload, ImageService.getSimpleType(filetype), w, h, x1, y1);
	ImageService.savePhoto(name, null, null, 6300);
	
	
	
	return "test";
}
	public String upLoadImg() throws IOException {

		HttpServletResponse response =ServletActionContext.getResponse();

		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		  Log.print("uploadContentType", uploadContentType);                                 
		  Log.print("uploadFileName", uploadFileName);                                 

		if(!uploadContentType.equalsIgnoreCase("image/png")){

		            out.print("<font color=\"red\"size=\"2\">*文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）</font>");

		            return null;

		}
		String localName=UUID.randomUUID().toString();
		InputStream img=new FileInputStream(upload);
		String savePath=ServletActionContext.getServletContext().getRealPath("/img/");
		File local=new File(savePath,localName);
		OutputStream saveObj=new FileOutputStream(local);
		Log.print(savePath);
		int length=0;
		byte[] buffer=new byte[1024];
		while((length=img.read(buffer))>0){
			
			saveObj.write(buffer, 0, length);
			
		}
		img.close();
		saveObj.close();
		Log.print("good");
		String callback =ServletActionContext.getRequest().getParameter("CKEditorFuncNum"); 

		out.println("<scripttype=\"text/javascript\">");

		out.println("window.parent.CKEDITOR.tools.callFunction("+ callback + ",'" +"../../img/"+ localName + "','')"); 

		out.println("</script>");
		Log.print("gxood");
		return null;
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
