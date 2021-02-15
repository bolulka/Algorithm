import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) throws IOException {
		List<Integer> elements = new ArrayList<Integer>();
		int numberOfElements = System.in.read();
		for (int i = 0; i < numberOfElements; i++) {
			elements.add(System.in.read());
		}
		List<Integer> elementsForSearch = new ArrayList<Integer>();
		int numberOfSearchElements = System.in.read();
		for (int i = 0; i < numberOfSearchElements; i++) {
			elementsForSearch.add(System.in.read());
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < numberOfSearchElements; i++) {
			result = binarySearch(result, elementsForSearch.get(i));
		}
		showResult(result);

	}

	public static List<Integer> binarySearch(List<Integer> list, int element) {
		List<Integer> res = null;
		int first = 0;
		int last = list.size() - 1;
		int pos = (first + last) / 2;
		while (list.get(pos) != element && first <= last) {
			if (list.get(pos) > element) {
				last = pos - 1;
			} else {
				first = pos + 1;
			}
			pos = (first + last) / 2;
		}
		if (first <= last) {
			res.add(1);
			res.add(pos);
			res.add(pos + 1);
		} else {
			res.add(0);
			res.add(null);
			res.add(null);
		}
		return res;
	}

	public static void showResult(List<Integer> res) {
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
			System.out.print(res.get(i + 1) + " ");
			System.out.println(res.get(i + 2) + " ");
			i = i + 2;
		}
	}

}
