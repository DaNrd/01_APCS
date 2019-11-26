# Testing a Propositional Constant

	In TestPropositionConstant.java, a proposition constant is defined and then run through PropositionConstant.java to see if it is valid.

	In TruthAssignment.java, a logic statement is declared and the run through LogicalSentence.java to test if it is syntactically legal.

### Errors

	Test cases for TestPropositionalConstant:


	Test cases for TruthAssignment:


### Code Overview

	ProportionalConstant.java contains 2 methods. "name" takes no arguments and returns a string ("" by default), and "truthValue" takes no arguments and returns a boolean (true by default).

	TestProportionalConstant.java has a main method that creates a new instance of ProportionalConstant called ProportionalConstant01 and prints the name and truth value.

	TruthAssignment defines a logical statement in the form of a string which is sent to LogicalSentence for a syntax check. If the sentence is legal, true is printed, else false is printed.

	LogicalSentence has a series of functions starting with IsLegal() and ending with LegalImplies() with LegalChar() and LegalLetter() called throughout. It tests the legality of the logical statement defined in TruthAssignment.

### Major Challenges

	I didn't know what a stub class was but figured it out. So many syntax errors... :(

### Acknowledgments

	Thanks to Ben for help with stub classes.

	Thanks to Quintin for a refresher on syntax.

	Thanks to Josh for test cases and checking my though process.

## Built With

	Java "regex" package - imported in LogicalSentence.Java
