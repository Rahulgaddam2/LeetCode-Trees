package Trees;

public class LeetCode543DFS {
	
	// for this problem we are doing post order traversal where we first calculate the 
	// height of left node than right node than root node
	private int diameter = 0;
	
	public static void main(String[] args) {
        
		
		LeetCode543DFS Object = new LeetCode543DFS();
		
		TreeNode root = Object.new TreeNode(1);
		root.left = Object.new TreeNode(2);
		root.right = Object.new TreeNode(3);
		root.left.left = Object.new TreeNode(4);
		root.left.right = Object.new TreeNode(5);
		
		System.out.println(Object.diameterOfBinaryTree(root));

	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		
		public TreeNode(int val) {
			this.val = val;
		}
		public TreeNode(int val, TreeNode left , TreeNode right) {
			this.val =val;
			this.left = left;
			this.right = right;
		}
	}
	 public int diameterOfBinaryTree(TreeNode root) {
		 height(root);
		 return diameter-1;
	 }
	 public int height(TreeNode node) {
		 if(node == null) {
			 return 0;
		 }
		 
		 int leftheight = height(node.left);
		 int rightheight = height(node.right);
		 
		 int dia = leftheight + rightheight + 1;
		 
		 diameter = Math.max(diameter, dia);
		 
		 return diameter;
	 }
}
