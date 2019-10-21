# HiVolts

This app is a game where one tries to avoid enemies (called Mho's) by moving on a grid and avoiding electric fences. It was a team effort between [Ivory Tang](mailto:ivoryttang@gmail.com), [Josh Athayde](https://github.com/jathayde314), [Jasmine Kapadia](https://github.com/jk26966), and myself.

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



### Code Overview

Main.Java

	- Controls movement via keyboard (via GameFrame functions)

	- Makes instance of GameFrame.java

GameFrame.java

	- Draws char, mhos, and fences redrawing after every move

    - Implements most of player movement

	- Calculates score and checks whether player has won or died

Npc.java

	- Controls mho movements

	- Stores mho locations

### Major Challenges

One major challenge I came across was generalizing the mho code. With help from Joshua, I managed to find a way to procedurally generate mhos and calculate their moves in order using for loops.

### Acknowledgments

* [Ivory Tang](mailto:ivoryttang@gmail.com) - helped with npc movement functions and GameFrame
* [Josh Athayde](https://github.com/jathayde314) - wrote the npc movement functions and helped with GameFrame
* [Jasmine Kapadia](https://github.com/jk26966) - worked on sprites and checked other code
