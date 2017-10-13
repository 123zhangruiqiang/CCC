package Utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientPostForm extends  HttpClientAbs {
    private Map<String,String> map;

    public String execute(String url) {
        HttpPost httpPost=null;

        httpPost=new HttpPost(url);
        httpPost.setConfig(requestConfig);

        httpPost.setHeader("Cookie", "JSESSIONID="+map.get("JSESSIONID")+";"+"sso-token="+map.get("sso-Token"));
        List pv=new ArrayList();
        map.remove("JSESSIONID");
        map.remove("sso-Token");
        if(map.size()!=0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                pv.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));

            }
        }
        try {

            httpPost.setEntity(new UrlEncodedFormEntity(pv));
            CloseableHttpResponse response=httpClient.execute(httpPost);
            HttpEntity httpEntity=response.getEntity();
            System.out.println(response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode()==302){
                Header header=response.getFirstHeader("location");
                httpPost.abort();
                HttpGet httpGet=new HttpGet(header.getValue());
                CloseableHttpResponse response1=httpClient.execute(httpGet);
                System.out.println(response1.getStatusLine().getStatusCode());
                //System.out.println(EntityUtils.toString(response1.getEntity(),"utf-8"));
                return  EntityUtils.toString(response1.getEntity(),"utf-8");
               /* Header header=response.getFirstHeader("location");
                System.out.println(header.getValue());
                HttpGet httpGet=new HttpGet(header.getValue());
                httpGet.setConfig(requestConfig);
                httpGet.setHeader("Cookie", "JSESSIONID="+JSESSIONID+";"+"sso-token="+Token);
                httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
               *//* for(Map.Entry<String,String> entry:map.entrySet()){
                    pv.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));

                }*//*
               // httpPost.setEntity(new UrlEncodedFormEntity(pv));
                CloseableHttpResponse response1=httpClient.execute(httpGet);
                System.out.println(response.getStatusLine().getStatusCode());*/
                   /* Header[] headers=response.getAllHeaders();
                    for(Header h:headers){
                        System.out.println(h);

                    }*/

            }
            return EntityUtils.toString(httpEntity,"utf-8");
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
        map=(Map<String, String>) t;

        return this;
    }

    public void login(){

    }
}
