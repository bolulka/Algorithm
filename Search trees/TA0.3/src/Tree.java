/*import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		return search(root, value, true);
	}

	private Node search(Node node, long value, Boolean print) {
		if (value < node.key)
			if (node.left != null)
				if (value == node.left.key)
					return node;
				else
					return search(node.left, value, print);
			else {
				return null;
			}
		else if (value > node.key)
			if (node.right != null)
				if (!print && value == node.right.key)
					return node;
				else
					return search(node.right, value, print);
			else {
				return null;
			}
		else {
			return node;
		}

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
			Integer leftSons = 0, rightSons = 0;
			if (node != null) {
				leftSons = numberOfDescendants(node.left, leftSons);
				rightSons = numberOfDescendants(node.right, rightSons);
				if (leftSons - rightSons == 1 || rightSons - leftSons == 1) {
					vertexList.add(el);
				}
			}
		}
		return vertexList;
	}

	private int numberOfDescendants(Node node, int counter) {
		if (node != null) {
			counter++;
			counter=numberOfDescendants(node.left, counter);
			counter=numberOfDescendants(node.right, counter);
		} else
			return counter;

		return counter;
	}
}*/
