import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSTestRepeat {
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
		Stack<Integer> stack;
		boolean[] visit;
		LinkedList<Integer> adj[];

		public Graph(int v) {
			stack = new Stack<>();
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
			stack.push(start);
			
			int v, next;
			while(!stack.isEmpty()) {
				v = stack.pop();
				if(!visit[v]) {
					visit[v] = true;
					System.out.print(v +" ");
					
					Iterator<Integer> list = adj[v].iterator();
					while (list.hasNext()) {
						next = list.next();
						if(!visit[next]) {
							stack.push(next);
						}
					}
				}
			}
		}
	}
}
