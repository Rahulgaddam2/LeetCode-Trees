package Trees;

import java.util.Scanner;

public class TreeImplementation {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TreeImplementation tree = new TreeImplementation();
		tree.Addnodes(scanner);
		tree.display();
	}
	
	public TreeImplementation() {
		
	}
	
	private static class Node{ // created nested class Node
		int value; //  value , left , right are the attributes of the class Node                     
		Node left;
		Node right;                        
		
		public Node(int value) { // we have taken an constructor to input value // 
			this.value = value;
		}
	}
	
	private Node root;  //here we declared an new node called root we used encapsulated to make it private;
	
	// inserting elements
	
	public void Addnodes(Scanner scanner) {  
		System.out.println("Enter the root node value");
		int value = scanner.nextInt();
		root = new Node(value);
		addnodesleftandright(scanner , root);
	}
	
	private void addnodesleftandright(Scanner scanner , Node node) {
		System.out.println("Do you want to enter left of " + node.value);
		boolean left = scanner.nextBoolean();
		if(left) {
			System.out.println("Enter the value of the left of " + node.value);
			int value = scanner.nextInt();
			node.left = new Node(value);
			addnodesleftandright(scanner , node.left);
		}
		System.out.println("Do you want to enter right of " + node.value);
		boolean right = scanner.nextBoolean();
		if(right) {
			System.out.println("Enter the value of the right of " + node.value);
			int value = scanner.nextInt();
			node.right = new Node(value);
			addnodesleftandright(scanner , node.right);
		}
	}
	
	public void display() {
		display(root, "");   // display is an function
	}
	
	private void display(Node node, String indent) {
		
		if(node == null) {
			return;
		}
		System.out.println(indent + node.value);
		display(node.left,indent + "/t");
		display(node.right,indent + "/t");
	}
	
	
	
}
