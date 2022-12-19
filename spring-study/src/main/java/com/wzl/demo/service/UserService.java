package com.wzl.demo.service;

import com.wzl.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Wzl
 * @time: 2022/8/16 21:47
 * @description:
 */
@Service
//@Scope("prototype")
public class UserService {

	@Autowired
	private OrderService orderService;

	public UserService() {
		System.out.println("userService create");
	}

	/*@Lazy
	public UserService(OrderService orderService) {
		this.orderService = orderService;
	}*/

	/*@Autowired
	private UserService userService;*/

	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/

	/*public void test(){
		System.out.println(orderService);
	}*/

	@Async
	public void testAop(){
		System.out.println(orderService);
	}

	public void testLookupAnn(){
		System.out.println(testLookup());
	}

	@Lookup("orderService")
	public OrderService testLookup(){
		System.out.println(orderService);
		return null;
	}

	public void testTransaction(){
		try {
			//DML操作
			//int jdbctemplate.update(String sql,Object ...)//给定sql语句和参数返回sql语句影响的行数

			//DQL操作
			//返回基本数据类型和字符串
			//jdbcTemplate.queryForObject(sql,XXX.class)//返回什么数据类型就写xxx.class
			//返回单个对象
			//jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<XXX>(XXX.class),查询语句参数...)//将查询到数据封装到指定的bean对象中
			//返回集合对象
			//jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));//查询集合元素

			//批量DML
			//jdbcTemplate.batchUpdate(sql,List<Object[]>)//使用sql语句+参数数组集合来执行批量操作 返回值是
			//批量int[] 数组是每一次操作的影响列数

			//jdbcTemplate.execute("")

			//List<Student> studentList = jdbcTemplate.query("select * from t_student", new BeanPropertyRowMapper<Student>(Student.class));
			//System.out.println(studentList);

		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Transactional
	public void testTransaction2(){
		//jdbcTemplate.execute("insert into t_student(sname, sage, ssex) values ('张三丰2', 22, true)");
		//userService.testTransaction3();
		throw new NullPointerException();
	}

	@Transactional(propagation = Propagation.NEVER)
	public void testTransaction3(){
		//jdbcTemplate.execute("insert into t_student(sname, sage, ssex) values ('张三丰3', 33, true)");
	}
}
