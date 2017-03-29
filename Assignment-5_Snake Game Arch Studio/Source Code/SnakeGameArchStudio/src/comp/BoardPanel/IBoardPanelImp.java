package comp.BoardPanel;


import comp.BoardPanel.BoardPanelArch;

import edu.game.constants.TileType;
import java.awt.Graphics;
import java.awt.Point;

public interface IBoardPanelImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (BoardPanelArch arch);
	public BoardPanelArch getArch();
	
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
  
    //To be imported: Graphics,Point,TileType
	//public void boardCreate(SnakeGame game);
    public void clearBoard ()  ;        
    public void setTile (Point point,TileType type)  ;        
    public void setTile (int x,int y,TileType type)  ;        
    public TileType getTile (int x,int y)  ;        
    public void paintComponent (Graphics g)  ;        
}