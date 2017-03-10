package edu.umkc.chatsys.server;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import edu.umkc.chatsys.IChat;
import edu.umkc.chatsys.IChatListener;

public class ChatServerArch extends AbstractMyxSimpleBrick implements IChat
{
    public static final IMyxName msg_IChat = MyxUtils.createName("edu.umkc.chatsys.IChat");
    public static final IMyxName msg_IChatListener = MyxUtils.createName("edu.umkc.chatsys.IChatListener");

    public IChatListener OUT_IChatListener;

	private IChatServerImp _imp;

    public ChatServerArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IChatServerImp getImplementation(){
        try{
			return new ChatServerImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_IChatListener = (IChatListener) MyxUtils.getFirstRequiredServiceObject(this,msg_IChatListener);
        if (OUT_IChatListener == null){
 			System.err.println("Error: Interface edu.umkc.chatsys.IChatListener returned null");
			return;       
        }
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_IChat)){
			return this;
		}        
		return null;
	}
  
    
    public void sendMessage (String sender,String message)   {
		_imp.sendMessage(sender,message);
    }    
}