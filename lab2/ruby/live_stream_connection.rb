require 'net/http'
require 'logger'

module Lab2
  class LiveStreamConnection

    @@logger = Logger.new(STDOUT)

    def logger
      @@logger
    end

    def initialize(endpoint_url, access_token)
       # perform your instance initialization here
    end

    def open
      # insert your code here to connect to the live stream endpoint.
      #
      # take a look at the provided Credentials class 
      # to see the credentials and server URLs that are provided.
      #
      # you will need to pass the access_token in a HTTP authorization header
      # that looks like this:
      #
      # Authorization: Bearer <hex access token string>
      #
      # the streaming response is chunked transfer encoding, so we
      # need to read chunks and emit records separated by newlines.
      # note that records may span chunks...so we need to read the
      # chunks into buffers and emit records when we see newlines.
    end

    def calculate_lag(record)
      # you probably want a function like this to take a hit record in string format,
      # parse it into a JSON hash, extract the event timestamp from the receivedTimeGMT
      # field and calculate the difference between that timestamp and now.
    end

  end
end
