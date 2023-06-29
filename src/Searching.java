import java.util.Scanner;
import java.util.Arrays;


/**
 * @author AltonWong
 *This class implements two searching algorithms to find a key number in the array
 */
public class Searching {
	//linear search algorithm
	public static int linearSearch(int[]array, int key) {
		for (int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				return i;
			}
		}
		return -1;
	}
	//interpolation search algorithm
	public static int interpolationSearchIterative(int[] array, int key) {
		int low = 0, mid, high = array.length-1, pos;
		while (low <= high) {
			pos = (key-array[low])/(array[high]-array[low]);
			mid = (low + ((high-low)*pos));
			if(key < array[mid]) {
				high = mid - 1;
			}
			else if(array[mid] < key) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	//linear search algorithm with a sorted array
	public static int sortedLinearSearch(int[]array, int key) {
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		//Creates new scanner object
		Scanner in = new Scanner(System.in);
		//Asking user how many elements they want in the array
		System.out.print("Enter the number of elements in the array: ");
		int n = in.nextInt();
		//Creating aray of size n
		int[] array = new int[n];
		System.out.println("Enter the elements in the array:");
		//Building our array from user inputs
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
				
		System.out.print("Enter the search key:");
		int search = in.nextInt();
		
		long startTime1 = System.nanoTime();

		if (linearSearch(array, search) == -1) {
			System.out.println("\nUsing Linear Search:\nSearch key NOT FOUND");
		}
		else {
			System.out.println("\nUsing Linear Search:\nSearch key FOUND at index " + linearSearch(array,search));
		}
		
		long duration1 = System.nanoTime() - startTime1;
		
		Arrays.sort(array);
		
		long startTime2 = System.nanoTime();

		if (interpolationSearchIterative(array, search) == -1) {
			System.out.println("\nUsing Linear Search:\nSearch key NOT FOUND");
		}
		else {
			System.out.println("\nUsing Interpolation Search:\nSearch key FOUND at index " + interpolationSearchIterative(array, search) + "\n");
		}
		long duration2 = System.nanoTime() - startTime2;
		
		
		System.out.println(duration1 + " nanoseconds for Linear Search");
		System.out.println(duration2 + " nanoseconds for Interpolation Search");
		System.out.println("Interpolation search performs better because it splits the data in half instead of parsing every single index in the array.");
		
		long startTime3 = System.nanoTime();

		if (sortedLinearSearch(array, search) == -1) {
			System.out.println("\nUsing Sorted Linear Search:\nSearch key NOT FOUND");
		}
		else {
			System.out.println("\nUsing Sorted Linear Search:\nSearch key FOUND at index " + sortedLinearSearch(array,search));
		}
		
		long duration3 = System.nanoTime() - startTime3;
		System.out.println(duration3 + " nanoseconds");

		float delta = (float)(duration1-duration3)/(duration1)*(100);
		System.out.println("\nThe sorted linear search is: " + delta + "% faster");
		
	}

}
