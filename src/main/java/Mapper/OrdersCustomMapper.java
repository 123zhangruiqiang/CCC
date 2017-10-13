package Mapper;

import java.util.List;

import POJO.OrderCustom;
import POJO.Orders;

public interface OrdersCustomMapper {

		public List<OrderCustom> findOrderUser();
		public List<Orders> findOrderUserResultMap();
}
	