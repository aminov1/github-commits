package amin.GitHubCommits;

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
    public static final int UNLIMITED_OUTPUT = 0;

    //###################################################################################
    //#####################                   URLs                #######################
    //###################################################################################
    /**
     * Internal base URL
     */
    public static final String INT_SERVER_URL = "https://agilemanager-int.saas.hp.com";


    //###################################################################################
    //####################                   Errors                ######################
    //###################################################################################
    /**
     * Invalid number of days (For values < 0)
     */
    public static final String INVALID_NUM_OF_DAYS = "Error: The provided days limit is invalid!";
    /**
     * Invalid file path
     */
    public static final String INVALID_FILE_PATH = "Error: The provided path is invalid!";
    /**
     * Invalid properties file syntax
     */
    public static final String INVALID_PROPERTIES_SYNTAX = "Error: There is a problem with the properties file! " +
            "Please check the syntax of its values.";
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
    //####################                Spring Beans             ######################
    //###################################################################################
    /**
     * Bean of the Internal AGM farm
     */
    public static final String INTERNAL_BEAN = "agmIntClient";

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

    //###################################################################################
    //####################              GitHub JSON Keys           ######################
    //###################################################################################
    /**
     * ID of backlog item
     */
    public static final String BACKLOG_ID ="item_id";

    //###################################################################################
    //####################                    MISC                 ######################
    //###################################################################################
    /**
     * Proper number of fields in a backlog item
     */
    public static final int VALID_BL_JSON_LENGTH = 57;

}
