package main.src.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ServicePointcut {
	@Pointcut("execution(* main.src.service.impl.*.*(..))")
	public void allServices(){}
	@Pointcut("execution(* main.src.service.impl.NoteServiceImpl.*(..))")
	public void testServices(){}
}
