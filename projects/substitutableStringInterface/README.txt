# Substitutable String Interface

When run, this program asks which function should be run. Once a function has been selected, the necessary arguments are collected. When the arguments are done being collected, either extractFirstParen() or substituteAll() is run.

### Errors

extractFirstParen(): no errors so far
	Edge cases:
		)((he(he(hello)he()))((( -> hello
		)((he(he(hello(he()))((( ->
		)()()()())()()() ->
		()hello ->
		hello() ->

substituteAll(): no errors so far
	Edge cases:
		"helldog, dog" -> 'dog' -> 'cat' -> "hellcat, cat"
		"dog" -> 'dog' -> 'superdog' -> "superdog"

### Code Overview

Main.java basically just creates an instance of Interface.java, asks for inputs, and runs the selected function.
Interface.java:
	extractFirstParen() takes an input string and uses a for loop to record position of every '(' it sees before it sees a ')' at which point it stops and, using another for loop, sets retval to the characters between the parentheses.
	substituteAll() goes through the first string and checks to see if any chars match the char of the second string. If they do, a for loop is used to check if the second string is contained int the first. If it is, same is set to true meaning the original for loop skips b.length() increments and the third string is added to retval. If same = false, the charAt(i) is added to retval. This process repeats for the entire string.

### Major Challenges

Finding a way to replace b with c without just replacing the first char of b. (eg: if dog->cat then dog becomes catog)

### Acknowledgments

Did by self

## Built With

Atom (ide)
java
