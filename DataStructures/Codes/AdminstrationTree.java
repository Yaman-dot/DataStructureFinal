package finalDataStructures;

public class AdminstrationTree 
{
	private Employees root;
	/* Constructor */
	public AdminstrationTree() {
		root = null;
	}

	/* Functions to insert data */
	public void insert(int id, String name) {

		root = insert(root, id, name);
	}

	/* Function to insert data recursively */
	private Employees insert(Employees node, int id, String name) {
		if (node == null)
			node = new Employees(name, id);
		else {

			if (id <= node.Id)

				node.left = insert(node.left, id, name);
			else
				node.right = insert(node.right, id, name);
		}

		return node;
	}

	/* Function for postorder traversal */
	public void postorder() {
		postorder(root);
	}

	private void postorder(Employees r) {
		if (r != null) {
			postorder(r.left);
			postorder(r.right);
			System.out.print(r.Id + " ");
		}
	}
	
	

	public void finish(int key) {
		Employees current = root;
		Employees parent = null;
		boolean isLeftChild = false;

		// Find the node to be deleted
		while (current != null && current.Id != key) {
			parent = current;

			if (key < current.Id) {
				current = current.left;
				isLeftChild = true;
			} else {
				current = current.right;
				isLeftChild = false;
			}
		}

		// Node not found
		if (current == null) {
			return;
		}

		// Case 1: Node to be deleted has no children
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		// Case 2: Node to be deleted has only one child
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		}

		// Case 3: Node to be deleted has two children
		else {
			Employees successor = getSuccessor(current);

			// Connect parent of current to successor instead
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}

			// Connect successor to current's left child
			successor.left = current.left;
		}
	}

	Employees getSuccessor(Employees node) {
		Employees parent = node;
		Employees successor = node;
		Employees current = node.right;

		while (current != null) {
			parent = successor;
			successor = current;
			current = current.left;
		}

		// If successor is not the right child, move the subtree
		if (successor != node.right) {
			parent.left = successor.right;
			successor.right = node.right;
		}

		return successor;
	}

}
