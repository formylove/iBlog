package test;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static main.src.common.Log.print;
import main.src.entity.Comment;

public class Test_reflection {
	
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SecurityException {

        Comment comment=new Comment();
        comment.setId(33);comment.setAppend(33);
        comment.setCity("xian");
        comment.setContent("my hapiine");
        comment.setCreate_date("2012");
        print(comment.getClass().getDeclaredFields()[0].getName());
       Field f= comment.getClass().getDeclaredFields()[0];
       f.setAccessible(true);
        print(f.get(comment));
        Field[] fs=comment.getClass().getDeclaredFields();
       for(Field t:fs){
    	   t.setAccessible(true);
    	   print(t.getName(), t.get(comment));
       }

    }

}
