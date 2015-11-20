package main.src.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import main.src.common.Log;
import main.src.entity.Note;

//@Aspect
public class AspectUtils {
	@Before("ServicePointcut.testServices()")
	public void authority() {
	Log.print("@Before", "权限检查");
	}
	
	@After("ServicePointcut.testServices()")
	public void backUp() {
		Log.print("@After", "释放资源");
	}
	
	@Around("ServicePointcut.testServices()")
	public void processTx(ProceedingJoinPoint jp) {
		Object[] args = jp.getArgs();
				Log.print("@Around", "开始");
		try {
			Object rvt = jp.proceed(args);
			Log.print("@Around", "结束");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@AfterReturning(returning = "rvt",pointcut = "ServicePointcut.testServices()")
	public void log(Object rvt) {
		if(rvt instanceof Note){
			Log.print("@AfterReturning",((Note)rvt).getCreate_date());
			
		}
	}
	
	@AfterThrowing(throwing = "ex",pointcut = "ServicePointcut.testServices()")
	public void fix(Throwable ex) {
		Log.print("@AfterThrowing",ex.getMessage());
	}
}
