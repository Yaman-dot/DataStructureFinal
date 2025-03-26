package finalDataStructures;

public class HospitalPlan 
{
	static ShortestPathPlan spp1 = new ShortestPathPlan();
	private int[][] adjacencyMatrix;
    private int numVertices;
    private String[] names;
    public HospitalPlan(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
        names = new String[numVertices];
    }
    
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }
    
    public void setName(int i, String name)
    {
    	names[i] = name;
    }
    
    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight;
        
    }
    
    public void print(int width)
    {
    	System.out.println("########### Hospital Plan #############");
    	System.out.println();
        System.out.print(String.format("%-" + width + "s", ""));
    	for(int i = 0; i < numVertices; i++)
    	{
            System.out.print(String.format("%-" + width + "s", names[i]));
    	}
    	System.out.println();
    	for(int i = 0; i<numVertices; i++)
    	{
            System.out.print(String.format("%-" + width + "s", names[i]));
    		for(int j = 0; j< numVertices; j++)
    		{
                System.out.print(String.format("%-" + width + "d", adjacencyMatrix[i][j]));
    		}
    		System.out.println();
    	}
    	System.out.println();
    	System.out.println("#######################################");
    	System.out.println();
    }
    
    public int[][] InitiatePlan()
    {
    	
    	setName(0, "Room101");
        setName(1, "Hallway");
        setName(2, "ICU");
        setName(3, "Hallway2");
        setName(4, "ER");
        setName(5, "Hallway3");
        setName(6, "Exit1");
        
        //ROOM 1
        addEdge(0, 1, 2);
        addEdge(0, 3, 3);
        
        //HALLWAY
        addEdge(1, 4, 4);
        addEdge(1, 2, 3);
        addEdge(1, 6, 7);
        addEdge(1, 5, 4);
        
        //HALLWAY 2
        addEdge(3, 6, 4);
        addEdge(3, 4, 1);
        
        //HALLWAY 3
        addEdge(5, 2, 2);
        addEdge(5, 4, 1);
        addEdge(5, 6, 1);
        
        //ICU
        //Already connected
        
        //ER
        //Already Connected
        
        //Exit
        //Already Connected
        
        
        print(10);
        System.out.println("Shortest Path Plan with Dijkstra");
		spp1.calculateEscapePlan(adjacencyMatrix, 0);
		System.out.println();
		System.out.println("Bellman-------Ford");
		spp1.bellmanFord(adjacencyMatrix, 0);
		
		
        return adjacencyMatrix;

    }

}
