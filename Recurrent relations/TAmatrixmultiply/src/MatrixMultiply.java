import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MatrixMultiply {
	
	public static String multiply(int[] matrixSizes) {
		int n = matrixSizes.length - 1;
		int[][] tempResults = new int[n][n];

		for (int i = 0; i < n; ++i) {
			tempResults[i][i] = 0;
		}

		for (int l = 1; l < n; ++l) {
			for (int i = 0; i < n - l; ++i) {
				int j = i + l;
				tempResults[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; ++k) {
					tempResults[i][j] = Math.min(tempResults[i][j], tempResults[i][k] + tempResults[k + 1][j]
							+ matrixSizes[i] * matrixSizes[k + 1] * matrixSizes[j + 1]);
				}
			}
		}
		return tempResults[0][n - 1] +"";
	}

	public static int[] getArray() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//input.txt"));
		int count = sc.nextInt();
		int[] arr = new int[2 * count];
		while (sc.hasNext()) {
			for (int i = 0; i < 2 * count; i++) {
				int el = sc.nextInt();
				arr[i] = el;
			}
		}

		int[] finallArray = new int[count + 1];
		finallArray[0] = arr[0];
		int j = 1;
		for (int i = 1; i < 2 * count; i++) {
			finallArray[j] = arr[i];
			if (j != count)
				j++;
			if (i != 2 * count - 1)
				i++;
		}

		return finallArray;
	}

	
	public static void safeToFile(String result) throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		outputFile.write(result);
		outputFile.close();

	}

	public static void main(String[] args) throws IOException {
		int[] sizes = getArray();
		 String res = multiply(sizes);
		 safeToFile(res);
	}

}
