
public class BinarySearch1 {

	public static void main(String[] args) {
		int arr[] = {2, 4, 7, 9, 11, 19, 23};
		int idx = binarySearch(arr, 19);
		
		System.out.println(idx);
	}
	
	public static int binarySearch(int[] arr, int key) {
		int low = 0;
		int high =arr.length;
		
		int mid;
		while(low<=high) {
			mid = low + (high-low)/2;
			
			if(arr[mid] == key) {
				return mid;
			}else if(arr[mid] > key) {
				high = mid-1;
			}else {
				low = mid-1;
			}
		}
		
		return -1;
	}

}
