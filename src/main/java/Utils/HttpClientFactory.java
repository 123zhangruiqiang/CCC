package Utils;

import java.util.HashMap;
import java.util.Map;

public class HttpClientFactory {

    public static HttpClientAbs create(String flag){

        if("get".equals(flag)){
            return new HttpClientGet();
        }else if("postForm".equals(flag)){
            return new HttpClientPostForm();

        }else if("postBody".equals(flag)){
            return  new HttpClientPostBody();

        }else if("getToken".equals(flag)){
            return  new HttpClientGetToken();
        }

        return null;

    }
}
