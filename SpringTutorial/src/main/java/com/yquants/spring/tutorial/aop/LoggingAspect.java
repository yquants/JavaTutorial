package com.yquants.spring.tutorial.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * This class is used to incept other functions just simply adding logging,
 * but with the same usage, you can do other things in a similar way.
 * 
 * @Component - to let it to be injected with
 * @Aspect - to let it to be AspectJ(aspectj-autoproxy)
 * @author Administrator
 *
 */
@Aspect
@Component
public class LoggingAspect {

	@Before("execution(public int ArithmeticCalculator.*(int, int))")
	public void beforeMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("Before Advice: The method " + methodName + " begins with " + args);
	}

	@After("execution (public int ArithmeticCalculator.*(int, int))")
	public void afterMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("After Advice£ºThe method " + methodName + " begins with " + args);
	}

	@AfterReturning(pointcut="execution (* ArithmeticCalculator.*(..))", returning="result")
	public void afterReturnning(JoinPoint joinpoint, Object/*int*/ result) {
		String methodName = joinpoint.getSignature().getName();
		System.out.println("Return Advice£ºThe method " + methodName + " ends with " + result);
	}

	@AfterThrowing(pointcut = "execution(* ArithmeticCalculator.*(..))", throwing="e")
	public void afterThrowing(JoinPoint joinpoint, Exception e) {
		String methodName = joinpoint.getSignature().getName();
		System.out.println("Throwing Advice: The method " + methodName + " throws exception " + e);
	}

	@Around("execution(* ArithmeticCalculator.*(..))")
	public Object aroundMethod(ProceedingJoinPoint joinpoint){
		Object obj = null;
		String methodName = joinpoint.getSignature().getName();
		
		try{
			System.out.println("Around[Before] Advice: The method " + methodName + " begins with " + Arrays.asList(joinpoint.getArgs()));
			obj = joinpoint.proceed();
			System.out.println("Around[After] Advice: The method " + methodName + " ends with " + obj);
		}catch(Throwable e){
			System.out.println("Around[AfterThrowing] Advice: The method " + methodName + " throws exception " + e);
			throw new RuntimeException(e);
		}
		
		System.out.println("Around[AfterReturning] Advice: The method "+ methodName + " ends");
		return obj;
	}

}
