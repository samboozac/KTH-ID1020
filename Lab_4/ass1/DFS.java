/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: DepthFirstSearch - Find an arbitrary path between X and Y
 * */
package ass1;
import edu.princeton.cs.algs4.Stack;

public class DFS {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex

    public DFS(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<String> pathTo(SymbolGraph sg, int v) {
        if (!hasPathTo(v)) return null;
        Stack<String> path = new Stack<String>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(sg.name(x));
        path.push(sg.name(s));
        return path;
    }
}