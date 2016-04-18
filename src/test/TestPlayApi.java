package test;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

/**
 * Created by sharsh on 4/15/16.
 */
public class TestPlayApi {

    @Test
    public void testPlayApi() {

        String url = "http://play-api-1.herokuapp.com/demo/";
        url = url+12;

        HttpClient client = new PlayApiStub();
        HttpGet request = new HttpGet(url);



        PlayApiClient apiClient = new PlayApiClient(client);
        apiClient.callApi(request);
    }
}
