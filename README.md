# GameOfLife

## Synopsis

The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970. 
What's interesting, this "game" require zero player and only one, initial input. Later everything evolves, some cells are born, some are 
going to die. It's amazing to sit and watch, how tiny universe can change over time. 

## Rules

1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by over-population.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

## Program

Program has been developed in Eclispe IDE, so it uses Eclipse - based project. After cloning this repo all that is require to
use it is simply importing project. It is possible to use Eclipse to launch program, although creator of this program is using free
terminal Cmder (http://cmder.net/), which makes life much easier. Examples uses this terminal.

There are two ways of launching the program: 
- with no argument - allows to provide initial state by inputing (x,y) pairs (without brackets) of coordinates. To stop providing data,
type "ctrl + z".
```
C:\Users\xxx\workspace\GameOfLife\target\classes (master)
λ java GameOfLife
Enter input as pairs x and y (without brackets).
Press "ctrl+z" to stop setting preset cells.
3 3
4 4
5 5
3 4
5 6
6 6
^Z
x:(0, 9)
y:(0, 9)
 .  .  .  .  .  .  .  .  .
 .  .  .  .  .  .  .  .  .
 .  .  .  .  .  .  .  .  .
 .  .  .  O  O  .  .  .  .
 .  .  .  .  O  .  .  .  .
 .  .  .  .  .  O  O  .  .
 .  .  .  .  .  .  O  .  .
 .  .  .  .  .  .  .  .  .
 .  .  .  .  .  .  .  .  .

Press any key to progress one generation (q to exit)...
```
- with one argument, which must be valid filename to a file with specified (x,y) pairs (without brackets) of coordinates, which becomes 
initial state. If the filename leads to file that do not exists, exception is thrown. Right now program supports only one filename, 
providing more arguments will result in reading from standard inputm just like not providing argument at all.
```
C:\Users\xxx\workspace\GameOfLife\target\classes (master)
λ java GameOfLife ..\..\testData\testInteresting.txt
x:(-3, 12)
y:(-3, 12)
 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .
 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .
 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .
 .  .  .  O  .  .  .  .  .  .  .  .  .  .  .
 .  .  .  .  O  .  .  .  .  .  .  .  .  .  .
 .  .  .  .  .  O  .  .  .  .  .  .  .  .  .
 .  .  .  .  .  .  O  .  .  .  .  .  .  .  .
 .  .  .  .  .  .  .  O  .  .  .  .  .  .  .
 .  .  .  .  .  .  .  .  O  .  .  .  .  .  .
 .  .  .  .  .  .  .  .  .  O  O  .  .  .  .
 .  .  .  .  .  .  .  .  .  .  O  .  .  .  .
 .  .  .  .  .  .  .  .  .  .  .  O  .  .  .
 .  .  .  .  .  .  .  .  .  .  .  .  O  .  .
 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .
 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .

Press any key to progress one generation (q to exit)...
```
Example of sourcefile:
```
C:\Users\xxx\workspace\GameOfLife\testData (master)
λ cat testInteresting.txt
0 0
1 1
2 2
3 3
4 4
5 5
6 6
7 7
8 8
9 9
6 7
```
## Tests

There are 12 tests checking core functionality of the project. All passess.

## Bibliography
 - https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
