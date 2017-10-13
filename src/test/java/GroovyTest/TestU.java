package GroovyTest;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestResult;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Mapper.PersonMapper;
import POJO.Person;

public class TestU {
	
	private AbstractApplicationContext ac;
	
		private SqlSessionFactory sqlSessionFactory;
		
		
		
		@Before
		public void init(){
		 ac = new ClassPathXmlApplicationContext("springmvc/application.xml");
		}
		
		@After
		public void destory(){
			ac.close();
		}
		
		
		@Test
		public void test1(){
			this.sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
			try {
			SqlSession sqlsession=sqlSessionFactory.openSession();
			/*System.out.println(sqlsession);
			System.out.println("zhangruiqang");*/
			PersonMapper pm=sqlsession.getMapper(PersonMapper.class);
			Person p=pm.findPersonById(1);
		/*	System.out.println(p);
			System.out.println("---------");*/
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
