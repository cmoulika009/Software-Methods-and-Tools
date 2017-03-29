package comp.SnakeGame;


import comp.SnakeGame.SnakeGameArch;

public interface ISnakeGameImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (SnakeGameArch arch);
	public SnakeGameArch getArch();
	
	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init();	
	public void begin();
	public void end();
	public void destroy();

	/*
  	  Implementation primitives required by the architecture
	*/
}