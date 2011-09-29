import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet1 extends Thread {

	
	public static void main(String[] args) {
		Integer[] arr = {7,5,7,3};
		Set<Integer> set = new TreeSet<Integer>(Arrays.asList(arr)); 
		set.add(4);
		for(Integer value: set){
			System.out.print(value);
		}
		
		System.out.println(Status.Published.index + Status.Rejected.index); // Line 10
	}
}
                                                  
enum Status {
	Published(1), Rejected(2); // Line 2
	int index;  // Line 3
	Status(int i) { index = i; }
        int getIndex(){return index;} // Line 5
}


