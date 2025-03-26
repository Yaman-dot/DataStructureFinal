package finalDataStructures;

public class Patient 
{
	Patient next;
	Patient prev;
	
	String Name;
	int Id;
	int age;
	String ailment;
	boolean bIsEmergency;
	
	public Patient(String Name, int Id, int age, String ailment, boolean Emergency)
	{
		this.Name = Name;
		this.Id = Id;
		this.age = age;
		this.ailment = ailment;
		this.bIsEmergency = Emergency;
		next = null;
		prev = null;
	}
}
