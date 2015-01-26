package lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import sun.misc.BASE64Encoder;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.List;

public class TokenRequest {

  public static final Logger log = LoggerFactory.getLogger(TokenRequest.class);

  protected static final String TOKEN_SERVER_URL = "https://api.omniture.com/token";

  protected String clientId;
  protected String clientSecret;

  public TokenRequest(String clientId, String clientSecret)
  {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  public String request() throws IOException {
    URL url = new URL(TOKEN_SERVER_URL);
    String postData = "grant_type=client_credentials";
    String basicAuth = this.clientId + ":" + this.clientSecret;
    HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
    connection.setReadTimeout(10000);
    connection.setConnectTimeout(10000);
    connection.setRequestProperty("Authorization", "Basic " + new BASE64Encoder().encode(basicAuth.getBytes()));
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    connection.setDoOutput(true);
    connection.getOutputStream().write(postData.getBytes());

    log.debug("HTTP response code "+connection.getResponseCode());

    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
      StringBuffer response = new StringBuffer();
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
      String line;
      while ((line = reader.readLine()) != null) {
	if (line.length() > 0) {
	  response.append(line);
	}
      }
      if (connection != null) {
	connection.disconnect();
      }
      return response.toString();
    }

    if (connection != null) {
      connection.disconnect();
    }
    throw new IOException("unexpected response from " + TOKEN_SERVER_URL + ":" + connection.getResponseCode() + ":" + connection.getResponseMessage());
  }

  public String parseResponse(String response) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> jsonModel = mapper.readValue(response, Map.class);
    String accessToken = (String)jsonModel.get("access_token");
    if (accessToken == null) {
      throw new IOException("access_token field not found in response body");
    }
    log.debug("access token: "+accessToken);
    return accessToken;
  }
}
