

class BiSysQu extends TestFather {

			def core='system/'
			def '计费系统方查询'(){
				when:
				def url=rtUrl(core, "select")
				def reqData=[:]
				then:
				def result=httpRequest(url, 'post', reqData, true,true)
				println result
				def c=TextUtils.singleTo().selCounts('systemName', result)
				println '一共有'+c+'家计费系统方'
				
			}
			
			def '新增计费系统方'(){
				when:
				def url=rtUrl(core, "insert")
				def reqData=[:]
				then:
				def result=httpRequest(url, 'post', reqData, true,true)
				def c=TextUtils.singleTo().selCounts('systemName', result)
				println '一共有'+c+'家计费系统方'
				
				 	def url1='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/system/save.json'
					def reqData1=[
						'id':'',
						'systemName':'测试数据',
						'notifyUrl':'是是是'
						
						]
					then:
					def result1=httpRequest(url1, 'post', reqData1, true, true)
					println result1
				
				
					def url2 ='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/system/query.json'
					def reqData2=[:]
					then:
					def result2=httpRequest(url, 'post', reqData, true,true)
					def c1=TextUtils.singleTo().selCounts('systemName', result2)
					println '新增后一共有'+c1+'家计费系统方'
					
					assert c1>c
			}
			
			def '计费系统方修改'(){
				when:
				def url=rtUrl(core, "insert")
				def reqData=[
					'systemName':'测试数据',
					'id':'ff8081815d976fd4015da2033ec40015',
					'notifyUrl':'否否否'
					
					]
				then:
				def result=httpRequest(url, 'post', reqData, true, true)
				println result
				
			}
			def '计费系统方修改_传入的值为空'(){
				
				when:
				
				def url=rtUrl(core, "select")
				def reqData=[
					'systemName':'',
					'id':'ff8081815d976fd4015da2033ec40015',
					'notifyUrl':''
					
					]
				then:
				def result=httpRequest(url, 'post', reqData, true, true)
				println result
				
			}
	
}
