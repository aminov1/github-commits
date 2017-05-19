package amin.GitHubCommits.Objects;

/**
 * This class serves as a container for constants.
 *
 * Created by habash on 17/05/2017.
 */
public class Consts {

    //###################################################################################
    //#####################               Input Related           #######################
    //###################################################################################
    /**
     * Unlimited output
     */
    public static final int NO_OUTPUT_LIMIT = 0;
    /**
     * Legal number of program arguments
     */
    public static final int LEGAL_ARGS_NUM = 1;
    /**
     * File argument index
     */
    public static final int FILE_ARG_INDEX = 0;
    /**
     * Int regular expression for number of days
     */
    public static final String INT_REGEX = "[0-9]*";
    //###################################################################################
    //#####################                   URLs                #######################
    //###################################################################################
    /**
     * GitHub API URL
     */
    public static final String GITHUB_API_URL = "https://api.github.com";
    /**
     * GitHub Repos Resource
     */
    public static final String REPOS_RESOURCE = "/repos/%s/%s";
    /**
     * Commits Resource
     */
    public static final String COMMITS_RESOURCE = "/commits";

    /**
     * Since param (Only commits after this date will be returned.
     * This is a timestamp in ISO 8601 format: YYYY-MM-DDTHH:MM:SSZ.
     */
    public static final String SINCE_PARAM = "?since=%s";

    //###################################################################################
    //####################                   Errors                ######################
    //###################################################################################
    /**
     * Illegal number of program arguments
     */
    public static final String ILLEGAL_ARGS_NUM = "Error: Illegal number of arguments given! " +
            "Please provide only the .properties file path.";
    /**
     * Not a file error
     */
    public static final String NO_FILE_ERROR = "Error: Couldn't find a properties file with the name specified!";
    /**
     * Invalid number of days (For values < 0)
     */
    public static final String INVALID_NUM_OF_DAYS = "Error: The provided days limit is invalid!";
    /**
     * Invalid file path
     */
    public static final String NULL_EMPTY_OUTPUT_FILE_PATH = "Error: The provided path is invalid!";
    /**
     * Output file error
     */
    public static final String OUTPUT_FILE_GENERAL_ERROR = "Error: An error occurred while creating the output file!";
    /**
     * Out file is a directory
     */
    public static final String OUTPUT_FIL_IS_DIRECTORY = "Error: The provided output file is a directory!";
    /**
     * Output file already exists
     */
    public static final String OUTPUT_FILE_EXISTS_ERROR = "Error: The provided output file already exists!";
    /**
     * Invalid properties file syntax
     */
    public static final String INVALID_PROPERTIES_SYNTAX = "Error: There is a problem with the properties file! " +
            "Please check the syntax of its values.";
    /**
     * Invalid GitHub details
     */
    public static final String INVALID_GITHUB_DETAILS = "Error: Invalid GitHub details!";
    /**
     * Default error message
     */
    public static final String DEFAULT_ERROR = "Error: An error occurred "
            + "while processing the request! Either the inserted owner-repository pair does not exist or " +
            "GitHub is currently down!";

    //###################################################################################
    //####################               Properties Keys           ######################
    //###################################################################################
    /**
     * Number of Days
     */
    public static final String NUM_OF_DAYS = "numOfDays";
    /**
     * Output File Path
     */
    public static final String OUTPUT_FILE_PATH = "outputFile";

    //###################################################################################
    //####################                 HTTP Codes              ######################
    //###################################################################################
    /**
     * HTTP OK Code: 200
     */
    public static final int OK = 200;
    /**
     * HTTP Unauthorized Code: 401
     */
    public static final int UNAUTHORIZED = 401;
    /**
     * HTTP Server Error Code: 500
     */
    public static final int SERVER_ERROR = 500;
    /**
     * HTTP Not found
     */
    public static final int NOT_FOUND = 404;

    //###################################################################################
    //####################                 HTTP Methods            ######################
    //###################################################################################
    /**
     * HTTP GET
     */
    public static final String HTTP_GET = "GET";
    /**
     * HTTP POST
     */
    public static final String HTTP_POST = "POST";

    //###################################################################################
    //####################              GitHub JSON Keys           ######################
    //###################################################################################
    /**
     * SHA key
     */
    public static final String SHA = "sha";
    /**
     * Commit key
     */
    public static final String COMMIT = "commit";
    /**
     * Committer key
     */
    public static final String COMMITTER = "committer";
    /**
     * Email key
     */
    public static final String COMMITTER_EMAIL = "email";
    /**
     * Date key
     */
    public static final String COMMIT_DATE = "date";
    /**
     * Message key
     */
    public static final String COMMIT_MESSAGE = "message";

    //###################################################################################
    //####################                    MISC                 ######################
    //###################################################################################
    /**
     * Zero Time
     */
    public static final String ZERO_TIME = "T00:00:00Z";
    /**
     * Milli seconds in a day
     */
    public static final long DAY_IN_MILLIS =  86400000;
    /**
     * Facebook GitHub owner
     */
    public static final String FACEBOOK_GH_OWNER = "facebook";
    /**
     * OSQUERY GitHub repository
     */
    public static final String OSQUERY_GH_REPOSITORY = "osquery";
    /**
     * Failure exit code
     */
    public static final int FAILURE_EXIT_CODE = 1;
}
