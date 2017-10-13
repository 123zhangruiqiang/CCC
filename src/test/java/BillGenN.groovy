class BillGenN extends TestFather {


    def '创建下载任务'(){

        when:
        //def url='http://172.19.60.18:8002/lanmaoly-fee-service/api/rest/FeeFacade/fetchFileNotify'
        def url='http://172.19.60.149:8080/lanmaoly-fee-boss/view/fee/automate/createTask'

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
        def url='http://172.19.60.149:8080/lanmaoly-fee-boss/view/fee/automate/executeDownLoad'
        def reqData=[:]
        then:
        def result=httpRequest(url, 'post', reqData, true, true)
        println result

    }

    def '执行计费任务'(){
        //18yuanlai
        when:
        def url='http://172.19.60.149:8080/lanmaoly-fee-boss/view/fee/automate/executeFee'

        def reqData=[:]
        then:
        def result=httpRequest(url, 'post', reqData, true, true)
        println result
    }
    def '生成账单执行'(){
        when:
        def url='http://172.19.60.149:8080/lanmaoly-fee-boss/view/fee/automate/executeBill'
        def reqData=[:]
        then:
        def result=httpRequest(url, 'post', reqData, true, true)
        println result
    }

//+++++++++++++++++++++++++++++++++++++



    def '扣费账单生成'(){
        when:

        def url='http://172.19.60.103:8003/lanmaoly-fee-boss/view/fee/automate/executeGenFee'
        //def url='http://172.19.62.36:8080/lanmaoly-fee-boss/view/fee/automate/executeGenFee'
        def reqData=[:]
        then:
        def result=httpRequest(url, 'post', reqData, true, true)
        println result

    }
    def '扣费账单执行扣费'(){
        when:
        def url="http://172.19.60.103:8003/lanmaoly-fee-boss/view/fee/automate/executeNotifyDeduct"
        //def url="http://172.19.62.36:8080/lanmaoly-fee-boss/view/fee/automate/executeNotifyDeduct"//本地接口
        def reqData=[:]
        then:
        def result=httpRequest(url, 'post', reqData, true, true)
        println result
    }



    def '获取状态更新结果接口'(){
        when:
        def url="http://172.19.60.103:8003/lanmaoly-fee-boss/view/fee/automate/executeUpdateStatus"
        //def url="http://172.19.62.36:8080/lanmaoly-fee-boss/view/fee/automate/executeUpdateStatus"//本地接口
        def reqData=[:]
        then:
        def result=httpRequest(url, 'post', reqData, true, true)
        println result
    }


}
