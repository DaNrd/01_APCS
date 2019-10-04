# Exponentiation

This project takes a base in the form of a double and a power in the form of an integer and completes the exponentiation using a recursive function.

### Errors

At first I was getting an error for odd exponents but that was fixed by multiplying the answer by 3 again.
Test Cases:
	✓ 0.5^2
	✓ 3^7
	✓ 0.4173^2
Still thinking about how to approach decimal exponents.

### Code Overview

All of the code is located in Exponentiation.java Which has a main function that collects the values of the base and power. They are then sent to a function called calcPower() which runs recursively calculating the proper power. Finally, the code prints out the answer as a mathematical sentence.

### Major Challenges

Decimal exponents - still a WIP
How to treat odd exponents - solved (multiply the base by base^2((power-1)/2))

## Built With

* [Exponentiation by Squaring](https://en.wikipedia.org/wiki/Exponentiation_by_squaring#Basic_method) - explanation of squaring used to check my thought process
