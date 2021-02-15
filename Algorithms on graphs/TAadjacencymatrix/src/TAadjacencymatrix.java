import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TAadjacencymatrix {

	static int[][] adjacencyMatrix;
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
		adjacencyMatrix = new int[numberOfVertex][numberOfVertex];
		for (int i = 0; i < numberOfVertex; i++) {
			for (int j = 0; j < numberOfVertex; j++) {
				adjacencyMatrix[i][j] = 0;
			}
		}
		for (int k = 0; k < numberOfRibs; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			adjacencyMatrix[i - 1][j - 1] = adjacencyMatrix[j - 1][i - 1] = 1;
		}
	}

	public static void safeToFile() throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		for (int i = 0; i < numberOfVertex; i++) {
			for (int j = 0; j < numberOfVertex; j++) {
				outputFile.write(adjacencyMatrix[i][j] + " ");
				if (j == numberOfVertex - 1)
					outputFile.write("\n");
			}
		}
		outputFile.close();
	}

}
