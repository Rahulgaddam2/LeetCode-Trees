package Trees;

import java.util.*;
public class LeetCode637 {

	public static void main(String[] args) {
		LeetCode637 Object = new LeetCode637();
		
		TreeNode root = Object.new TreeNode(3);
		root.left = Object.new TreeNode(9);
		root.right = Object.new TreeNode(20);
		root.right.left = Object.new TreeNode(15);
		root.right.right = Object.new TreeNode(7);
		
		List<Double> Final = new ArrayList<>(Object.averageOfLevels(root));
		
		System.out.println(Final);
		

	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val=val;
			this.left = left;
			this.right = right;
		}
		
	}
	
	public List<Double> averageOfLevels(TreeNode root){
		List<Double> result =  new ArrayList<>();
		
		if(root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int levelsize = queue.size();
			double Avaragelevel = 0;
			for(int i=0;i<levelsize;i++) {
				TreeNode currentNode = queue.poll();
				Avaragelevel = Avaragelevel + currentNode.val;
				
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			Avaragelevel = Avaragelevel/levelsize;
			result.add(Avaragelevel);
		}
		
		return result;
	}

}
