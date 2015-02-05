require 'spec_helper'

require 'net/http'

describe Lab2::LiveStreamConnection do

  it "requests an access token, connects to the live stream endpoint, and streams messages to stdout" do

    credentials = Lab::Credentials.new
    token_request = Lab2::TokenRequest.new(credentials.client_id, credentials.client_secret)
    response = token_request.request

    expect(response).to_not be_nil
    expect(response).to be_a(Net::HTTPSuccess)

    access_token = token_request.parse_response(response.body)

    expect(access_token).to_not be_nil
    expect(access_token).to be_a(String)

    connection = Lab2::LiveStreamConnection.new(credentials.livestream_endpoint_url, access_token)
    connection.open
  end

end
