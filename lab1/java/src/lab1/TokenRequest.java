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

public class TokenRequest {

  public static final Logger log = LoggerFactory.getLogger(TokenRequest.class);

  protected static final String TOKEN_SERVER_URL = "https://api.omniture.com/token";

  protected String clientId;
  protected String clientSecret;

  public TokenRequest(String clientId, String clientSecret) {

    // perform your instance initialization here

  }

  public String request() throws IOException {

    // insert your code here to perform a HTTP POST to the token server URL
    //
    // you will want to pass the client ID and client secret as the username and password
    // of HTTP basic auth credentials for the request, and you will want to pass a parameter
    // of "grant_type" = "client_credentials".
    //
    // I used java.net.* as the java HTTP client in the solution, but there are many others
    // and you are free to use any client you wish.
    //
    // Note also that the use of junit for unit test cases and test driven development
    // has been set up in the test directory. Feel free to use a different test framework
    // for your test cases if you wish.

  }

  public String parseResponse(String response) throws IOException {

    // If you have time, you can implement this optional function to parse the JSON response
    // and extract the access token string.

  }
}
