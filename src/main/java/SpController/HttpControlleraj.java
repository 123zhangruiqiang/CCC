package SpController;

import Utils.GetParam;
import Utils.HttpClientFactory;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HttpControlleraj {
    @RequestMapping(value = "/index/dohttp1",method = RequestMethod.GET)
    public @ResponseBody Object getMethod(HttpSession session)  {



        Map<String ,String> param1=GetParam.getPabyPost("checkRw");
        param1.put("JSESSIONID",session.getAttribute("JSESSIONID").toString());
        param1.put("sso-Token",session.getAttribute("sso-Token").toString());

        String response1=HttpClientFactory.create("postForm").setParams(param1).execute("http://172.19.60.103:8003/lanmaoly-fee-boss/view/fee/automate/createTask");
        System.out.println(response1);

        JSONObject jb=JSONObject.fromObject(response1);




        return jb;
    }
    @RequestMapping("/index/download1")
    public @ResponseBody Object download(HttpSession session){


        Map<String,String> param1=new HashMap<String, String>();
        param1.put("JSESSIONID",session.getAttribute("JSESSIONID").toString());
        param1.put("sso-Token",session.getAttribute("sso-Token").toString());

        String response1=HttpClientFactory.create("postForm").setParams(param1).execute("http://172.19.60.103:8003/lanmaoly-fee-boss/view/fee/automate/executeDownLoad");
        System.out.println(response1);

        JSONObject jb=JSONObject.fromObject(response1);


        return jb;
    }
    @RequestMapping("/index/fee1")
    public @ResponseBody Object fee(HttpSession session){

        /*Map<String,String> param=GetParam.getPa("loginParam");
        String response= HttpClientFactory.create("getToken").setParams(param).execute("http://172.19.60.164/lanmao-boss-app/login");
*/


        Map<String,String> param1=new HashMap<String, String>();
        param1.put("JSESSIONID",session.getAttribute("JSESSIONID").toString());
        param1.put("sso-Token",session.getAttribute("sso-Token").toString());
        String response1=HttpClientFactory.create("postForm").setParams(param1).execute("http://172.19.60.103:8003/lanmaoly-fee-boss/view/fee/automate/executeFee");
        System.out.println(response1);
        JSONObject jb=JSONObject.fromObject(response1);


        return jb;
    }
    @RequestMapping("/index/Bill1")
    public @ResponseBody Object Bill(HttpSession session){
      /*  Map<String,String> param=GetParam.getPa("loginParam");
        String response= HttpClientFactory.create("getToken").setParams(param).execute("http://172.19.60.164/lanmao-boss-app/login");
*/


        Map<String,String> param1=new HashMap<String, String>();
        param1.put("JSESSIONID",session.getAttribute("JSESSIONID").toString());
        param1.put("sso-Token",session.getAttribute("sso-Token").toString());
        String response1=HttpClientFactory.create("postForm").setParams(param1).execute("http://172.19.60.103:8003/lanmaoly-fee-boss/view/fee/automate/executeBill");
        System.out.println(response1);
        JSONObject jb=JSONObject.fromObject(response1);


        return jb;
    }
    @RequestMapping("/index/kf1")
    public @ResponseBody Object kf(HttpSession session){
      /*  Map<String,String> param=GetParam.getPa("loginParam");
        String response= HttpClientFactory.create("getToken").setParams(param).execute("http://172.19.60.164/lanmao-boss-app/login");

*/
        Map<String,String> param1=new HashMap<String, String>();
        param1.put("JSESSIONID",session.getAttribute("JSESSIONID").toString());
        param1.put("sso-Token",session.getAttribute("sso-Token").toString());
        String response1=HttpClientFactory.create("postForm").setParams(param1).execute("http://172.19.60.103:8003/lanmaoly-fee-boss/view/fee/automate/executeGenFee");
        System.out.println(response1);
        JSONObject jb=JSONObject.fromObject(response1);


        return jb;
    }
    @RequestMapping("/index/zxkf1")
    public @ResponseBody Object zxkf(HttpSession session){

        /*Map<String,String> param=GetParam.getPa("loginParam");
        String response= HttpClientFactory.create("getToken").setParams(param).execute("http://172.19.60.164/lanmao-boss-app/login");
*/

        Map<String,String> param1=new HashMap<String, String>();
        param1.put("JSESSIONID",session.getAttribute("JSESSIONID").toString());
        param1.put("sso-Token",session.getAttribute("sso-Token").toString());
        String response1=HttpClientFactory.create("postForm").setParams(param1).execute("http://172.19.60.103:8003/lanmaoly-fee-boss/view/fee/automate/executeNotifyDeduct");
        System.out.println(response1);
        JSONObject jb=JSONObject.fromObject(response1);


        return jb;
    }
    @RequestMapping("/index/resultJg1")
    public @ResponseBody Object resultJg(HttpSession session){
       /* Map<String,String> param=GetParam.getPa("loginParam");
        String response= HttpClientFactory.create("getToken").setParams(param).execute("http://172.19.60.164/lanmao-boss-app/login");*/



        Map<String,String> param1=new HashMap<String, String>();
        param1.put("JSESSIONID",session.getAttribute("JSESSIONID").toString());
        param1.put("sso-Token",session.getAttribute("sso-Token").toString());
        String response1=HttpClientFactory.create("postForm").setParams(param1).execute("http://172.19.60.103:8003/lanmaoly-fee-boss/view/fee/automate/executeUpdateStatus");
        System.out.println(response1);
        JSONObject jb=JSONObject.fromObject(response1);


        return jb;
    }
}
