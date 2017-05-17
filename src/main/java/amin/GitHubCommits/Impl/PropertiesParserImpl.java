package amin.GitHubCommits.Impl;

import amin.GitHubCommits.Consts;
import amin.GitHubCommits.Objects.RequestInput;
import amin.GitHubCommits.Service.PropertiesParser;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;


/**
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
    public RequestInput parseFile(File file) throws IOException {
        String propFileName = file.getAbsolutePath();
        Properties props = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        try {
            props.load(inputStream);
        } catch (IOException e1) {
            throw new IOException(Consts.INVALID_PROPERTIES_SYNTAX);
        }
        finally {
            if(inputStream != null)
                inputStream.close();
        }

        String numofDays = props.getProperty(Consts.NUM_OF_DAYS);
        String outputFile = props.getProperty(Consts.OUTPUT_FILE_PATH);

        return new RequestInput(Integer.valueOf(numofDays), outputFile);

    }
}
