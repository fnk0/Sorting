package main;

/**
 *  Bubble sort is much slower lists that are not pre sorted since it has to shift positions too many times
 *  For large data sets the Bubble sort proves itself very inneficient.
 * @author Marcus Gabilheri
 * @version 1.0
 * @since April 2014
 *
 */
public class BubbleSort extends Thread {

	
	private int sortSize;
	private Timer bubbleTimer;
	
	/**
	 * 
	 */
	public BubbleSort() {
		this.sortSize = 1;
		bubbleTimer = new Timer();
	}
	
	/**
	 * 
	 * @param sortSize
	 */
	public BubbleSort(int sortSize) {
		this.sortSize = sortSize;
		bubbleTimer = new Timer();
	}
	
	/**
	 * 
	 * @param toSortArray
	 */
	public void sortArray(double[] toSortArray) {
		bubbleTimer.start();
		getSortedArray(toSortArray);
	}
	
	/**
	 * 
	 * @param toSortArray
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public double[] getSortedArray(double[] toSortArray) {	
		
		try {
			for(int i = 0; i < toSortArray.length; i++) {
				boolean swaped = true;
				while(swaped) {
					if(System.currentTimeMillis() - bubbleTimer.getStartTime() > 20000) {
						System.out.println("Error... the Bubble computation with array size " + sortSize + " took too long.");
						stop();
					}
					swaped = false;
					for(int j = toSortArray.length - 1; i + 1 <= j; j--) {
						if(toSortArray[j] < toSortArray[j -1]) {
							double temp = toSortArray[j-1];
							toSortArray[j-1] = toSortArray[j];
							toSortArray[j] = temp;
							swaped = true;
						}
						
					}
				}
				if(swaped == false) {
					break;
				}
			}
	
			return toSortArray;
		} catch(OutOfMemoryError ex) {
			System.out.println("Error... the Bubble computation with array size " + sortSize + " ran out of memory!!.");
			stop();
		}
		return null;
	}
	
	/**
	 * 
	 * @param size
	 * @return
	 */
	private double[] generateArray(int size) {
		int arraySize = size * 10;
		double[] doubleArray = new double[arraySize];
		for(int i = 0; i < arraySize; i++) {
			doubleArray[i] = Math.random();
		}
		return doubleArray;
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		Timer timer = new Timer();
		boolean run = true;
		while(run) {
			sortSize *= 10;
			double[] arrayToSort = generateArray(sortSize);
			
			timer.start();
			sortArray(arrayToSort);
			timer.stop();
			
			System.out.println("\nBubbled sort of a double array with size " + sortSize + " was completed in: " + timer.getRunTime() + " ms");
		}
	}
	
}
