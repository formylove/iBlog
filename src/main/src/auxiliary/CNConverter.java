package main.src.auxiliary;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import main.src.common.Log;
public class CNConverter{}
//public class CNConverter extends StrutsTypeConverter {
//
//	@Override
//	public Long convertFromString(Map arg0, String[] jspValue, Class toClass) {
//		Log.print("进入", toClass);
//		Double product = 1.0;
//		if (jspValue.length > 1 && (toClass == Integer.class || toClass == Long.class)) {
//			for(String s:jspValue){
//				//支持从弱精度转高精度
//				product *= Float.valueOf(s);
//			}
//			return product.longValue();
//			}else{
//				return Long.parseLong(jspValue[0]);
//			}
//	}
//
//	@Override
//	public String convertToString(Map arg0, Object input) {
//		return ((Integer)input).toString();
//	}}


