import java.io.*;
import java.util.*;

public class TA0_0 {

	public static void main(String[] args) throws IOException {
		
		Set<Long> array = getArray();
		String output = "output.txt";
		System.out.print(array.toString());
		long sum=getRootSum(array);
		saveToFile(output,sum);
	}
	
	public static Set<Long> getArray() throws NoSuchElementException, FileNotFoundException{
		Scanner input = new Scanner(new File("src//input.txt"));
		Set<Long> arr = new TreeSet<Long>();
		while(input.hasNext()) {
		arr.add(input.nextLong());
		}
		return arr;
	}
	
	 public static long getRootSum(Set<Long> arr) {
		 long sum = 0;
		for(long el: arr) {
			sum+=el;
		}
		return sum; 
	 }
	 
	 public static void saveToFile(String fileName, long sum) throws IOException {
         FileWriter outputFile = new FileWriter(fileName);
         String res = sum + "";
         outputFile.write(res);
         outputFile.close();
     }
}
