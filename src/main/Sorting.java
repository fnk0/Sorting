package main;

/**
 * 
 * @author Marcus Gabilheri
 * @version 1.0
 * @since April 2014
 *
 */
public class Sorting {
	
	public Sorting() {
		
	}
	
	public static void main(String[] args) {	
		
		MergeSort mergeThread = new MergeSort(1);
		mergeThread.start();
		
		BubbleSort bubbleThread = new BubbleSort(1);
		bubbleThread.start();
	}	
	
	public static boolean checkSort(double[] sortedArray) {
		
		for(int i = 0; i < sortedArray.length; i++) {
			try {
				if(sortedArray[i + 1] < sortedArray[i]) {
					return false;
				}
			} catch(ArrayIndexOutOfBoundsException ex) {}
		}
		
		return true;
		
	}
}
