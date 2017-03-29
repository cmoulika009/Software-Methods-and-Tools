package comp.SidePanel;


import comp.SidePanel.SidePanelArch;

import java.awt.Graphics;

public interface ISidePanelImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (SidePanelArch arch);
	public SidePanelArch getArch();
	
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
  
    //To be imported: Graphics
    public void paintComponent (Graphics g)  ;        
}