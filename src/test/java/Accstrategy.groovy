

import java.util.Map.Entry

class Accstrategy extends TestFather{
			
			def core="scrpit/"
			/*def '显示主界面'(){
				when:
				log 'begin'
				
				def url='http://172.19.60.18:8002/lanmaoly-fee-boss/home'
				String result=httpRequest(url,'get',[:],true,true)
				then:
				
				assert result.contains("计费系统")
				
					
				
			}*/
			
			def '查询计费策略方式_查询所有'(){
			/**
			 * 字段 feeScriptName 根据输入的策略名称来执行查询
			 * 
			 * 
			 * 
			 */
				when:
				def url=rtUrl(core, "select")
				def reqData=['feeScriptName':'']
				String result=httpRequest(url,'post',reqData,true,true)
				println result
				then:
				def c=TextUtils.singleTo().selCounts('id',result)
				println c
				def s=parseJson(result)
				println s
				
			}
			def '查询计费策略方式_关键字查询'(){
				when:
				def url=rtUrl(core, "select")
				def reqData=['feeScriptName':'笔数计算公式']
				log '查询的关键字是------------>'+reqData['feeScriptName']
				String result=httpRequest(url,'post',reqData,true,true)
				println result
				then:
				def c=TextUtils.singleTo().selCounts('id',result)
				println c
				assert c>=1
				
			}
			
			def '新增计费策略并且查询'(){
				/**
				 * 新建策略名称不能重复，否则添加失败
				 * 
				 */
				
				when:
				def url=rtUrl(core, "select")
				//def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/scrpit/query.json'
				def reqData=['feeScriptName':'']
				String result=httpRequest(url,'post',reqData,true,true)
				println result
				def c=TextUtils.singleTo().selCounts('id',result)
				println c
				
				then:
				def url1='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/scrpit/addScript.json'
				def reqData1=[
					'strategyName':'新增计费策略',
					
					'strategyCode':'1024',
					'strategyFunName':'072217',
					'strategyArgument':'递减计算公式',
					'strategyArgument':'新增计费策略'
					
					
					]
				String result1=httpRequest(url1,'post',reqData1,true,true)
				println result1
				String result3=httpRequest(url,'post',reqData,true,true)
				println result3
				def c1=TextUtils.singleTo().selCounts('id',result3)
				println c1
				assert c1>c
			}
			
			def '计费策略修改'(){	
				/**
				 * 计费策略修改时需要传入修改策略的id
				 * 计费策略中的所有数据都可以进行修改
				 */
				when:
				def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/scrpit/addScript.json'
				def reqData=[
					'strategyName':'修改计费策略',
					'id':'ff8081815e02b764015e03c8f6fe000f',
					'strategyCode':'1024',
					'strategyFunName':'072217',
					'strategyArgument':'',
					'strategyArgument':'计费策略修改',
					'remark':'修改计费策略'
					
					]
				then:
				String result=httpRequest(url,'post',reqData,true,true)
				println result
				assert result.contains("true")
				/**
				 * 修改后进行查询并且将数据进行比对
				 */
				def url1='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/scrpit/query.json'
				def reqData1=['feeScriptName':reqData['strategyName']]
				println '查询的关键字是------------>'+reqData1['feeScriptName']
				String result1=httpRequest(url1,'post',reqData1,true,true)
				println result1
				
				def map=parseJson(result1)['data'][0]
				map as HashMap
				
				reqData.each {
					
					key,value->assert value==map[key]
					}
			
				println '数据一致'
				
				}
			
		def '计费策略修改_值全部为空'(){
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/scrpit/addScript.json'
			def reqData=[
				'strategyName':'',
				'id':'ff8081815d976fd4015d9819a4a80004',
				'strategyCode':'',
				'strategyFunName':'',
				'strategyArgument':'',
				'strategyArgument':'',
				'remark':''
				
				]
			then:
			String result=httpRequest(url,'post',reqData,true,true)
			println result
			assert result.contains("false")
			
			
		}
			
		def '计费策略下线'(){
			
			when:
			def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/scrpit/query.json'
			def reqData=['feeScriptName':'']
			String result=httpRequest(url,'post',reqData,true,true)
			//println result
			
			def c=TextUtils.singleTo().selCounts('ONLINE',result)
			println '上线的计划策略有：'+c+'个'
			def url1='c/lanmaoly-fee-boss/view/fee/scrpit/line.json'
			def reqData1=[
				'id':'3ef232222d1443ceb9364b4ae2c2b21b'
				
				]
			then:
			
			String result1=httpRequest(url1,'post',reqData1,true,true)
			println result1
			String result2=httpRequest(url,'post',reqData,true,true)
			
			def c1=TextUtils.singleTo().selCounts('ONLINE',result2)
			println '上线的计划策略有：'+c1+'个'
		}
		
		def '计费策略上线'(){
			when:
			
			def url1=' http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/scrpit/calculate.json'
			def reqData1=[
				
				'feeAnalysis':"[{'feeRate':'1','feeTop':'1'}]",
				'count':'100',
				'feeBizType':'100',
				'feeSubjectId':'1',
				'amount':'100',
				'createTime':'2017-08-02 00:00 到 2017-08-02 23:59',
				'periodDateTime':'2017-08-02 00:00 到 2017-08-02 23:59',
				'id':'22139cd4b5a2494fa0ec4ca4ccf04dc6'
				
				]
			String result1=httpRequest(url1,'post',reqData1,true,true)
			println result1
			
			def url=' http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/scrpit/online.json'
			def reqData=[
				'id':'3ef232222d1443ceb9364b4ae2c2b21a'
				
				
				]
			then:
			String result=httpRequest(url,'post',reqData,true,true)
			println result
		}
	
}
