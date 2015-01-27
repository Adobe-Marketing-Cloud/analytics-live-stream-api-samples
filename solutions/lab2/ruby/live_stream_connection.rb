require 'net/http'
require 'logger'

module Lab1
  class LiveStreamConnection

    @@logger = Logger.new(STDOUT)

    def logger
      @@logger
    end

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

      Net::HTTP.start(uri.hostname, uri.port, use_ssl: true) do |http|
	http.request req do |response|
	  response.read_body do |chunk|
	    # the streaming response is chunked transfer encoding, so we
	    # need to read chunks and emit records separated by newlines.
	    # note that records may span chunks...so we need to read the
	    # chunks into buffers and emit records when we see newlines.
            chunk.each_char do |c|
	      if c == "\n" then
		puts buffer
		puts "-------------------------------------"
		buffer = ""
	      else
		buffer << c
	      end
	    end
	  end
	end
      end
    end

  end
end
