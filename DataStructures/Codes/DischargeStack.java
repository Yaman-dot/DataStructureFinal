package finalDataStructures;


public class DischargeStack 
{
	private int topSize;
	private int size;
	Patient top;

	public DischargeStack(int size)
	{
		top = null;
		this.size = size;
		topSize = -1;
	}
	public void push(String Name, int Id, int age, String ailment, boolean Emergency)
	{
		if(isFull())
		{
			System.out.println("Stack is full");
			return;
		}
		Patient newNode = new Patient(Name, Id, age, ailment, Emergency);
		newNode.next = top;
		top = newNode;
		topSize++;
	}
	public Patient pop()
	{
		if(isEmpty())
		{
			System.out.println("Stacked Array is Empty");
			return null;
		}
		System.out.println("\nPopped Patient: " + top.Name + " ID: " +top.Id); // Print the popped value
		Patient poppedPatient = top;
		
		
		top = top.next; // Move head to the next node
        topSize--; // Decrement the top index
        
        return poppedPatient;
	}
	public void peak()
	{
		if(isEmpty())
		{
			return;
		}
		else
		{
			System.out.println("Top is " + top.Name + " ID: " +top.Id);
		}
	}
	public boolean isFull()
	{
		return topSize == size - 1;
	}
	public int size()
	{
		return topSize+1;
	}
	public boolean isEmpty()
	{
		return top == null;
	}
	public void showDischarged()
	{
		System.out.println();
		System.out.println("######## Discharged Patients ########");
		Patient loopingNode = top;
		while (loopingNode != null)
		{
			System.out.println(loopingNode.Name + " ID: " + loopingNode.Id  + " ");
			loopingNode = loopingNode.next;
		}
	}

}
