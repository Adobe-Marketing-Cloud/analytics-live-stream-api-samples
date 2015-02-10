package lab2;

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

import lab.Credentials;

public class LiveStreamConnection {

  public static final Logger log = LoggerFactory.getLogger(LiveStreamConnection.class);

  protected String endpointUrl;
  protected String accessToken;

  public LiveStreamConnection(String endpointUrl, String accessToken)
  {
    // perform your instance initialization here
  }

  public void open() throws IOException {
    // insert your code here to connect to the live stream endpoint.
    // you will need to pass the access_token in a HTTP authorization header
    // that looks like this:
    //
    // Authorization: Bearer <hex access token string>
    // 
    // the streaming response is chunked transfer encoding, so we
    // need to read chunks and emit records separated by newlines.
    // note that records may span chunks...so we need to read the
    // chunks into buffers and emit records when we see newlines.
  }

  public void calculate_lag(String record) throws IOException {
    // you probably want a function like this to take a hit record in string format,
    // parse it into a JSON hash, extract the event timestamp from the receivedTimeGMT
    // field and calculate the difference between that timestamp and now.
  }
}
