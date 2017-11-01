package SpController;

import POJO.*;
import Utils.ConnectFtp;
import Utils.FileIo;

import Utils.GetParam;
import Utils.HttpClientFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Service.imp.PersonServiceImp;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static javafx.scene.input.KeyCode.T;

@Controller
public class IndexController {
	@Autowired
	private PersonServiceImp pi;
	private static final Logger logger=LogManager.getLogger(IndexController.class);
	@RequestMapping("/index")
	public String show(Model model, HttpSession session){

		logger.setLevel(Level.INFO);
		logger.info("这是log4j的日志输出");
		logger.debug("这是log4j的debug输出");
		Person p=pi.findPersonByIdResultMap(1);
		System.out.println(p.getAge());
		model.addAttribute("Person",p);
		Map<String,String> param= GetParam.getPa("loginParam");
		String response= HttpClientFactory.create("getToken").setParams(param).execute("http://172.19.60.164/lanmao-boss-app/login");
		System.out.println(response);
		System.out.println(response.split(",")[0]);
		System.out.println(response.split(",")[1]);
		session.setAttribute("JSESSIONID",response.split(",")[0].toString());
		session.setAttribute("sso-Token",response.split(",")[1].toString());
		return "FileIndex";
	}


	@RequestMapping("/second")
	public String showHello(@RequestParam String name,Model model) {
		System.out.println(name);
		System.out.println("zheshiyigeixaohu ");
		PersonServiceImp ps=new PersonServiceImp();
		model.addAttribute("");
		return "index";
	}
	@RequestMapping("/makeFile")
	public String makeFile(HttpServletRequest request,Model model) {
		String ids[]=request.getParameterValues("userid");
		String dates[]=request.getParameterValues("date");
		String times[]=request.getParameterValues("time");
		String moneys[]=request.getParameterValues("money");
		String filename=request.getParameter("filename");
		System.out.println(moneys.length);
		List<SourceFile> list=new ArrayList<SourceFile>();
		for(int i=0;i<ids.length;i++){
			SourceFile sf=new SourceFile();
			sf.setUserid(ids[i]);
			sf.setDate(dates[i]);
			sf.setTime(times[i]);
			sf.setMoney(moneys[i]);
			list.add(sf);

		}
		for(SourceFile s:list){
			System.out.println(s);


		}
		FileIo.write(list);
		String filepath=FileIo.overZip(filename);
		ConnectFtp.upFile(filepath);
		//JSONObject jb=new JSONObject();
		//net.sf.json.JSONArray js=new net.sf.json.JSONArray();
		//js.fromObject();
		String filePath=FileIo.folderPath+"XMTest.csv";
		//FileIo.readCsv(filePath);
		model.addAttribute("filename",filename );

		return "ShowMessage";



	}
	@RequestMapping("/JFlc")
	public String JFlc(){
		return "JFlc";
	}
	/*@RequestMapping("/updateFile")
	public String updateFile(HttpServletRequest request,Model model) {
		String ids[]=request.getParameterValues("userid");
		String dates[]=request.getParameterValues("date");
		String times[]=request.getParameterValues("time");
		String moneys[]=request.getParameterValues("money");
		String filename=request.getParameter("filename");

		List<SourceFile> list=new ArrayList<SourceFile>();
		for(int i=0;i<ids.length;i++){
			SourceFile sf=new SourceFile();
			sf.setUserid(ids[i]);
			sf.setDate(dates[i]);
			sf.setTime(times[i]);
			sf.setMoney(moneys[i]);
			list.add(sf);

		}
		for(SourceFile s:list){
			System.out.println(s);


		}
		FileIo.write(list);
		String filepath=FileIo.overZip(filename);
		//ConnectFtp.upFile(filepath);
		//JSONObject jb=new JSONObject();
		//net.sf.json.JSONArray js=new net.sf.json.JSONArray();
		//js.fromObject();
		String filePath=FileIo.folderPath+"XMTest.csv";
		//FileIo.readCsv(filePath);
		model.addAttribute("filename",filePath);

		return "ShowMessage";



	}*/

	@RequestMapping(value ="/updateFile",method = RequestMethod.POST)
	public @ResponseBody Object updateFile(String sfc){

		System.out.println(sfc);
		JSONArray jsonArray=JSONArray.fromObject(sfc);

		/*String s=jsonArray.get(0).toString();
		System.out.println(s);
		JSONObject js=JSONObject.fromObject(s);
		System.out.println(js);*/
		List <SourceFile> list=new ArrayList<SourceFile>();

		for(int i=0;i<jsonArray.size();i++){
			SourceFile sf=new SourceFile();
			System.out.println("huhuhuhuhuhuhu");
			System.out.println(jsonArray.getJSONObject(i).getString("text_name"));
			sf.setText_name(jsonArray.getJSONObject(i).getString("text_name"));
			sf.setUserid(jsonArray.getJSONObject(i).getString("userid"));
			sf.setDate(jsonArray.getJSONObject(i).getString("date"));
			sf.setTime(jsonArray.getJSONObject(i).getString("time"));
			sf.setMoney(jsonArray.getJSONObject(i).getString("money"));
			sf.setToken1(jsonArray.getJSONObject(i).getString("token1"));
			sf.setToken2(jsonArray.getJSONObject(i).getString("token2"));
			list.add(sf);
		}


		FileIo.write(list);
		String filepath=FileIo.overZip(list.get(0).getText_name());
		System.out.println("修改完成");
		JSONObject jb=new JSONObject();
		jb.put("status","修改完成");
		return jb;
	}








	@RequestMapping("/ajax")
	public String testJson(){




		return "Demo";

	}


	@RequestMapping(value = "/login",method = RequestMethod.POST)

	public @ResponseBody Yonhu val(Yonhu yh){

		System.out.println(yh.getUsername());
		System.out.println(yh.getPassword());

		return yh;

	}

	@RequestMapping("/test")
	public String test(){
		return "FileIndex2";
	}

	@RequestMapping("/update")
	public @ResponseBody List<SourceFile> undateFile(){
		String filePath=FileIo.folderPath+"XMTest.csv";

		List<SourceFile> list=FileIo.readCsv(filePath);




		return list;
	}
	@RequestMapping("/update/{id}")
	public String updateFile2(@PathVariable("id") String id){
		System.out.println("resultful风格");
		return "";
	}


	@RequestMapping("/haha")
	public String haha(){
		return "test";
	}


	@RequestMapping(value = "test1",method = RequestMethod.PUT)
	public @ResponseBody Object text(Testd testd){


		System.out.println(testd.getList());
		JSONObject jb=new JSONObject();

		return jb;
	}

}
