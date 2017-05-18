package amin.GitHubCommits;

import amin.GitHubCommits.Exception.GitHubCommitsException;
import amin.GitHubCommits.Impl.CommitsRetrievalImpl;
import amin.GitHubCommits.Impl.PropertiesParserImpl;
import amin.GitHubCommits.Objects.RequestInput;
import amin.GitHubCommits.Service.CommitsRetriever;
import amin.GitHubCommits.Service.PropertiesParser;

import java.io.File;


/**
 * The main class of the program
 *
 * Created by habash on 18/05/2017.
 */
public class GitHubCommits {

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
        RequestInput rq;
        try {
            rq = pp.parseFile(propFile);
            CommitsRetriever commits = new CommitsRetrievalImpl();
            System.out.println(commits.getCommits(Consts.FACEBOOK_GH_OWNER, Consts.OSQUERY_GH_REPOSITORY, rq.getNumOfDays()));
        } catch (GitHubCommitsException e) {
            System.err.println(e.getMessage());
            System.exit(Consts.FAILURE_EXIT_CODE);
        }
    }
}
