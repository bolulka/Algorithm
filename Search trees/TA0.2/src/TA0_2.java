import java.io.*;
import java.util.*;

public class TA0_2 implements Runnable {

	public static void main(String[] args) throws IOException {

		new Thread(null, new TA0_2(), "", 128 * 1024 * 1024).start();
	}

	public static List<Long> getArray() throws NoSuchElementException, FileNotFoundException {
		Scanner input = new Scanner(new File("src//input.txt"));
		List<Long> arr = new ArrayList<Long>();
		while (input.hasNext()) {
			arr.add(input.nextLong());
		}
		return arr;
	}

	public static void saveToFile(String fileName, String str) throws IOException {
		FileWriter outputFile = new FileWriter(fileName);
		outputFile.write(str);
		outputFile.close();
	}

	@Override
	public void run() {
		List<Long> list = null;
		try {
			list = getArray();
		} catch (NoSuchElementException | FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long deletedElement = list.get(0);
		list.remove(0);
		Tree tree = new Tree();
		for (long el : list) {
			tree.add(el);
		}
		String output = "output.txt";
		tree.delete(deletedElement);
		tree.goRootLeftRight();

		try {
			saveToFile(output, tree.getString().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


