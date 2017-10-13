import java.awt.Component.BaselineResizeBehavior
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry
import javax.xml.crypto.Data
import javax.xml.ws.spi.http.HttpContext
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair

//import com.lanmao.autotest.AutoTestSpecification
//import com.lanmao.autotest.XiamenCunguanSpecification

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
//import groovy.utils.LogTest;
import spock.lang.Specification

import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.apache.log4j.Logger



class TestFather extends Specification {
//     static void main(args){
//		 
//		 	JsonOutput jsonOutput=new JsonOutput()
//			println jsonOutput.prettyPrint('[1:2,1:3,1:4]')
//		 
//	 }
	 
/*	def setup(){
		
		
		
	}*/
	/*def '大幅度'(){
		when:
		println 'ss'
		then:
		println 'ss'
	}*/
	private static CloseableHttpClient client
	private static CloseableHttpResponse response
	private static HttpGet httpGet
	private static HttpPost httpPost
	private static String JSESSIONID
	private static String Token
	public  static String path
	//private static String pa="C:\\Users\\Administrator\\Desktop\\zrqsss\\CCC\\src\\main\\resources\\properties\\pbpm.properties"
	private static String pa="src/main/resources/properties/pbpm.properties"
	static Properties pr
	public static String suffix
	def setupSpec(){
		println "==================================="
		 client=HttpClients.createDefault()
		 doLogin()
		 pr=getProp(pa)
		 path=pr.getAt("pbUrl")
		 suffix=pr.getProperty("suffix")
	}
	
	def cleanup() {
		
		println "==================================="
		println ''
		
	}
	def httpRequest(String url,String method,Map param,Boolean needHeader=false,Boolean needCookie=false){
		url=url.trim()
		if("get".equals(method)){
			
			 def nvps=new ArrayList()
			if(param){
				for (Entry<String, String> entry : param.entrySet()) {
					nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
				def str=EntityUtils.toString(new UrlEncodedFormEntity(param,'utf-8'))
				httpGet=new HttpGet(url+"?"+str)
			}else{
			httpGet=new HttpGet(url)
			
			}
			 
			 
			if (needHeader==true){
				setHeader(method)
				
				if (needCookie==true){
					setCookie(method)
				}
				
			}
			response=client.execute(httpGet)
			return parseRep(response)
		
		}else if ("post".equals(method)){
			  
				 httpPost=new HttpPost(url)
				def nvps=new ArrayList()
				if (param!=null){
					for (Entry<String, String> entry : param.entrySet()) {
						nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
					}
				}
				httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"))
				if (needHeader==true){
					setHeader(method)
					
					if (needCookie==true){
						setCookie(method)
					}
					
				}
				
				
				response=client.execute(httpPost)
				
				println '-----'+response.getStatusLine().getStatusCode()
				//httpPost.abort()
				if(response.getStatusLine().getStatusCode()==302) {
					
					String locationUrl=response.getLastHeader("Location").getValue();
					println locationUrl
					httpPost=new HttpPost(locationUrl)
					httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0")
					httpPost.setHeader("Accept", "text/html")
					httpPost.setHeader("Cookie", "JSESSIONID="+JSESSIONID+";"+"sso-token="+Token)
					response=client.execute(httpPost)
					
					
					/*String locationUrl=response.getLastHeader("Location").getValue();
					println locationUrl
					def get=new HttpGet(locationUrl)
					println get
					//setHeader("get")
					//setCookie("get")
					get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0")
					get.setHeader("Accept", "text/html")
					get.setHeader("Cookie", "JSESSIONID="+JSESSIONID+";"+"sso-token="+Token)
					response=client.execute(get)*/
					println parseRep(response)
				}else {
				return parseRep(response)
				}
				//println  response
		}
		
	}
	def setHeader(String method){
		if ('get'.equals(method)){
			httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0")
			httpGet.setHeader("Accept", "text/html")
			
		}else if('post'.equals(method)){
		httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0")
		httpPost.setHeader("Accept", "text/html")
		
		}
	}
	def setCookie(String method){
		
		if ('get'.equals(method)){
			println JSESSIONID
			println Token
			httpGet.setHeader("Cookie", "JSESSIONID="+JSESSIONID+";"+"sso-token="+Token)
		}else if('post'.equals(method)){
		httpPost.setHeader("Cookie", "JSESSIONID="+JSESSIONID+";"+"sso-token="+Token)
		}
		
	}
	def doLogin(){
		def url='http://172.19.60.164/lanmao-boss-app/login'
		def reqData=[
			name:'admin',
			password:'123456',
			redirect:'http://172.19.60.18:8002/lanmaoly-fee-boss/sso'
			
			]
		
		//response=httpRequest(url,'post',reqData,true,false)
		
		def nvps=new ArrayList()
		if (reqData!=null){
			for (Entry<String, String> entry : reqData.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		httpPost=new HttpPost(url)
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"))
		response=client.execute(httpPost)
		def cookie=response.getAllHeaders()
		//Logger lg=LogTest.getLog()
		JSESSIONID=cookie[4].toString().substring(23, 55).toString()
		
		//lg.debug(JSESSIONID)
		//lg.error(JSESSIONID)
		log  JSESSIONID
		Token=cookie[5].toString().substring(22,54)
		log Token
	}
	
	def log(text){
		
		println text
	}
	
	def parseRep(CloseableHttpResponse response){
		if (response.getStatusLine().getStatusCode()==200){
			def content=EntityUtils.toString(response.getEntity())
			//println content
			return content
		}else {
			
			def content=EntityUtils.toString(response.getEntity())
			//println content
			return content
		}
		
		
	}
	
	def formatJson(json){
		JsonOutput jsonOutput=new JsonOutput()
		println jsonOutput.prettyPrint(json)
		
	}
	
	def toJson(res) {
		JsonOutput jo=new JsonOutput()
		return jo.toJson(res)
		
	}
	
	def parseJson(json){
		
		JsonSlurper jsonSlurper=new JsonSlurper()
		def map=jsonSlurper.parseText(json)
		return map
		
	}
	
	def getProp(String path){
		Properties prop=new Properties()
		prop.load(new FileInputStream(path))
		return prop
	}
	
	def joinUrl(core,act){
		
		def url=path+core+act+suffix
		return url
	}
	
	/*def getCallBack() {
		
		
	}*/
	
	def rtUrl(core,act){
		 act=pr.getProperty(act)
		
			
		def url=joinUrl(core, act)
		return url
		
	}
	
	def endCall(list) {
		
		def fname=Thread.currentThread().getStackTrace()[10].getClassName()
	    createFile(fname,list)
		
	}
	
	def createFile(path,context) {
		
		def file=new File("src/test/java/CasedData/"+path+"_"+mkDate()+".csv")
		if(!pdFile("src/test/java/CasedData/",path)) {
			def out=file.newPrintWriter()
			out.write(context.toString())
			out.flush()
			out.close()
			
		}
		
	}
	def pdFile(path,file) {
		def list=TextUtils.singleTo().IteratorDir(path)
		def flag
		list.each{
			i->if(i.toString().contains(file)) {
				  flag=true
				  
				}
			}
			
		return flag
		
		
	}
	
	def findCsv(path,file) {
		def list=TextUtils.singleTo().IteratorDir(path)
		def csv
		list.each{
			i->if(i.toString().contains(file)) {
				csv=i
			}
		}
		
		return csv.toString()
	}
	
	def mkDate() {
		
		Date time=new Date()
		SimpleDateFormat sf=new SimpleDateFormat("yyyMMddHHmmss")
		return sf.format(time)
		
	}
	
	
	/*def Mapequals(String mapSource,String mapDate){
		
		JsonSlurper jsonSlurper=new JsonSlurper()
		def ms=jsonSlurper.parseText(mapSource)
		def sm=jsonSlurper.parseText(mapDate)
		
		return ms==sm
	}*/
	
	def checkResult(callBack,file,list) {
		
		
		if(callBack) {
			def res=findCsv("src/test/java/CasedData/",file)
			def text=TextUtils.singleTo().readFile(res)
			println text
			def json= toJson(text)
			def map= parseJson(json)
			def end=TextUtils.singleTo().assertResultCol(text, map)
			println end
			
		}
	}
	
}
