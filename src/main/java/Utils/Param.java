
package Utils;

import java.util.Map;

public class Param {

    public Map<String,String> loginParam(Map<String,String> map){
        map.put("name","admin");
        map.put("password","123456");
        map.put("redirect","http://172.19.60.18:8002/lanmaoly-fee-boss/sso");
        return map;
    }

    public Map<String, String> checkRw(Map<String,String> map) {

        map.put("hashCode","f3c74d5517d99b4c5a1eeb27f95e175a");
        map.put("bachNo","111111111111102");
        map.put("bizType","2dcbf5617a644d8882a0ace1495c25da");
        map.put("startDateTime","09/16/2017");
        map.put("endDateTime","12/17/2017");
        map.put("ftpUrl","ftp://feefile1:123456@172.19.60.187/XMTest_b02.zip");
        map.put("fileSize","1482");
        map.put("fileName","XMTest.csv");
        return map;
    }


}
