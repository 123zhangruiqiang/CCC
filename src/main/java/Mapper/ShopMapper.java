package Mapper;

import POJO.Shop;

import java.util.List;

public interface ShopMapper {
    public  List<Shop>  pageList(int index,int end);
    public  List<Shop> findall();
}
