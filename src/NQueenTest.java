import java.util.Scanner;

public class NQueenTest {
	//Solution2806
	
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int N;
		for(int i=1; i<=T; i++) {
			N = sc.nextInt();
			int[] arr = new int[N];
			count=0;
			nQueen(arr, 0);
			System.out.println("#" + i + " " + count);
		}
	}
	
	public static void nQueen(int[] arr, int level) {
		if(level == arr.length) {
			count++;
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[level] = i;
			
			if(check(arr, level)) {
				nQueen(arr, level+1);
			}
		}
	}
	
	public static boolean check(int[] arr, int level) {
		boolean flag = true;
		
		for(int i=0; i<level; i++) {
			if(arr[i] == arr[level]) {
				flag = false;
				break;
			}
			if(Math.abs(arr[level]-arr[i]) == Math.abs(level-i)) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
}
