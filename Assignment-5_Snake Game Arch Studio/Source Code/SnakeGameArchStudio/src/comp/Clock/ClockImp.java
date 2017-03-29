package comp.Clock;

public class ClockImp implements IClockImp {
	private ClockArch _arch;

	public float millisPerCycle;

	/**
	 * The last time that the clock was updated (used for calculating the delta
	 * time).
	 */
	public long lastUpdate;

	/**
	 * The number of cycles that have elapsed and have not yet been polled.
	 */
	public int elapsedCycles;

	/**
	 * The amount of excess time towards the next elapsed cycle.
	 */
	public float excessCycles;

	/**
	 * Whether or not the clock is paused.
	 */
	public boolean isPaused;

	public ClockImp() {
	}

//	public ClockImp(float f) {
//		// TODO Auto-generated constructor stub
//		setCyclesPerSecond(f);
//		reset();
//	}

	public void setArch(ClockArch arch) {
		_arch = arch;
	}

	public ClockArch getArch() {
		return _arch;
	}

	/*
	 * Myx Lifecycle Methods: these methods are called automatically by the
	 * framework as the bricks are created, attached, detached, and destroyed
	 * respectively.
	 */
	public void init() {
		// TODO Auto-generated method stub
		setCyclesPerSecond(9.0f);
		reset();
	}

	public void begin() {
		// TODO Auto-generated method stub
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

	public void setCyclesPerSecond(float cyclesPerSecond) {
		this.millisPerCycle = (1.0f / cyclesPerSecond) * 1000;
	}

	public void reset() {
		this.elapsedCycles = 0;
		this.excessCycles = 0.0f;
		this.lastUpdate = getCurrentTime();
		this.isPaused = false;
	}

	public void update() {
		// TODO Auto-generated method stub
		// Get the current time and calculate the delta time.
		long currUpdate = getCurrentTime();
		float delta = (float) (currUpdate - lastUpdate) + excessCycles;

		// Update the number of elapsed and excess ticks if we're not paused.
		if (!isPaused) {
			this.elapsedCycles += (int) Math.floor(delta / millisPerCycle);
			this.excessCycles = delta % millisPerCycle;
		}

		// Set the last update time for the next update cycle.
		this.lastUpdate = currUpdate;
	}

	public void setPaused(boolean paused) {
		// TODO Auto-generated method stub
		this.isPaused = paused;

	}

	public boolean isPaused() {
		// TODO Auto-generated method stub
		return isPaused;
	}

	public boolean hasElapsedCycle() {
		// TODO Auto-generated method stub
		if (elapsedCycles > 0) {
			this.elapsedCycles--;
			return true;
		}
		return false;
	}

	public boolean peekElapsedCycle() {
		// TODO Auto-generated method stub
		return (elapsedCycles > 0);
	}
	
	private static final long getCurrentTime() {
		return (System.nanoTime() / 1000000L);
	}
}