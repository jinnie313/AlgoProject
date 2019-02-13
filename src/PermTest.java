
public class PermTest {
	public static void main(String[] args) {
		char[] arr = {'A', 'B', 'C', 'D'};
		perm(arr, 0);
	}
	
	public static void perm(char[] arr, int pivot) {
		if(pivot == arr.length) {
			pr(arr);
			return;
		}
		
		for(int i=pivot; i<arr.length; i++) {
			System.out.println("i: " + i+"     pivot: " +pivot);
			swap(arr, i, pivot);
			perm(arr, pivot+1);
			swap(arr, i, pivot);
		}
	}
	
	public static void swap(char[] arr, int x, int y) {
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	public static void pr(char[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println(arr[arr.length-1]);
	}
}
