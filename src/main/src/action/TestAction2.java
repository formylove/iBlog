package main.src.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import main.src.common.Log;
import main.src.entity.Opus;
import main.src.entity.User;
public class TestAction2 {
	boolean working = false;
	Date tDate;
	Date tDate2;
	String dateStr;
	Date dateTrans;
	Long population;
	String[] actors;
	int count = 0 ;
	List<String> cast = new ArrayList<String>();
	String[] nations;
	char gender;
	List<User> users;
	List<User> users2 = new ArrayList<User>();
	boolean checkbox_test;
	String checkbox_test2;
	List<String> checkboxList;
	List<String> multiple;
	String checkbox_test3;
	Opus o;
	List<String> multiply;
	public String execute () throws ParseException{
		count++;
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		String s= "2011-07-09"; 
		dateStr   = "2011-07-09"; 
		tDate =  formatter.parse(s);
		tDate2 =  formatter.parse(s);
		dateTrans =  formatter.parse(s);
		users.add(new User("ÅË½ðÁ«",1));
		users.add(new User("Ñ¦ó´p¨¢n",2));
		users.add(new User("¼Öçöli¨£n",3));
		users.removeAll(Collections.singleton(null));
		cast.add("ÖÜÈó·¢");
		cast.add("»Æ²³");
		cast.add("¸ðÓÅ");
		cast.add("Ðìá¿");
		cast.add("¾ÞÊ¯Ç¿É­");
		return "test";
	}
	public String t2() {
		Log.print("opus hashcod", o.hashCode());;
		Log.print("protagonists hashcod", o.getProtagonists().hashCode());;
		users.remove(1);
		users.add(new User("ÅË½ðÁ«",1));
		users.add(new User("Ñ¦ó´p¨¢n",2));
		users.add(new User("¼Öçöli¨£n",3));
		users.remove(3);
		return "done";
	}
	public List<User> getUsers2() {
		return users2;
	}
	public void setUsers2(List<User> users2) {
		this.users2 = users2;
	}
	public List<String> getMultiple() {
		return multiple;
	}
	public void setMultiple(List<String> multiple) {
		this.multiple = multiple;
	}
	public boolean isWorking() {
		return working;
	}
	public void setWorking(boolean working) {
		this.working = working;
	}
	public Date gettDate() {
		return tDate;
	}
	public void settDate(Date tDate) {
		this.tDate = tDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String[] getActors() {
		return actors;
	}
	public void setActors(String[] actors) {
		this.actors = actors;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String[] getNations() {
		return nations;
	}
	
	public void setNations(String[] nations) {
		this.nations = nations;
	}
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
	public Date getDateTrans() {
		return dateTrans;
	}
	public void setDateTrans(Date dateTrans) {
		this.dateTrans = dateTrans;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public Date gettDate2() {
		return tDate2;
	}
	public void settDate2(Date tDate2) {
		this.tDate2 = tDate2;
	}
	public Opus getO() {
		return o;
	}
	public void setO(Opus o) {
		this.o = o;
	}
	public String t3() {
		return "result";
	}
	public List<String> getCast() {
		return cast;
	}
	public void setCast(List<String> cast) {
		this.cast = cast;
	}
	public String getCheckbox_test3() {
		return checkbox_test3;
	}
	public void setCheckbox_test3(String checkbox_test3) {
		this.checkbox_test3 = checkbox_test3;
	}
	public List<String> getMultiply() {
		return multiply;
	}
	public void setMultiply(List<String> multiply) {
		this.multiply = multiply;
	}
	public boolean isCheckbox_test() {
		return checkbox_test;
	}
	public void setCheckbox_test(boolean checkbox_test) {
		this.checkbox_test = checkbox_test;
	}
	public String getCheckbox_test2() {
		return checkbox_test2;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<String> getCheckboxList() {
		return checkboxList;
	}
	public void setCheckboxList(List<String> checkboxList) {
		this.checkboxList = checkboxList;
	}
	public void setCheckbox_test2(String checkbox_test2) {
		this.checkbox_test2 = checkbox_test2;
	}
	
}
