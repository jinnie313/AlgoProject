import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DijkstraArrayTest {
	static int[][] ad;
	static int[] dist;
	static boolean[] visit;
	static int nE, nV;
	static final int INF = Integer.MAX_VALUE; 
	static void dijkstra(int start) {
		dist[start] = 0;
		for(int i = 0 ; i < nV - 1;  i++) {
//    		방문하지 않은 정점에서 최소값의 위치를 구하여라
			int min = INF;
			int minIndex = -1;
			for(int j = 0 ; j < nV; j++) {
				if(!visit[j] && min > dist[j]) {
					min = dist[j];
					minIndex = j;
				}
			}
			visit[minIndex] = true;
			System.out.println(minIndex);

//			dist 배열에 있는 값과 현재 위치를 거쳐가는 값과 그 다음값의 합을 비교해서
//			더 작은 값으로  dist 값을 변경하라
			for(int j = 0; j < nV ;j++) {
				if(ad[minIndex][j] != 0 && dist[j] > dist[minIndex] + ad[minIndex][j]) {
					dist[j] = dist[minIndex] + ad[minIndex][j];
				}
			}
		}
		System.out.println(Arrays.toString(dist));
	}
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("input_dijkstra.txt"));
		Scanner scan = new Scanner(System.in);
		nV = scan.nextInt();        
		nE = scan.nextInt();        
		ad = new int[nV][nV];
		dist = new int[nV];
		visit = new boolean[nV];
		Arrays.fill(dist, INF);
//		for(int i = 0; i < nV; i++){
//			dist[i] = INF;   //임의의 무한한 값으로 거리값 초기화
//		}        
		for(int i = 0; i < nE; i++){
			int t1, t2, t3;
			t1 = scan.nextInt();	            
			t2 = scan.nextInt();            
			t3 = scan.nextInt();            
			ad[t1][t2] = t3;
		}
		System.out.println(Arrays.deepToString(ad));
		dijkstra(0);
	}

}
