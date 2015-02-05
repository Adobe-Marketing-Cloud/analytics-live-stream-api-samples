require 'net/http'
require 'json'
require 'logger'

require "../../../credentials/ruby/credentials"

module Lab1
  class TokenRequest

    @@logger = Logger.new(STDOUT)

    def logger
      @@logger
    end

    def initialize(clientId, clientSecret)
      @clientId = clientId
      @clientSecret = clientSecret
    end

    def request
      logger.debug "initiating request for token"

      uri = URI(Lab::Credentials.new.token_server_url)

      params = Hash.new
      params['grant_type'] = "client_credentials"

      req = Net::HTTP::Post.new(uri)
      req.basic_auth @clientId, @clientSecret
      req.set_form_data params

      response = Net::HTTP.start(uri.hostname, uri.port, use_ssl: true) { |http| http.request(req) }

      logger.debug "HTTP response code #{response.code}"
      logger.info response.body
      return response
    end

    def parse_response(response)
      response_json = JSON.parse(response)
      access_token = response_json['access_token']
      logger.debug "access token: #{access_token}"
      return access_token
    end

  end
end
