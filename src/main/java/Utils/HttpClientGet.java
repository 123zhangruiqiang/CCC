package Utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientGet extends  HttpClientAbs {

    public String execute(String url) {
        HttpGet httpGet=null;

        httpGet=new HttpGet(url);
        httpGet.setConfig(requestConfig);

        try {
            CloseableHttpResponse response=httpClient.execute(httpGet);
            HttpEntity httpEntity=response.getEntity();
            return EntityUtils.toString(httpEntity,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public <T> HttpClientAbs setParams(T t) {
        return null;
    }
}
