import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TAbreadthFirstSearch {

	static boolean[] used;
	static int numberOfVerex;
	static int[] marks;
	static int number = 1;
	static int[][] matrix;

	public static void main(String[] args) throws IOException {
		readFromFile();
		for (int i = 0; i < numberOfVerex; i++)
			if (used[i])
				bfs(i);
		safeToFile();
	}

	public static void readFromFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//input.txt"));
		numberOfVerex = sc.nextInt();
		used = new boolean[numberOfVerex];
		marks = new int[numberOfVerex];
		matrix = new int[numberOfVerex][numberOfVerex];
		for (int i = 0; i < numberOfVerex; i++) {
			used[i] = true;
			for (int j = 0; j < numberOfVerex; j++)
				matrix[i][j] = sc.nextInt();
		}
	}

	public static void safeToFile() throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		if (numberOfVerex == 1) {
			outputFile.write(1 + "");
		} else {
			for (int i = 0; i < numberOfVerex; i++) {
				outputFile.write(marks[i] + " ");
			}
		}
		outputFile.close();
	}

	static void bfs(int index) {
		Queue<Integer> myQueue = new LinkedList<Integer>();
		myQueue.add(index);
		used[index] = false;
		while (!myQueue.isEmpty()) {
			index = myQueue.poll();
			marks[index] = number;
			number++;
			for (int j = 0; j < numberOfVerex; j++) {
				if (matrix[index][j] == 1 && used[j]) {
					myQueue.add(j);
					used[j] = false;
				}
			}
		}
	}
}