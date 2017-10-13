

import org.apache.http.client.methods.HttpPost

class MeRaQuery extends TestFather{

	
	def '商户费率查询_无条件直接查询'(){
		
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/query.json'
		def reqData=[
			'feeScriptName':'',
			'feeSubjectId':''
			
			]
		then:
		def result=httpRequest(url,'post',reqData,true,true)
		println result
		result as java.lang.String
		assert result.contains("true")
	}
	
	def '商户费率查询_按计费策略民称'(){
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/query.json'
		def reqData=[
			'feeScriptName':'笔数计算公式',
			'feeSubjectId':''
			
			]
		then:
		def result=httpRequest(url,'post',reqData,true,true)
		println result
		/*def c=TextUtils.singleTo().selCounts("strategyId", result)
		println '查询出'+c+"条数据"*/
		
		def list=parseJson(result)['data']
		println list
		//assert list.size()==2
		assert result.contains("true")
	}
	def '商户费率查询_按商户编号'(){
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/query.json'
		def reqData=[
			'feeScriptName':'',
			'feeSubjectId':'3000000001'
			
			]
		then:
		def result=httpRequest(url,'post',reqData,true,true)
	
		
		def list=parseJson(result)['data']
		
		println '查询出的记录为'+list.size()+'条'
		assert result.contains("true")
	}
	def '新增商户费率'(){
		when:
		def url1='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/query.json'
		def reqData1=[
			'feeScriptName':'',
			'feeSubjectId':''
			
			]
		
		def result1=httpRequest(url1,'post',reqData1,true,true)
		println parseJson(result1)['data'].size()
		
		
		
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/save.json'
		//def list=[{'bizType':'210f78fbbb384609a6f6539623383540','argument':[{'feeRate':'1','feeTop':'1','feeBottom':'1'}],'billCycle':'MONTH','feeCycle':'STROKE','id':'0728757a9589443984fb7490535c7b33','strategyFunName':'rateResult'}]
		def list="""[
			{"bizType":"210f78fbbb384609a6f6539623383540",
			 "argument":[{"feeRate":"1","feeTop":"1","feeBottom":"1"}],
			 "billCycle":"MONTH","feeCycle":"STROKE",
			 "id":"0728757a9589443984fb7490535c7b33",
			 "strategyFunName":"rateResult"}
			]"""
			
			
			
		def reqData=[
			'rateName':'二位若若人',
			'feeSubjectId':'热污染',
			'subjectName':'二二位',
			'validity':'2017-08-03 00:00 到 2017-08-03 23:59',
			'feeAnalysis':list,
			'templateId':'ff8081815da27978015da2b701ce0000'
			
			
			]
		then:
		
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
		
		
		def result2=httpRequest(url1,'post',reqData1,true,true)
		println parseJson(result2)['data'].size()
		
		
	}
	
	
	def '商户费率修改'(){
		/**
		 * 已修改数据不可以再次修改
		 * 
		 */
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/updateStrategy.json'
		def reqData=[
			'id':'ff8081815da2f0b0015da606840a0006',
			'validity':'2017-08-03 00:00 到 2017-08-04 00:00',
			'feeAnalysis':"""[{"feeRate":"1","feeTop":"1","feeBottom":"1"}]"""
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
	}
	def '商户费率修改_传入值设置为空'(){
		/**
		 * 将传入的值设置为空
		 * 无法修改成功
		 */
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/updateStrategy.json'
		def reqData=[
			'id':'ff8081815da2f0b0015da606840a0008',
			'validity':'',
			'feeAnalysis':"""[]"""
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
		
		
	}
	
	def '商户费率批量启用_未选择启用银行'(){
		when:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/usingOption.json'
		def reqData=[
			'using':"""[]""",
			'deprecated':"""["ff8081815da2f0b0015da5ac50f80002","ff8081815da2f0b0015da5ab5f920001","ff8081815da2f0b0015da5aa31d10000","ff8081815da2f0b0015da606f9b70007","ff8081815da2f0b0015da606840a0006","ff8081815da2f0b0015da5d2be940005","ff8081815da2f0b0015da5cf73740004","ff8081815da2f0b0015da5acf00e0003"]"""
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
		
		
	}
	def '商户费率批量启用_选择启用公式'(){
		
		when:
		
		
		def url1='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/query.json'
		def reqData1=[
			'feeScriptName':'',
			'feeSubjectId':''
			
			]
		
		def result1=httpRequest(url1,'post',reqData1,true,true)
		def c =TextUtils.singleTo().selCounts('USING',result1)
		println '已经启用的商户费率数量'+c
		
		
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/usingOption.json'
		def reqData=[
			'using':"""["ff8081815da2f0b0015da6cb3c010008","ff8081815da27978015da2b701ce0000"]""",
			'deprecated':"""[]"""
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
		def result2=httpRequest(url1,'post',reqData1,true,true)
		def c1 =TextUtils.singleTo().selCounts('USING',result2)
		println '已经启用的商户费率数量'+c1
		
		assert c1>c
		
	}
	
	def '商户费率批量禁用_选择禁用公式'(){
		
		when:
		def url1='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/query.json'
		def reqData1=[
			'feeScriptName':'',
			'feeSubjectId':''
			
			]
		
		def result1=httpRequest(url1,'post',reqData1,true,true)
		def c =TextUtils.singleTo().selCounts('USING',result1)
		println '已经启用的商户费率数量'+c
		
		then:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/usingOption.json'
		def reqData=[
			'using':"""[]""",
			'deprecated':"""["ff8081815da2f0b0015da6cb3c010008"]"""
			
			]
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
		def result2=httpRequest(url1,'post',reqData1,true,true)
		def c1 =TextUtils.singleTo().selCounts('USING',result2)
		println '已经启用的商户费率数量'+c1
		
		assert c1<c
		
	}
	
	def '商户费率启用_批量启用'(){
		
		when:
		
		
		def url1='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/query.json'
		def reqData1=[
			'feeScriptName':'',
			'feeSubjectId':''
			
			]
		
		def result1=httpRequest(url1,'post',reqData1,true,true)
		def c =TextUtils.singleTo().selCounts('USING',result1)
		println '已经启用的商户费率数量'+c
		
		
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/usingOption.json'
		def reqData=[
			'using':"""["ff8081815da2f0b0015da6cb3c010008","ff8081815da2f0b0015da6de029b0009"]""",
			'deprecated':"""[]"""
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
		def result2=httpRequest(url1,'post',reqData1,true,true)
		def c1 =TextUtils.singleTo().selCounts('USING',result2)
		println '已经启用的商户费率数量'+c1
		
		assert c1>c
		
	}
	
	def '商户费率禁用_批量禁用'(){
		
		when:
		def url1='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/query.json'
		def reqData1=[
			'feeScriptName':'',
			'feeSubjectId':''
			
			]
		
		def result1=httpRequest(url1,'post',reqData1,true,true)
		def c =TextUtils.singleTo().selCounts('USING',result1)
		println '已经启用的商户费率数量'+c
		
		then:
		def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/usingOption.json'
		def reqData=[
			'using':"""[]""",
			'deprecated':"""["ff8081815da2f0b0015da6cb3c010008","ff8081815da2f0b0015da6de029b0009"]"""
			
			]
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
		def result2=httpRequest(url1,'post',reqData1,true,true)
		def c1 =TextUtils.singleTo().selCounts('USING',result2)
		println '已经启用的商户费率数量'+c1
		
		assert c1<c
		
	}
	
	
	def 'ceshi'(){
		when:
		def stsr='http://www.baidu.com/query.json'
		def ste='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/rate/save.json'
		//URL url=new URL(stsr)
		then:
		HttpPost hp=new HttpPost(ste)
		//println url
	}
}
