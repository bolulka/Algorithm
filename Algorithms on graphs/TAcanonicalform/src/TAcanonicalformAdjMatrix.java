import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TAcanonicalformAdjMatrix {

	static int numberOfVertex;
	static int[] p;

	public static void main(String[] args) throws IOException {
		readFromFile();
		safeToFile();
	}

	public static void readFromFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//input2.txt"));
		String line = sc.nextLine();
		numberOfVertex = Integer.parseInt(line);
		p = new int[numberOfVertex];
		for (int i = 0; i < numberOfVertex; i++)
			p[i] = 0;
		for (int i = 0; i < numberOfVertex; i++) {
			String[] buf = sc.nextLine().split(" ");
			for (int j = 0; j < buf.length; j++) {
				if (buf[j].equals("1")) {
					p[j] = i+1;
				}
			}
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
