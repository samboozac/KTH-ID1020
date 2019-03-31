/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: Checks if a Directed Graph has a directed cycle
 * */
package P2ass2;
import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // vertices on a cycle (if one exists)
    private boolean[] onStack; // vertices on recursive call stack

    public DirectedCycle(DirectedGraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }
    // Ran from construct, on every node if no cycle is found
    private void dfs(DirectedGraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        // Check adj
        for (int w : G.adj(v))
            // If a cycle is already found jump out!
            if (this.hasCycle())return;
        // If not marked Depth Search for a cycle
        else if (!marked[w]){ edgeTo[w] = v; dfs(G, w); }
        // If marked, check if it's in the list -> Add path to stack
        else if (onStack[w]) {
            cycle = new Stack<Integer>();
            for (int x = v; x != w; x = edgeTo[x])
                cycle.push(x);
            cycle.push(w);
            cycle.push(v);
        }
        onStack[v] = false;
    }
    public boolean hasCycle() { return cycle != null; }
    public Iterable<Integer> cycle() { return cycle; }
}