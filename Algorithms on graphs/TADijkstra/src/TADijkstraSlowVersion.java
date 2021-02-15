import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class TADijkstraSlowVersion {

	static int numberOfTowns;
	static int numberOfRoads;
	static int[][] roadsPrices;
	static int[] distances;
	static int[] visitedTowns;
	static int result;

	public static void main(String[] args) throws IOException {
		readFromFile();
		Dijkstra();
		safeToFile();
	}

	public static void Dijkstra() {
		distances = new int[numberOfTowns];
		visitedTowns = new int[numberOfTowns];
		for (int i = 0; i < numberOfTowns; i++) {
			distances[i] = 1000000;
			visitedTowns[i] = 1;
		}
		int minIndex, min, temp;
		distances[0] = 0;
		int straightPath = 100000;
		if (roadsPrices[0][numberOfTowns - 1] != 0 && roadsPrices[0][numberOfTowns - 1] != 100000) {
			straightPath = roadsPrices[0][numberOfTowns - 1];
		}

		do {
			minIndex = 1000000;
			min = 1000000;
			for (int i = 0; i < numberOfTowns; i++) {
				if ((visitedTowns[i] == 1) && (distances[i] < min)) {
					min = distances[i];
					minIndex = i;
				}
			}
			if (minIndex != 1000000) {
				for (int i = 0; i < numberOfTowns; i++) {
					if (roadsPrices[minIndex][i] > 0) {
						temp = min + roadsPrices[minIndex][i];
						if (temp < distances[i]) {
							distances[i] = temp;
						}
					}
				}
				visitedTowns[minIndex] = 0;
			}
		} while (minIndex < 1000000);
		if (distances[numberOfTowns - 1] < straightPath) {
			result = distances[numberOfTowns - 1];
		} else
			result = straightPath;

	}

	public static void readFromFile() throws IOException {
		FileReader fileReader = new FileReader(new File("src//input.txt"));
		BufferedReader sc = new BufferedReader(fileReader);
		StringTokenizer tk = new StringTokenizer(sc.readLine());
		numberOfTowns = Integer.parseInt(tk.nextToken());
		numberOfRoads = Integer.parseInt(tk.nextToken());
		roadsPrices = new int[numberOfTowns][numberOfTowns];
		for (int i = 0; i < numberOfTowns; i++) {
			for (int j = 0; j < numberOfTowns; j++) {
				roadsPrices[i][j] = 1000000;
				roadsPrices[i][i] = 0;
			}
		}
		for (int i = 0; i < numberOfRoads; i++) {
			tk = new StringTokenizer(sc.readLine());
			int firstCity = Integer.parseInt(tk.nextToken()) - 1;
			int secondCity = Integer.parseInt(tk.nextToken()) - 1;
			int length = Integer.parseInt(tk.nextToken());
			if (roadsPrices[firstCity][secondCity] == 0 || roadsPrices[firstCity][secondCity] == 1000000) {
				roadsPrices[firstCity][secondCity] = roadsPrices[secondCity][firstCity] = length;
			} else {
				if (roadsPrices[firstCity][secondCity] > length) {
					roadsPrices[firstCity][secondCity] = roadsPrices[secondCity][firstCity] = length;
				}
			}

		}

	}

	public static void safeToFile() throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		outputFile.write(result + "");
		outputFile.close();
	}
}