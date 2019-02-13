
public class SelectionSortRecursive {
	static int[] arr= {3, 4, 2, 5, 1, 8, 6, 9, 7, 10};
	static int minIdx, tmp;
	public static void main(String[] args) {
		for(int i=0; i<arr.length-2; i++) {
			minIdx=i;
			run(i, i+1);
		}
		for(int j:arr) {
			System.out.print(j +" ");
		}
		
	}
	
	public static void run(int i, int idx) {
		if(arr[idx] < arr[minIdx]) {
			minIdx=idx;
		}
		
		if(idx==arr.length-1) {
			tmp=arr[minIdx];
			arr[minIdx]=arr[i];
			arr[i]=tmp;
			return;
		}
		
		run(i, idx+1);
	}
}
