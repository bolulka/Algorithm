import java.io.*;
import java.util.*;

public class TA0_1  implements Runnable {

	public static void main(String[] args) throws IOException {

		new Thread(null,new TA0_1(),"",128*1024*1024).start();
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
		} catch (NoSuchElementException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Tree tree = new Tree();
		
		for (long el : list) {
			tree.add(el);
		}
		String output = "output.txt";
		tree.goRootLeftRight();

		try {
			saveToFile(output, tree.getString().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
class Node {
	public long key;
	public Node left;
	public Node right;

	public Node(long key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
}
class Tree {

	private Node root;
	private StringBuilder string = new StringBuilder();

	StringBuilder setString(String str) {
		this.string .append(str + '\n');
		return string;
	}

	StringBuilder getString() {
		return string;
	}

	public void add(long key) {
		Node prev = null;
		Node current = root;

		while (current != null) {
			prev = current;
			if (key > current.key)
				current = current.right;
			else if (key < current.key)
				current = current.left;
			else
				return;
		}

		Node node = new Node(key);

		if (prev == null)
			root = node;
		else if (key < prev.key)
			prev.left = node;
		else if (key > prev.key)
			prev.right = node;
	}

	public void goRootLeftRight() {
		goRootLeftRight(root);
	}

	private void goRootLeftRight(Node node) {
		if (node != null) {
			setString(node.key + " ");
			goRootLeftRight(node.left);
			goRootLeftRight(node.right);
		}
	}
}
