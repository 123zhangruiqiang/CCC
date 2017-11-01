package Service.imp;

import Mapper.ShopMapper;
import POJO.Shop;
import Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopServiceImp implements ShopService {
    @Autowired
    ShopMapper shopMapper;
    public List<Shop> pageList(int ind,int end) {

        List<Shop> list=shopMapper.pageList(ind,end);
        return list;
    }

    public List<Shop> findall() {
        List<Shop> list=shopMapper.findall();
        return list;
    }
}
