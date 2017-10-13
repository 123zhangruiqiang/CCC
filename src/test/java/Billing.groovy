

class Billing extends TestFather {
	 def core='bill/'
	def '计费账单查询_默认查询'(){
		when:
		def act=pr.getProperty("select")
		
			
		def url=joinUrl(core, act)
		def reqData=[
			
			'feeBizTypeName':"",
			'feeSubjectId':"",
			'createTime':"2017-08-04 00:00 到 2017-08-04 23:59",
			'certificateTime':"",
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println parseJson(result)['data'].size()
		
		
	}
	def '计费账单查询_添加计费凭证生成时间'(){
		
		when:
		def act=pr.getProperty("select")
		
			
		def url=joinUrl(core, act)
		def reqData=[
			
			'feeBizTypeName':"",
			'feeSubjectId':"",
			'createTime':"2017-08-04 00:00 到 2017-08-04 23:59",
			'certificateTime':"2017-08-04 00:00 到 2017-08-05 00:00",
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println parseJson(result)['data'].size()
		
		
	}
	def '计费账单查询_添加计费业务'(){
		when:
		def act=pr.getProperty("select")
		
			
		def url=joinUrl(core, act)
		def reqData=[
			
			'feeBizTypeName':"海口hk",
			'feeSubjectId':"",
			'createTime':"2017-08-04 00:00 到 2017-08-04 23:59",
			'certificateTime':"",
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println parseJson(result)['data'].size()
		
		
		
	}
	def '计费账单详细'(){
		when:
		def core="certificate/"
		def act=pr.getProperty("select")
		
			
		def url=joinUrl(core, act)
		def reqData=[
			'feeBizTypeName':"",
			'feeSubjectId':"",
			'belongBill':"ff8081815dacbc42015dba716395000b",
			'createTime':"",
			'transTime':""
			
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println parseJson(result)['data'].size()
		println '转到计费凭证页面'
		println result
		
	}
	
	def '计费凭证详细'(){
		when:
		def core="downloadinfo/"
		def act=pr.getProperty("select")
		
			
		def url=joinUrl(core, act)
		def reqData=[
			
			'bachNo':"",
			'feeSubjectId':"3000000001",
			'feeBizTypeName':"海口hk",
			'transTime':"2017-09-05 00:00 到 2017-09-06 00:00"
			
			
			]
		then:
		def result=httpRequest(url,'post',reqData,true,true)
		println parseJson(result)['data'].size()
		println '跳转到原始数据明细界面'
		println result
	}
	
	
}
