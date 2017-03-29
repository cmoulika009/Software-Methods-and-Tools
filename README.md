# Software Methods and Tools

Software methods and tools are extensively used in current software production to improve software productivity and quality. In this course, we learnt a number of popular software methods and tools being used in academia or industry. These methods include object-oriented design and analysis, architecture styles, unit testing, and version control. The covered software tools include Microsoft Project, IBM Rational Modeler, Eclipse Plug-ins, ArchStudio, JUnit, Subversion, and GIT. We used these methods and tools to develop a software system, from initial planning to final deployment.

The tutorials of this course are in below link:

https://github.com/cmoulika009/Software-Methods-and-Tools/tree/master/SMT%20Tutorials

As part of this course we have developed project similar to <b>Snake Game</b> using Java

<b>Tools Used :</b> Eclipse, ArchStudio, Microsoft Project 2013, IBM Rational Software Modeler</b>

<h3>UML Diagrams</h3>

<h4><u>Class Diagram:</u></h4>
<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-2_UML%20Modelling-%20Class%20Diagram/ClassDiagram.JPG">

<h4><u>State Diagram:</u></h4>
<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-3_UML%20Modeling-Sequence%20%26%20State%20Diagram/StateDiagram_SnakeDiagram.JPG">

<h4><u>Sequence Diagram:</u></h4>
<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-3_UML%20Modeling-Sequence%20%26%20State%20Diagram/SeqSnake-1.JPG">
<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-3_UML%20Modeling-Sequence%20%26%20State%20Diagram/SeqSnake-2.JPG">
<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-3_UML%20Modeling-Sequence%20%26%20State%20Diagram/SeqSnake-3.JPG">

<h3>Java Application to Eclipse Plugin</h3>

The standalone Java Snake Game is converted to Eclipse Plugin using extension and extension points. I created below 5 plugins and used extension and extension points to convert game to eclipse plugin.

<b>Source Code:</b> https://github.com/cmoulika009/Software-Methods-and-Tools/tree/master/Assignment-4_Snake%20Game%20Eclipse%20Plugin/Source%20Code

<b>1. SnakeGameMainPlugin:</b>
This plugin is the starting point of the project, in which extension point is created to main class Snake Game. Using Handler, the function startGame() in SnakeGame class is invoked.

<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-4_Snake%20Game%20Eclipse%20Plugin/Images/Plugin-1.JPG">

<b>2. SnakeGameLogicPlugin:</b>
Extension is created in this plugin for extension Point of SnakeGameMainPlugin and SnakeGame class is invoked, where the main game logic starts.

<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-4_Snake%20Game%20Eclipse%20Plugin/Images/Plugin-2-a.JPG">

Also extension point is created for Clock and SidePanel class, whose logic is implemented in other plugins.

<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-4_Snake%20Game%20Eclipse%20Plugin/Images/Plugin-2-b.JPG">

<b>3. SnakeGameInfoPanelPlugin:</b>
Extension is created for extension point created in SnakeGameLogicPlugin which invokes SidePanel class. SidePanel class which is responsible for displaying the game controls and information such as score,fruit eaten etc. to the right of game board.

<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-4_Snake%20Game%20Eclipse%20Plugin/Images/Plugin-3.JPG">

<b>4. SnakeGameClockPlugin:</b>
Extension is created for extension point created in SnakeGameLogicPlugin which invokes Clock class.Clock class that is responsible for maintaining cycles in Game.

<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-4_Snake%20Game%20Eclipse%20Plugin/Images/Plugin-4.JPG">

<b>5. SnakeGameBoardPlugin:</b>
Extension is created for extension point created in SnakeGameLogicPlugin which invokes BoardPanel class. BoardPanel class contains the logic for Game Board Control and the elements appears on Board.

<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-4_Snake%20Game%20Eclipse%20Plugin/Images/Plugin-5.JPG">

Finally, SnakeGameMainPlugin is executed as Eclipse Application to run the plugin. Also, the entire project is exported as plugins and installed the same in Eclipse.

<b>Plugins:</b> https://github.com/cmoulika009/Software-Methods-and-Tools/tree/master/Assignment-4_Snake%20Game%20Eclipse%20Plugin/plugins

<h3>Snake Game Implementation in ArchStudio</h3>

<b>What is Arch Studio??</b> 

The ArchStudio environment plays two roles in the development of architectures:

First, ArchStudio is an architecture development environment. That is, the ArchStudio developers have identified recurring principal design concerns that occur in many domains and projects, and attempted to support these. ArchStudio has built-in support for modeling the hierarchical structure of complex systems, the types of various components, connectors, and interfaces, product-lines of systems that are related by a common base, and so on.

Second, ArchStudio is an architecture meta-modeling environment. ArchStudio is based on the highly-extensible xADL architecture description language. xADL allows stakeholders to define and re-define the language's syntax and semantics to suit their own needs, and ArchStudio provides the tool support for this extensibility.

<b>Snake Game Architecture Diagram</b>

Below is the architecture diagram of Snake Game with four component SnakeGame, Clock, SidePanel, BoardPanel. Using interface. links the components communicate with each other

<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-5_Snake%20Game%20Arch%20Studio/Images/Architecture%20Diagram.JPG">

All components should communicate with each other using its in out Interface, defined for each component.

<b>Final product is a two-player Snake game</b>

Each player controls a snake using different keys in the keyboard.

Player-1 uses below keys to control direction
W : Move Up
A: Move Down
S: Move Down
D: Move Right

Player-2 uses Up,Down,Left,Right arrowkeys to control direction

Once we press enter two snakes appear (Green: Player-1, Yellow: Player-2) and using above controls two players can play game.Two players play against each other. One player's snake can use its body to block the other snake.

<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-5_Snake%20Game%20Arch%20Studio/Images/SnakeGame-Start.JPG">

<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-5_Snake%20Game%20Arch%20Studio/Images/Two%20Player%20Game.jpg">

The game ends if 

 <b> i. Player-1 hits wall then Player-2 wins game</b>
  
  <img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-5_Snake%20Game%20Arch%20Studio/Images/Player-1%20hit%20Wall.JPG">
  
  <b>ii. Player-2 hits wall then Player-1 wins game</b>
  
  <img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-5_Snake%20Game%20Arch%20Studio/Images/Player-2%20hit%20wall.JPG">
  
 <b> iii. Player-2 hits Player-1 then Player-1 wins game</b>
  
  <img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-5_Snake%20Game%20Arch%20Studio/Images/Player-2%20hits%20Playe-1.JPG">
  
  <b>iv. Player-1 hits Player-2 then Player-2 wins game</b>
  
  <img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-5_Snake%20Game%20Arch%20Studio/Images/Player-1%20hits%20Player-2.JPG">
  
  <b>v. If one player's snake eats 5 fruits first</b>
  
  In below diagram Player-2 ate 5 fruits so it won the game.
  
  <img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-5_Snake%20Game%20Arch%20Studio/Images/Player-2%20ate%205%20Fruits.JPG">
  
<b>Source Code:</b> https://github.com/cmoulika009/Software-Methods-and-Tools/tree/master/Assignment-5_Snake%20Game%20Arch%20Studio/Source%20Code/SnakeGameArchStudio
