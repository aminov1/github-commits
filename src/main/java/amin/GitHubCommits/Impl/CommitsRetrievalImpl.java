package amin.GitHubCommits.Impl;

import amin.GitHubCommits.Service.CommitsRetriever;

import java.io.File;

/**
 * Created by habash on 17/05/2017.
 */
public class CommitsRetrievalImpl implements CommitsRetriever {


    /**
     * Returns the commits of the repository's master of the last provided number of days
     *
     * @param gitHubURL the URL of the GitHub repository
     * @param numOfDays the last number of days of which the commits should be returned
     * @return the list of commits
     */
    @Override
    public String getCommits(String gitHubURL, int numOfDays) {
        return null;
    }
}
