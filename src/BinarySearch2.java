
public class BinarySearch2 {

	public static void main(String[] args) {
		int arr[] = {2, 4, 7, 9, 11, 19, 23};
		int idx = binarySearch(arr, 0, arr.length, 9);
		
		System.out.println(idx + "번째 인덱스");
	}
	
	public static int binarySearch(int[] arr, int low, int high, int key) {
		if(low>high) {
			return -1;
		}
		
		int mid = low + (high-low)/2;
		
		if(arr[mid] == key) {
			return mid;
		}else if(arr[mid] > key) {
			return binarySearch(arr, low, mid-1, key);
		}else {
			return binarySearch(arr, mid+1, high, key);
		}
	}

}
