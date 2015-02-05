module Lab
  class Credentials

    attr_reader :client_id
    attr_reader :client_secret
    attr_reader :token_server_url
    attr_reader :livestream_endpoint_url

    def initialize
      @client_id = "356e592973-summitlab"
      @client_secret = "2f0bfb2dba04bf30d714"
      @token_server_url = "https://api.omniture.com/token"
      @livestream_endpoint_url = "https://sjo.livestream.adobe.net/api/1/stream/dt-lab-prime"
    end

  end
end
