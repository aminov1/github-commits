package amin.GitHubCommits.Client;

import amin.GitHubCommits.Objects.Consts;
import amin.GitHubCommits.Exception.GitHubCommitsException;
import amin.GitHubCommits.Resource.GitHubCommits;

import java.io.File;
import java.util.Map;


/**
 * The main class of the program
 *
 * Created by habash on 18/05/2017.
 */
public class MainApp {

    public static final String SUCCESS_MESSAGE = "Done! To view the commits list please check run the html " +
            "code in output file %s in your browser.";

    public static void main(String[] args) {

        if(args.length != Consts.LEGAL_ARGS_NUM) {
            System.err.println(Consts.ILLEGAL_ARGS_NUM);
            System.exit(Consts.FAILURE_EXIT_CODE);
        }

        File propFile = new File(args[Consts.FILE_ARG_INDEX]);
        if(!propFile.exists() || propFile.isDirectory()) {
            System.err.println(Consts.NO_FILE_ERROR);
            System.exit(Consts.FAILURE_EXIT_CODE);
        }

        PropertiesParser pp = new PropertiesParserImpl();
        HTMLBuilder builder;
        String absoluteOutputFilePath;
        Map<String, String> propertiesKeysValues;
        try {
            propertiesKeysValues = pp.parseFile(propFile);
            GitHubCommits commits = new GitHubCommits();
            builder = new HTMLBuilder();
            absoluteOutputFilePath = builder.buildHTMLFile(commits.getCommits(Consts.FACEBOOK_GH_OWNER,
                    Consts.OSQUERY_GH_REPOSITORY, Integer.valueOf(propertiesKeysValues.get(Consts.NUM_OF_DAYS))),
                    propertiesKeysValues.get(Consts.OUTPUT_FILE_PATH));
            System.out.println(String.format(SUCCESS_MESSAGE, absoluteOutputFilePath));
        } catch (GitHubCommitsException e) {
            System.err.println(e.getMessage());
            System.exit(Consts.FAILURE_EXIT_CODE);
        }
    }
}
