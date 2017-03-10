package edu.moulika.gInterface;

import edu.moulika.Game.constants.Direction;

public interface GameInterface {
	public void startGame();
	public int getScore();
	public int getFruitsEaten();
	public int getNextFruitScore();
	public Direction getDirection();
	public boolean isPaused();
	public boolean isNewGame();
	public boolean isGameOver();
}
