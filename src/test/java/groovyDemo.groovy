
class groovyDemo {
	def static list1=[:]	
	static void main(args) {
		
		def list=[1,2,3]
		
		
		def map=['1':'2','3':'4']
		def map1=['3':'4','1':'2']
		map1['5']='8'
		map1['6']=['1':'2','3':'4']
		
		new groovyDemo().run()
		println list1
		println list1.class
		println map.class
		println map1.class
		map1 as java.util.Map
		println map1.class
	}	
	
	def void run() {
		list1.put("1",['1':'2','3':'4'])
	}
	
}
