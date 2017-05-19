package amin.GitHubCommits.Impl;

import amin.GitHubCommits.Objects.Consts;
import amin.GitHubCommits.Exception.GitHubCommitsException;
import amin.GitHubCommits.Objects.RequestInput;
import amin.GitHubCommits.Service.PropertiesParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is responsible for parsing .properties files. It current accepts only 2 keys: numOfDays and outputFile
 *
 * Created by habash on 17/05/2017.
 */
public class PropertiesParserImpl implements PropertiesParser{


    /**
     * Parses the given properties file and returns a RequestInput object with its key/value pairs. An IOException is thrown if the
     * extension of the file is not .properties or the syntax of the file contents does not match those of a proper properties file.
     *
     * @param file the properties file to be parsed
     * @return a RequestInput object with its key/value pairs
     */
    @Override
    public RequestInput parseFile(File file) throws GitHubCommitsException {
        Properties props = new Properties();
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(file);
            props.load(inputStream);
        } catch (IOException e1) {
            throw new GitHubCommitsException(Consts.INVALID_PROPERTIES_SYNTAX);
        }
        finally {
            if(inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new GitHubCommitsException("Error: " + e.getMessage());
                }
        }

        String numOfDays = props.getProperty(Consts.NUM_OF_DAYS);
        String outputFile = props.getProperty(Consts.OUTPUT_FILE_PATH);

        if(!numOfDays.matches(Consts.INT_REGEX))
            throw new GitHubCommitsException(Consts.INVALID_NUM_OF_DAYS);

        return new RequestInput(Integer.valueOf(numOfDays), outputFile);

    }
}
