import java.util.Arrays;

public class QuickSortPartition {
	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 6, 9, 1, 8, 7, 5, 100, 1, 3};
		quickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

	public static void quickSort(int[] arr, int left, int right) {
		if(left<right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}
	
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i= left-1;
		
		for(int j=left; j<right; j++) {
			if(arr[j]<=pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i+1, right);
		return i+1;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
