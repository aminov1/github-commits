package amin.GitHubCommits.Impl;

import amin.GitHubCommits.Consts;
import amin.GitHubCommits.Exception.GitHubCommitsException;
import amin.GitHubCommits.Objects.GitHubResponse;
import amin.GitHubCommits.Service.CommitsRetriever;
import amin.GitHubCommits.Service.RestCommunicator;

import java.io.IOException;
import java.util.Calendar;

/**
 * This class commuicates with GitHub to retrieve the commits of a given owner-repository pair. The results can be limited by the last desired number
 * of days
 *
 * Created by habash on 17/05/2017.
 */
public class CommitsRetrievalImpl implements CommitsRetriever {


    /**
     * Returns the commits of the repository's master of the last provided number of days
     *
     * @param owner the owner of the GitHub repository
     * @param repository the GitHub repository
     * @param numOfDays the last number of days of which the commits should be returned
     * @return the list of commits
     */
    public String getCommits(String owner, String repository, int numOfDays)
            throws GitHubCommitsException {

        if(owner == null || "".equals(owner) || repository == null || "".equals(repository))
            throw new GitHubCommitsException(Consts.INVALID_GITHUB_DETAILS);

        StringBuffer url = new StringBuffer(Consts.GITHUB_API_URL);
        url.append(String.format(Consts.REPOS_RESOURCE, owner, repository))
                .append(Consts.COMMITS_RESOURCE);
        if(numOfDays > Consts.NO_OUTPUT_LIMIT) {
            String sinceDate = calculateDate(numOfDays);
            url.append(String.format(Consts.SINCE_PARAM, sinceDate));
        }
        RestCommunicator restCom = new RestCommunicatorImpl();
        GitHubResponse response;
        try {
            response = restCom.sendRequest(url.toString(), null, Consts.HTTP_GET);
        } catch (IOException e) {
            throw new GitHubCommitsException(Consts.DEFAULT_ERROR);
        }
        if(response.getCode() == Consts.NOT_FOUND)
            throw new GitHubCommitsException(Consts.DEFAULT_ERROR);
        return response.getData();
    }

    /**
     * Calculates the date <b>numOfDays</b> ago
     *
     * @param numOfDays
     * @return the date <b>numOfDays</b> ago
     */
    private String calculateDate(int numOfDays) {
        Calendar c = Calendar.getInstance();
        long today = c.getTimeInMillis();
        c.setTimeInMillis(today - (numOfDays * Consts.DAY_IN_MILLIS));
        StringBuffer date = new StringBuffer();
        date.append(c.get(Calendar.YEAR)).append("-").append(pad(c.get(Calendar.MONTH) + 1))
                .append("-").append(pad(c.get(Calendar.DAY_OF_MONTH))).append(Consts.ZERO_TIME);
        return date.toString();
    }

    /**
     * If <b>num</b> is less than 10 a "0" is added to its left and the result is returned as a String
     *
     * @param num
     * @return a String representation of <b>num</b>, with a "0" on its left if its value is below 10
     */
    private String pad(int num) {
        if(num < 10)
            return "0" + num;
        else return "" + num;
    }


}
