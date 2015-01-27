require 'net/http'
require 'logger'

module Lab1
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

  end
end
