import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinomialHeap {

	public static void main(String[] args) throws IOException {
		String number = toBinarySystem(readFromFile());
		List<Long> list = heightsCalculation(number);
		safeToFile(list);
	}

	public static List<Long> heightsCalculation(String number) {
		long n = number.length();
		List<Long> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (number.charAt(i) == '1') {
				list.add((long) (n - i - 1));
			}
		}
		return list;
	}

	public static String toBinarySystem(long number) {
		long temp;
		StringBuilder str = new StringBuilder();
		while (number != 0) {
			temp = number % 2;
			str.append(temp);
			number = number / 2;
		}
		str.reverse();
		String res = str.toString();
		return res;
	}

	public static void safeToFile(List<Long> res) throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		for (int i = res.size() - 1; i >= 0; i--) {
			outputFile.write(res.get(i) + "\n");
		}
		outputFile.close();
	}

	public static long readFromFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//input.txt"));
		long n = sc.nextLong();
		return n;
	}
}
