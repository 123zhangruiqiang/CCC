package GroovyTest;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Mapper.PersonMapper;
import POJO.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc/application.xml"})
public class TestW {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void test1() {
		try {
			SqlSession sqlsession = sqlSessionFactory.openSession();
			/*System.out.println(sqlsession);
			System.out.println("zhangruiqang");*/
			PersonMapper pm = sqlsession.getMapper(PersonMapper.class);
			Person p = pm.findPersonById(1);
			/*System.out.println(p);
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getGender());
			System.out.println(p.getAge());*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
