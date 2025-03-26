package finalDataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
        Random random = new Random();

		//initialize pointers
		HospitalManagement hm1 = new HospitalManagement();
		AdminstrationTree AT1 = new AdminstrationTree();
		HospitalPlan hp1 = new HospitalPlan(7);
		ShortestPathPlan spp1 = new ShortestPathPlan();
		
		
		
		//Initialize the floor plan and find the closest distance to exit from selected source
		int[][] floorPlan = hp1.InitiatePlan();
		
		System.out.println();
		System.out.println("########################################");
		
		hm1.Register("Yman", 1, 1, "problem", false);
		hm1.Register("Yman", 2, 1, "problem", true);

		hm1.dequeue();
		// Print all patients in emergency room, waiting room, and discharged list
		hm1.printAll();



		
		
//		//mManage employees using a binary search tree
//		AT1.insert(15, "Mohammad Al Yaman Al Zalami");
//		String[] names = {
//	            "Ahmed bin Khalid",
//	            "Yousef bin Zaid",
//	            "Ibrahim bin Omar",
//	            "Hassan bin Saleh",
//	            "Abdullah bin Tareq",
//	            "Ali bin Samir",
//	            "Saif bin Jamal",
//	            "Omar bin Faisal",
//	            "Zayd bin Ibrahim",
//	            "Khalid bin Mahmoud",
//	            "Hamza bin Nasir",
//	            "Amir bin Yassin",
//	            "Salim bin Rashid",
//	            "Fahad bin Tariq",
//	            "Bilal bin Anwar",
//	            "Musa bin Haidar",
//	            "Ismail bin Taher",
//	            "Majid bin Younis",
//	            "Adnan bin Lutfi"
//	        };
//
//		 // Create a list of indices to shuffle
//        List<Integer> indices = new ArrayList<>();
//        for (int i = 2; i < names.length + 2; i++) {
//            indices.add(i);
//        }
//
//        // Shuffle the indices
//        Collections.shuffle(indices);
//
//        // Insert each name into the list at a random index
//        for (int i = 0; i < names.length; i++) {
//            AT1.insert(indices.get(i), names[i]);
//            //System.out.print(indices.get(i) + " ");
//        }
//        
//        //System.out.println();
//        
//        //AT1.postorder();
//		
//		
//		//hm1.discharge(0);
//		//hm1.wq1.peek()
	}

}
