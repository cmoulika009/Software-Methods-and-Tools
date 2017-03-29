package comp.SnakeGame;

import edu.main.SnakeGame.SnakeGame;

public class SnakeGameImp implements ISnakeGameImp {
	private SnakeGameArch _arch;
	SnakeGame game;

	public SnakeGameImp() {
	}

	public void setArch(SnakeGameArch arch) {
		_arch = arch;
	}

	public SnakeGameArch getArch() {
		return _arch;
	}

	/*
	 * Myx Lifecycle Methods: these methods are called automatically by the
	 * framework as the bricks are created, attached, detached, and destroyed
	 * respectively.
	 */
	public void init() {
		System.out.println("Initializing snake game");
		game = new SnakeGame();
		// TODO Auto-generated method stub
	}

	public void begin() {
		// TODO Auto-generated method stub
		System.out.println("Snake game starting");
		game.setArchData(_arch);
		startGame();
	}

	public void end() {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/*
	 * Implementation primitives required by the architecture
	 */

	public void startGame() {
		// TODO Auto-generated method stub
		game.startGame();

	}

}