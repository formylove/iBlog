package main.src.service;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import main.src.common.FileUtils;
import main.src.common.Log;
import main.src.common.MessageUtils;
import main.src.common.SqlUtils;
import main.src.common.TimeManager;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class ImageService {


	//返回存路径
	 public String saveImage(File image) throws IOException{
	 String path = 	MessageUtils.getMessageFromUrl("image.path");
		return FileUtils.saveFile(image, path);
	}

	
	static public String cut(File image,String picType,float width,float height,float x,float y) throws IOException{
        
			FileInputStream is = null;  
        ImageInputStream iis = null;  
        String name=UUID.randomUUID().toString();
        String path=MessageUtils.getMessageFromUrl("img.path");
        @SuppressWarnings("deprecation")
		String absPath = new java.io.File(((HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST)).getRealPath("/img/")).getParent();
        System.out.println("+++" + absPath);
        try {  
            // 读取图片文件  
            is = new FileInputStream(image);  
            /* 
             * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。 
             * 参数：formatName - 包含非正式格式名称 . （例如 "jpeg" 或 "tiff"）等 。 
             */  
            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(picType);  
            ImageReader reader = it.next();  
            // 获取图片流  
            iis = ImageIO.createImageInputStream(is);  
            /* 
             * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。 
             * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。 
             */  
            reader.setInput(iis, true);  
            /* 
             * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O 
             * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的 
             * getDefaultReadParam 方法中返回 ImageReadParam 的实例。 
             */  
            ImageReadParam param = reader.getDefaultReadParam();  
            /* 
             * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象 
             * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。 
             */  
            Rectangle rect = new Rectangle((int)x, (int)y, (int)width, (int)height);  
            // 提供一个 BufferedImage，将其用作解码像素数据的目标。  
            param.setSourceRegion(rect);  
            /* 
             * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的 
             * BufferedImage 返回。 
             */  
            BufferedImage bi = reader.read(0, param);  
            // 保存新图片  
            Log.print(path);
            Log.print(path);
            ImageIO.write(bi, picType, new File(absPath+path+name)); 
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
