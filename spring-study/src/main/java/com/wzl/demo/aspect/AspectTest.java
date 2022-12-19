package com.wzl.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author: Wzl
 * @time: 2022/8/16 21:52
 * @description:
 */
@Aspect
@Component
public class AspectTest {

	@Before("execution(public void com.wzl.demo.service.UserService.testAop())")
	public void before(JoinPoint joinPoint){
		System.out.println("before aspect");
	}
}
