import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BinaryHeap {

	public static void main(String[] args) throws IOException {
		int[] mas = readFromFile();
		boolean res = isBinaryHeap(mas);
		safeToFile(res);
	}

	public static boolean isBinaryHeap(int[] mas) {
		int n = mas.length - 1;
		if (n == 1)
			return true;
		for (int i = 1; i <= n / 2; i++) {
			if (2 * i < n) {
				if (mas[i] > mas[2 * i] || mas[i] > mas[2 * i + 1]) {
					return false;
				}
			} else {
				if (mas[i] > mas[2 * i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void safeToFile(boolean res) throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		if (res == true) {
			outputFile.write("Yes");
		} else {
			outputFile.write("No");
		}
		outputFile.close();
	}

	public static int[] readFromFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//input.txt"));
		int n = sc.nextInt();
		int[] mas = new int[n + 1];
		mas[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			mas[i] = sc.nextInt();
		}
		return mas;
	}
}
