# HiVolts

This app is a game where one tries to avoid enemies (called Mho's) by moving on a grid and avoiding electric fences.

### Controls

W - up

X - down

A - left

D - right

Q - up and to the left

E - up and to the right

Z - down and to the left

C - down and to the right

S - stay where you are

J - jump to a random square

### Errors

Currently unsure if the npc movement is correct (regarding diagonals vs minimizing longest distance)

### Code Overview

Main.Java

	- Controls movement via keyboard

	- Makes instance of GameFrame.java

GameFrame.java

	- Draws char, mhos, and fences redrawing after every move

	- Calculates score and whether player is winning or not

Npc.java

	- Controls mho movements

### Major Challenges

One major challenge I came across was generalizing the mho code. With help from Joshua, I managed to find a way to procedurally generate mhos and calculate their moves in order using for loops.

### Acknowledgments

* [@Ivory Tang](mailto:ivoryttang@gmail.com) - helped with npc movement functions and GameFrame
* [@Josh Athyde](https://github.com/jathayde314) - wrote the npc movement functions and helped with GameFrame
* [@Jasmine Kapadia](https://github.com/jk26966) - worked on sprites and checked other code
