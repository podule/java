package lesson7;

import java.util.LinkedList;

public abstract class BaseFirstPaths {
    protected boolean[] marked;
    protected int[] edgeTo;
    protected int source;

    public BaseFirstPaths(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        search(g, source);
    }

    abstract void search(Graph g, int source);


    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

}
