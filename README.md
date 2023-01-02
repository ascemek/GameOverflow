# GameOverflow
GameOverflow Object Oriented Design (OOD) Final Project

## Authors

Contributors' names and contact info:

* [Sami Cemek](https://github.com/ascemek) 
* [Zach East](https://github.com/ZiongaB)
* [Sebastian Mark](https://github.com/SebastianMark32)

[Live Demo & Presentation](https://drive.google.com/file/d/17_Ne7JDdNLrVaTEhMLxoVUiNXbY4AZdW/view?usp=sharing) 

## Description

To start the game selection, go to the Demo class and compile the code. First, a prompt will appear in the console saying "Enter 
a username:" Another prompt will appear after entering a username with a choice of games. Please select one of three games by 
entering 1,2,3. Once the any games done, and the leaderboard is updated, the menu repeats the original prompt. This allows you to 
try multilpe games and multiple different users.

If the user decides to enter 1, then the game Punch-Out will be selected. Then the user will be playing against an NPC by blocking,
punching, or using a special attack. The user will have to type each move in the command window. Once the game results in a win or
lose, the score will be sent to the leaderboard and a text file called punchoutScored.txt which will display the current score of 
the user. 

If the user decides to enter 2, then the Pokémon game will be executed. The user will be provided with instruction before playing 
the game. The player will have a chance to roll a die. For example, if the die lands on 1 then the player will have an increased 
attack. The NPC will also roll the die randomly. Each roll of the die is at random, meanwhile the player and NPC will alternate 
turns by attacking each other. At the end of the game the current score of the user will be printed to a text file 
pokemonScores.txt

Lastly, if the user decides to enter 3, the hangman word game will be executed. At the start of the game the user will be provided 
with a set of instructions that will explain the details of the game. Meanwhile, the user will have a choice of playing one or two 
players. If the selection one is made, then a random word from the database will be drawn. For each turn there will be two entries, 
one to guess the letter and one to guess the word. If the user guesses the word, they automatically win the game, while having the 
option of replaying. A total of 9 attempts are given to guess/figure out the word. If the user decides to select two players, then 
player one will enter a word say "tacocat", then player two will have to guess the word that player one entered. After each game, 
the score will be added to the leaderboard and printed to a text file called hangmanScore.txt.

Some potential issues may arise since each person uses different IDE's and operating systems. In the hangman game, the user might 
have the change the file path since the hangman class is reading from the alternativeWords.txt file.
We had some issues with the Game class, while testing the games. Implementation of the Game class, didn't work at some points with 
the Pokemon class. We are addressing that issue.
 

Have fun and enjoy the games!

## License

This project is licensed under the MIT License - see the LICENSE.md file for details

