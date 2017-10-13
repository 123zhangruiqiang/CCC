package Service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mapper.UserMapper;
import POJO.User;
import POJO.UserExample;
import Service.UserService;
@Service
public class UserServiceImp implements UserService{
	@Autowired
	UserMapper userMapper;
	
	public User selectByPrimeryKey(Integer id) {
		User user=userMapper.selectByPrimaryKey(id);
		return user;
		
	}

	public List<User> selectByExample(UserExample example) {
		List<User> list=userMapper.selectByExample(example);
		return list;
	}

	
}
