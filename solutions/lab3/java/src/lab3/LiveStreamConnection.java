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
    this.endpointUrl = endpointUrl;
    this.accessToken = accessToken;
  }

  public void open() throws IOException {
    log.debug("opening live stream connection to " + this.endpointUrl);
    URL url = new URL(this.endpointUrl);
    HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
    connection.setReadTimeout(10000);
    connection.setConnectTimeout(10000);
    connection.setRequestProperty("Authorization", "Bearer " + this.accessToken);
    connection.setRequestProperty("Accept-Encoding", "gzip");
    connection.setRequestMethod("GET");

    log.debug("HTTP response code "+connection.getResponseCode());

    if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
      throw new IOException(connection.getResponseMessage() + " (" + connection.getResponseCode() + ")");
    }

    InputStream inputStream = new GZIPInputStream(connection.getInputStream());
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    long start_time = System.currentTimeMillis() / 1000; // now should be in seconds
    int records_received = 0;
    int bytes_received = 0;

    String line;
    while ((line = reader.readLine()) != null) {
      if (line.length() > 0) {
	records_received += 1;
	bytes_received += line.length();
      }
      long now = System.currentTimeMillis() / 1000; // now should be in seconds
      long elapsed_time = now-start_time;
      if (elapsed_time > STREAM_RATE_SAMPLE_PERIOD_SECONDS) {
	float stream_rate = (float)records_received / (float)elapsed_time;
	float transfer_rate = (float)bytes_received / (float)elapsed_time / (float)1024.0;
	System.out.println("stream rate calculated: "+stream_rate+" records/second, read "+records_received+" records in "+elapsed_time+" seconds");
	System.out.println("transfer rate calculated: "+transfer_rate+" kb/second, read "+bytes_received+" bytes in "+elapsed_time+" seconds");
	System.out.println("-------------------------------------");
      }
    }
  }
}
