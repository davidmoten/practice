package algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Trees {
	
	public static List<Integer> postOrder(TreeNode a) {
		Deque<Integer> result = new ArrayDeque<>();
		if (a == null) {
			return new ArrayList<>();
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(a);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.push(node.val);
			if (node.left!= null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		return new ArrayList<Integer>(result);
	}

	public static List<Integer> preOrder(TreeNode a) {
		if (a == null) {
			return new ArrayList<>();
		}
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		stack.push(a);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if (node.right !=null) {
				stack.push(node.right);
			}
			if (node.left!=null) {
				stack.push(node.left);
			}
		}
		return result;
	}
	
	public static TreeNode createTree() {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.right = f;
		return a;
	}
	
	public static void main(String[] args) {
		assertEquals(Arrays.asList(4,5,2,6,3,1),  postOrder(createTree()));
		assertTrue(postOrder(null).isEmpty());
		assertEquals(Arrays.asList(1,2,4,5,3,6), preOrder(createTree()));
		assertTrue(preOrder(null).isEmpty());
	}
	
}
