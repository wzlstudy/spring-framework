package com.wzl.demo.test;

import com.wzl.demo.entity.Student;
import com.wzl.demo.service.OrderService;
import com.wzl.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.util.JavaScriptUtils;

import java.util.List;

/**
 * @author: Wzl
 * @time: 2022/8/1 15:51
 * @description:
 */
public class TestXmlMain {
	public static void main(String[] args) {
		//加载配置文件，创建bean容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		//根据bean的id，获取具体的bean
		UserService userService = (UserService) applicationContext.getBean("userService");
		OrderService orderService = (OrderService) applicationContext.getBean("orderService");
		//调用方法
		//userService.testAop();
		//System.out.println(userService);
		//System.out.println(orderService);

		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		List<Student> studentList = jdbcTemplate.query("select * from t_student", new BeanPropertyRowMapper<Student>(Student.class));
		System.out.println(studentList);
	}
}
