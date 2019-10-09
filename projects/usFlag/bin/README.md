# US Flag

When run, this project uses java's graphics functionality to draw an American flag with the proper specs as written on usflag.org.

### Errors

For a while, I was getting an error involving artifacting from the stripes (which I think was caused by the way I refreshed things when scaled). To fix this, I added black boxes around the flag (just right and bottom) on the top layer to cover the artifacts.

### Code Overview

Main.java basically just creates an instance of FlagFrame.java and makes it visible.

FlagFrame.java:

	after imports and class declarations, variables for color, number of points, etc... are declared (and sometimes given values)

	next, there is a function to be run when the FlagFrame is called from Main, it calls init()

	init() sets the window size, background color, scale factor (through calling updateFrameSize()), and adds a listener that calls updateFrameSize() when windos dimensions change

	updateFrameSize() picks the smaller of width or 1.6*height and sets the scale factor based on that
	starX() and starY() take center coordinates and output strings of x's and y's for the star drawing with fillPolygon()

	in paint() **for more in depth theory look at the plan**

		variables determining the sizing based off of scale factor as it relates to the diff dimensions (defined on usflag.org)

		stripes are drawn with a for loop for white, then red

		union is drawn on top of stripes

		stars are drawn on top of union

		black borders are drawn at top to fix errors

### Major Challenges

The biggest challenge for me was making the stars recursively using for loops because I had the wrong idea of how to approach it for a while. Instead of starting with the center and calculating points from there, I wanted to start with the topmost point and go around in a circle (which is really hard to pull off)

### Acknowledgments

Josh and Quintin both helped lead me (not tell me) towards the right way to approach the scaling and star building

## Built With

* [Standard Proportions For The United States Flag](http://www.usflag.org/flag.specs.html)
* [Creating a Normal Star in Adobe Illustrator, American Flag Style](http://johnbhall.com/post-assets/illustrator-star/radii.jpg) - proportions of a normal 5-pointed star
