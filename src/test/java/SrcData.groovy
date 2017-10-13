

class SrcData extends TestFather {

	
	
		def '原始数据明细查询_默认交易时间范围查询'(){
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/downloadinfo/query.json'
			def reqData=[
				
				'bachNo':"",
				'feeSubjectId':"",
				'feeBizTypeName':"",
				'transTime':"2017-08-04 00:00 到 2017-09-01 23:00"
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println parseJson(result)['data'].size()
		}
		def '原始数据明细查询_添加计费业务'(){
			
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/downloadinfo/query.json'
			def reqData=[
				
				'bachNo':"",
				'feeSubjectId':"",
				'feeBizTypeName':"海口hk",
				'transTime':"2017-08-04 00:00 到 2017-09-01 23:00"
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println parseJson(result)['data'].size()
			
		}
		def '原始数据明细查询_添加业务批次号'(){
			
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/downloadinfo/query.json'
			def reqData=[
				
				'bachNo':"111111",
				'feeSubjectId':"",
				'feeBizTypeName':"",
				'transTime':"2017-08-04 00:00 到 2017-09-01 23:00"
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println parseJson(result)['data'].size()
			
			
			
		}
		def '原始数据明细查询_添加商户编号'(){
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/downloadinfo/query.json'
			def reqData=[
				
				'bachNo':"",
				'feeSubjectId':"3000000001",
				'feeBizTypeName':"",
				'transTime':"2017-08-04 00:00 到 2017-09-01 23:00"
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println parseJson(result)['data'].size()
			
			
			
			
		}
		
		def '原始数据明细下载'(){
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/downloadinfo/csv/原始数据.csv'
			def reqData=[
				
				'bachNo':"111111",
				'feeSubjectId':"",
				'feeBizTypeName':"",
				'transTime':"2017-08-04 00:00 到 2017-09-01 23:00"
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			result as java.lang.String
			println new String(result.getBytes(),'iso-8859-1')
		}
}
