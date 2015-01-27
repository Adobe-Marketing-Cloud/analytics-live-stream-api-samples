package lab1.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lab1.TokenRequest;

public class TokenRequestTest
{
  final Logger log = LoggerFactory.getLogger(TokenRequestTest.class);

  protected static final String CLIENT_ID = "356e592973-summitlab";
  protected static final String CLIENT_SECRET = "2f0bfb2dba04bf30d714";

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
  public void testRequest()
  throws Exception
  {
    TokenRequest request = new TokenRequest(CLIENT_ID, CLIENT_SECRET);
    String response = request.request();
    assertNotNull(response);
    log.info("response is:\n"+response);
  }
  
  @Test
  public void testParseResponse()
  throws Exception
  {
    TokenRequest request = new TokenRequest(CLIENT_ID, CLIENT_SECRET);
    String response = request.request();
    assertNotNull(response);
    log.info("response is:\n"+response);
    String accessToken = request.parseResponse(response);
    assertNotNull(response);
    log.info("access_token is: "+accessToken);
  }
}
