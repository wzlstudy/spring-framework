package com.wzl.demo.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author: Wzl
 * @time: 2022/8/16 21:48
 * @description:
 */
@Service
// @Scope("prototype")
public class OrderService implements ApplicationContextAware {

	@Autowired
	private UserService userService;

	public OrderService() {
		System.out.println("orderService create");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("call orderService aware callback");
	}

	// 生命周期初始化回调方法
	@PostConstruct
	public void objectInit(){
		System.out.println("call orderService lifecycle init callback");
	}

	/*public OrderService(UserService userService) {
		this.userService = userService;
	}*/
}
