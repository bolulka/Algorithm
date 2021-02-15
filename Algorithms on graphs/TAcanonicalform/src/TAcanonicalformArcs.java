import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TAcanonicalformArcs {

	static int numberOfVertex;
	static int[] p;

	public static void main(String[] args) throws IOException {
		readFromFile();
		safeToFile();
	}

	public static void readFromFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//input1.txt"));
		numberOfVertex = sc.nextInt();
		p = new int[numberOfVertex];
		for (int i = 0; i < numberOfVertex; i++)
			p[i] = 0;
		while(sc.hasNext()) {
			int value = sc.nextInt();
			int index = sc.nextInt();
			p[index - 1] = value;
		}
	}

	public static void safeToFile() throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		for (int i = 0; i < numberOfVertex; i++) {
			outputFile.write(p[i] + " ");
		}
		outputFile.close();
	}
}