package amin.GitHubCommits.Client;

import amin.GitHubCommits.Exception.GitHubCommitsException;

import java.io.File;
import java.util.Map;

/**
 * Created by habash on 17/05/2017.
 */
public interface PropertiesParser {
    /**
     * Parses the given properties file and returns a Map object with its key/value pairs. An IOException is thrown if the
     * extension of the file is not .properties or the syntax of the file contents does not match those of a proper properties file.
     *
     * @param file the properties file to be parsed
     * @return  a Map object with its key/value pairs
     */
    public Map<String,String> parseFile(File file) throws GitHubCommitsException;

}
