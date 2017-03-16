# Software Methods and Tools

Software methods and tools are extensively used in current software production to improve software productivity and quality. In this course, we learnt a number of popular software methods and tools being used in academia or industry. These methods include object-oriented design and analysis, architecture styles, unit testing, and version control. The covered software tools include Microsoft Project, IBM Rational Modeler, Eclipse Plug-ins, ArchStudio, JUnit, Subversion, and GIT. We used these methods and tools to develop a software system, from initial planning to final deployment.

The tutorials of this course are in below link:

https://github.com/cmoulika009/Software-Methods-and-Tools/tree/master/SMT%20Tutorials

As part of this course we have developed project similar to <b>Snake Game</b> using Java

<h3>UML Diagrams</h3>

<h4><u>Class Diagram:</u></h4>
<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-2_UML%20Modelling-%20Class%20Diagram/ClassDiagram.JPG">

<h4><u>State Diagram:</u></h4>
<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-3_UML%20Modeling-Sequence%20%26%20State%20Diagram/StateDiagram_SnakeDiagram.JPG">

<h4><u>Sequence Diagram:</u></h4>
<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-3_UML%20Modeling-Sequence%20%26%20State%20Diagram/SeqSnake-1.JPG">
<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-3_UML%20Modeling-Sequence%20%26%20State%20Diagram/SeqSnake-2.JPG">
<img src="https://github.com/cmoulika009/Software-Methods-and-Tools/blob/master/Assignment-3_UML%20Modeling-Sequence%20%26%20State%20Diagram/SeqSnake-3.JPG">

<h3>Java Application to Eclipse Pligin</h3>

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
