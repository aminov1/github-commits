package amin.GitHubCommits.Service;

import amin.GitHubCommits.Objects.GitHubResponse;

import java.io.IOException;
import java.util.Map;

/**
 * Created by habash on 17/05/2017.
 */
public interface RestCommunicator {

    public static String HTTP_GET = "GET";
    public static String HTTP_POST = "POST";

    public GitHubResponse sendRequest(String url, Map<String, String> headers, String httpMethod) throws IOException;

    public void setBody(String data);
}
