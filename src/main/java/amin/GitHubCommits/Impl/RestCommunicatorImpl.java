package amin.GitHubCommits.Impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import amin.GitHubCommits.Objects.GitHubResponse;
import amin.GitHubCommits.Service.RestCommunicator;

/**
 * This class is responsible for sending HTTP requests to the server at a given URL
 *
 *
 * Created by habash on 17/05/2017.
 */
public class RestCommunicatorImpl implements RestCommunicator{


    private String body;

    public RestCommunicatorImpl() {

        body = null;
    }

    /**
     * Sends an HTTP request to a server at the given <b>url</b>.
     *
     * @param url the URL of the requested server resource
     * @param headers the headers of the request
     * @param httpMethod HTTP method (GET, POST, PUT, DELETE, HEAD, etc...)
     * @return the response as a GitHubResponse object which contains the response code and data
     * @throws IOException
     */
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

    /**
     * Sets the body of the request to <b>data</b>
     *
     * @param data the body to be set for the request
     */
    public void setBody(String data) {

        body = data;
    }
}

