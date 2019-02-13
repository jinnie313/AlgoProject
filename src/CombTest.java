public class CombTest {
	static int[] arr = {1, 2, 3};
	static int[] temp = new int[arr.length];
	
	public static void main(String[] args) {
		comb(arr.length, 2);
	}
	
	public static void comb(int n, int r) {
		if(r == 0) {
			for(int i:temp) {
				if(i!=0) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
			
		}else if(n<r) {
			return;
		}else {
			temp[r-1] = arr[n-1];
			comb(n-1, r-1);
			comb(n-1, r);
		}
	}
}
