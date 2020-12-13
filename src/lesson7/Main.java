package lesson7;

public class Main {
    public static void main(String[] args) {
//        Graph graph = new Graph(10);
//        graph.addEdge(1, 2);
//        graph.addEdge(0, 4);
//        graph.addEdge(1, 4);
//        graph.addEdge(1, 0);
//
//        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 2);
//        System.out.println(bfp.hasPathTo(0));
//        System.out.println(bfp.pathTo(0));

        Graph graph2 = new Graph(10);
        graph2.addEdge(1, 2);
        graph2.addEdge(0, 4);
        graph2.addEdge(1, 4);
        graph2.addEdge(1, 0);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 2);
        graph2.addEdge(2, 7);
        graph2.addEdge(2, 8);
        graph2.addEdge(3, 6);
        graph2.addEdge(4, 1);
        graph2.addEdge(5, 7);
        graph2.addEdge(5, 9);
        graph2.addEdge(6, 2);

        BreadthFirstPaths bfp = new BreadthFirstPaths(graph2, 0);
        System.out.println(bfp.hasPathTo(9));
        System.out.println("Кратчайший путь: " + bfp.pathTo(9));

    }
}
