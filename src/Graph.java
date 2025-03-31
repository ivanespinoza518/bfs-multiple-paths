// Ivan Espinoza
// Project 1

import java.util.*;

public class Graph {
    private final int numVertices;
    private final Integer [][] adjacencyMatrix;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new Integer[numVertices + 1][numVertices + 1];
    }

    public void initEdges(int vertex, List<Integer> neighbors) {
        int current = 1;
        for (int neighbor : neighbors)
            adjacencyMatrix[vertex][current++] = neighbor;
    }

    public void bfs() {
        Queue<Integer> perimeter = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();
        int [] parentOf = new int[numVertices + 1];
        int numPaths = 0;

        perimeter.add(1);
        visited.add(1);

        for (int i = 0; i <= numVertices; i++)
            parentOf[i] = 0;

        while (!perimeter.isEmpty()) {
            int from = perimeter.remove();

            if (from == numVertices) {
                Stack<Integer> path = new Stack<>();
                path.push(from);

                int parent = parentOf[from];

                while (parent != 0) {
                    path.push(parent);
                    parent = parentOf[parent];
                }

                while (!path.isEmpty()) {
                    int vertex = path.pop();

                    adjacencyMatrix[vertex][parentOf[vertex]] = 0;
                    adjacencyMatrix[parentOf[vertex]][vertex] = 0;

                    System.out.print(vertex + " ");
                }

                System.out.println();

                for (int i = 0; i <= numVertices; i++)
                    parentOf[i] = 0;

                perimeter.clear();
                visited.clear();

                perimeter.add(1);
                visited.add(1);

                numPaths++;
            }

            else {
                for (int to = 1; to <= numVertices; to++) {
                    if (adjacencyMatrix[from][to] == 1 && !visited.contains(to)) {
                        perimeter.add(to);
                        visited.add(to);
                        parentOf[to] = from;
                    }
                }
            }
        }

        System.out.println(numPaths + " paths\n");
    }
}
