import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class TA0_2roads {

	static int numberOfTowns, numberOfEarthquake, numberOfRoads;
	static int[][] roads;
	static boolean[] roadsToBreak;
	static int parent[];
	static int rank[];
	static int connectedComponent;
	static Stack<Integer> breakingRoads;

	public static void main(String[] args) throws IOException {

		readFromFile();

		parent = new int[numberOfTowns + 1];
		rank = new int[numberOfTowns + 1];
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < numberOfRoads; i++) {
			if (!roadsToBreak[i]) {
				union(roads[i][0], roads[i][1]);
			}
		}
		result.append(getVerdict());

		for (int i = 0; i < numberOfEarthquake - 1; i++) {
			int y = breakingRoads.pop();
			union(roads[y - 1][0], roads[y - 1][1]);
			result.append(getVerdict());
		}
		result.reverse();
		safeToFile(result.toString());
	}

	public static String getVerdict() {
		if (connectedComponent != 1) {
			return "0";
		} else {
			return "1";
		}
	}

	public static int findSet(int v) {
		if (parent[v] == v)
			return v;
		else
			return parent[v] = findSet(parent[v]);
	}

	public static void union(int x, int y) {
		int ap = findSet(x);
		int bp = findSet(y);
		if (ap == 0 && bp == 0) {
			parent[x] = x;
			parent[y] = x;
			rank[x]++;
			connectedComponent--;
		} else if (ap == 0) {
			parent[x] = parent[y];
			rank[parent[y]]++;
			connectedComponent--;
		} else if (bp == 0) {
			parent[y] = parent[x];
			rank[parent[x]]++;
			connectedComponent--;
		} else {
			if (!(ap == bp)) {
				if (rank[ap] < rank[bp]) {
					int k = bp;
					bp = ap;
					x = k;
				}
				parent[bp] = x;
				rank[ap] += rank[bp];
				connectedComponent--;
			}
		}
	}

	public static void readFromFile() throws IOException {
		FileReader fileReader = new FileReader(new File("src//input.txt"));
		BufferedReader sc = new BufferedReader(fileReader);
		StringTokenizer tk = new StringTokenizer(sc.readLine());
		numberOfTowns = Integer.parseInt(tk.nextToken());
		numberOfRoads = Integer.parseInt(tk.nextToken());
		numberOfEarthquake = Integer.parseInt(tk.nextToken());
		connectedComponent = numberOfTowns;
		roadsToBreak = new boolean[numberOfRoads];
		roads = new int[numberOfRoads][2];
		breakingRoads = new Stack<>();
		for (int i = 0; i < numberOfRoads; i++) {
			tk = new StringTokenizer(sc.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			roads[i][0] = a;
			roads[i][1] = b;
		}
		for (int i = 0; i < numberOfEarthquake; i++) {
			tk = new StringTokenizer(sc.readLine());
			int y = Integer.parseInt(tk.nextToken());
			breakingRoads.push(y);
			roadsToBreak[y - 1] = true;
		}
	}

	public static void safeToFile(String result) throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		outputFile.write(result);
		outputFile.close();
	}

}
