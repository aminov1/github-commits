package amin.GitHubCommits.Impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import amin.GitHubCommits.Objects.GitHubResponse;

/**
 * Created by habash on 17/05/2017.
 */
public class RestCommunicatorImpl {


    private String body;

    public RestCommunicatorImpl() {

        body = null;
    }

    public GitHubResponse sendRequest(String url, Map<String, String> headers, String httpMethod) throws IOException {
        URL agmUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) agmUrl.openConnection();
        con.setRequestMethod(httpMethod);

        if(headers != null) {
            for(Map.Entry<String, String> e : headers.entrySet()) {
                con.setRequestProperty(e.getKey(), e.getValue());
            }
        }
        if (body != null) {
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(body);
            wr.flush();
            wr.close();
        }

        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while((inputLine = reader.readLine()) != null) {
            buffer.append(inputLine);
        }
        reader.close();
        return new GitHubResponse(con.getResponseCode(), buffer.toString());
    }

    public void setBody(String data) {

        body = data;
    }
}

