package Service;

import java.util.List;

import POJO.User;
import POJO.UserExample;

public interface UserService {

	public  User selectByPrimeryKey(Integer id);
	public List<User> selectByExample(UserExample example);
}
