package Trees;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94Inorder {

	public static void main(String[] args) {
		LeetCode94Inorder Object = new LeetCode94Inorder();
		
		TreeNode root = Object.new TreeNode(5);
		root.left = Object.new TreeNode(1);
		root.right = Object.new TreeNode(4);
		root.right.left = Object.new TreeNode(3);
		root.right.right = Object.new TreeNode(6);
		
		System.out.println(Object.Inorder(root));
		

	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right =right;
		}
	}
	
	public List<Integer> Inorder(TreeNode root){
		List<Integer> result = new ArrayList<>();
		helper(root , result);
		return result;
	}
	
	public void helper(TreeNode node , List<Integer> result) {
		if(node == null) {
			return ;
		}
		
		helper(node.left , result);
		
		result.add(node.val);
		
		helper(node.right , result);
	}

}
