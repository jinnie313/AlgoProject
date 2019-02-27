import java.util.ArrayList;
import java.util.Arrays;

public class LISTest {
	public static void main(String[] args) {
		int[] arr = {3,2,6,4,5,1};
//		lis1(arr);
		list2(arr);
	}
	
	static void list2(int[] arr) {
		int[] LIS = new int[arr.length];
		
		Arrays.fill(LIS, 1);
		
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i] && LIS[j]+1 > LIS[i]) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}
		
		System.out.println(Arrays.toString(LIS));
		int max = Arrays.stream(LIS).max().getAsInt();
		System.out.println(max);
	}
	
	static void lis1(int[] arr) {
		int size = 1 <<arr.length;	
		int max = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = size-1; i > 0; i--) {
			list.clear();
			for(int j = 0; j < arr.length; j++) {
				if( (i & 1 <<j) != 0) {
					list.add(arr[j]);
//					System.out.print(arr[j] + " ");
				}
			}
			max = Math.max(max, solve(list));
//			System.out.println();
		}
		System.out.println(max);
	}
	static int solve(ArrayList<Integer> list) {
		int size =list.size();
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i-1) > list.get(i)) {
				size = 1;
				break;
			}
		}
		return size;
	}
}





