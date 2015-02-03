require 'net/http'
require 'logger'
require 'json'

module Lab4
  class LiveStreamConnection

    @@logger = Logger.new(STDOUT)

    def logger
      @@logger
    end

    VISITOR_ID_SAMPLE_PERIOD_SECONDS = 90

    def initialize(endpoint_url, access_token)
    end

    def open
      # Use your code or the solution from lab3 to open the connection.
      # Then, extract the visitor ID from each hit record by taking the visIdHigh and
      # visIdLow fields from the record and combining them (you can concatenate them 
      # as strings). Store these visitor IDs in a data structure and maintain a count of
      # how many times each visitor ID is presented. Do this for at least 90 seconds.
      # Optionally, calculate the average number of hit records per visit, and determine
      # how many visits contain exactly the average number of hit records.
    end
  end
end
