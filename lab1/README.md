Lab 1 : Get an Access Token With Code
=================

For this lab, you will write code that will connect to the token API server and request an access token using client credentials (a client ID and a client secret). 

You can choose to code in Java or Ruby. A skeleton devleopment directory for each language has been created for each lab, including build scripts and unit test support (JUnit for Java, RSpec for Ruby). Feel free to use the skeletons or create your own directory structure - it's up to you. The solutions follow test driven development methodology and provide unit tests to test the goals for each coding exercise (hint: you should probably do this, too!).

Your code should do the following:

* Open a HTTPS connection to the token API server at https://api.omniture.com/token
* Perform a HTTP POST to this connection using HTTP basic authentication using the client ID and client secret listed below as the username and password, and passing a single post parameter named "grant_type" with the value "client_credentials".
```
CLIENT_ID = "356e592973-summitlab"
CLIENT_SECRET = "2f0bfb2dba04bf30d714"
```
* Read the response from the token server, check the HTTP response code for success (200 OK), and output the response to stdout.
* (Optional) Parse the response into a JSON object, and extract the "access_token" field and output that string to stdout.

Good luck! A working solution is available in [![solutions/lab1](../solutions/lab1)](../solutions/lab1)
