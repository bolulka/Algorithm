/*import java.io.FileWriter;
import java.io.IOException;


public class Tree {
	public class Node {
		public long key;
		public Node left;
		public Node right;

		public Node(long key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;
	private String string = "";

	String setString(String str) {
		this.string += str;
		return this.string;
	}

	String getString() {
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
}*/
