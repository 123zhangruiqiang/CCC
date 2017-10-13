package Utils;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientGetToken extends HttpClientAbs {
    private Map<String,String> map;
    public String execute(String url) {

        HttpPost httpPost=null;
        httpPost=new HttpPost(url);
        httpPost.setConfig(requestConfig);
        List pv=new ArrayList();
        for(Map.Entry<String,String> entry:map.entrySet()){
            pv.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));

        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(pv));
            CloseableHttpResponse response=httpClient.execute(httpPost);
            Header[] headers=response.getAllHeaders();
            return headers[4].toString().substring(23, 55)+","+headers[5].toString().substring(22,54);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> HttpClientAbs setParams(T t) {
        map=(Map<String,String>)t;
        return this;
    }
}
