require 'spec_helper'

require 'net/http'

describe Lab1::LiveStreamConnection do

  it "requests an access token, connects to the live stream endpoint, and streams messages to stdout" do

    token_request = Lab1::TokenRequest.new(CLIENT_ID, CLIENT_SECRET)
    response = token_request.request

    expect(response).to_not be_nil
    expect(response).to be_a(Net::HTTPSuccess)

    access_token = token_request.parse_response(response.body)
    
    expect(access_token).to_not be_nil
    expect(access_token).to be_a(String)

    connection = Lab1::LiveStreamConnection.new(LIVE_STREAM_ENDPOINT, access_token)
    connection.open
  end

end
