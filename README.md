# unique-number-challenge

Unique number challenge
 -  Given a list of numbers, find the 2 numbers whose sum equals 2020.
Once you have the numbers, print the product of the 2 numbers on screen.
 -  Extend the program to find 3
numbers that sum up to 2020 and print the product of these 3 numbers.
 -  In either cases, if there are no numbers that sum up to 2020, then the answer
should be 0.

Input file is in resources.
If you want to test with another input replace the content of the json file `mer_unc_input.json` with new input respecting the json format.

* sum of 2 use:  `http://localhost:8081/generate-unique-number?parts=2`
* sum of 3 use:  `http://localhost:8081/generate-unique-number?parts=3`

##To start the project:
Run the following command in the root project:

`mvn install`

Start the Spring boot application:

`java -jar target/UniqueNumberChallenge-0.0.1-SNAPSHOT.jar`

In another terminal window run the following curl commands:

* `curl --request GET http://localhost:8081/generate-unique-number?parts=2`
    * expected result: `{"uniqueNumber":8614}`

* `curl --request GET http://localhost:8081/generate-unique-number?parts=3`
  * expected result: `{"uniqueNumber":303394260}`
