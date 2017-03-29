package comp.SidePanel;


import edu.game.interfaces.SidePanelInterface;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import java.awt.Graphics;

public class SidePanelArch extends AbstractMyxSimpleBrick implements SidePanelInterface
{
    public static final IMyxName msg_SidePanelInterface = MyxUtils.createName("edu.game.interfaces.SidePanelInterface");


	private ISidePanelImp _imp;

    public SidePanelArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ISidePanelImp getImplementation(){
        try{
			return new SidePanelImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_SidePanelInterface)){
			return this;
		}        
		return null;
	}
  
    //To be imported: Graphics
    public void paintComponent (Graphics g)   {
		_imp.paintComponent(g);
    }    
}