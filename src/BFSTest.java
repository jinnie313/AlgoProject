import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTest {
	public static void main(String[] args) {
		//그래프 생성
		Graph g = new Graph(7+1);

		//간선추가
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(3, 7);
		
		g.search(1);
	}

	static class Graph{
		Queue<Integer> queue;
		boolean[] visit;
		LinkedList<Integer> adj[];

		public Graph(int v) {
			queue = new LinkedList<>();
			visit = new boolean[v];
			adj = new LinkedList[v];
			
			for(int i=1; i<v; i++) {
				adj[i] = new LinkedList<>();
			}
		}

		public void addEdge(int i, int j) {
			adj[i].add(j);
			adj[j].add(i);
		}

		public void search(int start) {
			queue.offer(start);
			visit[start] = true;
			
			int v, next;
			Iterator<Integer> list;
			while(!queue.isEmpty()) {
				v=queue.poll();
				System.out.print (v + " ");
				
				list = adj[v].iterator();
				while (list.hasNext()) {
					next = list.next();
					if(!visit[next]) {
						queue.offer(next);
						visit[next] = true;
					}
				}
			}
		}
	}
}
