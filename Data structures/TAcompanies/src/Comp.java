import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Comp {

	static int input[][];
	static boolean visited[];
	static int sum[];
	static int numberOfCompanies = 0;

	public static void main(String[] args) throws IOException {
		readFromFile();
		FileWriter outputFile = new FileWriter("output.txt");
		for (int i = 1; i <= numberOfCompanies; i++) {
			for (int j = 1; j <= numberOfCompanies; j++) {
				visited[j] = false;
				sum[j] = 0;
			}
			func(i);
			for (int company = 1; company <= numberOfCompanies; company++) {
				if (sum[company] > 50 && company != i) {
					outputFile.write(i + " " + company + "\n");
					System.out.println(i + " " + company);
				}
			}
		}
		outputFile.close();
	}

	static void func(int index) {
		if (visited[index]) {
			return;
		}
		visited[index] = true;
		for (int i = 1; i <= numberOfCompanies; i++) {
			sum[i] = sum[i] + input[index][i];
			if (sum[i] > 50) {
				func(i);
			}
		}
	}

	public static void readFromFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//input04.txt"));
		input = new int[1000][1000];
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				input[i][j] = 0;
			}
		}
		while (sc.hasNext()) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int proc = sc.nextInt();
			input[i][j] = proc;
			int n = Math.max(i, j);
			if (numberOfCompanies < n)
				numberOfCompanies = n;
		}
		visited = new boolean[1000];
		sum = new int[1000];
	}
}
