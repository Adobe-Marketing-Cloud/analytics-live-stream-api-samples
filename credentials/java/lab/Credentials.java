package lab;

public class Credentials {

  protected String clientId;
  protected String clientSecret;
  protected String tokenServerUrl;
  protected String livestreamEndpointUrl;

  public Credentials() {
    this.clientId = "356e592973-summitlab";
    this.clientSecret = "2f0bfb2dba04bf30d714";
    this.tokenServerUrl = "https://api.omniture.com/token";
    this.livestreamEndpointUrl = "https://sjo.livestream.adobe.net/api/1/stream/dt-lab-prime";
  }

  public String getClientId() { return this.clientId; }
  public String getClientSecret() { return this.clientSecret; }
  public String getTokenServerUrl() { return this.tokenServerUrl; }
  public String getLivestreamEndpointUrl() { return this.livestreamEndpointUrl; }
}
