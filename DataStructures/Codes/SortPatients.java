package finalDataStructures;
import java.util.Random;

class SortPatients {
    public static Patient[] Merge_Sort(Patient[] A, int p, int r, boolean BisSortByAge)
    {
        if (p < r)
        {
            int q = (p + r) / 2;
            Merge_Sort(A, p, q, BisSortByAge);
            Merge_Sort(A, q + 1, r, BisSortByAge);
            if (BisSortByAge)
            {
            	MergeAge(A, p, q, r);
            }
            else 
            {
            	MergeID(A, p, q, r);
            }
        }
        return A;
    }

    private static void MergeAge(Patient[] A, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;

        Patient[] L = new Patient[n1];
        Patient[] R = new Patient[n2];

        for (int i = 0; i < n1; i++)
        {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++)
        {
            R[j] = A[q + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = p;    
        while (i < n1 && j < n2)
        {
            if (L[i].age <= R[j].age)
            {
                A[k] = L[i];
                i++;
            }
            else
            {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) 
        { 
            A[k] = L[i]; 
            i++; 
            k++; 
        }
        while (j < n2)
        {
            A[k] = R[j];
            j++;
            k++;
        }
    }
    private static void MergeID(Patient[] A, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;

        Patient[] L = new Patient[n1];
        Patient[] R = new Patient[n2];

        for (int i = 0; i < n1; i++)
        {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++)
        {
            R[j] = A[q + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = p;    
        while (i < n1 && j < n2)
        {
            if (L[i].Id <= R[j].Id)
            {
                A[k] = L[i];
                i++;
            }
            else
            {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) 
        { 
            A[k] = L[i]; 
            i++; 
            k++; 
        }
        while (j < n2)
        {
            A[k] = R[j];
            j++;
            k++;
        }
    }
    public static Patient[] Selection_Sort(Patient[] A, int n, boolean bisSortByAge)
    {
        int min = 0;
        for (int i = 0; i < n - 1; i++)
        {
            min = i;
            for (int j = i + 1; j < n; j++)
            {
            	if(bisSortByAge)
            	{
            		if (A[j].age < A[min].age)
                    {
                        min = j;
                    }
            	}
            	else
            	{
            		if (A[j].Id < A[min].Id)
                    {
                        min = j;
                    }
            	}
            }
            Patient temp = A[min];
            A[min] = A[i];
            A[i] = temp;
        }
        return A;
    }
    
	/*
	 * public static void main(String[] args) { Patient[] patientsSmall =
	 * generatePatients(100); Patient[] patientsMedium = generatePatients(1000);
	 * Patient[] patientsLarge = generatePatients(10000); long startTime =
	 * System.nanoTime(); SortPatients.Merge_Sort(patientsSmall.clone(), 0,
	 * patientsSmall.length - 1, false); long endTime = System.nanoTime();
	 * System.out.println("Merge Sort Small: " + (endTime - startTime) + " ns");
	 * startTime = System.nanoTime();
	 * SortPatients.Selection_Sort(patientsSmall.clone(), patientsSmall.length,
	 * false); endTime = System.nanoTime();
	 * System.out.println("Selection Sort Small: " + (endTime - startTime) + " ns");
	 * 
	 * System.out.println(); startTime = System.nanoTime();
	 * SortPatients.Merge_Sort(patientsMedium.clone(), 0, patientsMedium.length - 1,
	 * false); endTime = System.nanoTime(); System.out.println("Merge Sort Medium: "
	 * + (endTime - startTime) + " ns");
	 * 
	 * startTime = System.nanoTime();
	 * SortPatients.Selection_Sort(patientsMedium.clone(), patientsMedium.length,
	 * false); endTime = System.nanoTime();
	 * System.out.println("Selection Sort Medium: " + (endTime - startTime) +
	 * " ns");
	 * 
	 * System.out.println(); startTime = System.nanoTime();
	 * SortPatients.Merge_Sort(patientsLarge.clone(), 0, patientsLarge.length - 1,
	 * false); endTime = System.nanoTime(); System.out.println("Merge Sort Large: "
	 * + (endTime - startTime) + " ns");
	 * 
	 * startTime = System.nanoTime();
	 * SortPatients.Selection_Sort(patientsLarge.clone(), patientsLarge.length,
	 * false); endTime = System.nanoTime();
	 * System.out.println("Selection Sort Large: " + (endTime - startTime) + " ns");
	 * 
	 * }
	 * 
	 * private static Patient[] generatePatients(int size) { Random random = new
	 * Random(); Patient[] patients = new Patient[size]; for (int i = 0; i < size;
	 * i++) { patients[i] = new Patient("Patient" + i, i, random.nextInt(100),
	 * "Ailment" + i, false); } return patients; }
	 */


}
