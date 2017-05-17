package amin.GitHubCommits.Objects;

public class GitHubResponse {

	private int responseCode;
	private String responseData;
	
	public GitHubResponse(int code, String data) {
		responseCode = code;
		responseData = data;
	}
	public int getCode() {
		return responseCode;
	}
	public String getData() {
		return responseData;
	}
}
