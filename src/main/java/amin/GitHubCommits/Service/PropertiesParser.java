package amin.GitHubCommits.Service;

import amin.GitHubCommits.Objects.RequestInput;

import java.io.File;
import java.io.IOException;

/**
 * Created by habash on 17/05/2017.
 */
public interface PropertiesParser {
    /**
     * Parses the given properties file and returns a RequestInput object with its key/value pairs. An IOException is thrown if the
     * extension of the file is not .properties or the syntax of the file contents does not match those of a proper properties file.
     *
     * @param file the properties file to be parsed
     * @return  a RequestInput object with its key/value pairs
     */
    public RequestInput parseFile(File file) throws IOException;

}
