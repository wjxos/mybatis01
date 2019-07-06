package com.wjx.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wjx.mybatis.mapper.EmployeeMapper;

import org.junit.Test;

public class MybatisTests {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MybatisTests.class);

	//@Test
	public void testMybatis() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			Employee employee = (Employee) session.selectOne("com.wjx.mybatis.Employee.selectEmployee", 1);
			System.out.println(employee.getAge());
		} finally {
			session.close();
		}

	}
	
	@Test
	public void testMybatis1() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//获取SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取sqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		try {
			//获取接口的实现类对象
			//会为接口自动创建一个代理对象代理地对象去执行增删盖查方法
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.selectEmployee(1);
			System.out.println(employee.getAge());
		} finally {
			session.close();
		}
		
	}

}
