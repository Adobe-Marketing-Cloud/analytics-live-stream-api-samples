require 'net/http'
require 'json'
require 'logger'

module Lab1
  class TokenRequest

    @@logger = Logger.new(STDOUT)

    def logger
      @@logger
    end

    TOKEN_SERVER_URL = "https://api.omniture.com/token"

    def initialize(clientId, clientSecret)

      # perform your instance initialization here

    end

    def request

      # insert your code here to perform a HTTP POST to the token server URL
      #
      # you will want to pass the client ID and client secret as the username and password
      # of HTTP basic auth credentials for the request, and you will want to pass a parameter
      # of "grant_type" = "client_credentials".
      #
      # I used Net::HTTP as the ruby HTTP client in the solution, but there are many others
      # and you are free to use any client you wish.
      #
      # Note also that the use of rspec for unit test cases and test driven development
      # has been set up in the spec directory. Feel free to use a different test framework
      # for your test cases if you wish.

    end

    def parse_response(response)

      # If you have time, you can implement this optional function to parse the JSON response
      # and extract the access token string.

    end

  end
end
