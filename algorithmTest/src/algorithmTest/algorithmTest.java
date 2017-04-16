package algorithmTest;

import java.util.Arrays;

/**
 * This program test two different ways to sort arrays - one user created algorithm
 * which implements insertion sorting and a built-in algorithm. The run times for 
 * each are printed.
 * 
 * As tested, when an array contains 1,000 elements, the user created algorithm takes
 * about 0.003s to sort the array, while the built-in algorithm takes just 0.001s.
 * When the arrays contain 10,000 elements, the user created algorithm takes about 
 * 0.058s to sort the array, while the built-in algorithm takes just 0.005s.
 * When the arrays contain 100,000 elements, the user created algorithm takes about 
 * 0.068s to sort the array, while the built-in algorithm takes just 0.005s.
 * 
 * @author Natalia
 *
 */
public class algorithmTest {
	public static void main(String[] args) {
		//declaring all variables
		long startTimeUser; //start time for user created sorting algorithm
		long runTimeUser; //run time for user created sorting algorithm
		long startTimeBuilt; //start time for built-in sorting algorithm
		long runTimeBuilt; //run time for built-in sorting algorithm
		int itemAmt = 1000; //number of items in the arrays
		int[] array1 = new int[itemAmt]; //array to be sorted by user created algorithm
		int[] array2 = new int[itemAmt]; //array to be sorted by built-in algorithm
		
		//filling the arrays with random integers
		for (int i=0; i<array1.length; i++){
			array1[i]=(int)(Integer.MAX_VALUE*Math.random());
			array2[i]=array1[i];
		}
		
		//timing sorting by user created algorithm
		startTimeUser = System.currentTimeMillis();
		insertionSort(array1);
		runTimeUser = System.currentTimeMillis() - startTimeUser;
		
		//timing sorting by built-in algorithm
		startTimeBuilt = System.currentTimeMillis();
		Arrays.sort(array2);
		runTimeBuilt = System.currentTimeMillis() - startTimeBuilt;
		
		//printing out test results
		System.out.println("The two identical arrays contained "+itemAmt+" elements each.");
		System.out.println("Using the user created algorithm took "+runTimeUser/1000.0+" seconds to sort an array.");
		System.out.println("Using the built-in algorithm took "+runTimeBuilt/1000.0+" seconds to sort an array.");
		
	}
	/**
	 * The intertionSort subroutine was copied from http://math.hws.edu/javanotes/c7/s4.html
	 * @param A
	 */
	static void insertionSort(int[] A) {
	      // Sort the array A into increasing order.
	      
	   int itemsSorted; // Number of items that have been sorted so far.

	   for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
	         // Assume that items A[0], A[1], ... A[itemsSorted-1] 
	         // have already been sorted.  Insert A[itemsSorted]
	         // into the sorted part of the list.
	         
	      int temp = A[itemsSorted];  // The item to be inserted.
	      int loc = itemsSorted - 1;  // Start at end of list.
	      
	      while (loc >= 0 && A[loc] > temp) {
	         A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
	         loc = loc - 1;       // Go on to next location.
	      }
	      
	      A[loc + 1] = temp; // Put temp in last vacated space.
	   }
	}
}
