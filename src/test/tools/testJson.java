package test.tools;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import main.src.entity.gallery.Nation;
import main.src.service.NationService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class testJson {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[]{"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml"
						,"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/daoContext.xml"
				});
		NationService ns = ctx.getBean("nationService",NationService.class);
		
		System.out.println(ns.getTree());
//		JSONObject branch = new JSONObject();
//		JSONObject child1 = new JSONObject();
//		JSONObject child2 = new JSONObject();
//		child1.accumulate("name", "zhongguo");
//		child2.accumulate("name", "meiguo");
//		JSONArray a = new JSONArray();
//		a.add(child1);
//		a.add(child2);
//		branch.accumulate("name", "ÑÇÖÞ");
//		branch.accumulate("children", a);
//		System.out.println(branch);
	}

}
