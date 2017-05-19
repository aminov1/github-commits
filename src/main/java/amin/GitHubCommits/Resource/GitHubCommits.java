package amin.GitHubCommits.Resource;

import amin.GitHubCommits.Exception.GitHubCommitsException;
import amin.GitHubCommits.Impl.CommitsRetrievalImpl;
import amin.GitHubCommits.Service.CommitsRetriever;

/**
 * The GitHub commit Resource, which serves as the main entry to the tool.
 *
 * Created by habash on 19/05/2017.
 */
public class GitHubCommits {

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
        CommitsRetriever commitsRetriever = new CommitsRetrievalImpl();
        return commitsRetriever.getCommits(owner, repository, numOfDays);
    }
}
