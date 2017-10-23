package SpController;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController1 {
    @RequestMapping("/test1")
    public String show(){

        return "tes";
    }
    @RequestMapping(value = "/testajax",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject haha(String data){

        System.out.println(data);

        JSONObject jb=new JSONObject();
        return  jb;
    }
}
