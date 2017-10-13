
package Service.imp;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpService {

        public String doget(String url,Map<String,String> map,Boolean needHeader,Boolean needCookie){
            url=url.trim();
            List nvps=new ArrayList();
            if(map.size()>0){
                for(Map.Entry<String,String> entry:map.entrySet()){
                    nvps.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
                }
                try {
                    String str=EntityUtils.toString(new UrlEncodedFormEntity(nvps));
                    HttpGet httpGet=new HttpGet(url+"?"+str);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return "";
        }
        public String dopost(){

            return "";
        }


}
