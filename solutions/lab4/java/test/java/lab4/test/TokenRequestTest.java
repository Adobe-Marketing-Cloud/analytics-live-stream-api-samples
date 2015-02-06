package lab4.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lab4.TokenRequest;

import lab.Credentials;

public class TokenRequestTest
{
  final Logger log = LoggerFactory.getLogger(TokenRequestTest.class);

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
    Credentials credentials = new Credentials();
    TokenRequest request = new TokenRequest(credentials.getClientId(), credentials.getClientSecret());
    String response = request.request();
    assertNotNull(response);
    log.info("response is:\n"+response);
  }
  
  @Test
  public void testParseResponse()
  throws Exception
  {
    Credentials credentials = new Credentials();
    TokenRequest request = new TokenRequest(credentials.getClientId(), credentials.getClientSecret());
    String response = request.request();
    assertNotNull(response);
    log.info("response is:\n"+response);
    String accessToken = request.parseResponse(response);
    assertNotNull(response);
    log.info("access_token is: "+accessToken);
  }
}
