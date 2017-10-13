import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
import POJO.PersonCustom;
import POJO.PersonQueryVo;

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
			PersonMapper pm=sqlsession.getMapper(PersonMapper.class);
			Person p=pm.findPersonById(1);
			System.out.println(p);
			System.out.println("0--=");
			System.out.println(p.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		@Test
		public void testUpdate() throws Exception {
			this.sqlSessionFactory= (SqlSessionFactory) ac.getBean("sqlSessionFactory");
			SqlSession sqlSession=sqlSessionFactory.openSession();
			PersonMapper personMapper=sqlSession.getMapper(PersonMapper.class);
			Person p=new Person();
			p.setName("123");
			personMapper.updatePerson(p);
			throw new Exception("hha");

		}
		
		

		@Test		
		public void test2(){
			this.sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
			try {
			SqlSession sqlsession=sqlSessionFactory.openSession();

			PersonMapper pm=sqlsession.getMapper(PersonMapper.class);
			PersonQueryVo po=new PersonQueryVo();
			PersonCustom pc=new PersonCustom();
			//pc.setGender("男");
			//pc.setName("zhangruiqi");
			
			List<Integer> ids=new ArrayList<Integer>();
			ids.add(1);
			ids.add(2);
			ids.add(3);
			po.setIds(ids);
			po.setPersonCustom(pc);
			List<PersonCustom> li= pm.findPersonList(po);
		    System.out.println(li.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@Test		
		public void test3(){
			this.sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
			try {
			SqlSession sqlsession=sqlSessionFactory.openSession();

			PersonMapper pm=sqlsession.getMapper(PersonMapper.class);
			PersonQueryVo po=new PersonQueryVo();
			PersonCustom pc=new PersonCustom();
			pc.setGender("男");
			pc.setName("zz");
			po.setPersonCustom(pc);
			
		//    pm.findPersonList(po);
		    System.out.println(pm.findPersonCount(po));
			/*System.out.println(p);
			 * 
			System.out.println("---------");*/
			//System.out.println(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Test
		public void test4(){
			this.sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
			try {
			SqlSession sqlsession=sqlSessionFactory.openSession();
			PersonMapper pm=sqlsession.getMapper(PersonMapper.class);
			Person p=pm.findPersonByIdResultMap(1);
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getGender());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		@Test
		public void test5(){
			this.sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
			try {
			SqlSession sqlsession=sqlSessionFactory.openSession();
			PersonMapper pm=sqlsession.getMapper(PersonMapper.class);
			PersonCustom ps=new PersonCustom();
			ps.setId(2);
			List<Integer> list=new ArrayList<Integer>();
			list.add(1);
			list.add(2);
			list.add(3);
			PersonQueryVo po=new PersonQueryVo();
			po.setPersonCustom(ps);
			po.setIds(list);
			List<PersonCustom> li=pm.findPersonListById(po);
			System.out.println(li.size());
			System.out.println(li.get(0));
			System.out.println(li.get(1));
			System.out.println(li.get(2));
		/*	System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getGender());*/
			//System.out.println(p.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
}
