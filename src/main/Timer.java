package main;
/**
 * Timer class for easy computation of the run time.
 * @author Marcus Gabilheri
 * @version 1.0
 * @since April 2014
 *
 */
public class Timer  {

	private long start;
	private long stop;
	
	public Timer() {
		start = 0L;
		stop = 0L;
	}
	
	public Timer(boolean startRunning) {
		stop = 0L;
		start();
	}
	
	public void start() {
		start = System.currentTimeMillis();
	}
	
	public void stop() {
		stop = System.currentTimeMillis();
	}
	
	public long getStartTime() {
		return start;
	}
	
	public long getStopTime() {
		return stop;
	}
	
	public long getRunTime() {
		if(stop != 0L) {
			stop = System.currentTimeMillis();
		}
		return (stop - start);
	}

}
