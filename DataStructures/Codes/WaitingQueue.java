package finalDataStructures;

public class WaitingQueue 
{
	private Patient front;
	private Patient rear;
	private int size;
	public WaitingQueue()
	{
		front = rear = null;
		size = 0;
	}
	public boolean isEmpty()
	{
		return (size == 0 && rear == null && front == null);
	}
	public void enqueue(String Name, int Id, int age, String ailment, boolean Emergency)
	{
		Patient newNode = new Patient(Name, Id, age, ailment, Emergency);
		if(isEmpty())
		{
			rear = front = newNode;
		}
		else
		{
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}
	public void dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
		}
		else
		{
			if(front == rear){
				rear = null;
			}
			//int id = front.Id;
			front = front.next;
			size--;
		}
	}
	public void peek()
	{
		try {
			System.out.println();
			System.out.println("######## Waiting Room ########");
			System.out.println(front.Name + ", " + front.Id +  ", " +front.age + ", " + front.ailment);
		}catch(Exception e)
		{
			System.out.println("The waiting room is empty.");
		}
	}
	
	public void printRoom()
	{
		try {
			System.out.println();
			System.out.println("######## Waiting Room ########");
			
			Patient loopingPatient = front;
			while(loopingPatient != null)
			{
				System.out.println(front.Name + ", " + front.Id +  ", " +front.age + ", " + front.ailment);
				loopingPatient=loopingPatient.next;
			}
		}catch(Exception e)
		{
			System.out.println("The waiting room is empty.");
		}
	}
}
