package main.src.common;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class ImageUtils {
	static public String baseRealPath = ((HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST)).getRealPath("/");
	static public String saveImageFromUrl(String imgUrl){
		String localName = null;
		System.out.println("imgfromUrl: ");
	        try {  
	            //ʵ����url  
	            URL url = new URL(imgUrl);  
	            //����ͼƬ��������  
	            java.io.BufferedInputStream bis = new BufferedInputStream(url.openStream());  
	            //ʵ�����洢�ֽ�����  
	            byte[] bytes = new byte[100];  
	            //����д��·���Լ�ͼƬ����  
	             localName = UUID.randomUUID().toString();
			     localName = localName + "." + getSimpleType(imgUrl);
//			     String relPath = MessageUtils.getMessageFromUrl("img.path");
//				 String savePath = ServletActionContext.getServletContext().getRealPath(relPath);
			     String savePath = "d:/";
				 System.out.println("imgfromUrl: "+savePath);
				 File folder = new File(savePath);
			     if(!folder.exists()){
						folder.mkdir();//д�ļ����������Զ�����Ŀ¼
					}
			     OutputStream bos = new FileOutputStream(new File(savePath+localName));
	             int len;  
	             while ((len = bis.read(bytes)) > 0) {  
	                bos.write(bytes, 0, len);  
	            }  
	            bis.close();  
	            bos.flush();  
	            bos.close();  
	        } catch (Exception e) { 
	        }  

		return localName;
	}
	
	
	static public int[] getImgWidth(File img){
		int[] a ={0,0};
        BufferedImage bi = null;  
        boolean imgwrong=false;  
        try {  
            //��ȡͼƬ  
            bi = javax.imageio.ImageIO.read(img);  
            try{  
                //�ж��ļ�ͼƬ�Ƿ���������ʾ,��ЩͼƬ���벻��ȷ  
                int i = bi.getType();  
                imgwrong=true;  
            }catch(Exception e){  
                imgwrong=false;  
            }  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
        if(imgwrong){  
            a[0] = bi.getWidth(); //��� ���  
            a[1] = bi.getHeight(); //��� �߶�  
        }else{  
            a=null;  
        }  
        //ɾ���ļ�  
        img.delete();  
		return a;
	}
	static public String saveImage(File image,String org_name,String realPath) throws IOException{
		 String localName = UUID.randomUUID().toString();
		 localName = localName + FileUtils.getFileSuffix(org_name);
		 File folder = new File(realPath);
		if(!folder.exists()){
			folder.mkdir();//д�ļ����������Զ�����Ŀ¼
		}
		 return FileUtils.saveFile(image, localName,realPath);
	 }
	static public String saveTemp(File image,String org_name) throws IOException{
		String realPath = baseRealPath + MessageUtils.getMessageFromUrl("img.temp");
		return ImageUtils.saveImage(image, org_name,realPath);
	}
	
		static public String cut(String cover,float width,float height,float x,float y) {
			try { 
			if(cover.indexOf("http")>=0 || cover.indexOf("https")>=0 || cover.indexOf("www.")>=0){
					URL url = new URL(cover);
					URLConnection connection = url.openConnection();
					connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
					return cut(new BufferedInputStream(connection.getInputStream()),getSimpleType(cover),width,height,x,y);
		    }else{
		    	    FileInputStream fis = new FileInputStream(new File(baseRealPath + MessageUtils.getMessageFromUrl("img.temp")+cover));
		    	    return cut(new BufferedInputStream(fis),getSimpleType(cover),width,height,x,y);
		    }
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		}
	static public String cut(BufferedInputStream image,String picType,float width,float height,float x,float y) throws IOException{
       
	   BufferedInputStream is = null;  
       ImageInputStream iis = null;  
       String name=UUID.randomUUID().toString();
       String path=MessageUtils.getMessageFromUrl("img.depot");
       try {  
           // ��ȡͼƬ�ļ�  
           is = image;  
           /* 
            * ���ذ������е�ǰ��ע�� ImageReader �� Iterator����Щ ImageReader �����ܹ�����ָ����ʽ�� 
            * ������formatName - ��������ʽ��ʽ���� . ������ "jpeg" �� "tiff"���� �� 
            */  
           Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(picType);  
           ImageReader reader = it.next();  
           // ��ȡͼƬ��  
           iis = ImageIO.createImageInputStream(is);  
           /* 
            * <p>iis:��ȡԴ.true:ֻ��ǰ���� </p>.�������Ϊ ��ֻ��ǰ�������� 
            * ��������ζ�Ű���������Դ�е�ͼ��ֻ��˳���ȡ���������� reader ���⻺���������ǰ�Ѿ���ȡ��ͼ����������ݵ���Щ���벿�֡� 
            */  
           reader.setInput(iis, true);  
           /* 
            * <p>������ζ������н������<p>.����ָ�����������ʱ�� Java Image I/O 
            * ��ܵ��������е���ת��һ��ͼ���һ��ͼ�������ض�ͼ���ʽ�Ĳ�� ������ ImageReader ʵ�ֵ� 
            * getDefaultReadParam �����з��� ImageReadParam ��ʵ���� 
            */  
           ImageReadParam param = reader.getDefaultReadParam();  
           /* 
            * ͼƬ�ü�����Rectangle ָ��������ռ��е�һ������ͨ�� Rectangle ���� 
            * �����϶�������꣨x��y������Ⱥ͸߶ȿ��Զ���������� 
            */  
           Rectangle rect = new Rectangle((int)x, (int)y, (int)width, (int)height);  
           // �ṩһ�� BufferedImage���������������������ݵ�Ŀ�ꡣ  
           param.setSourceRegion(rect);  
           /* 
            * ʹ�����ṩ�� ImageReadParam ��ȡͨ������ imageIndex ָ���Ķ��󣬲��� ����Ϊһ�������� 
            * BufferedImage ���ء� 
            */  
           BufferedImage bi = reader.read(0, param);  
           // ������ͼƬ  
           Log.print(path);
           File folder = new File(baseRealPath + path);
           if(!folder.exists()){
        	   folder.mkdir();
           }
           ImageIO.write(bi, picType, new File(baseRealPath + path + name+"."+picType)); 
       } finally {  
           if (is != null)  
               is.close();  
           if (iis != null)  
               iis.close();  
       }  
		return name+"."+picType;
	}
	
	public static String getSimpleType(String originType){
		String simpleType="jpg";
		if(originType.indexOf("png")>=0){
			simpleType="png";
		}else if(originType.indexOf("gif")>=0){
			simpleType="gif";
			
		}else if(originType.indexOf("bmp")>=0){
			simpleType="png";
			
		}else if(originType.indexOf("ico")>=0){
			simpleType="ico";
		}else if(originType.indexOf("jpeg")>=0){
			simpleType="jpeg";
		}
		return simpleType;
	}
	public static int savePhoto(Map<String,Object> data){
		return SqlUtils.executeInsert(data, "photo");
	}
	public static int savePhoto(String name,String title,String desc,int under){
		Map<String,Object> data=new HashMap<String, Object>();
		data.put("name", name);
		data.put("title", title);
		data.put("desc", desc);
		data.put("under", under);
		data.put("create_date", TimeManager.getDate());
		data.put("create_time", TimeManager.getTime());
		return SqlUtils.executeInsert(data, "photo");
	}
}
