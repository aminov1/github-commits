package amin.GitHubCommits.Objects;

import amin.GitHubCommits.Exception.GitHubCommitsException;


/**
 * Contains the data parsed from the .properties file that was provided as an argument to the program
 *
 * Created by habash on 17/05/2017.
 */
public class RequestInput {

    private int numOfDays;
    private String outputFile;

    public RequestInput(int numOfDays, String outputFile) throws GitHubCommitsException {
        if(numOfDays < Consts.NO_OUTPUT_LIMIT)
            throw new GitHubCommitsException(Consts.INVALID_NUM_OF_DAYS);
        if(outputFile == null || "".equals(outputFile))
            throw new GitHubCommitsException(Consts.NULL_EMPTY_OUTPUT_FILE_PATH);

        this.numOfDays = numOfDays;
        this.outputFile = outputFile;
    }

    /**
     * Returns the number of days
     *
     * @return the number of days
     */
    public int getNumOfDays() {
        return numOfDays;
    }

    /**
     * Returns the output file path
     *
     * @return the output file path
     */
    public String getOutputFile() {
        return outputFile;
    }

}
