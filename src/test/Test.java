package test;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import main.src.entity.Comment;

public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Bingo!");
        Calendar cal=Calendar.getInstance();
        Date date=new Date();
        date=cal.getTime();
        System.out.println(date.getTime());
        System.out.println(cal.getTimeInMillis());
        System.out.println(cal.getWeekYear()+"  "+cal.toString());
        //System.out .println(cal.getTime().toString()+"  "+date+"  "+cal);
        Random ran=new Random();
        System.out.println(ran.nextFloat()+" "+ran.nextInt()+" "+ran.nextBoolean());
        System.out.println(ran.nextFloat()+" "+ran.nextInt()+" "+ran.nextBoolean());//���ظ�
        System.out .println(Math.random());//Math����һЩ����:pow(power����),abs,log,max,sin
        System.out .println(Math.random());
        System.out .println(Math.random());//����0_1С��
       
        
    }
}