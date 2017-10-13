

class BlVoucher extends TestFather {

	def core='certificate/'
	def '计费凭证查询_时间查询'(){
		
		when:
		def url=rtUrl(core, "select")
		def reqData=[
			
			'feeBizTypeName':"",
			'feeSubjectId':"",
			'belongBill':"",
			'createTime':"2017-08-03 00:00 到 2017-09-01 23:00",
			'transTime':"2017-08-31 00:00 到 2017-09-01 23:00"
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		println parseJson(result)['data'].size()
	}
	def '计费凭证查询_增加计费业务名称'(){
		
		when:
		def url=rtUrl(core, "select")
		def reqData=[
			
			'feeBizTypeName':"提现",
			'feeSubjectId':"",
			'belongBill':"",
			'createTime':"2017-08-03 00:00 到 2017-09-01 23:00",
			'transTime':"2017-08-31 00:00 到 2017-09-01 23:00"
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		println parseJson(result)['data'].size()
		
	}
	
	def '计费凭证查询_添加商户编号'(){
		
		when:
		def url=rtUrl(core, "select")
		def reqData=[
			
			'feeBizTypeName':"",
			'feeSubjectId':"3000000001",
			'belongBill':"",
			'createTime':"2017-08-03 00:00 到 2017-09-01 23:00",
			'transTime':"2017-08-31 00:00 到 2017-09-01 23:00"
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		println parseJson(result)['data'].size()
		
	}
	def '计费凭证查询_添加账单id'(){
		when:
		def url=rtUrl(core, "select")
		def reqData=[
			
			'feeBizTypeName':"",
			'feeSubjectId':"",
			'belongBill':"2c93beb05daad2be015daad6625a0000",
			'createTime':"2017-08-03 00:00 到 2017-09-01 23:00",
			'transTime':"2017-08-31 00:00 到 2017-09-01 23:00"
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		println parseJson(result)['data'].size()
		
		
	}
	def '计费凭证下载'(){
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/certificate/csv/%E8%AE%A1%E8%B4%B9%E5%87%AD%E8%AF%81.csv'
		def reqData=[
			
			'feeBizTypeName':"",
			'feeSubjectId':"",
			'belongBill':"",
			'createTime':"2017-08-03 00:00 到 2017-09-01 23:00",
			'transTime':"2017-08-31 00:00 到 2017-09-01 23:00"
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		result as java.lang.String
		println new String(result.getBytes(),'gb2312')
	}
	
}
