

class UpdateStat extends TestFather{

		def '上传记录查询_默认状态'(){
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/uploadRecord/query.json'
			def reqData=[
				'bachNo':"",
				'feeBizName':"",
				'createTime':"2017-08-04 00:00 到 2017-08-04 23:59",
				'status':""
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println '本次查询出的数据数量为'+parseJson(result)['data'].size()
			
		}
		def '上传记录查询_添加批次号'(){
			
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/uploadRecord/query.json'
			def reqData=[
				'bachNo':"7a2a83eed60742e28e2610dde2bf4513",
				'feeBizName':"",
				'createTime':"2017-08-04 00:00 到 2017-08-04 23:59",
				'status':""
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println '本次查询出的数据数量为'+parseJson(result)['data'].size()
			
			
			
		}
		def '上传记录查询_添加业务名称'(){
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/uploadRecord/query.json'
			def reqData=[
				'bachNo':"",
				'feeBizName':"海口hk",
				'createTime':"2017-08-04 00:00 到 2017-08-04 23:59",
				'status':""
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println '本次查询出的数据数量为'+parseJson(result)['data'].size()
			
			
			
			
		}
		def '上传记录查询_添加上传状态_上传成功'(){
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/uploadRecord/query.json'
			def reqData=[
				'bachNo':"",
				'feeBizName':"",
				'createTime':"2017-08-04 00:00 到 2017-08-04 23:59",
				'status':"UPLOADSUCCESS"
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println '本次查询出的数据数量为'+parseJson(result)['data'].size()
			
			
			
		}
		def '上传记录查询_添加上传状态_添加失败'(){
			
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/uploadRecord/query.json'
			def reqData=[
				'bachNo':"",
				'feeBizName':"",
				'createTime':"2017-08-04 00:00 到 2017-08-04 23:59",
				'status':"UPLOADFAIL"
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println '本次查询出的数据数量为'+parseJson(result)['data'].size()
			
			
			
		}
		def '上传记录查询_添加上传状态_通知成功'(){
			
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/uploadRecord/query.json'
			def reqData=[
				'bachNo':"",
				'feeBizName':"",
				'createTime':"2017-08-04 00:00 到 2017-08-04 23:59",
				'status':"NOTIFYSUCCESS"
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println '本次查询出的数据数量为'+parseJson(result)['data'].size()
			
			
			
		}
		def '上传记录查询_添加上传状态_通知失败'(){
			
			
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/uploadRecord/query.json'
			def reqData=[
				'bachNo':"",
				'feeBizName':"",
				'createTime':"2017-08-04 00:00 到 2017-08-04 23:59",
				'status':"NOTIFYFAIL"
				
				]
			then:
			def  result=httpRequest(url,'post',reqData,true,true)
			println '本次查询出的数据数量为'+parseJson(result)['data'].size()
			
			
		}
}
