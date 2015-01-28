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
      @endpoint_url = endpoint_url
      @access_token = access_token
    end

    def open
      logger.debug "opening live stream connection to #{@endpoint_url}..."

      uri = URI(@endpoint_url)

      req = Net::HTTP::Get.new(uri)
      req['Authorization'] = "Bearer #{@access_token}"

      buffer = ""

      start_time = Time.new.to_i
      records_received = 0
      bytes_received = 0

      Net::HTTP.start(uri.hostname, uri.port, use_ssl: true) do |http|
	http.request req do |response|
	  response.read_body do |chunk|
	    # the streaming response is chunked transfer encoding, so we
	    # need to read chunks and emit records separated by newlines.
	    # note that records may span chunks...so we need to read the
	    # chunks into buffers and emit records when we see newlines.
	    chunk.each_char do |c|
	      if c == "\n" then
		records_received += 1
		bytes_received += buffer.size
		buffer = ""
	      else
		buffer << c
	      end
	    end
	    # check the time after each chunk is processed, emit stats after 60 seconds
	    now = Time.new.to_i
	    elapsed_time = now-start_time
	    if elapsed_time > STREAM_RATE_SAMPLE_PERIOD_SECONDS then
	      stream_rate = records_received.to_f / elapsed_time.to_f
	      transfer_rate = bytes_received.to_f / elapsed_time.to_f / 1024.0
	      puts "stream rate calculated: #{stream_rate} records/second, read #{records_received} records in #{elapsed_time} seconds"
	      puts "transfer rate calculated: #{transfer_rate} kb/second, read #{bytes_received} bytes in #{elapsed_time} seconds"
	      puts "-------------------------------------"
	    end
	  end
	end
      end
    end

  end
end
