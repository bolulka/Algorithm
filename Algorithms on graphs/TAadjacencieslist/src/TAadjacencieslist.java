import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TAadjacencieslist {

	static List<List<Integer>> adjacencyList;
	static int numberOfVertex;
	static int numberOfRibs;

	public static void main(String[] args) throws IOException {
		readFromFile();
		safeToFile();
	}

	public static void readFromFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//input.txt"));
		numberOfVertex = sc.nextInt();
		numberOfRibs = sc.nextInt();
		adjacencyList = new ArrayList<>(numberOfVertex);
		for (int i = 0; i < numberOfVertex; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		for (int k = 0; k < numberOfRibs; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			adjacencyList.get(i-1).add(j);
			adjacencyList.get(j-1).add(i);
		}
	}

	public static void safeToFile() throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		for (int i = 0; i < numberOfVertex; i++) {
			outputFile.write(adjacencyList.get(i).size() + " ");
			for (int el : adjacencyList.get(i)) {
				outputFile.write(el + " ");
			}
			outputFile.write("\n");
		}
		outputFile.close();
	}

}