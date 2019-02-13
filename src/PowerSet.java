
public class PowerSet {

	public static void main(String[] args) {
		int arr[] = {3, 6, 7, 1, 5, 4};
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
}
