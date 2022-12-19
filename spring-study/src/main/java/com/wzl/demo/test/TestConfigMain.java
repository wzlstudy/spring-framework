package com.wzl.demo.test;

import com.wzl.demo.AppConfig;
import com.wzl.demo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author: Wzl
 * @time: 2022/8/16 21:30
 * @description:
 */
public class TestConfigMain {
	public static void main(String[] args) {
		//ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) context.getBean("userService");
		// 测试aop，最后执行testAop方法的是userService普通对象，而不是代理对象，通过cglib生成的userService代理对象有一个target属性，指向userService普通对象
		//userService.testAop();

		// 测试lookup注解
		// userService.testLookupAnn();
		// userService.testLookupAnn();
		// userService.testLookupAnn();

		// 测试事务
		//userService.testTransaction();

		//userService.testTransaction2();

		// userService.test();
	}
}
