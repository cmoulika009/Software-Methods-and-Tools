package comp.BoardPanel;


import edu.game.constants.TileType;

import edu.game.interfaces.BoardPanelInterface;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import java.awt.Graphics;
import java.awt.Point;

public class BoardPanelArch extends AbstractMyxSimpleBrick implements BoardPanelInterface
{
    public static final IMyxName msg_BoardPanelInterface = MyxUtils.createName("edu.game.interfaces.BoardPanelInterface");


	private IBoardPanelImp _imp;

    public BoardPanelArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IBoardPanelImp getImplementation(){
        try{
			return new BoardPanelImp();    
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
		if (arg0.equals(msg_BoardPanelInterface)){
			return this;
		}        
		return null;
	}
  
    //To be imported: Graphics,Point,TileType
    public void clearBoard ()   {
		_imp.clearBoard();
    }    
    public void setTile (Point point,TileType type)   {
		_imp.setTile(point,type);
    }    
    public void setTile (int x,int y,TileType type)   {
		_imp.setTile(x,y,type);
    }    
    public TileType getTile (int x,int y)   {
		return _imp.getTile(x,y);
    }    
    public void paintComponent (Graphics g)   {
		_imp.paintComponent(g);
    }    
}