package Trees;

public class BinarySearchTree {

	public static void main(String[] args) {
		BinarySearchTree BST = new BinarySearchTree();
		
		int[] nums = {5,2,7,1,4,6,9,8,3,10};
		BST.populate(nums);
		BST.display();
	}
		
		public static class Node{
		private int value;
		private int height;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
		}
		
		
		
	}
	
	private Node root;
	
	public int height(Node node) { // this method is to find the height 
		if(node == null) {
			return -1;
		}
		return node.height; //  it returns the stored height of the node.
	}
	
	public boolean isempty() {   // this method is for if the root is empty
		return root == null;
	}
	
	public void insert(int value) { // this method is to insert an value into the binary tree
		root = insert(value, root);
	}
	private Node insert(int value, Node node) {
		if(node == null) {
			node = new Node(value);
			return node;
		}
		if(value < node.value) {                   // if value is smaller than previous value than it will add to left side
			node.left = insert(value , node.left);
		}
		if(value > node.value) {				   // if value is Larger than previous value than it will add to right side
			node.right = insert(value , node.right);
		}
		
		node.height = Math.max(height(node.left), height(node.right) + 1);
		
		return node;
			
	}
	
	public void populate(int[] nums) {
		for(int i=0;i <nums.length; i++) {
			this.insert(nums[i]);
		}
	}
	
	public boolean balanced() {
		return balanced(root);
	}
	
	private boolean balanced(Node node) {
		if(node == null) {
			return true;
		}
		
		return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
	}
	
	public void display() {
		display(this.root, "root node: ");
	}
	
	private void display(Node node,String details) {
		if(node == null) {
			return;	
		}
		System.out.println(details + node.value);
		display(node.left, "Left child of" + node.value + " : ");
		display(node.right, "right child of" + node.value + " : ");
	}

}
