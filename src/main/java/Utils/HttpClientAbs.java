package Utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class HttpClientAbs {
    protected CloseableHttpClient httpClient;
    protected RequestConfig requestConfig;
    public void close(){

        if(httpClient!=null){
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }

    public HttpClientAbs(){
        httpClient= HttpClients.createDefault();
        requestConfig=RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
    }


    public abstract  String execute(String url);
    public abstract  <T> HttpClientAbs setParams(T t);

}
