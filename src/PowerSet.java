
public class PowerSet {

	public static void main(String[] args) {
		int arr[] = {3, 6, 7, 1, 5, 4};
		//		method1(arr);
		method2(arr);
	}

	public static void method1(int[] arr) {
		int n = arr.length;

		for(int i=0; i<(1<<n); i++) {
			// 1<<n : 부분 집합의 개수
			for(int j=0; j<n; j++) {
				//원소의 수만큼 비트를 비교함
				if((i&(1<<j)) != 0) {	//i의 j번째 비트가 1이면 j번째 원소 출력
					System.out.printf("%d ", arr[j]);
				}
			}
			System.out.println();
		}
	}

	static boolean[] flag;
	public static void method2(int[] arr) {
		flag = new boolean[arr.length];
		powerset(arr, 0, arr.length);

	}

	public static void powerset(int[] arr, int depth, int maxSize) {
		if(depth == maxSize) {
			print(arr);
			return;
		}

		flag[depth] = true;
		powerset(arr, depth+1, maxSize);
		flag[depth] = false;
		powerset(arr, depth+1, maxSize);
	}

	public static void print(int[] arr) {
		System.out.print("[");
		for(int i = 0 ; i< arr.length; i++) {
			if(flag[i]) {
				System.out.print(arr[i] +" ");
			}
		}
		System.out.println("]");	
	}
}
