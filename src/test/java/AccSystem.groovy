
class AccSystem extends TestFather {
	
	/**
	 * 新增计费系统方
	 * @return
	 */
	def core="system/"
	def '计费系统方新增'(){
		when:
		def url=rtUrl(core, "insert")
		println url
		def reqData=[
			"systemName":"测试",	
			"id":"",
			"notifyUrl":"www.xina.com",	
			"remark":"测试"
			
			]
		then:
		def result=httpRequest(url, "post",reqData,false,false)
		println result
		assert result.contains("true")
	}
		
}
