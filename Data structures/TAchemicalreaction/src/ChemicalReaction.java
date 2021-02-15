import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ChemicalReaction {
	static int n;
	static int m;
	static int[][] mas;
	static int[] data;

	public static void main(String[] args) throws IOException {
		readFromFile();
		Stack<Integer> res = reaction(data, mas);
		safeToFile(res);
	}

	public static void safeToFile(Stack<Integer> stack) throws IOException {
		FileWriter outputFile = new FileWriter("out.txt");
		while (!stack.isEmpty()) {
			if (stack.size() == 1) {
				int el = stack.pop();
				outputFile.write("" + el);
			} else {
				int el = stack.pop();
				outputFile.write(el + " ");
			}
		}
		outputFile.close();
	}

	public static void readFromFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//in05.txt"));
		n = sc.nextInt();
		m = sc.nextInt();
		mas = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mas[i][j] = sc.nextInt();
			}
		}
		data = new int[m];
		for (int i = 0; i < m; i++) {
			data[i] = sc.nextInt();
		}
	}

	public static Stack<Integer> reaction(int[] data, int[][] mas) {
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < m; i++) {
			int element = data[i];
			while (!stack.isEmpty() && mas[element - 1][stack.peek() - 1] != 0) {
				element = mas[element - 1][stack.peek() - 1];
				stack.pop();
			}
			stack.push(element);
		}
		return stack;
	}

	public static Stack<Integer> reaction2(int[] data, int[][] mas) {
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < m; i++) {
			int element = data[i];
			while (!stack.isEmpty() && mas[element - 1][stack.peek() - 1] != 0) {
				if (element != stack.peek()) {
					element = mas[element - 1][stack.peek() - 1];
					stack.pop();
				}
				stack.push(element);
			}
			stack.push(element);
		}
		return stack;
	}
}
