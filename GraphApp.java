import java.util.Scanner;

public class GraphApp {

    private static final int MAX_VERTICES = 10; // Adjust as needed
    private int[][] adjMatrix;
    private int numVertices;

    public GraphApp() {
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        numVertices = 0;
    }

    public void addVertex() {
        if (numVertices < MAX_VERTICES) {
            numVertices++;
        } else {
            System.out.println("Graph is full. Cannot add more vertices.");
        }
    }

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjMatrix[source][destination] = 1; // Assuming undirected graph
            adjMatrix[destination][source] = 1;
        } else {
            System.out.println("Invalid vertex indices.");
        }
    }

    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphApp graph = new GraphApp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Graph Application");
        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        for (int i = 0; i < numVertices; i++) {
            graph.addVertex();
        }

        System.out.println("Enter edges (source, destination, -1 to finish):");
        int source, destination;
        do {
            source = scanner.nextInt();
            destination = scanner.nextInt();
            if (source != -1 && destination != -1) {
                graph.addEdge(source, destination);
            }
        } while (source != -1 && destination != -1);


        graph.printGraph();
        scanner.close();
    }
              }
          
