package main;

/**
 * 
 * @author Marcus Gabilheri
 * @version 1.0
 * @since April 2014.
 * This class is used to sort double[] arrays using the MergeSort algorithm.
 * The merge sort algorithm is a O(n log n) sorting type algorithm. 
 * Since it's data structure 
 * Merge Sort is much faster than the Bubble Sort for large data sets. 
 * Since it's algorithm is based on dividing the data sets in 2 every time is very easy to predict
 * how long it will take to run.
 *
 */

public class MergeSort extends Thread {
	
	private int sortSize;
	private Timer mergeTimer;
	
	/**
	 * Default Constructor
	 * Initializes the sortSize to 1 and initializes the Timer
	 */
	public MergeSort() {
		mergeTimer = new Timer();
		sortSize = 1;
	}
	
	/**
	 * Constructor to initialize sortSize to another value
	 * @param sortSize the size of the Array
	 */
	public MergeSort(int sortSize) {
		mergeTimer = new Timer();
		this.sortSize = sortSize;
	}
	
	/**
	 * Sorts an array of double[] 
	 * @param sortArray the double[] array to be sorted
	 */
	public void sortArray(double[] sortArray) {
		mergeTimer.start();
		mergeSort(sortArray);
	}
	
	/**
	 * Sorts an array of doubles and starts the timer 
	 * @param sortArray the array to be sorted
	 * @return the sorted double[] array
	 */
	public double[] getMergedSortedArray(double[] sortArray) {
		
		mergeTimer.start();
		double[] sortedArray = mergeSort(sortArray);
		return sortedArray;
	}
	
	/**
	 * Sorts an array using mergeSort Algorithm
	 * @param sortArray the array to be sorted
	 * @return double[] sorted array 
	 */
	public double[] mergeSort(double[] sortArray) {
		
		try {
			if(mergeTimer.getStartTime() != 0L) {
				if(System.currentTimeMillis() - mergeTimer.getStartTime() > 20000) {
					System.out.println("Error... the Merge computation with array size " + sortSize + " took too long.");
					stop();
				}
			}
			
			if(sortArray.length <= 1) {
				return sortArray;
			}
		
			
			int division = sortArray.length / 2;
			double[] mergedArray;
			
			double[] leftArray = new double[division];
			double[] rightArray = new double[sortArray.length - division];
			
			System.arraycopy(sortArray, 0, leftArray, 0, division);
			System.arraycopy(sortArray, division, rightArray, 0, sortArray.length - division);
			
			leftArray = mergeSort(leftArray);
			rightArray = mergeSort(rightArray);
			
			mergedArray = mergeArray(leftArray, rightArray);
			
			return mergedArray;
		} catch(OutOfMemoryError ex) {
			System.out.println("Error... the Merge computation with array size " + sortSize + " ran out of memory!!.");
			stop();
		}
		
		return null;
	}
	
	/**
	 * Merges the arrays from mergeSort Algorithm
	 * @param leftArray 
	 * @param rightArray
	 * @return double[] the merged array
	 */
	public double[] mergeArray(double[] leftArray, double[] rightArray) {
		
		double[] mergedArray = new double[leftArray.length + rightArray.length];
		int leftCounter = 0;
		int rightCounter = 0;
		int counter = 0;
		
		while(leftCounter < leftArray.length || rightCounter < rightArray.length) {
			if(leftCounter < leftArray.length && rightCounter < rightArray.length) {
				if(leftArray[leftCounter] > rightArray[rightCounter]) {
					mergedArray[counter] = rightArray[rightCounter];
					rightCounter++;
					counter++;
				} else {
					mergedArray[counter] = leftArray[leftCounter];
					leftCounter++;
					counter++;
				}
			} else if(rightCounter < rightArray.length) {
				mergedArray[counter] = rightArray[rightCounter];
				rightCounter++;
				counter++;
			} else if(leftCounter < leftArray.length) {
				mergedArray[counter] = leftArray[leftCounter];
				leftCounter++;
				counter++;
			}
		}
		return mergedArray; 
	}
	
	/**
	 * Generates an array of random doubles from 0 to 1. The array is 10 times bigger than the size argument
	 * @param size
	 * @return double[] 
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
	 * runs the thread. Every cycle of the thread prints how long it took to compute the sort Algorithm
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
			
			System.out.println("\nMerged sort of a double array with size " + sortSize + " was completed in: " + timer.getRunTime() + " ms");
		}
		
	}
	
}

