// dfs 적용 사례
public class kNapsackTest2 {
	static int[][] items = {
			{10,5},{40,4},{30,6},{50,3}
	};
	static int N =4;
	static int K[][];
	public static void main(String[] args) {
		int capacity = 10;
		K = new int[N][capacity];
		for(int i = 1; i < N; i++) {
			for(int w = 1; w < capacity; w++) {
				if(items[i][1] > w) {
					K[i][w] = K[i - 1][w];
				} else {
					K[i][w] = Math.max(K[i-1][w - items[i][1]] + items[i][0], K[i-1][w]);
				}
			}
		}
		System.out.printf("knapsack(%d,%d)=%d%n",0,capacity, K[N-1][capacity - 1]);
	}
}