

class DataDownload extends TestFather{
			
	
			def '创建下载任务'(){
				when:
				def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/automate/createTask'
				/*def reqData=[
					'hashCode':'1668c5186cc4e20533bd5fac3c1b86e6',
					'backNo':'111111',
					'bizType':'210f78fbbb384609a6f6539623383540',
					'startDateTime':'08/01/2017',
					'endDateTime':'09/02/2017',
					'ftpUrl':'ftp://feefile1:123456@172.19.60.187/XMTest.csv.zip',
					'fileSize':'1349',
					'fileName':'XMTest.csv'
					
					]*/
				def reqData=[
					'hashCode':'887fd431177ac30f34a1e83a0d995b53',
					'bachNo':'1111111113',
					'bizType':'210f78fbbb384609a6f6539623383540',
					'startDateTime':"09/02/2017",
					'endDateTime':"09/04/2017",
					'ftpUrl':'ftp://feefile1:123456@172.19.60.187/XML.zip',
					'fileSize':'1347',
					'fileName':'XMTest.csv',
					
					
					]
				
				then:
				def result=httpRequest(url, 'post', reqData, true, true)
				println result
				
			}
	
			def '数据下载'(){
				
				
				when:
				def url='http://172.19.60.18:8002/lanmaoly-fee-boss/view/fee/automate/executeDownLoad'
				def reqData=[:]
				then:
				def result=httpRequest(url, 'post', reqData, true, true)
				println result
				
			}
			
			def '执行计费任务'(){
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
}
