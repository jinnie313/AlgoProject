import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PrimTest {
	static ArrayList<Node>[] list;
	public static void main(String[] args) {
		list = new ArrayList[7];
		
		for(int i = 0 ; i < list.length; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		Node n1 = new Node(0,31);
		Node n2 = new Node(2,31);
		list[2].add(n1);
		list[0].add(n2);
		
		n1 = new Node(0,51);
		n2 = new Node(6,51);
		list[6].add(n1);
		list[0].add(n2);
		
		n1 = new Node(2,25);
		n2 = new Node(6,25);
		list[6].add(n1);
		list[2].add(n2);
		
		n1 = new Node(0,32);
		n2 = new Node(1,32);
		list[1].add(n1);
		list[0].add(n2);
		
		n1 = new Node(0,60);
		n2 = new Node(5,60);
		list[5].add(n1);
		list[0].add(n2);
		
		n1 = new Node(3,18);
		n2 = new Node(5,18);
		list[5].add(n1);
		list[3].add(n2);
		
		n1 = new Node(4,40);
		n2 = new Node(5,40);
		list[5].add(n1);
		list[4].add(n2);
		
		n1 = new Node(3,34);
		n2 = new Node(4,34);
		list[4].add(n1);
		list[3].add(n2);
		
		n1 = new Node(1,21);
		n2 = new Node(2,21);
		list[2].add(n1);
		list[1].add(n2);
		
		n1 = new Node(2,46);
		n2 = new Node(4,46);
		list[4].add(n1);
		list[2].add(n2);
		
		n1 = new Node(6,51);
		n2 = new Node(4,51);
		list[4].add(n1);
		list[6].add(n2);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[7];
		
		int start = 0;
		visit[start] = true;
		
		Iterator<Node> datas = list[start].iterator();
		while(datas.hasNext()) {
			pq.offer(datas.next());
		}
		
		int cnt=0, sum = 0;
		Node tempNode;
		System.out.print(start + " ");
		
		while(!pq.isEmpty()) {
			tempNode = pq.poll();
			
			if(visit[tempNode.data])	continue;
			
			sum+= tempNode.weight;
			visit[tempNode.data] = true;
			cnt++;
			System.out.print(tempNode.data + " ");
			
			Iterator<Node> datas2 = list[tempNode.data].iterator();
			while(datas2.hasNext()) {
				pq.offer(datas2.next());
			}
		}
		
		System.out.println("\n" + sum + "\n" + cnt);
	}
	static class Node implements Comparable<Node>{
		int data;
		int weight;
		public Node(int data, int weight) {
			super();
			this.data = data;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight==o.weight? this.data-o.data:this.weight-o.weight;
		}		
	}
}
