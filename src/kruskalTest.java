import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

//백준 2644
public class kruskalTest {
	static int[] parent;
	static long sum = 0;
	static int count = 0;
	
	public static void main(String[] args) {
		TreeSet<Node> ts = new TreeSet<Node>();
		
		ts.add(new Node(0,2,31));
		ts.add(new Node(0,6,51));
		ts.add(new Node(2,6,25));
		ts.add(new Node(0,1,32));
		ts.add(new Node(0,5,60));
		ts.add(new Node(3,5,18));
		ts.add(new Node(4,5,40));
		ts.add(new Node(3,4,34));
		ts.add(new Node(1,2,21));
		ts.add(new Node(2,4,46));
		ts.add(new Node(6,4,51));
		
		parent = new int[7];
		for(int i=0; i<parent.length; i++) {
			makeSet(i);
		}
		
		for(Node node: ts) {
			unionSet(node);
			
			if(count == parent.length-1) {
				break;
			}
		}
		System.out.println(sum);
	}
	
	static void unionSet(Node node) {
		int x = findSet(node.A);
		int y = findSet(node.B);
		
		if(x != y) {
			parent[x] = y;
			sum += node.C;
			count++;
		}
	}
	
	static int findSet(int x) {
		if(x == parent[x]) {
			return x;
		}else {
			int p = findSet(parent[x]);
			parent[x] = p;
			return p;
		}
	}

	
	private static void makeSet(int x) {
		parent[x] = x;
	}


	public static class Node implements Comparable<Node> {
		int A; // 정점
		int B; // 정점
		int C; // 가중치
		public Node(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
		public int compareTo(Node o) {
			return this.C == o.C ? this.A - o.A :this.C - o.C ;
		}
	}
}
