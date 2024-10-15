package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode199 {

	public static void main(String[] args) {
		
		leetCode199 Object = new leetCode199();
		
		TreeNode root = Object.new TreeNode(1);
		root.left = Object.new TreeNode(2);
		root.right = Object.new TreeNode(3);
		root.left.right = Object.new TreeNode(5);
		root.right.right = Object.new TreeNode(4);
		
		System.out.print(Object.rightSideView(root));
		
		

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
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> result = new ArrayList<>();
		
		if(root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelsize = queue.size();
			
			for(int i=0; i<levelsize; i++) {
				TreeNode currentNode = queue.poll();
				if(i == levelsize-1) {
					result.add(currentNode.val);
				}
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
		}
		
		
		return result;
	}

}
