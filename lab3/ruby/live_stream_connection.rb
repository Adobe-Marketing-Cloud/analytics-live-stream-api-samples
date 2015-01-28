require 'net/http'
require 'logger'
require 'json'

module Lab3
  class LiveStreamConnection

    @@logger = Logger.new(STDOUT)

    def logger
      @@logger
    end

    STREAM_RATE_SAMPLE_PERIOD_SECONDS = 60

    def initialize(endpoint_url, access_token)
    end

    def open
      # Use your code or the solution from lab2 to open the connection.
      # Then, calculate the stream rate in records per second after counting
      # for at least 60 seconds. Optionally, you can also calculate the
      # transfer rate in kbytes per seconds.
    end

  end
end
