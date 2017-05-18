package amin.GitHubCommits.Objects;

/**
 * This class is used to contain the response code and data returned by a server after an HTTP request.
 *
 * Created by habash on 17/05/2017.
 */
public class GitHubResponse {

	private int responseCode;
	private String responseData;
	
	public GitHubResponse(int code, String data) {
		responseCode = code;
		responseData = data;
	}

    /**
     * Returns the response code
     *
     * @return the response code
     */
	public int getCode() {
		return responseCode;
	}

    /**
     * Returns the response data
     *
     * @return the response data
     */
	public String getData() {
		return responseData;
	}
}
