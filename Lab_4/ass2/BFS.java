/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: BreadthFirstSearch - Find path between X and Y
 * */
package ass2;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BFS {
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private final int s;

    public BFS(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    // breadth-first search from a single source, strip the graph
    private void bfs(Graph G, int s) {
        marked[s] = true;
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) { return marked[v]; }
    // Find the way in the already stripped graph to vertex v.
    public Iterable<String> pathTo(SymbolGraph sg, int v) {
        if (!hasPathTo(v)) return null;
        Stack<String> path = new Stack<String>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(sg.name(x));
        path.push(sg.name(s));
        return path;
    }
}