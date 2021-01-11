import java.util.Random;
import java.util.Arrays;

// class only handles integers
public class Sorts {
	
	private static void swap(int input[], int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	private static boolean isSorted(int input[]) {
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] > input[i+1]) {
				return false;
			}
		}
		
		return true;
	}
	
	// n^2 time complexity algorithms
	public static void bubbleSort(int input[]) {
		boolean sorted = false;
		
		while (!sorted) {
			sorted = true;
			
			for (int i = 0; i < input.length - 1; i++) {
				if (input[i] > input[i+1]) {
					sorted = false;
					swap(input, i, i+1);
				}
			}
		}
	}
	
	public static void insertionSort(int input[]) {
		for (int i = 0; i < input.length; i++) {			
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j-1]) {
					swap(input, j, j-1);
				}
				else {
					break;
				}
			}
		}
	}
	
	public static void selectionSort(int input[]) {
		int min, minIndex;
		
		for (int i = 0; i < input.length - 1; i++) {
			min = input[i];
			minIndex = i;
			
			for (int j = i+1; j < input.length; j++) {
				if (input[j] < min) {
					min = input[j];
					minIndex = j;
				}
			}
			
			swap(input, i, minIndex);
		}
	}
	
	// n*log(n) time complexity algorithms
	public static void mergeSort(int input[]) {
		if (input.length <= 1) {
			return;
		}
				
		int half1[] = Arrays.copyOfRange(input, 0, input.length/2);
		int half2[] = Arrays.copyOfRange(input, input.length/2, input.length);
		
		mergeSort(half1);
		mergeSort(half2);
		
		merge(half1, half2, input);
	}
	
	private static void merge(int[] a, int[] b, int[] aux) {
		int i = 0;
		int j = 0;
		
		for (int c = 0; c < a.length + b.length; c++) {
			if (j == b.length || i == a.length) {
				if (i == a.length) {
					aux[c] = b[j];
					j++;
				}
				else {
					aux[c] = a[i];
					i++;
				}
			}
			else if (a[i] < b[j]) {
				aux[c] = a[i];
				i++;
			}
			else {
				aux[c] = b[j];
				j++;
			}
		}
	}
	
	public static void quickSort(int input[]) {
		if (input.length <= 1) {
			return;
		}
		
		int inPlace = partition(input, 0, input.length);
		quickSort(input, 0, inPlace);
		quickSort(input, inPlace + 1, input.length);
	}
	
	private static void quickSort(int input[], int low, int high) {
		if (high - low < 2) {
			return;
		}
		
		int inPlace = partition(input, low, high);
		quickSort(input, low, inPlace);
		quickSort(input, inPlace + 1, high);
	}
	
	private static int partition(int input[], int low, int high) {
		int pivot = input[low];
		int i = low + 1;
		int j = high - 1;
		
		while (i <= j) {
			if (input[i] <= pivot) {
				i++;
			}
			else if (input[j] > pivot) {
				j--;
			}
			else {
				swap(input, i, j);
			}
		}
		
		swap(input, low, j);		
		return j;
	}
	
	public static void printArray(int input[]) {
		for (int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	// Unit testing
	public static void main(String args[]) {
		Random rand = new Random();
		int test[] = new int[10];
		int clone[];
		
		System.out.println("Input array: ");
		for (int i = 0; i < 10; i++) {
			test[i] = rand.nextInt(100);
			System.out.print(test[i] + " ");
		}
		System.out.println("");
		
		clone = test.clone();
		System.out.println("\nBubble sort: ");
		Sorts.bubbleSort(clone);
		Sorts.printArray(clone);
		System.out.println("Sorted? " + Sorts.isSorted(clone));
		
		clone = test.clone();
		System.out.println("\nInsertion sort: ");
		Sorts.insertionSort(clone);
		Sorts.printArray(clone);
		System.out.println("Sorted? " + Sorts.isSorted(clone));
		
		clone = test.clone();
		System.out.println("\nSelection sort: ");
		Sorts.selectionSort(clone);
		Sorts.printArray(clone);
		System.out.println("Sorted? " + Sorts.isSorted(clone));
		
		clone = test.clone();
		System.out.println("\nMerge sort: ");
		Sorts.mergeSort(clone);
		Sorts.printArray(clone);
		System.out.println("Sorted? " + Sorts.isSorted(clone));
		
		clone = test.clone();
		System.out.println("\nQuick sort: ");
		Sorts.quickSort(clone);
		Sorts.printArray(clone);
		System.out.println("Sorted? " + Sorts.isSorted(clone));
	}
}
