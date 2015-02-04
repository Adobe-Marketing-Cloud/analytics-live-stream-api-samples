Lab 4 : Open a connection to Live Stream and count unique visitor IDs
=================

For this lab, you will write code to do the following:

* Use your code or the solution from lab 3 to get an access token from the token API server and connection to the Live Stream API endpoint.
* Read individual hit records from the Live Stream connection and extract the visitor ID from each hit record by taking the visIdHigh and visIdLow fields from the record and combining them (you can concatenate them as strings).
* Store these visitor IDs in a data structure of your choice and maintain a count of how many times each visitor ID is presented.
* Do this for at least 90 seconds, and then output the number of unique visitor IDs that have been presented.
* (Optional) Calculate the average number of hit records per visit, and determine how many visits contain exactly the average number of hit records to characterize the distribution.

As before, you can choose to code in Java or Ruby. Feel free to use the skeletons or create your own directory structure - it's up to you. The solutions follow test driven development methodology and provide unit tests to test the goals for each coding exercise (hint: you should probably do this, too!).

Good luck! A working solution is available in [![solutions/lab4](../solutions/lab4)](../solutions/lab4)
