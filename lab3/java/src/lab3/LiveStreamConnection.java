package lab3;

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

public class LiveStreamConnection {

  public static final Logger log = LoggerFactory.getLogger(LiveStreamConnection.class);

  public static final int STREAM_RATE_SAMPLE_PERIOD_SECONDS = 60;

  protected String endpointUrl;
  protected String accessToken;

  public LiveStreamConnection(String endpointUrl, String accessToken)
  {
  }

  public void open() throws IOException {
    // Use your code or the solution from lab2 to open the connection.
    // Then, calculate the stream rate in records per second after counting
    // for at least 60 seconds. Optionally, you can also calculate the
    // transfer rate in kbytes per seconds.
  }
}
