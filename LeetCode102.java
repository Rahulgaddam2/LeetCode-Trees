package Trees;

import java.util.*;

public class LeetCode102 {

	public static void main(String[] args) {
		LeetCode102 object = new LeetCode102();
		
		TreeNode root = object.new TreeNode(3);
		root.left = object.new TreeNode(9);
		root.right = object.new TreeNode(20);
		root.right.left = object.new TreeNode(15);
		root.right.right = object.new TreeNode(7);
		
		List<List<Integer>> result = object.levelOrder(root);
        System.out.println(result);
        
		
	
	}
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
		public TreeNode(int val , TreeNode left , TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		
		if(root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelsize = queue.size();
			List<Integer> currentlevel = new ArrayList<>(levelsize);
			for(int i=0;i<levelsize;i++) {
				TreeNode currentNode = queue.poll();
				currentlevel.add(currentNode.val);
				
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			result.add(currentlevel);
		}
		
		return result;
	}
}
