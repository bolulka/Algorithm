import java.io.*;
import java.util.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TA0_3 implements Runnable {

	public static void main(String[] args) throws IOException {

		new Thread(null, new TA0_3(), "", 128 * 1024 * 1024).start();
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
		String output = "output.txt";
		try {
			list = getArray();
		} catch (NoSuchElementException | FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Tree tree = new Tree();
		for (long el : list) {
			tree.add(el);
		}
		List<Long> vertexList = tree.numberOfDescendants(list);
		if (vertexList.size() % 2 == 0)
			tree.goRootLeftRight();
		else {
			vertexList.sort(null);
			System.out.println(vertexList.toString());
			int el = vertexList.size() / 2;
			tree.delete(vertexList.get(el));
			tree.goRootLeftRight();
		}

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
	private StringBuffer string = new StringBuffer();
	private List<Long> list = new ArrayList<Long>();

	void addToList(long el) {
		list.add(el);
	}

	List getList() {
		return list;
	}

	void setString(String str) {
		this.string.append(str + '\n');
	}

	StringBuffer getString() {
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

	public Node search(long value) {
		Node node = this.root;
		return search(node, value);
	}

	private Node search(Node node, long value/* , Boolean print */) {

		if (node == null || value == node.key)
			return node;

		if (value < node.key && node.left != null) {
			return search(node.left, value);
		}

		else if (node.right != null) {
			return search(node.right, value);
		} else
			return node;
	}

	public void goRootLeftRight() {
		goRootLeftRight(root);
	}

	private void goRootLeftRight(Node node) {
		if (node != null) {
			setString(Long.toString(node.key));
			goRootLeftRight(node.left);
			goRootLeftRight(node.right);
		}
	}

	void delete(long key) {
		if (root.key == key) {
			root = delete(root, key);
		} else {
			delete(root, key);
		}
	}

	private Node delete(Node node, long key) {
		if (node == null)
			return node;

		if (key < node.key) {
			node.left = delete(node.left, key);
		} else if (key > node.key) {
			node.right = delete(node.right, key);
		} else if (node.left != null && node.right != null) {
			node.key = minKey(node.right);
			node.right = delete(node.right, node.key);
		} else if (node.left != null) {
			node = node.left;
		} else if (node.right != null) {
			node = node.right;
		} else {
			node = null;
		}

		return node;
	}

	private long minKey(Node root) {
		return root.left == null ? root.key : minKey(root.left);
	}

	public List<Long> numberOfDescendants(List<Long> list) {
		List<Long> vertexList = new ArrayList<Long>();
		for (long el : list) {
			Node node = search(el);
			int leftSons = 0, rightSons = 0;
			leftSons = numberOfDescendants(node.left, leftSons);
			rightSons = numberOfDescendants(node.right, rightSons);
			if (leftSons - rightSons == 1 || rightSons - leftSons == 1) {
				vertexList.add(el);
			}
		}
		return vertexList;
	}

	private int numberOfDescendants(Node node, int counter) {
		if (node != null) {
			counter++;
			counter = numberOfDescendants(node.left, counter);
			counter = numberOfDescendants(node.right, counter);
		} else
			return counter;

		return counter;
	}
}
