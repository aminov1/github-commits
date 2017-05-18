package amin.GitHubCommits.Service;

import amin.GitHubCommits.Exception.GitHubCommitsException;


/**
 * Created by habash on 17/05/2017.
 */
public interface CommitsRetriever {

    /**
     * Returns the commits of the repository's master of the last provided number of days
     *
     * @param owner the owner of the GitHub repository
     * @param repository the GitHub repository
     * @param numOfDays the last number of days of which the commits should be returned
     *
     * @throws GitHubCommitsException the exception is thrown in case of invalid input or a general error
     * @return the list of commits
     */
    public String getCommits(String owner, String repository, int numOfDays) throws GitHubCommitsException;

}
