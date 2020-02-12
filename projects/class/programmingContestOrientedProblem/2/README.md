# Another Programming Contest Oriented Problem

## Prompt:

You are given K sorted arrays, and the sum of the sizes of the arrays is N. Your task is to merge these arrays into one common array that is also sorted.

####Input Format:
The first line will contain integers N, where 1 <= N <= 2*10^5, and K, where 1 <= K <= N.
The next K lines will contain an integer s followed by s integers representing an array of size s

Sample Input:\
`10 3`\
`2 1 7`\
`5 2 3 8 9 10`\
`3 4 5 6`

####Output format: 
N integers in sorted order

Sample Output:\
`1 2 3 4 5 6 7 8 9 10`

####Test Cases:
https://drive.google.com/drive/folders/1KFJDp7NWysvWlxXPb5wpfo6iUkEWWNXm

## Project Description:

I read the input with a scanner, processed it into an ArrayList of Integer ArrayLists called input and merged these ArrayLists in linear time. I then printed the merged arrays.

There was also a version where I used a stalin-sort-esque solution by deleting any values that were out of order.

### Errors

No errors that I could find. Worked for the 8 given test cases.

### Code Overview

PcopTwo.Java

    - Finds input file
    - Reads input file
    - Stores read values in ArrayList of Integer ArrayLists called input
    - Removes unwanted values from input (first number of each ArrayList and first ArrayList)
    - Goes through ArrayLists in input and merges them in linear time
    - Prints the output in a readable output

### Major Challenges

One major challenge I came across was trying to get the time complexity to O(N*ln(K)).