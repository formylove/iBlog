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

import main.src.common.gif.AnimatedGifEncoder;
import main.src.common.gif.GifDecoder;

public class ImageUtils {
	static public String baseRealPath = ((HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST)).getRealPath("/");
	static public String saveImageFromUrl(String imgUrl){
		String localName = null;
	        try {  
	            //实例化url  
	            URL url = new URL(imgUrl);  
	            URLConnection connection = url.openConnection();
	            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
	            //载入图片到输入流  
	            java.io.BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());  
	            //实例化存储字节数组  
	            byte[] bytes = new byte[100];  
	            //设置写入路径以及图片名称  
	             localName = UUID.randomUUID().toString();
			     localName = localName + "." + getSimpleType(imgUrl);
			     String realPath = baseRealPath + MessageUtils.getMessageFromUrl("img.temp");
				 File folder = new File(realPath);
			     if(!folder.exists()){
						folder.mkdir();//写文件操作不会自动生成目录
					}
			     OutputStream bos = new FileOutputStream(new File(realPath+localName));
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
	
	static public String saveImage(File image,String org_name,String realPath) throws IOException{
		 String localName = UUID.randomUUID().toString();
		 localName = localName + FileUtils.getFileSuffix(org_name);
		 File folder = new File(realPath);
		if(!folder.exists()){
			folder.mkdir();//写文件操作不会自动生成目录
		}
		 return FileUtils.saveFile(image, localName,realPath);
	 }
	static public String saveTemp(File image,String org_name) throws IOException{
		String realPath = baseRealPath + MessageUtils.getMessageFromUrl("img.temp");
		return ImageUtils.saveImage(image, org_name,realPath);
	}
	
		static public String cut(String cover,float width,float height,float x,float y) {
			String simpleType = getSimpleType(cover);
			try {
			if("gif".equalsIgnoreCase(simpleType)){
				if(cover.indexOf("http")>=0 || cover.indexOf("https")>=0 || cover.indexOf("www.")>=0){
					cover = saveImageFromUrl(cover);
				}	
				String sourcePath = baseRealPath + MessageUtils.getMessageFromUrl("img.temp") + cover;
				return cutGif(sourcePath, (int)x, (int)y,(int)width, (int)height);
			}else{
				if(cover.indexOf("http")>=0 || cover.indexOf("https")>=0 || cover.indexOf("www.")>=0){
					URL url = new URL(cover);
					URLConnection connection = url.openConnection();
					connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
					return cut(new BufferedInputStream(connection.getInputStream()),simpleType,width,height,x,y);
				}else{
		    	    FileInputStream fis = new FileInputStream(new File(baseRealPath + MessageUtils.getMessageFromUrl("img.temp")+cover));
		    	    return cut(new BufferedInputStream(fis),simpleType,width,height,x,y);
				}	
			}
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		}
	static public String cut(BufferedInputStream image,String picType,float width,float height,float x,float y) throws IOException{
	   String sourcePath = null;
	   BufferedInputStream is = null;  
       ImageInputStream iis = null;  
       String name=UUID.randomUUID().toString();
       String path=MessageUtils.getMessageFromUrl("img.depot");
       try {  
           // 读取图片文件  
           is = image;  
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
           File folder = new File(baseRealPath + path);
           if(!folder.exists()){
        	   folder.mkdir();
           }
           sourcePath = baseRealPath + path + name+"."+picType;
           ImageIO.write(bi, picType, new File(sourcePath)); 
       } finally {  
           if (is != null)  
               is.close();  
           if (iis != null)  
               iis.close();  
       } 

		return name+"."+picType;
	}
	
	public static String cutGif(String sourcePath,int x,int y,int width,int height){
	     //为gif保存一份静态备份
		String name=UUID.randomUUID().toString();
		String path=MessageUtils.getMessageFromUrl("img.depot");
		String simpleType = getSimpleType(sourcePath);
		String targetPath = baseRealPath + path + name + "." + simpleType;
		            GifDecoder decoder = new GifDecoder();  
		            int status = decoder.read(sourcePath);  
		            if (status != GifDecoder.STATUS_OK) {  
		                try {
							throw new IOException("read image " + sourcePath + " error!");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
		            }
		 
		            AnimatedGifEncoder encoder = new AnimatedGifEncoder();
		            encoder.start(targetPath);
		            encoder.setRepeat(decoder.getLoopCount());  
		            Log.print("帧数："+decoder.getFrameCount());
		            for (int i = 0; i < decoder.getFrameCount(); i ++) {  
		                encoder.setDelay(decoder.getDelay(i));  
		                BufferedImage childImage = decoder.getFrame(i);
		                BufferedImage subImage = childImage.getSubimage(x, y, width, height);
		                encoder.addFrame(subImage);  
		            }  
		            encoder.finish();
		return  name + "." + simpleType;
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
	static public int[] getImgWidth(File img){
		int[] a ={0,0};
        BufferedImage bi = null;  
        boolean imgwrong=false;  
        try {  
            //读取图片  
            bi = javax.imageio.ImageIO.read(img);  
            try{  
                //判断文件图片是否能正常显示,有些图片编码不正确  
                int i = bi.getType();  
                imgwrong=true;  
            }catch(Exception e){  
                imgwrong=false;  
            }  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
        if(imgwrong){  
            a[0] = bi.getWidth(); //获得 宽度  
            a[1] = bi.getHeight(); //获得 高度  
        }else{  
            a=null;  
        }  
        //删除文件  
        img.delete();  
		return a;
	}
}
