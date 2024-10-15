package Trees;

public class leetCode993 {

	public static void main(String[] args) {
		leetCode993 Object = new leetCode993();
		TreeNode root = Object.new TreeNode(1);
		root.left = Object.new TreeNode(2);
		root.left.left = Object.new TreeNode(4);
		root.right = Object.new TreeNode(3);
		
		int x = 4;
		int y = 3;
		
		System.out.println(Object.isCousins(root, x, y));
				
		

	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public boolean isCousins(TreeNode root, int x, int y) {
		TreeNode xx = findnode(root , x);
		TreeNode yy = findnode(root , y);
		
		//return((level(root , xx, 0) == level(root, yy, 0)) && !isSibling(root , xx , yy));
		
		return false;
		
	}
	public TreeNode findnode(TreeNode node , int x) {
		if(node == null) {
			return null;
		}
		if(node.val == x) {
			return node;
		}
		TreeNode n = findnode(node.left, x);
			if(n != null) {
				return n;
			}else {
				return findnode(node.right, x);
			}
	}
	public boolean	isSibling(TreeNode node , TreeNode x , TreeNode y) {
		if(node == null) {
			return false;
		}
		
		return (node.left == x && node.right == y) || (node.left == y && node.right == x) || (isSibling(node.left ,x ,y) || (isSibling(node.right ,x ,y) ));
				
	}

}
