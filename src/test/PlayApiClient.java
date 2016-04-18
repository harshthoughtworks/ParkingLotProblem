package test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sharsh on 4/15/16.
 */
public class PlayApiClient {

    private HttpClient httpClient;

    public PlayApiClient(HttpClient httpClient){

        this.httpClient = httpClient;
    }

    public void callApi(HttpGet httpGet){

        HttpGet request = httpGet;

        HttpResponse response = null;
        try {
            response = this.httpClient.execute(request);
            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            System.out.print("result = "+result);
        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
