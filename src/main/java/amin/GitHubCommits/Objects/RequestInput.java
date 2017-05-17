package amin.GitHubCommits.Objects;

import amin.GitHubCommits.Consts;

import java.io.IOException;

/**
 * Created by habash on 17/05/2017.
 */
public class RequestInput {

    private int numOfDays;
    private String outputFile;

    public RequestInput(int numOfDays, String outputFile) throws IOException{
        if(numOfDays < Consts.UNLIMITED_OUTPUT)
            throw new IOException(Consts.INVALID_NUM_OF_DAYS);
        if(outputFile == null || "".equals(outputFile))
            throw new IOException(Consts.INVALID_FILE_PATH);

        this.numOfDays = numOfDays;
        this.outputFile = outputFile;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public String getOutputFile() {
        return outputFile;
    }

}
