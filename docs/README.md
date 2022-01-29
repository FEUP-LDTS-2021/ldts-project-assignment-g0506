# LPOO_T5_G57 - OVERKILL

## Game Description

Monster Killer is a RPG where you have to kill monsters in order to level up, increasing your stats in the process, and proceed to the next stages.
Each stage is harder than the one preceded.

This project was developed by Alexandre Costa (up202005319@edu.fe.up.pt), Antonio Augusto (up202000705@edu.fe.up.pt) and Andre Silva (up2020@edu.fe.up.pt) for LDTS 2021⁄22.

## Implemented Features

- **Connected Menus** - The user has the capability of browsing through the different menus including in game ones. (Ex: Main Menu, Instructions, Play and Pause).
- **Buttons** - Functional and interactive buttons.
- **Keyboard control** - The mouse and keyboard inputs are received through the respective events and interpreted according to the current game state.
- **Player control** - The player may move with the keyboard control and shoot his gun when the left mouse button is pressed.
- **Collisions detection** - Collisions between different objects are verified. (Ex: Player, Bombs, Enemies, Obstacles).
- **Different stages** - 7 different levels with an increasing difficulty were implemented.
- **Saving the state of your game** - The player is able to save his current state and load it afterwards.

## Planned Features

All the planned features were successfully implemented.

## Design

### General Structure
#### Problem in Context:
The first concern of our project was how the structure would look like. Since our game is dealling with a GUI and is divided by different gameStates some specific patterns came to mind in order to fullfil our needs the best way possible.

#### The Pattern:
We implemented two patterns: Factory method for the GUI and 

#### Implementation:
Regarding the implementation, we now have classes which main purpose is to store data (model), classes that control the logic of the game (controllers) and classes that are responsible for the visual effects on the screen (viewers), these types of classes associate with each other in the following manner:

<p align="center" justify="center">
  <img src="images/UML/MVC.png"/>
</p>
<p align="center">
  <b><i>Fig 1. Model, Controller and Viewer pattern design</i></b>
</p>

As for the different states, they are divided with the same methodology as the mvc style, and permite the game to alter its behavior in a simple and efficient way.

#### Consequences:



### Different types of commands
#### **Problem in Context:**
In an initial and more simplified version of the current game, the diversity in between buttons was not significant. However, in the course of the development of the project, the number of buttons increased exponentially and the need to generalise the button element became more evident. That said and knowing that good software design is often based on the principle of separation of concerns, a major refactor had to be done.

#### The Pattern:
We have applied the **_Command_** also know as Action pattern. This pattern turns a request into a stand-alone object that contains all information about the request.

#### Implementation:
Regarding the implemetation process, all the Button classes were deleted and transformed into a single **Button** with a command attribute. These **commands**  implement the same interface having an execution method that takes no parameters. This interface lets you use various commands with the same request sender, without coupling it to concrete classes of commands. As a bonus, now you can switch command objects linked to the sender, effectively changing the sender’s behavior at runtime.

<p align="center" justify="center">
  <img src="images/UML/ButtonCommand.png"/>
</p>
<p align="center">
  <b><i>Fig 4. Buttons and commands</i></b>
</p>

These classes can be found in the following files:
- [Button](../src/main/java/com/g57/model/element/button/Button.java)
- [Command](../src/main/java/com/g57/model/item/command/Command.java)

#### Consequences:
The Command Pattern allows the following consequences:
- You can decouple classes that invoke operations from classes that perform these operations (SRP).
- You can implement undo/redo.
- You can assemble a set of simple commands into a complex one.
- The code may become more complicated since you’re introducing a whole new layer between senders and receivers.


### GUI
#### Problem in Context:
Aiming for a structured and unstable (easy to change) code, we tried to make it as general as possible. The lanterna library contains various functions that aren't useful to our program, Interface Segregation Principle violation, and lacks some other functions that our interface needs. Also, if using the raw library, our game (high level module) would be directly depending on a low level module. This is a violation of the Dependency Inversion Principle (DIP). A need to implement an interface that solves these problems was born.

#### The Pattern:
We have applied the **_Facade_** pattern. A facade provides a simple interface to a complex subsystem which contains lots of moving parts, allowing us to only include the features that really matter.

#### Implementation:
<p align="center" justify="center">
  <img src="images/UML/GUI.png"/>
</p>
<p align="center">
  <b><i>Fig 5. Observers and Listeners screenshot</i></b>
</p>

These classes can be found in the following files:
- [Game](../src/main/java/com/g57/Game.java)
- [GUI](../src/main/java/com/g57/gui/GUI.java)
- [LanternaGUI](../src/main/java/com/g57/gui/LanternaGUI.java)

#### Consequences:
The use of the Facade Pattern in the current design allows the following benefits:
- Isolate code from the complexity of a subsystem.
- Promotes testability and replaceability.
- Expand lanterna functionalities as well as respecting the Interface Segregation Principle.


## Known Code Smells And Refactoring Suggestions
#### **Large Class**
Some classes (e.g. Game, Battlefield, Player) contain many fields and others (e.g. GUI interface) contain many methods. In both cases, we find it justifiable as the classes require these fields, in one hand the Game class is the main class of the program and it needs to store a considerable amount of data, on the other hand various methods are needed for the interface and it wouldn't make sense to split it into two separate ones (extract method).

#### **Data Class**
All model classes are Data Classes, as they contain only fields, and no behavior (dumb classes). This is caused by the **MVC** (Model-View-Controller) architectural pattern which holds the responsibility to the controller to implement the logic functionalities of each model.
This is not a bad code smell because it only exits due to the chosen design pattern.

#### **Alternative classes with different interfaces and Lazy Classes**
When we conceived the project ideas, we aspired various enemy types with different behaviours. However, with the project development, we decided to generalize our **Enemy Class** and differenciate, the divergent characteristics, from contrasting enemies based on their fields. As this classes only differ in the values passed to the **Enemy Class** constructor and have no other significant functions they are an example of **Alternative Classes with different interfaces and Lazy Classes**.

#### **Refused bequest**
In an attempt to generalize and simplify our code, various abstract classes and interfaces were created. Nevertheless this resulted in the rising of the **Refused bequest** smell. As a result, some subclasses inherited methods from its parent classes which are neither defined nor used. For example, the [**SwapCommand Class**](../src/main/java/com/g57/model/item/command/SwapCommand.java#L31).

#### **Feature envy and message chains**
As the result of the **MVC** (Model-View-Controller) pattern some of the controllers use is narrowed to its model method calls. Our controller envies its model.
Also, in order to access a certain model's parameter it is mandatory to start by making a request to its controller.

## Testing

### Screenshot of coverage report
<p align="center" justify="center">
  <img src="images/screenshots/codeCoverage"/>
</p>
<p align="center">
  <b><i>Fig 6. Code coverage screenshot</i></b>
</p>

### Link to mutation testing report
[Mutation tests](../build/reports/pitest/202105302045/index.html)

## Self-evaluation

The work was divided in a mutual way and we all contributed with our best. It helped us to enrich our java and principle/pattern knwoledge, as well as our team work.

- Ana Beatriz Aguiar: 33.3%
- João Marinho: 33.3%
- Tiago Silva: 33.3%
