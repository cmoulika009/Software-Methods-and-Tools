package edu.umkc.chatsys.server;


import edu.umkc.chatsys.server.ChatServerArch;

public interface IChatServerImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (ChatServerArch arch);
	public ChatServerArch getArch();
	
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
  
    
    public void sendMessage (String sender,String message)  ;        
}