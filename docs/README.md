# LDTS_G0506 - Monster Killer

## Game Description

Monster Killer is a RPG where you have to kill monsters in order to level up, increasing your stats in the process, and proceed to the next stages.
Each stage is harder than the one preceded.

This project was developed by Alexandre Costa (up202005319@edu.fe.up.pt), Antonio Augusto (up202000705@edu.fe.up.pt) and Andre Soares (up202004161@edu.fe.up.pt) for LDTS 2021⁄22.

## Implemented Features

- **Connected Menus** - The user has the capability of browsing through the different menus including in game ones. (Ex: Main Menu, Instructions, Play and Pause).
- **Buttons** - Functional and interactive buttons.
- **Keyboard control** - The mouse and keyboard inputs are received through the respective events and interpreted according to the current game state.
- **Player control** - The player may move with the keyboard control and swing his sword when the spacebar is pressed.
- **Collisions detection** - Collisions between different objects are verified. (Ex: Player, Bombs, Enemies, Obstacles).
- **Different stages** - 7 different levels with an increasing difficulty were implemented.
- **Saving the state of your game** - The player is able to save his current state and load it afterwards.
- **Level Up** - When the player kills a monster, he gains exp and when the player has enough hp, he levels up, increasing his stats. 
- **Monsters movement** - The monster moves independently of the player's input. When a monster is close enough to the player, it moves towards the player, otherwise he moves randomly. Also, when a monster is hit, he gets knocked back.  
- **Different monsters** - There are different types of monsters, each one with its stats. Stronger monsters will have more hp and deal more damage. The higher the stage, the higher the chance to spawn stronger monsters. There's also a special monster at the end of the game that always walks towards you and is very strong.

## Planned Features

- **Coins and Shops** - The user would be able to buy weapons with coins that would drop upon killing a monster. 

## Design

### Game Structure
#### Problem in Context:
The main problem was that we needed to control everything inside the game.

#### The Pattern:
We implemented the Model-View-Controller pattern. 

#### Implementation:
Regarding the implementation, we have 3 elements:
- **Model** - we have the class Game that serves as bridge between the input (Controller) and the output (View).
- **View** - we have the abstract class view that lets us draw the output. 
- **Controller** - we have the method GetProcessKey that reads the player's input.
#### Consequences:
We have the benefit of:
- being more efficient since the architecture of our program is divided into 3 components.
- being more organized for the same reason as before and so it is easier to find bugs.

### Different types of commands
#### **Problem in Context:**
Initially, we had to designate every action every time there was an input, which would be a bad practice. 

#### The Pattern:
We have applied the Action pattern. 

#### Implementation:
Regarding the implementation process, we used and enum to list the different possible actions and then created a method (GetKeyCommand) that associated every enum element with an input. 

####Consequences:
This allowed us to create an action pattern for every input and evade conflicts on input.

### GUI
#### Problem in Context:
The main problem was that we needed to draw different things independently.

#### The Pattern:
We implemented the Factory method.

#### Implementation:
Regarding the implementation, we have an interface (GUI) that is implemented by a class (Lanterna) that imports from the Lanterna framework. This way, we were able to create an abstract class (View) that lets its extended classes inherit the abstract method **draw** and so the screen is independent from the rest of the elements that need to be drawn.

#### Consequences:
We have the benefit of:
- being able to use the draw method in many occasions.
- read the player's input with the same design on the whole program.

## Known Code Smells And Refactoring Suggestions
#### **Long Method**
The method run method inside the class Game is too big and difficult to read, so we could use **Extract Method** to reduce the length of the method's body.  

#### **Duplicate Code** 
In our menus, we have similar code to select options that could be extracted using the **Extract Superclass**. 

#### **Switch Statements**
In our program we have some long switch statements, but we think they are necessary since there are many possible inputs.

## Testing

### Screenshot of coverage report

### Link to mutation testing report


## Self-evaluation

The work was divided in a mutual way, and we all contributed with our best.

- Alexandre Costa: 33.3%
- Antonio Augusto: 33.3%
- Andre Soares: 33.3%
