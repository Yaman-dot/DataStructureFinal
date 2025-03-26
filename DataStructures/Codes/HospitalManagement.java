package finalDataStructures;

public class HospitalManagement 
{
	WaitingQueue wq1;
	DischargeStack ds1;
	Patient head;
	Patient tail;
	int length;
	//
	public HospitalManagement()
	{
		head = null;
		length = 0;
		
		this.wq1 = new WaitingQueue();
		this.ds1 = new DischargeStack(1000);
	}
	
	//Time complicity O(n)
	public void updateTailPointer()
	{
		if(isEmpty())
		{
			System.out.println("List is Empty");
		}
		else
		{
			Patient loopingPatient = head;
			while(loopingPatient.next != null)
			{
				loopingPatient = loopingPatient.next;
			}
			tail = loopingPatient;
			
		}
	}
	//Time complexity O(n)
	public void Register(String Name, int Id, int age, String ailment, boolean Emergency)
	{
		Patient newPatient = new Patient(Name,Id,age,ailment, Emergency);
		if(Emergency)
		{
			if(isEmpty())
			{
					head = newPatient;
			}else
			{
					Patient loopingPatient = head;
					while(loopingPatient.next != null)
					{
						loopingPatient = loopingPatient.next;
					}
					loopingPatient.next = newPatient;
					newPatient.prev = loopingPatient;
					tail = newPatient;
					length++;
			}
		}else
		{
			//ENQUEUE HERE
			wq1.enqueue(Name, Id, age, ailment, Emergency);
		}
	}

	//Time complexity O(1)
	private boolean isEmpty()
	{
		return head == null;
	}
	//Time Complexity O(1)
	/*
	 * public void appendFirst(String Name, int Id, int age, String ailment) {
	 * Patient newPatient= new Patient(Name, Id, age, ailment, ); if(isEmpty()) {
	 * head = newPatient; }else { head.prev = newPatient; newPatient.next = head;
	 * head = newPatient; } length++; }
	 */
	//Time complexity O(1)
	/*
	 * public void deleteFirst() { if(isEmpty()) { head=head.next; head.prev = null;
	 * length--; } else { System.out.println("List is Empty"); } }
	 */
	//Time complexity O(n)
	/*
	 * public void deleteLast() { if(isEmpty()) {
	 * System.out.println("List is already Empty"); } else if(head.next == null) {
	 * head = null; length--; } else { Patient loopingPatient = head; while
	 * (loopingPatient.next.next != null) { loopingPatient = loopingPatient.next; }
	 * loopingPatient.prev.next = null; loopingPatient.prev = null; length--; }
	 * 
	 * }
	 */
	//Time complexity O(n)
	private void printRoom()
	{
		System.out.println();
		System.out.println("######## Emergency Room ########");
		Patient loopingPatient = head;
		while (loopingPatient != null)
		{
		    
			System.out.println(loopingPatient.Name + ", " + loopingPatient.Id +  ", " +loopingPatient.age + ", " + loopingPatient.ailment);
			
			loopingPatient = loopingPatient.next;
		}
	}
	public void printAll()
	{
		System.out.println();
		printRoom();
		wq1.printRoom();
		ds1.showDischarged();
	}
	//Time complexity O(n)
	public boolean search(int Id)
	{
		Patient loopingPatient = head;
		while(loopingPatient != null)
		{
			if(loopingPatient.Id == Id)
			{
				return true;
			}
			loopingPatient = loopingPatient.next;
		}
		return false;
	}

	//Time complexity O(n)
	public void discharge(int PatientId)
	{
		if(head == null)
		{
			return;
		}
		else if(head.Id == PatientId)
		{
	        ds1.push(head.Name, head.Id, head.age, head.ailment, head.bIsEmergency);
			head = head.next;
			
//			if(head!=null)
//			{
//				head.prev=null;
//			}
			return;
		}
		Patient loopingPatient = head;
		while(loopingPatient.next != null)
		{
			if(loopingPatient.next.Id == PatientId)
			{
		        ds1.push(head.Name, head.Id, head.age, head.ailment, head.bIsEmergency);
		        loopingPatient.next = loopingPatient.next.next;
                //loopingPatient.next.prev = loopingPatient;
				return;
			}
			loopingPatient = loopingPatient.next;
		}
		if (loopingPatient.Id == PatientId)
		{
			loopingPatient = null;
		}
	}
	
	public void reAdmitPatient()
	{
		if(ds1.isEmpty())
		{
			System.out.println("The Discharge Stack is empty");
			return;
		}
		
		Patient dischargedPatient = ds1.pop();
		
		if(dischargedPatient.bIsEmergency)
		{
			dischargedPatient.next = head;
			if (head!=null)
			{
				head.prev = dischargedPatient;
			}
			head = dischargedPatient;
			if(tail == null)
			{
				tail = head;
			}
		}
		else
		{
			if(tail!=null)
			{
				tail.next = dischargedPatient;
				dischargedPatient.prev = tail;
			}
			
			tail = dischargedPatient;
			if(head == null)
			{
				head = tail;
			}
		}
		
		System.out.println("Readmitted Patient: " + dischargedPatient.Name);
		
	}
	public void dequeue()
	{
		wq1.dequeue();
	}


}
