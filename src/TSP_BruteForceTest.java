import java.util.Arrays;
//	0 => 2 => 3 => 1 => 0    (9,8,3,1)  
public class TSP_BruteForceTest {

	public static void main(String[] args) {
		N = 4;
		dist = new int[N][N];
		for (int[] a : dist) {
			Arrays.fill(a, INF);
		}
		dist[0][1] = 2;
		dist[0][2] = 9;
		dist[1][0] = 1;
		dist[1][2] = 6;
		dist[1][3] = 4;
		dist[2][1] = 7;
		dist[2][3] = 8;
		dist[3][0] = 6;
		dist[3][1] = 3;
		for(int i = 0; i < dist.length; i++) {
			dist[i][i] = 0;
		}
		visited = new boolean[N];
		visited[0] = true;
		tsp(0,0,0,0, 0+"");
		System.out.println(ret);
	}
	static void tsp(int start, int pos, int size, int value, String route) {
		if(size == N-1) {
			if(dist[pos][start] != INF) {
				value += dist[pos][start];
			}
			if(ret > value) {
				ret = value;
			}
			System.out.println(ret + " " + route);
			return;
		}

		for(int i = 0; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			if(dist[pos][i] != INF) {
				visited[i] = true;
				tsp(start,  i, size+1, value + dist[pos][i], route + i);
				visited[i] = false;
			}
		}
	}
	static int N;
	static int[][] dist;
	static boolean[] visited;
	static final int INF = 999;
	static int ret = INF;
}