require 'spec_helper'

require 'net/http'

describe Lab4::TokenRequest do

  it "requests an access token from the token server via HTTPS" do

    token_request = Lab4::TokenRequest.new(CLIENT_ID, CLIENT_SECRET)
    response = token_request.request

    expect(response).to_not be_nil
    expect(response).to be_a(Net::HTTPSuccess)

  end

  it "requests an access token from the token server via HTTPS and parses the JSON response to get the access token" do

    token_request = Lab4::TokenRequest.new(CLIENT_ID, CLIENT_SECRET)
    response = token_request.request

    expect(response).to_not be_nil
    expect(response).to be_a(Net::HTTPSuccess)

    access_token = token_request.parse_response(response.body)
    
    expect(access_token).to_not be_nil
    expect(access_token).to be_a(String)

  end

end
