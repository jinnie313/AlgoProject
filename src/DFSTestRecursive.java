import java.util.Iterator;
import java.util.LinkedList;

public class DFSTestRecursive {
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
		
		g.dfs(1);
	}
	
	static class Graph{
		int v;
		LinkedList<Integer> adj[];
		boolean[] visit;
		
		public Graph(int v) {
			this.v = v;
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
		
		public void dfs(int start) {
			visit[start] = true;
			System.out.print(start + " ");
			
			Iterator<Integer> list = adj[start].iterator();
			while(list.hasNext()) {
				int next = list.next();
				if(!visit[next]) {
					dfs(next);
				}
			}
		}
		
	}
}
