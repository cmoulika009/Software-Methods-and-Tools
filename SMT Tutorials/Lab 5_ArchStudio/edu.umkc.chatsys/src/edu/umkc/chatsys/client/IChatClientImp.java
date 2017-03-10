package edu.umkc.chatsys.client;


import edu.umkc.chatsys.client.ChatClientArch;

public interface IChatClientImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (ChatClientArch arch);
	public ChatClientArch getArch();
	
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
  
    
    public void messageSent (String sender,String message)  ;        
}