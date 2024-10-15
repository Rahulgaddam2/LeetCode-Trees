package Trees;

import java.util.*;

public class LeetCode101 {

	public static void main(String[] args) {
		LeetCode101 Object = new LeetCode101();
		
		TreeNode root = Object.new TreeNode(1);
		
		root.left = Object.new TreeNode(2);
		root.right = Object.new TreeNode(2);
		root.left.left = Object.new TreeNode(3);
		root.right.right = Object.new TreeNode(3);
		root.left.right = Object.new TreeNode(4);
		root.right.left = Object.new TreeNode(4);
		
		System.out.println(Object.isSymmetric(root));

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
			this.right = right; 
		}
	}
	
     public boolean isSymmetric(TreeNode root) {
    	 
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root.left);
    	queue.offer(root.right);
    	
    	while(!queue.isEmpty()) {
    		TreeNode left = queue.poll();
    		TreeNode right = queue.poll();
    		
    		if(left == null && right == null) {
    			continue;
    		}
    		if(left == null || right == null) {
    			return false;
    		}
    		
    		if(left.val != right.val) {
    			return false;
    		}
    		
    		queue.offer(left.left);
    		queue.offer(right.right);
    		queue.offer(left.right);
    		queue.offer(right.left);
    	}
        return true;
    }
	
	
	
	

}
