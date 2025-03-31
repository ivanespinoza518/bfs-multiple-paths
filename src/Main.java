// Ivan Espinoza
// Project 1
// COMP 482
// Professor Noga

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);

            int numVertices = Integer.parseInt(scanner.nextLine());
            Graph testGraph = new Graph(numVertices);

            int currVertex = 1;
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                List<Integer> neighbors = new ArrayList<>();
                for (String s : data.split(" ")) {
                    neighbors.add(Integer.parseInt(s));
                }

                testGraph.initEdges(currVertex, neighbors);
                currVertex++;
            }

            testGraph.bfs();

            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
