package comp.SnakeGame;

import edu.game.interfaces.BoardPanelInterface;
import edu.game.interfaces.ClockInterface;
import edu.game.interfaces.SidePanelInterface;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class SnakeGameArch extends AbstractMyxSimpleBrick {
	public static final IMyxName msg_GameInterface = MyxUtils.createName("edu.game.interfaces.GameInterface");
	public static final IMyxName msg_ClockInterface = MyxUtils.createName("edu.game.interfaces.ClockInterface");
	public static final IMyxName msg_SidePanelInterface = MyxUtils.createName("edu.game.interfaces.SidePanelInterface");
	public static final IMyxName msg_BoardPanelInterface = MyxUtils
			.createName("edu.game.interfaces.BoardPanelInterface");

	public ClockInterface OUT_ClockInterface;
	public SidePanelInterface OUT_SidePanelInterface;
	public BoardPanelInterface OUT_BoardPanelInterface;

	private ISnakeGameImp _imp;

	public SnakeGameArch() {
		_imp = getImplementation();
		if (_imp != null) {
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}

	protected ISnakeGameImp getImplementation() {
		try {
			return new SnakeGameImp();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public void init() {
		_imp.init();
	}

	public void begin() {
		OUT_ClockInterface = (ClockInterface) MyxUtils.getFirstRequiredServiceObject(this, msg_ClockInterface);
		if (OUT_ClockInterface == null) {
			System.err.println("Error: Interface edu.game.interfaces.ClockInterface returned null");
			return;
		}
		OUT_SidePanelInterface = (SidePanelInterface) MyxUtils.getFirstRequiredServiceObject(this,
				msg_SidePanelInterface);
		if (OUT_SidePanelInterface == null) {
			System.err.println("Error: Interface edu.game.interfaces.SidePanelInterface returned null");
			return;
		}
		OUT_BoardPanelInterface = (BoardPanelInterface) MyxUtils.getFirstRequiredServiceObject(this,
				msg_BoardPanelInterface);
		if (OUT_BoardPanelInterface == null) {
			System.err.println("Error: Interface edu.game.interfaces.BoardPanelInterface returned null");
			return;
		}
		_imp.begin();
	}

	public void end() {
		_imp.end();
	}

	public void destroy() {
		_imp.destroy();
	}

	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_GameInterface)) {
			return this;
		}
		return null;
	}
}