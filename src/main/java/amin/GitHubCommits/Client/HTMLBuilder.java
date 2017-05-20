package amin.GitHubCommits.Client;

import amin.GitHubCommits.Exception.GitHubCommitsException;
import amin.GitHubCommits.Objects.Consts;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class receives a list of GitHub commits of a certain repository and generates an HTML file that contains the
 * SHA, committer email, date and message of each commit.
 *
 * Created by habash on 19/05/2017.
 */
public class HTMLBuilder {

    /**
     * Output file error
     */
    private static final String OUTPUT_FILE_GENERAL_ERROR = "Error: An error occurred while creating the output file!";
    /**
     * Output file is a directory
     */
    private static final String OUTPUT_FILE_IS_DIRECTORY = "Error: The provided output file is a directory!";
    /**
     * Output file already exists
     */
    private static final String OUTPUT_FILE_EXISTS_ERROR = "Error: The provided output file already exists!";
    /**
     * Null or empty file path
     */
    public static final String OUTPUT_FILE_PATH_NULL_EMPTY = "Error: The provided path cannot be " +
            "null or empty!";
    /**
     * Invalid list of commits
     */
    private static final String INVALID_LIST_ERROR = "Error: Commits list provided for HTML file building " +
            "cannot be null or empty!";
    /**
     * JSON parsing error
     */
    private static final String JSON_PARSER_ERROR = "Error: Invalid JSON input syntax!";


    //###################################################################################
    //####################        For building the HTML code       ######################
    //###################################################################################

    private static final String BODY_OPEN_TAG = "<body>";
    private static final String BODY_CLOSE_TAG = "</body>";
    private static final String HTML_OPEN_TAG = "<html>";
    private static final String HTML_CLOSE_TAG = "</html>";
    private static final String TABLE_ELEMENTS_STYLE = "style=\"border-collapse: collapse; " +
            "border: 1px solid black; " +
            "padding: 5px;" +
            "text-align: center\"";
    private static final String TABLE_OPEN_TAG = "<table " + TABLE_ELEMENTS_STYLE +
            "width:100%; " +
            "align=center\">";
    private static final String TABLE_CLOSE_TAG = "</table>";
    private static final String TABLE_HEADER_OPEN_TAG = "<th " + TABLE_ELEMENTS_STYLE + ">";
    private static final String TABLE_HEADER_CLOSE_TAG = "</th>";
    private static final String TABLE_DATA_OPEN_TAG = "<td " + TABLE_ELEMENTS_STYLE + ">";
    private static final String TABLE_DATA_CLOSE_TAG = "</td>";
    private static final String ROW_OPEN_TAG = "<tr>";
    private static final String ROW_CLOSE_TAG = "</tr>";
    private static final String TABLE_HEADER_ROW = ROW_OPEN_TAG +
            TABLE_HEADER_OPEN_TAG + "SHA" + TABLE_HEADER_CLOSE_TAG +
            TABLE_HEADER_OPEN_TAG + "Committer Email" + TABLE_HEADER_CLOSE_TAG +
            TABLE_HEADER_OPEN_TAG + "Commit Date" + TABLE_HEADER_CLOSE_TAG +
            TABLE_HEADER_OPEN_TAG + "Commit Message" + TABLE_HEADER_CLOSE_TAG +
            ROW_CLOSE_TAG;

    /**
     * Receives a list of GitHub commits of a certain repository and generates an HTML file that contains the
     * SHA, committer email, date and message of each commit.
     *
     * @param commits the list of commits in JSON format
     * @param outputFile the path of the output file
     * @return The absolute path of the output file
     * @throws GitHubCommitsException in case of errors during parsing the commits json string or
     * during the creation of the output file.
     */
    public String buildHTMLFile(String commits, String outputFile) throws GitHubCommitsException {
        if(commits == null || "".equals(commits))
            throw new GitHubCommitsException(INVALID_LIST_ERROR);
        if(outputFile == null || "".equals(outputFile))
            throw new GitHubCommitsException(OUTPUT_FILE_PATH_NULL_EMPTY);

        JSONObject json;
        JSONArray array;
        StringBuffer html = new StringBuffer(
                BODY_OPEN_TAG +
                        HTML_OPEN_TAG +
                        TABLE_OPEN_TAG +
                        TABLE_HEADER_ROW);
        try {
            array = new JSONArray(commits);
            for(int i = 0; i < array.length(); i++) {
                json = array.getJSONObject(i);
                html.append(ROW_OPEN_TAG + TABLE_DATA_OPEN_TAG).append(json.getString(Consts.SHA)).append(TABLE_DATA_CLOSE_TAG)
                        .append(TABLE_DATA_OPEN_TAG).append(json.getJSONObject(Consts.COMMIT)
                        .getJSONObject(Consts.COMMITTER).getString(Consts.COMMITTER_EMAIL)).append(TABLE_DATA_CLOSE_TAG)
                        .append(TABLE_DATA_OPEN_TAG).append(json.getJSONObject(Consts.COMMIT)
                        .getJSONObject(Consts.COMMITTER).getString(Consts.COMMIT_DATE)).append(TABLE_DATA_CLOSE_TAG)
                        .append(TABLE_DATA_OPEN_TAG).append(json.getJSONObject(Consts.COMMIT)
                        .getString(Consts.COMMIT_MESSAGE)).append(TABLE_DATA_CLOSE_TAG + ROW_CLOSE_TAG);
            }
            html.append(TABLE_CLOSE_TAG +
                    HTML_CLOSE_TAG +
                    BODY_CLOSE_TAG);
            return generateHTMLFile(html.toString(), outputFile);
        } catch (JSONException e) {
            throw new GitHubCommitsException(JSON_PARSER_ERROR);
        }
    }

    /**
     * This method actually creates the file in the file system
     *
     * @param html
     * @param outputFile
     * @return
     * @throws GitHubCommitsException
     */
    private String generateHTMLFile(String html, String outputFile) throws GitHubCommitsException {

        File htmlFile = new File(outputFile);
        BufferedWriter buff = null;
        try {
            if(htmlFile.isDirectory())
                throw new GitHubCommitsException(OUTPUT_FILE_IS_DIRECTORY);
            if(!htmlFile.createNewFile())
                throw new GitHubCommitsException(OUTPUT_FILE_EXISTS_ERROR);
            buff = new BufferedWriter(new FileWriter(htmlFile));
            buff.write(html);
        } catch (IOException e) {
            throw new GitHubCommitsException(OUTPUT_FILE_GENERAL_ERROR + " " + e.getMessage());
        }
        finally {
            if(buff != null) {
                try {
                    buff.flush();
                    buff.close();
                } catch (IOException e) {
                    throw new GitHubCommitsException(OUTPUT_FILE_GENERAL_ERROR + " " + e.getMessage());
                }
            }
        }
        return htmlFile.getAbsolutePath();
    }
}
