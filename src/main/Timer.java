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
	
	/**
	 * 
	 */
	public Timer() {
		start = 0L;
		stop = 0L;
	}
	
	/**
	 * 
	 * @param startRunning
	 */
	public Timer(boolean startRunning) {
		stop = 0L;
		start();
	}
	
	/**
	 * 
	 */
	public void start() {
		start = System.currentTimeMillis();
	}
	
	/**
	 * 
	 */
	public void stop() {
		stop = System.currentTimeMillis();
	}
	
	/**
	 * 
	 * @return
	 */
	public long getStartTime() {
		return start;
	}
	
	/**
	 * 
	 * @return
	 */
	public long getStopTime() {
		return stop;
	}
	
	/**
	 * 
	 * @return
	 */
	public long getRunTime() {
		if(stop != 0L) {
			stop = System.currentTimeMillis();
		}
		return (stop - start);
	}

}
