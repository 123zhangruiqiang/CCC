

class DownSelect extends TestFather{

		def core='downloadrecord/'
		def '下载信息查询_默认查询'(){
			when:
			def url=rtUrl(core, "select")
			def reqData=[
				
				'feeBizTypeName':""
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println parseJson(result)['data'].size()
			
		}
		
		def '下载信息查询_添加业务名称'(){
			 
			when:
			def url=rtUrl(core, "select")
			def reqData=[
				
				'feeBizTypeName':"海口hk"
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println parseJson(result)['data'].size()
			
			
			
		}
}
