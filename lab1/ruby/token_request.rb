require 'net/http'
require 'json'
require 'logger'

require '../../credentials/ruby/credentials'

module Lab1
  class TokenRequest

    @@logger = Logger.new(STDOUT)

    def logger
      @@logger
    end

    def initialize(clientId, clientSecret)

      # perform your instance initialization here

    end

    def request

      # insert your code here to perform a HTTP POST to the token server URL
      #
      # take a look at the provided Credentials class (with require statement above)
      # to see the credentials and server URLs that are provided. you can find the class
      # source file in the top level credentials directory.
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
