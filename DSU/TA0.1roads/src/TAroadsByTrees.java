import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TAroadsByTrees {

	static int numberOfTowns;
	static int numberOfRoads;
	static int parent[];
	static int rank[];

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new FileReader("src//input.txt")));
		if (st.nextToken() == StreamTokenizer.TT_NUMBER) {
			numberOfTowns = (int) st.nval;
		}
		if (st.nextToken() == StreamTokenizer.TT_NUMBER) {
			numberOfRoads = (int) st.nval;
		}
		int data[] = new int[2 * numberOfRoads];
		for (int i = 0; i < 2 * numberOfRoads; i++) {
			if (st.nextToken() == StreamTokenizer.TT_NUMBER) {
				data[i] = (int) st.nval;
			}
		}
		parent = new int[numberOfTowns + 1];
		rank = new int[numberOfTowns + 1];
		initDSU();
		int k = numberOfTowns;
		FileWriter outputFile = new FileWriter("output.txt");
		int n = 2 * numberOfRoads;
		for (int i = 0; i < n; i++) {
			boolean res = merge(data[i], data[i + 1]);
			if (res == false) {
				outputFile.write(numberOfTowns + "\n");
			} else {
				numberOfTowns--;
				outputFile.write(numberOfTowns + "\n");
			}
			i++;
		}
		outputFile.close();

	}

	public static void initDSU() {
		for (int i = 1; i < numberOfTowns + 1; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	public static int findSet(int v) {
		if (parent[v] == v) {
			return v;
		} else {
			return parent[v] = findSet(parent[v]);
		}
	}

	public static boolean merge(int firstEl, int secondEl) {
		int firstRepresentative = findSet(firstEl);
		int secondRepresentative = findSet(secondEl);
		if (firstRepresentative == secondRepresentative)
			return false;
		else {
			if (rank[firstRepresentative] <= rank[secondRepresentative]) {
				parent[firstRepresentative] = secondRepresentative;
				rank[secondRepresentative] += rank[firstRepresentative];
				rank[firstRepresentative] = 0;
			} else if (rank[secondRepresentative] < rank[firstRepresentative]) {
				parent[secondRepresentative] = firstRepresentative;
				rank[firstRepresentative] += rank[secondRepresentative];
				rank[secondRepresentative] = 0;
			}
			return true;
		}
	}
}
