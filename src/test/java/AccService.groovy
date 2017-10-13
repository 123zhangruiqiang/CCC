

class AccService extends TestFather {
	 
	
	 def core="biz/"
	 def static  list=[]
	 def '计费业务查询_查询所有'(){
		 
		 when:
		
		def url=rtUrl(core, "select")
		 def reqData=[
			 'feeBizTypeName':'',
			 'feeBizType':''
			 
			 
			 ]
		 
		 String result=httpRequest(url,'post',reqData,true,true)
		 println result
		 then:
		 def c=TextUtils.singleTo().selCounts('id',result)
		 println '一共有'+c+'条数据'
		 

		 def map=parseJson(result)['data']
		 list.add(map)
		 
		 
		 
	 }
	
	def '计费业务查询_计费业务名称'(){
		
		when:
		def url=rtUrl(core, "select")
		def reqData=[
			'feeBizTypeName':'提现',
			'feeBizType':''
			
			
			]
		def token='ff8081815d7a4e47015d7e422f9e0003'
		String result=httpRequest(url,'post',reqData,true,true)
		println result
		then:
		def c=TextUtils.singleTo().selCounts('id',result)
		println '一共有'+c+'条数据'

		def map=parseJson(result)['data'][0]
		assert map['id']==token
		
		
		def mapp=parseJson(result)['data']
		list.add(mapp)
	} 
	def '计费业务查询_计费业务标识'(){
		
		when:
		def url=rtUrl(core, "select")
		def reqData=[
			'feeBizTypeName':'',
			'feeBizType':'455c98932037436394b5cac6aab95907'
			
			
			]
		def token='ff8081815d7a4e47015d7e422f9e0003'
		String result=httpRequest(url,'post',reqData,true,true)
		println result
		then:
		def c=TextUtils.singleTo().selCounts('id',result)
		println '一共有'+c+'条数据'

		def map=parseJson(result)['data'][0]
		assert map['id']==token
		
		
		def mapp=parseJson(result)['data']
		list.add(mapp)
		
	}
	def '计费业务查询_计费业务标识和名称'(){
		
		when:
		def url=rtUrl(core, "select")
		def reqData=[
			'feeBizTypeName':'提现',
			'feeBizType':'455c98932037436394b5cac6aab95907'
			
			
			]
		def token='ff8081815d7a4e47015d7e422f9e0003'
		String result=httpRequest(url,'post',reqData,true,true)
		println result
		then:
		def c=TextUtils.singleTo().selCounts('id',result)
		println '一共有'+c+'条数据'

		def map=parseJson(result)['data'][0]
		assert map['id']==token

		
		
		def mapp=parseJson(result)['data']
		list.add(mapp)
	}
	def '新增计费业务'(){
		when:
		def url=rtUrl(core, "insert")
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
			'remark':'测试数据',
			'feeBizTypeName':'测试数据1'
			
			
			
			]
		then:
		String result=httpRequest(url,'post',reqData,true,true)
		println result
		assert result.contains('true')
		
		def map=parseJson(result)['data']
		println map
		list.add(map)
	}
	def '计费业务修改'(){
		
		when:
		def url=rtUrl(core, "update")
		def reqData=[
			
			'createStringTime':'2017-08-02 14:46:43',
			'feeBizType':'fa3d77b99e2b44039d4d2bd22e52a7fe',
			'id':'ff8081815d976fd4015da1b24d0a0008',
			'concatCellphone':'14444444444',
			'email':'949895839@qq.com',
			'billCycle':'DAY',
			'concatName':'edd',
			'systemId':	'ff8081815d7fca66015d81aa6ac30001',
			'storageType':'ftp',
			'acquireBillType':'note',
			'feeCycle':'STROKE',
			'remark':'测试数据',
			'feeBizTypeName':'测试数据1'
			
			]
		then:
		String result=httpRequest(url,'post',reqData,true,true)
		println result
		
		def map=parseJson(result)['data']
		println map
		list.add(map)
	}
	
	def '计费业务修改_将所有值设置为空'(){
		
		def url=''
	 
	}
	
	def cleanupSpec() {
		
		//endCall(list)
	}
}
