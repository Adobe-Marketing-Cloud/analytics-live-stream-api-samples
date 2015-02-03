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
      visits = {}
      finished = false

      begin
	Net::HTTP.start(uri.hostname, uri.port, use_ssl: true) do |http|
	  http.request req do |response|
	    response.read_body do |chunk|
	      # the streaming response is chunked transfer encoding, so we
	      # need to read chunks and emit records separated by newlines.
	      # note that records may span chunks...so we need to read the
	      # chunks into buffers and emit records when we see newlines.
	      chunk.each_char do |c|
		if c == "\n" then
		  begin
		    record_json = JSON.parse(buffer)
		    visIdHigh = record_json['visIdHigh']
		    visIdLow = record_json['visIdLow']
		    visitorId = visIdHigh+visIdLow
		    visit = visits[visitorId]
		    (visit = visits[visitorId] = Array.new) if visit.nil?
		    visit << record_json
		  rescue StandardError => e
		    puts "error: #{e}"
		  end
		  buffer = ""
		else
		  buffer << c
		end
	      end
	      # check the time after each chunk is processed, emit stats after VISITOR_ID_SAMPLE_PERIOD_SECONDS seconds
	      now = Time.new.to_i
	      elapsed_time = now-start_time
	      if elapsed_time > VISITOR_ID_SAMPLE_PERIOD_SECONDS then
		puts "#{visits.size} unique visitors found in #{elapsed_time} seconds"
		longest_visit = 0
		visits.each { |visit| longest_visit = visit.size if visit.size > longest_visit }
		puts "longest visit currently #{longest_visit} records"
		longest_visit_count = 0
		visits.each { |visit| longest_visit_count += 1 if visit.size == longest_visit }
		puts "#{longest_visit_count} visits out of #{visits.size} visits contain #{longest_visit} records"
		http.finish
		finished = true
		break
	      end
	    end
	  end
        end
	rescue StandardError => e
	  # suppresses errors raises by additional chunks arriving after termination of the connection
	  raise e if not finished
	end

    end
  end
end
