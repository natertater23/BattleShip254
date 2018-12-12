# BattleShip254

CPSC 254 
Tues/Thurs 4:30

Anthony Cardenas - Code design and implimentation director / 
Justin Castillo - Code assist and documentation creator

Our project was used from an open source Java project found on Github. The original source code created a battleship game in the command prompt, and our new, updated version of it creates a gui interface for the game. 

To do this, we added a new class called GUI to the project files. This creates the pop-up window that contains a 10x10 grid for the game. Each grid slot is a button that can be pressed. This then sends the information to the Game class which calculates the moves from there. Along with this, all other classes were altered to work with the new GUI class as well.

For every button pressed, the program asks if it is a hit or miss. The result will either produce a picture of open sea (miss) or a ship getting hit (hit). The button pressed is then disabled, and the game continues until either the user or the computer player destroys all 5 enemy ships.

Version Control: GitHub.

CASE Tools: Eclipse along with WindowsBuilder



The MIT License (MIT)

Copyright (c) 2015 Yuval Marcus

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
