package finalDataStructures;

public class Employees 
{
	Employees next;
	Employees prev;
	
	Employees left;
	Employees right;
	
	String Name;
	int Id;
	
	public Employees(String Name, int Id)
	{
		this.Name = Name;
		this.Id = Id;
		next = null;
		prev = null;
		right = null;
		left = null;
	}

}
