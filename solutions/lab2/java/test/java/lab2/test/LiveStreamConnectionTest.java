package lab2.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lab2.TokenRequest;
import lab2.LiveStreamConnection;

public class LiveStreamConnectionTest
{
  final Logger log = LoggerFactory.getLogger(LiveStreamConnectionTest.class);

  protected static final String CLIENT_ID = "356e592973-summitlab";
  protected static final String CLIENT_SECRET = "2f0bfb2dba04bf30d714";
  protected static final String LIVE_STREAM_ENDPOINT = "https://sjo.livestream.adobe.net/api/1/stream/dt-lab-prime";

  @BeforeClass
  public static void setUp()
  throws Exception
  {
  }

  @AfterClass
  public static void tearDown()
  throws Exception
  {
  }

  @Test
  public void testLiveStreamConnection()
  throws Exception
  {
    TokenRequest request = new TokenRequest(CLIENT_ID, CLIENT_SECRET);
    String response = request.request();
    assertNotNull(response);
    log.info("response is:\n"+response);
    String accessToken = request.parseResponse(response);
    assertNotNull(response);
    log.info("access_token is: "+accessToken);

    LiveStreamConnection connection = new LiveStreamConnection(LIVE_STREAM_ENDPOINT, accessToken);
    connection.open();
  }
}
