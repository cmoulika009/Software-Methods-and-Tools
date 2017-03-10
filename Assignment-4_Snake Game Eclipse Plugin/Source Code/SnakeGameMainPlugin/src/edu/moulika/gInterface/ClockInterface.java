package edu.moulika.gInterface;

public interface ClockInterface {
	void setCyclesPerSecond(float cycles);
	void reset();
	void update();
	void setPaused(boolean flag);
	boolean isPaused();
	boolean hasElapsedCycle();
	boolean peekElapsedCycle();
	void init(float cyclesPerSecond);
}
