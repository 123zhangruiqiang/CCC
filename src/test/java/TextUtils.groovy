

import groovy.json.JsonSlurper
import java.text.SimpleDateFormat
import java.util.HashMap.EntrySet

class TextUtils {
	 static TextUtils tt=null
	
	private TextUtils(){}
	public static  TextUtils singleTo(){
		
		if(tt==null){
			tt=new TextUtils()
			return tt
		}
		else{
		return tt
		}
	}
	
	
	def selCounts(String sta,String stb){
		
		  int count =0, start =0
            while((start=stb.indexOf(sta,start))>=0){  
                start += sta.length(); 
                count ++
            }  
            return count
		
		
	}
	
	def selMapCounts(){
		
		
		
	}
	/**
	 * 格式化时间
	 * 将时间戳转化为时间
	 * @return
	 */
	def FormatTime(Object time){
		
		
		SimpleDateFormat sdf=new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')
		return sdf.format(time)
	}
	
	/*static void main(args){
		
		TextUtils.singleTo().selCounts("", "")
		def a=new TextUtils().selCounts("aa", "dsfa asafdsaf dsaafasafafafafa")
		println a
		
	}*/
	
	def Mapequals(String mapSource,String mapDate){
		
		JsonSlurper jsonSlurper=new JsonSlurper()
		def ms=jsonSlurper.parseText(mapSource)
		def sm=jsonSlurper.parseText(mapDate)
		
		return ms==sm
	}
	
	def actid(){
		
		return UUID.randomUUID().toString()
	}
	
	def readFile(file) {
		def res=new File(file).text
		return res
	}
	
	def assertResultCol(source,result) {
		
		
		
		
		/*JsonSlurper jsonSlurper=new JsonSlurper()
		
		def sur=jsonSlurper.parseText(source);
		println sur
		//def res=jsonSlurper.parseText(result);
		def res=result
		
		println res+"sfdsfssafsd"
		
		return equalMap(sur,res)*/
		def res=result.toString()
		
		return source.equals(res)
		
		
		
	}
	
	def equalMap(Map map1,Map map2) {
		def equal=0
		def different=0
		
		for(Map.Entry<String,String> entry:map1.entrySet()) {
			
			String svalue=entry.getValue()==null?"":entry.getValue()
			String rvalue=map2.get(entry.getKey())==null?"":map2.get(entry.getKey())
			if(svalue.equals(rvalue)) {
				
				equal+=1
				
			}else {
				different+=1
			}
			
			
		}
		
		println equal
		println different
		return equal>different?true:false
		
	}
	
	
	def IteratorDir(path) {
		def file=new File(path)
	
		def list=file.listFiles()
		println list
		return list
	}
	static void main(args){
			//println TextUtils.singleTo().IteratorDir("src/test/java/CasedData/")
			def res=TextUtils.singleTo().readFile("src/test/java/CasedData/AccModule_20170818160216.csv")
			println res
			println res[0]
			def list=Arrays.asList(res)
			println list
			println list[0]
			
	}
}
