;

class BillGen extends TestFather{

			//1
	def '创建下载任务'(){
		
		when:
		//def url='http://172.19.60.18:8002/lanmaoly-fee-service/api/rest/FeeFacade/fetchFileNotify'
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/automate/createTask'
	
		def reqData=[
				'hashCode':'f3c74d5517d99b4c5a1eeb27f95e175a',
				'bachNo':'111111111111102',
				'bizType':'2dcbf5617a644d8882a0ace1495c25da',
				'startDateTime':"09/16/2017",
				'endDateTime':"12/17/2017",
				'ftpUrl':'ftp://feefile1:123456@172.19.60.187/XMTest_b02.zip',
				'fileSize':'1482',
				'fileName':'XMTest.csv',
			
			
			]
			
		
		
		then:
		def result=httpRequest(url, 'post', reqData, true, true)
		println result
		
		
		
	}
	//2
	def '数据下载'(){
		
		
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/automate/executeDownLoad'
		def reqData=[:]
		then:
		def result=httpRequest(url, 'post', reqData, true, true)
		println result
		
	}
	
	def '新增计费业务_测试流程'(){
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/biz/save.json'
		def reqData=[
			'createStringTime':'',
			'feeBizType':'',
			'id':'',
			'concatCellphone':'14444444444',
			'email':'949895839@qq.com',
			'billCycle':'DAY',
			'concatName':'edd',
			'systemId':	'ff8081815d7fca66015d81aa6ac30001',
			'storageType':'ftp',
			'acquireBillType':'note',
			'feeCycle':'STROKE',
			'remark':'测试流程数据',
			'feeBizTypeName':'测试流程'
			
			
			
			]
		then:
		String result=httpRequest(url,'post',reqData,true,true)
		println result
		assert result.contains('true')
		
		
	}
	
	def '计费业务模板新增_测试流程'(){
		/**
		 * 模板的名称不可以添加重复的内容
		 */
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/biztemplate/save.json'
		def reqData=[
			
			'template':"""[{"name":"测试流程","remark":"测试流程添加","strategyId":"22139cd4b5a2494fa0ec4ca4ccf04dc6","bizId":"ff8081815d2c1714015d2c418de90000"}]"""
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		def str=result as java.lang.String
		assert str.contains('true')
		assert str.contains("测试流程")
		
	}
	


	def '商户费率新增_增加流程'(){
		
		when:
		def url1='http://172.19.60.18:8018/lanmaoly-fee-boss/view/fee/rate/query.json'
		def reqData1=[
			'feeScriptName':'',
			'feeSubjectId':''
			
			]
		
		def result1=httpRequest(url1,'post',reqData1,true,true)
		println parseJson(result1)['data'].size()
		
		
		
		def url='http://172.19.60.18:8018/lanmaoly-fee-boss/view/fee/rate/save.json'
		//def list=[{'bizType':'210f78fbbb384609a6f6539623383540','argument':[{'feeRate':'1','feeTop':'1','feeBottom':'1'}],'billCycle':'MONTH','feeCycle':'STROKE','id':'0728757a9589443984fb7490535c7b33','strategyFunName':'rateResult'}]
		def list="""[
			{"bizType":"210f78fbbb384609a6f6539623383540",
			 "argument":[{"feeRate":"1","feeTop":"1","feeBottom":"1"}],
			 "billCycle":"MONTH","feeCycle":"STROKE",
			 "id":"0728757a9589443984fb7490535c7b33",
			 "strategyFunName":"rateResult"}
			]"""
		def list1="""[{"bizType":"d0a47d3c506b43ada23a1a1ef9613dd6",
		"argument":[{"feeCountMoney":"1000"}],
		"billCycle":"DAY","feeCycle":"STROKE",
		"id":"22139cd4b5a2494fa0ec4ca4ccf04dc6",
		"strategyFunName":"countResult"}]"""	
			
			
		def reqData=[
			'rateName':'测试流程',
			'feeSubjectId':'测试流程',
			'subjectName':'测试流程',
			'validity':'2017-08-03 00:00 到 2017-10-03 23:59',
			'feeAnalysis':list,
			'templateId':'ff8081815dacbbfa015dba6721a70006'
			
			
			]
		then:
		
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
		
		
		def result2=httpRequest(url1,'post',reqData1,true,true)
		println parseJson(result2)['data'].size()
		
		
		
	}
	
	//34
	def '执行计费任务'(){
		//18yuanlai
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/automate/executeFee'
		
		def reqData=[:]
		then:
		def result=httpRequest(url, 'post', reqData, true, true)
		println result
	}
	def '生成账单执行'(){
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/automate/executeBill'
		def reqData=[:]
		then:
		def result=httpRequest(url, 'post', reqData, true, true)
		println result
	}





	def '扣费账单生成'(){
		when:

		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/automate/executeGenFee'
		//def url='http://172.19.62.36:8080/lanmaoly-fee-boss/view/fee/automate/executeGenFee'
		def reqData=[:]
		then:
		def result=httpRequest(url, 'post', reqData, true, true)
		println result

	}
	def '扣费账单执行扣费'(){
		when:
		def url="http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/automate/executeNotifyDeduct"
		//def url="http://172.19.62.36:8080/lanmaoly-fee-boss/view/fee/automate/executeNotifyDeduct"//本地接口
		def reqData=[:]
		then:
		def result=httpRequest(url, 'post', reqData, true, true)
		println result
	}



	def '获取状态更新结果接口'(){
		when:
		def url="http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/automate/executeUpdateStatus"
		//def url="http://172.19.62.36:8080/lanmaoly-fee-boss/view/fee/automate/executeUpdateStatus"//本地接口
		def reqData=[:]
		then:
		def result=httpRequest(url, 'post', reqData, true, true)
		println result
	}
	/*
	def '计费账单下载'(){
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/bill/csv/%E8%B4%A6%E5%8D%95.csv'
		def reqData=[
			'feeBizTypeName':'',
			'feeSubjectId':'',
			'createTime':'2017-08-07 00:00 到 2017-08-07 23:59',
			'certificateTime':''
			
			
			]
		then:
		def result=httpRequest(url, 'post', reqData, true, true)
		println new String(result.getBytes('ISO-8859-1'),'GBK')
		def out=new File('zhangruiqiang.txt').newPrintWriter()
		out.write(new String(result.getBytes('ISO-8859-1'),'utf-8'))
		
		out.flush()
		out.close()
	}*/
	
}
