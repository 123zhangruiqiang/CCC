package Utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class HttpClientPostBody extends HttpClientAbs {
    private String body;
    public String execute(String url) {
        HttpPost httpPost=null;
        httpPost=new HttpPost(url);
        httpPost.setConfig(requestConfig);
        try {
            httpPost.setEntity(new StringEntity(body));
            CloseableHttpResponse response=httpClient.execute(httpPost);
            HttpEntity httpEntity=response.getEntity();
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
        body=(String) t;
        return this;
    }
}
