package main.src.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class MsgConstants {
public static final String SUCCESS="success"; 
public static final String REDUPLICATIVE="reduplicative"; 
public static final String ESSAYPAGE="essaypage"; 
public static final String NOTEPAGE="notepage"; 
public static final String DELETED="deleted"; 
public static final String RECOVERED="recovered"; 
public static final String Essays="essays"; 
public static final String LIKE="like"; 
public static final String NO="N"; 
public static final String YES="Y"; 
public static final int ADMINID=1000; 
public static final int ROOTCAT=5000; 
public static final int MESBOOK=6666; 
public static Map<String, String> ISO31661ALPHA3 = new LinkedHashMap<String, String>(); 
public static Map<String, String> DYNASTY = new LinkedHashMap<String, String>(); 
public static Map<String, String> AUTHORITY = new LinkedHashMap<String, String>(); 
public static Map<String, String> SCORE = new LinkedHashMap<String, String>(); 
public static Map<String, String> RATE = new LinkedHashMap<String, String>(); 
static {
	ISO31661ALPHA3.put("nope", "����");
	ISO31661ALPHA3.put("CN", "�й�");
	ISO31661ALPHA3.put("CN", "�й�");
	ISO31661ALPHA3.put("US", "����");
	ISO31661ALPHA3.put("JP", "�ձ�");
	ISO31661ALPHA3.put("JP1", "����");
	ISO31661ALPHA3.put("JP2", "̩��");
	ISO31661ALPHA3.put("JP3", "����");
	ISO31661ALPHA3.put("JP4", "Ӣ��");
	ISO31661ALPHA3.put("JP5", "�¹�");
	ISO31661ALPHA3.put("JP6", "����˹");
	ISO31661ALPHA3.put("JP7", "������");
	ISO31661ALPHA3.put("JP8", "�����");
	ISO31661ALPHA3.put("JP9", "�µ���");
	ISO31661ALPHA3.put("JP00", "����");
	ISO31661ALPHA3.put("JP88", "�ձ�");
	
	
	DYNASTY.put("nope", "�ִ�");
	DYNASTY.put("���", "���");
	DYNASTY.put("�峯", "�峯");
	DYNASTY.put("����", "����");
	DYNASTY.put("Ԫ��", "Ԫ��");
	DYNASTY.put("�γ�", "�γ�");
	DYNASTY.put("�Ƴ�", "�Ƴ�");
	DYNASTY.put("����", "����");
	DYNASTY.put("����", "����");
	DYNASTY.put("ս��", "ս��");
	
	AUTHORITY.put("10", "�����˿ɼ�");
	AUTHORITY.put("0", "�Լ��ɼ�");
	AUTHORITY.put("5", "��¼�ɼ�");
	AUTHORITY.put("1", "�麣ip�ɼ�");
	AUTHORITY.put("2", "�麣ip���ɼ�");
	
	RATE.put("nope", "����");
	RATE.put("���õ�", "���õ�");
	RATE.put("�ض�", "�ض�");
	RATE.put("ֵ��һ��", "ֵ��һ��");
	RATE.put("����һ��", "����һ��");
	RATE.put("��ֵ�ö�", "��ֵ�ö�");
	RATE.put("��", "��");
	System.out.println("ios move on");
}
}