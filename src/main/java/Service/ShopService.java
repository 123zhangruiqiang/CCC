package Service;

import POJO.Shop;

import java.util.List;

public interface ShopService {
    public List<Shop> pageList(int ind,int end);
    public List<Shop> findall();
}
