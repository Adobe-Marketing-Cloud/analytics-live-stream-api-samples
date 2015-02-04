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
    HashMap<String, ArrayList> visits = new HashMap<String, ArrayList>();

    String line;
    while ((line = reader.readLine()) != null) {
      if (line.length() > 0) {
	ObjectMapper mapper = new ObjectMapper();
	Map<String, Object> jsonModel = mapper.readValue(line, Map.class);
	Long visIdHigh = (Long)jsonModel.get("visIdHigh");
	Long visIdLow = (Long)jsonModel.get("visIdLow");
	System.out.println("visitorId: " + visIdHigh.toString() + ":" + visIdLow.toString());
	String visitorId = visIdHigh.toString() + visIdLow.toString();
	ArrayList visit = visits.get(visitorId);
	if (visit == null) {
	  visit = new ArrayList();
	  visits.put(visitorId, visit);
	}
	visit.add(jsonModel);
      }
      long now = System.currentTimeMillis() / 1000; // now should be in seconds
      long elapsed_time = now-start_time;
      if (elapsed_time > VISITOR_ID_SAMPLE_PERIOD_SECONDS) {
	System.out.println(visits.size() + " unique visitors found in " + elapsed_time + " seconds");
	int longest_visit = 0;
	for (Entry<String, ArrayList> entry : visits.entrySet()) {
	  ArrayList visit = entry.getValue();
	  if (visit.size() > longest_visit) {
	    longest_visit = visit.size();
	  }
	}
	System.out.println( "longest visit currently " + longest_visit + " records");
	int longest_visit_count = 0;
	for (Entry<String, ArrayList> entry : visits.entrySet()) {
	  ArrayList visit = entry.getValue();
	  if (visit.size() == longest_visit) {
	    longest_visit_count += 1;
	  }
	}
	System.out.println(longest_visit_count + " visits out of " + visits.size() + " visits contain " + longest_visit + " records");
	System.out.println("-------------------------------------");
	reader.close();
	return;
      }
    }
  }
}
