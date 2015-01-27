package lab1.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lab1.TokenRequest;
import lab1.LiveStreamConnection;

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
    // # insert your test code here
  }
}
