import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TAmeeting {

	static int countOfHouses;
	static int countOfRoads;
	static int houseNumber;
	static int[][] arr;
	static int[] specialCase;

	public static void main(String[] args) throws IOException {
		readFromFile();
		if (countOfHouses == 2) {
			FileWriter outputFile = new FileWriter("output.out");
			outputFile.write(specialCase[0] + " " + specialCase[1] + " " + specialCase[2] / 2);
			outputFile.close();
		} else {
			int res = func();
			System.out.println(houseNumber+" "+res);
			safeToFile(res);
		}
	}

	public static void safeToFile(int res) throws IOException {
		FileWriter outputFile = new FileWriter("output.out");
		outputFile.write(houseNumber + " " + res);
		outputFile.close();
	}

	public static void print() {
		for (int i = 1; i < countOfHouses + 1; i++) {
			for (int j = 1; j < countOfHouses + 1; j++) {
				System.out.print(arr[i][j] + " ");
				if (j == countOfHouses)
					System.out.println();
			}
		}
	}

	public static void readFromFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//input.in"));
		countOfHouses = sc.nextInt();
		countOfRoads = sc.nextInt();
		if (countOfHouses == 2) {
			specialCase = new int[3];
			int u = sc.nextInt();
			int v = sc.nextInt();
			int distance = sc.nextInt();
			specialCase[0] = u;
			specialCase[1] = v;
			specialCase[2] = distance;
		} else {
			arr = new int[countOfHouses + 1][countOfHouses + 1];
			for (int i = 1; i < countOfHouses + 1; i++) {
				for (int j = 1; j < countOfHouses + 1; j++) {
					if (j == i) {
						arr[i][j] = 0;
					} else
						arr[i][j] = 100000000;
				}
			}
			for (int i = 1; i < countOfRoads + 1; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int distance = sc.nextInt();
				arr[u][v] = arr[v][u] = distance;
			}
		}
	}

	public static int func() {
		int minSum = Integer.MAX_VALUE;
		houseNumber = -1;
		for (int k = 1; k < countOfHouses + 1; k++) {
			for (int i = 1; i < countOfHouses + 1; i++) {
				for (int j = 1; j < countOfHouses + 1; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
			//print();
			//System.out.println();
		}

		for (int i = 1; i < countOfHouses + 1; i++) {
			int curSum = 0;
			for (int j = 1; j < countOfHouses + 1; j++) {
				curSum += arr[i][j];
			}
			if (curSum < minSum) {
				minSum = curSum;
				houseNumber = i;
			}
		}
		return minSum;
	}

}
