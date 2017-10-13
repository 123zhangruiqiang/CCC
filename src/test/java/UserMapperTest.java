

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Mapper.OrdersCustomMapper;
import Mapper.UserMapper;
import POJO.OrderCustom;
import POJO.Orders;
import POJO.User;
import POJO.UserExample;

public class UserMapperTest {
	private ApplicationContext applicationContext;
	private UserMapper userMapper;
	private OrdersCustomMapper ordersCustomMapper;
	@Before
	public void setup(){
		applicationContext=new ClassPathXmlApplicationContext("springmvc/application.xml");
		userMapper=(UserMapper) applicationContext.getBean("userMapper");
	}
	@Test
	public void testCountByExample() {
		
		
	}
	@Test
	public void testSelectByExample(){
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andSexEqualTo("男");
		List<User> list=userMapper.selectByExample(userExample);
		System.out.println(list.size());
		
	}
	
	@Test
	public void testSelectByPrimaryKey(){
		applicationContext=new ClassPathXmlApplicationContext("springmvc/application.xml");
		userMapper=(UserMapper) applicationContext.getBean("userMapper");
		User user=userMapper.selectByPrimaryKey(1);
		System.out.println(user);
		System.out.println(user.getAddress());
		System.out.println(user.getSex());
		System.out.println(user.getUsername());
		System.out.println(user.getBirthday());
		System.out.println(user.getId());
		
		
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() throws ParseException {
		User user=new User();
		user.setAddress("上海");
		SimpleDateFormat sf=new SimpleDateFormat("yyyy.MM.dd");
		String source="2017.09.07";
		
		user.setBirthday(sf.parse(source));
		user.setId(2);
		user.setSex("女");
		user.setUsername("郑惠文");
		userMapper.insert(user);
		
	}

	@Test
	public void testUpdateByPrimaryKey() {
			
		ordersCustomMapper=(OrdersCustomMapper) applicationContext.getBean("ordersCustomMapper");
		List<OrderCustom> list=ordersCustomMapper.findOrderUser();
		System.out.println(list.get(0));
	}
	@Test
	public void testfindOrderUserResultMap(){
		ordersCustomMapper=(OrdersCustomMapper) applicationContext.getBean("ordersCustomMapper");
		List<Orders> list=ordersCustomMapper.findOrderUserResultMap();
		System.out.println(list);
		System.out.println(list.get(0));
	}
	

}
