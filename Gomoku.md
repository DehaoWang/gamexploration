**It is the darKnight that deserves more, rather than the cycle in front.**
# Gomoku
![MacDown logo](https://www.htmlgames.com/uploaded/thumb/gomoku300.jpg)

##Rule
>Gomoku, also called Gobang or Five in a Row, is an abstract strategy board game. It is traditionally played with Go pieces (black and white stones) on a Go board, using 15×15 of the 19×19 grid intersections. Because pieces are not moved or removed from the board, Gomoku may also be played as a paper and pencil game. The game is known in several countries under different names.

>Players alternate turns placing a stone of their color on an empty intersection. The winner is the first player to form an unbroken chain of five stones horizontally, vertically, or diagonally.

Cited from [Gomoku in wikipedia](https://en.wikipedia.org/wiki/Gomoku)  
## Architecture
The introduction will be illustrated in following architecture:  
* General Design  
* System Design  
* AI Design
 
### General Design

* Availability	[system on operation with out any bug]  
* Minimization	[no need for GUI,focused on algorithm]

### System Design  

* Players take turns to move  
* Validate on 4 directions(0,45,90,135)
* Design models that work well independently and interactively

### AI Design
* All AIs should be able to move based on the board, so inheritance can be introduced    
* The board can be viewed from 4 directions(0,90,180,270), on consideration of efficiency  
* AI level design
	* level 1 AI: make random moves
	* level 2 AI: make moves based on strategies
	* level 3 AI: alpha-beta pruning & reinforcement learning