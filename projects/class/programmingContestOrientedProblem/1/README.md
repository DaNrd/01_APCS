# A Programming Contest Oriented Problem

## Prompt:

You are given an array a of size n containing integers. You are given Q queries of the form (l, r) which ask for the average of the integers between indices l and r inclusive.

####Input Format:
The first line will consist of an integer n.

The following n lines will consist of integers.

The next line will consist of an integer q;

The following q lines will contain queries as stated above.

####Constraints:
1 <= n <= 2￿￿￿•10<sup>5</sup>

1 <= q <= 2￿￿￿•10<sup>5</sup>

1 <= l <= r <= n

1 <= a[i] <= 10<sup>6</sup>

####Output format:
Q integers separated by a new line containing the answers to the queries as described above. Print to 3 decimal places.

####Test Cases:
Test cases and their solutions can be found [here](https://github.com/DaNrd/01_APCSprojects/class/programmingContestOrientedProblem/1/testCases).

## Project Description:

I read the input with a scanner, processed it into an String array called input and put it through functions that prints the solutions.

### Errors

No errors that I could find. Worked for the 8 given test cases. (6/8 complete in less than 4 seconds)

### Code Overview

Main.Java

    - Creates instance of reader
    
    - calls processInput;

Reader.java

	- collects file path and prints solutions

### Major Challenges

One major challenge I came across was avoiding the temptation of ArrayLists (which we were not allowed to use). I initially wrote the code using ArrayLists and then went back and replaced them all with arrays.