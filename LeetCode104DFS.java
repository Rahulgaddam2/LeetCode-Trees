package Trees;



public class LeetCode104DFS {

	public static void main(String[] args) {
        
		LeetCode104DFS Object = new LeetCode104DFS();
 		
		TreeNode root = Object.new TreeNode(3);
		root.left = Object.new TreeNode(9);
		root.right = Object.new TreeNode(20);
		root.right.left = Object.new TreeNode(15);
		root.right.right = Object.new TreeNode(7);
		
		System.out.println(Object.maxDepth(root));

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
	
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return height(root);
	}
	public int height(TreeNode node) {
		if(node == null) {
			return 0;
		}
		
		int leftheight = height(node.left);
		int rightheight = height(node.right);
		
		int depth = Math.max(leftheight , rightheight) +1;
		
		return depth;
		
		
	}
	

}
