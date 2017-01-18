Documentation
=========================

## Purpose of the project
* The aim of the project is to learn the basic concepts of Software Engineering. It gives an insight and understanding on:
	* Version control
	* Test Driven Deployment
	* Design patterns
	* Dependency Injection
	* and much more **...**

#### Project contributers
* Jaromir Charles, Maximilian Dauner

#### Referenced documents/material
* Lecture slides from Herr Boger
* World Wide Web

## Users of the project 
The authors and anyone interested in playing a desktop version of the game **Phase10**

###### How to download
* Clone the project from GitHub

###### How to install/Setup
* Add project to your Eclipse workspace
* run **sbt eclipse** in bash which will create the necessary Eclipse project files in order for the program to run

###### How to run
* Run the scala class **phase10.scala** to execute

###### Introduction on how to play
* Hit **Start New Game** and create players (2-4)
* Each player receives 10 cards to start with
* Player must then either take a card from the deck or from the stack
* He can then try to move a phase by completing the requirements (if he holds the necessary cards) or block a player
* Player ends his turn by laying a card onto the stack

###### Goal of the game
* First player to finish all 10 Phases has won!

## Project development over time
* The project was written in the programming language *scala* in the Eclipse IDE for scala
* scrumwise (web based tool) was used to set Sprints *(tasks we would like to accomplish in x amount of hours)* and to
also keep track of project development via Burndown charts. 
* The MVC architecture was used to implement the project:
	* Model layer was implemented to provide the ground work of the project and to maintain data
	* Controller layer controlls the actions between the model and the view
	* View layer to display the workings of the project to the user
* Tests were continuously written in order to ensure that the code runs smoothly without problems. 


## Problems

## Ways to improve the project
* Add a sort function to sort the cards in ascending order when player is attempting a phase
* Fix GUI layout so that the windows do not overlap one another
* Display an overview of everyones' phase
* Add an Undo-Function
* One should be able to save the current state of the game and and restart game from that state

## User Interface Design
* Both a TUI and a GUI was designed for this project. They were designed to run parallel
