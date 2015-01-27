Lab 2 : Use your access token to open a connection to Live Stream and stream hit records
=================

For this lab, you will write code to do the following:

* Use your code or the solution from lab 1 to get an access token from the token API server.
* Open a HTTPS connection to the Live Stream API endpoint at *https://sjo.livestream.adobe.net/api/1/stream/dt-lab-STUDENT_NUMBER*, where your student number is the number on your name tag (e.g. student 01 would use *https://sjo.livestream.adobe.net/api/1/stream/dt-lab-01*).
* Perform a HTTP GET to this connection passing in the access token in a HTTP Authorization header using the "Bearer" keyword with the form:
```
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dSI6IjIwMTQtMDQtMDFcL2dhdGV3YXkuY2VyIn0[…]uw48OjseKCBaTwkMU2cJu1B5QrBg
```
* Read individual hit records from the HTTPS connection, and write them to stdout. Note that the response stream from Live Stream will be a GZIP-compressed stream, and the uncompressed contents of the compressed stream will be delivered using HTTP chunked transfer encoding. The chunks can be reassembled to form the stream of hit records in JSON format, separated by newlines. You can read about chunked transfer encoding here:
```
[![https://en.wikipedia.org/wiki/Chunked_transfer_encoding](https://en.wikipedia.org/wiki/Chunked_transfer_encoding)](https://en.wikipedia.org/wiki/Chunked_transfer_encoding)
```
* (Optional) Parse one of the hit records in the response into a JSON object, and calculate the "lag" - the difference, in seconds, between the event time of the hit record and the current time when you received the record. The JSON hit records contain a field named "receivedTimeGMT" that includes a timestamp in UNIX time format (a.k.a POSIX time or Epoch time)..

As before, you can choose to code in Java or Ruby. Feel free to use the skeletons or create your own directory structure - it's up to you. The solutions follow test driven development methodology and provide unit tests to test the goals for each coding exercise (hint: you should probably do this, too!).

Good luck! A working solution is available in [![solutions/lab2](../solutions/lab2)](../solutions/lab2)
