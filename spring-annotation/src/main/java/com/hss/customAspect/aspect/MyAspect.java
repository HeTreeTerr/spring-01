package com.hss.customAspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	/**
	 * 切入点
	 */
	@Pointcut("execution(public * com.hss.customAspect.aspect.AspectTargetObject.*(..))")
	private void myPointcut() {}

	/**
	 * 前置通知
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before(value = "myPointcut()")
	public void doBefore(JoinPoint joinPoint){

		/*String class_name = joinPoint.getTarget().getClass().getName();
		String method_name = joinPoint.getSignature().getName();
		System.out.println("class_name = " + class_name);
		System.out.println("method_name = "+method_name);*/
		System.out.println("前置通知..");
	}

	/**
	 * 后置通知
	 * @param joinPoint
	 */
	@After(value = "myPointcut()")
	public void doAfter(JoinPoint joinPoint){
		System.out.println("后置通知..");
	}

	/**
	 * 返回通知
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(value = "myPointcut()",returning = "result")
	public void doAfterReturning(JoinPoint joinPoint, Object result){
		System.out.println("返回通知..result=" + result);
	}

	/**
	 * 异常通知
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value = "myPointcut()",throwing = "ex")
	public void doAfterThrowing(JoinPoint joinPoint, Exception ex){
		System.out.println("异常通知..ex=" + ex);
	}

	/**
	 * 环绕通知
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "myPointcut()")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("@Around before..");
		Object obj = proceedingJoinPoint.proceed();
		System.out.println("@Around after..");
		return obj;
	}
}
