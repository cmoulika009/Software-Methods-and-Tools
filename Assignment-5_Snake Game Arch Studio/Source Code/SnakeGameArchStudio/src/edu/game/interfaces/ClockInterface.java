package edu.game.interfaces;

public interface ClockInterface {
	public void setCyclesPerSecond(float cyclesPerSecond);
	public void reset();
	public void update();
	public void setPaused(boolean paused);
	public boolean isPaused();
	public boolean hasElapsedCycle();
	public boolean peekElapsedCycle();
}
