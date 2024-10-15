package Trees;

import java.util.*;

public class LeetCode107 {

	public static void main(String[] args) {
		LeetCode107 Object = new LeetCode107();
		
		TreeNode root = Object.new TreeNode(3);
		root.left = Object.new TreeNode(9);
		root.right = Object.new TreeNode(20);
		root.right.left = Object.new TreeNode(15);
		root.right.right = Object.new TreeNode(7);
		
		List<List<Integer>> Final = new ArrayList<>(Object.levelOrderBottom(root));
		
		System.out.println(Final);
		

	}
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
		
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val=val;
			this.left=left;
			this.right=right;
		}
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		
		if(root == null) {
			return result;
		}
		
		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int levelsize = queue.size();
			List<Integer> currentlevel = new ArrayList<>();
			
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
			result.add(0,currentlevel);
		}
		return result;
	}

}
