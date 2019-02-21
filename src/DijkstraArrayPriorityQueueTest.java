import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraArrayPriorityQueueTest {
	static int[][] ad;
    static int[] dist;
    static int nE, nV;
    static final int INF = Integer.MAX_VALUE; 
    static class Node implements Comparable<Node>{
    	int index;
    	int cost;
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return cost == o.cost ? index - o.index: cost-o.cost;
		} 		
    }
    static void dijkstra(int start) {
    	PriorityQueue<Node> pq = new PriorityQueue<Node>();
    	dist[start] = 0;
    	pq.offer(new Node(start, dist[start]));
    	
    	Node current;
    	while(!pq.isEmpty()) {
    		current = pq.poll();
    		int minIndex = current.index;
    		
    		for(int i = 0 ; i < nV; i++) {
    			if(ad[minIndex][i] != 0 && dist[i] > dist[minIndex] + ad[minIndex][i]) {
    				dist[i] =  dist[minIndex] + ad[minIndex][i];
    				pq.offer(new Node(i, dist[i]));
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
        Arrays.fill(dist, INF);
//        for(int i = 0; i < nV; i++){
//            dist[i] = INF;   //임의의 무한한 값으로 거리값 초기화
//        }        
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
