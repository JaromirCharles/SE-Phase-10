htwg-scala-seed
=========================

This is a seed project to create a basic scala project as used in the
class Software Engineering at the University of Applied Science HTWG Konstanz

* Has a folder structure prepared for a MVC-style application
* Has *ScalaTest* and *ScalaMock* at their latest versions as dependencies.
* Has *sbt-scalariform*, *sbt-scapegoat*, *scalastyle-sbt-plugin* and *sbt-scoverage* sbt plugins
* Has .gitignore defaults
=======
# SE-Phase-10
Implementation of the game 'Phase-10' in scala

Setting up GitHub
>>>>>>> branch 'master' of https://github.com/JaromirCharles/SE-Phase-10.git 

## Setup
* Clone the project from GitHub
* Add project to your workspace
* run *sbt eclipse* in bash which will create the necessary Eclipse project files in order for the program to run
* run *phase10.scala* to start playing

## Introduction on how to play
* Hit *Start New Game* and create players (2-4)
* Each player receives 10 cards to start with
* Player must then either take a card from the deck or from the stack
* He can then try to move a phase by completing the requirements (if he holds the necessary cards) or block a player
* Player ends his turn by laying a card onto the stack

## Goal of the game
* First player to finish all 10 Phases has won!
