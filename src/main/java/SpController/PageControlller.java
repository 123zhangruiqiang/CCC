package SpController;

import POJO.Shop;
import Service.imp.ShopServiceImp;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PageControlller {
    @Autowired
    ShopServiceImp shopServiceImp;
    @RequestMapping("/next")
    @ResponseBody
    public Object page(@RequestParam(required =false) String currentPage){
        int index=0;
        int num=9;

        if(null==currentPage||"".equals(currentPage)){
            index=0;
        }else{
            index=Integer.parseInt(currentPage);
            if(index<0){
                JSONObject object=new JSONObject();
                object.put("error","请提交正确的数据");
                return object;
            }
        }
        int count=shopServiceImp.findall().size();
        int page= (int) Math.ceil(count/num);

        if(index>page){
            JSONObject jb=new JSONObject();
            jb.put("error","查询数据失败,数据不存在");
            return jb;
        }


        List<Shop> list=shopServiceImp.pageList(index*num,num);
        return list;
    }
}
