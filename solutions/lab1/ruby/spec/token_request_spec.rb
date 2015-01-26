require 'bundler/setup'
require 'net/http'

require './token_request'

CLIENT_ID = "356e592973-summitlab"
CLIENT_SECRET = "2f0bfb2dba04bf30d714"

describe Lab1::TokenRequest do

  it "requests an access token from the token server via HTTPS" do

    token_request = Lab1::TokenRequest.new(CLIENT_ID, CLIENT_SECRET)
    response = token_request.request

    expect(response).to_not be_nil
    expect(response).to be_a(Net::HTTPSuccess)

  end

  it "requests an access token from the token server via HTTPS and parses the JSON response to get the access token" do

    token_request = Lab1::TokenRequest.new(CLIENT_ID, CLIENT_SECRET)
    response = token_request.request

    expect(response).to_not be_nil
    expect(response).to be_a(Net::HTTPSuccess)

    access_token = token_request.parse_response(response.body)
    
    expect(access_token).to_not be_nil
    expect(access_token).to be_a(String)

  end

end
