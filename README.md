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
