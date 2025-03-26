package finalDataStructures;

public class ShortestPathPlan 
{
	static final int NUM_VERTICES = 7;

	
	int findMinDistanceVertex(int distances[], Boolean shortestPathTreeSet[]) {
		
		int minDistance = Integer.MAX_VALUE;
		int minDistanceVertex = -1;

		for (int v = 0; v < NUM_VERTICES; v++) {
			if (!shortestPathTreeSet[v] && distances[v] <= minDistance) {
				minDistance = distances[v];
				minDistanceVertex = v;
			}
		}

		return minDistanceVertex;
	}

	// Print the constructed distance array
	void printSolution(int distances[]) {
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < NUM_VERTICES; i++) {
			System.out.println(i + " \t\t " + distances[i]);

		}
	}

	// Implement Dijkstra's single source shortest path algorithm for a graph
	// represented using adjacency matrix representation
	void calculateEscapePlan(int graph[][], int sourceVertex) {
		
		
		int[] distances = new int[NUM_VERTICES]; 
		Boolean[] shortestPathTreeSet = new Boolean[NUM_VERTICES];

		for (int i = 0; i < NUM_VERTICES; i++) {
			distances[i] = Integer.MAX_VALUE;
			shortestPathTreeSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		distances[sourceVertex] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < NUM_VERTICES; count++) {
		
			int u = findMinDistanceVertex(distances, shortestPathTreeSet);

			// Mark the picked vertex as processed
			shortestPathTreeSet[u] = true;

			for (int v = 0; v < NUM_VERTICES; v++) {
			
				if (!shortestPathTreeSet[v] && 
						
						graph[u][v] != 0 && 
						
						distances[u] != Integer.MAX_VALUE && 
						
						distances[u] + graph[u][v] < distances[v]) {
					
					distances[v] = distances[u] + graph[u][v];
				}
			}
		}

		// Print the constructed distance array
		printSolution(distances);
	}
	
	
	
	
	
	
	
	
	
	
	void bellmanFord(int graph[][], int sourceVertex) {
	    int[] distances = new int[NUM_VERTICES];

	    // Step 1: Initialize distances
	    for (int i = 0; i < NUM_VERTICES; i++) {
	        distances[i] = Integer.MAX_VALUE;
	    }
	    distances[sourceVertex] = 0;

	    // Step 2: Relax all edges |V| - 1 times
	    for (int i = 1; i < NUM_VERTICES; i++) {
	        for (int u = 0; u < NUM_VERTICES; u++) {
	            for (int v = 0; v < NUM_VERTICES; v++) {
	                if (graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE && 
	                    distances[u] + graph[u][v] < distances[v]) {
	                    distances[v] = distances[u] + graph[u][v];
	                }
	            }
	        }
	    }

	    // Step 3: Check for negative weight cycles
	    for (int u = 0; u < NUM_VERTICES; u++) {
	        for (int v = 0; v < NUM_VERTICES; v++) {
	            if (graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE && 
	                distances[u] + graph[u][v] < distances[v]) {
	                System.out.println("Graph contains a negative weights");
	                return;
	            }
	        }
	    }

	    // Step 4: Print the shortest distances
	    printSolution(distances);
	}
}
