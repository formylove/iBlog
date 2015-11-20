package test.spring;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.UrlResource;

import main.src.common.Log;

public class Spring08 {

	@SuppressWarnings({ "resource", "static-access", "rawtypes", "unused" })
	public static void main(String[] args) throws  Exception {
		UrlResource us = new UrlResource("http://fmn.xnpic.com/fmn072/20151110/2235/p/m2w470h350q85lt_original_neNn_82f30002d75e1e7f.jpg");
		Log.print("UrlResource-JPG", us.getFilename());
		Log.print("UrlResource-Description-JPG", us.getDescription());
		us = new UrlResource("file:D:/beans1.xml");		
		SAXReader reader = new SAXReader();
		Document doc= reader.read(us.getFile());
		Element el = doc.getRootElement();
		Log.print("doc", el.getName());
		List<Element> es= el.elements();
		for(Element e : es){
			Log.print("element", e.getName());
			if(e.elements().size() >0){
				Log.print("element", ((Element)e.elements().get(0)).getName());
			}
		}
}

}
