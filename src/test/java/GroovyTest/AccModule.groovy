package GroovyTest


class AccModule extends TestFather {
	
	def core="biztemplate/"
	def '计费业务模板查询_无条件查询'(){
		when:
	
		def url=rtUrl(core, "select")
		
		def reqData=[
			
			'feeScriptName':''
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
	}
	def '计费业务模板查询_有条件查询'(){
		
		when:
	
		def url=rtUrl(core, "select")
		def reqData=[
			
			'feeScriptName':''
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
		
		
	}
	def '计费业务模板详情'(){
		when:
		
		def act=pr.getProperty("select")
		
			
		def url=joinUrl(core, act)
		
		def reqData=[
			'tempalteName':'',
			'id':'ff8081815d976fd4015da1ebc927000b'
			
			]
		then:
		
		def  result=httpRequest(url,'post',reqData,true,true)
		println result
		
		
	}
	def '计费业务模板新增'(){
		/**
		 * 模板的名称不可以添加重复的内容
		 */
		when:
		def url=rtUrl(core, "insert")
		def reqData=[
			
			'template':"""[{"name":"测试数据新的","remark":"测试添加","strategyId":"22139cd4b5a2494fa0ec4ca4ccf04dc6","bizId":"ff8081815d2c1714015d2c418de90000"},
			{"name":"测试数据新的","remark":"测试添加","strategyId":"22139cd4b5a2494fa0ec4ca4ccf04dc6","bizId":"ff8081815d2c1714015d2c4241940001"},
			{"name":"测试数据新的","remark":"测试添加","strategyId":"22139cd4b5a2494fa0ec4ca4ccf04dc6","bizId":"ff8081815d2c1714015d2c45ee1a0002"},
			{"name":"测试数据新的","remark":"测试添加","strategyId":"22139cd4b5a2494fa0ec4ca4ccf04dc6","bizId":"ff8081815d2c1714015d2c4983bb0003"}]"""
			
			]
		then:
		def  result=httpRequest(url,'post',reqData,true,true)
		def str=result as java.lang.String
		assert str.contains('true')
		assert str.contains("测试数据新的")
		
	}
	
}
