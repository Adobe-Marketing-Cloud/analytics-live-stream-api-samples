package lab4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.util.zip.GZIPInputStream;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.ArrayList;

public class LiveStreamConnection {

  public static final Logger log = LoggerFactory.getLogger(LiveStreamConnection.class);

  public static final int VISITOR_ID_SAMPLE_PERIOD_SECONDS = 90;

  protected String endpointUrl;
  protected String accessToken;

  public LiveStreamConnection(String endpointUrl, String accessToken)
  {
  }

  public void open() throws IOException {
    // Use your code or the solution from lab3 to open the connection.
    // Then, extract the visitor ID from each hit record by taking the visIdHigh and
    // visIdLow fields from the record and combining them (you can concatenate them
    // as strings). Store these visitor IDs in a data structure and maintain a count of
    // how many times each visitor ID is presented. Do this for at least 90 seconds.
    // Optionally, calculate the average number of hit records per visit, and determine
    // how many visits contain exactly the average number of hit records.
  }
}
