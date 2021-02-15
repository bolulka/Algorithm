import java.io.*;
import java.util.*;

public class TADijkstra {

	static int n;
	static int m;
	static boolean[] visited;
	static long[] distances;
	static List<List<Pair>> list;
	static long result;

	public static void main(String[] args) throws IOException {
		readFromFile();
		Dijkstra();
		safeToFile();
	}

	public static void Dijkstra() {
//		Comparator<Vertex> comparator = new Comparator<Vertex>() {
//			@Override
//			public int compare(Vertex o1, Vertex o2) {
//				if (o1.mark < o2.mark) {
//					return -1;
//				} else if (o1.mark > o2.mark) {
//					return 1;
//				}
//				return 0;
//			}
//		};

		PriorityQueue<Vertex> pq = new PriorityQueue<>(m == 0 ? 1 : m, new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				if (o1.mark < o2.mark) {
					return -1;
				} else if (o1.mark > o2.mark) {
					return 1;
				}
				return 0;
			}
		});
		
		pq.add(new Vertex(0, 0L));
		Vertex tempVertex;

		while (!pq.isEmpty()) {
			tempVertex = pq.poll();
			if (!visited[tempVertex.number]) {
				visited[tempVertex.number] = true;
				if (tempVertex.number == 0) {
					distances[tempVertex.number] = 0L;
				} else {
					distances[tempVertex.number] = tempVertex.mark;
				}
				for (int i = 0; i < list.get(tempVertex.number).size(); i++) {
					pq.add(new Vertex(list.get(tempVertex.number).get(i).vertexNum,
							distances[tempVertex.number] + list.get(tempVertex.number).get(i).length));
				}
			}
		}
		result = distances[n - 1];
		System.out.println(distances[n - 1]);
	}

	public static void readFromFile() throws IOException {
		FileReader fileReader = new FileReader(new File("src//input.txt"));
		BufferedReader sc = new BufferedReader(fileReader);
		StringTokenizer tk = new StringTokenizer(sc.readLine());
		n = Integer.parseInt(tk.nextToken());
		m = Integer.parseInt(tk.nextToken());
		visited = new boolean[n];
		distances = new long[n];
		for (int i = 0; i < n; i++) {
			visited[i] = false;
			distances[i] = 0L;
		}
		int from, to, length;
		list = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			tk = new StringTokenizer(sc.readLine());
			from = Integer.parseInt(tk.nextToken());
			to = Integer.parseInt(tk.nextToken());
			length = Integer.parseInt(tk.nextToken());
			if (from != to) {
				list.get(from - 1).add(new Pair(to - 1, length));
				list.get(to - 1).add(new Pair(from - 1, length));
			}
		}
	}

	public static void safeToFile() throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		outputFile.write(result + "");
		outputFile.close();
	}
}

class Pair {

	int vertexNum;
	int length;

	public Pair(int toVertex, int lengthToVertex) {
		this.vertexNum = toVertex;
		this.length = lengthToVertex;
	}
}

class Vertex {

	int number;
	long mark;

	public Vertex(int num, long mark) {
		this.number = num;
		this.mark = mark;
	}
}