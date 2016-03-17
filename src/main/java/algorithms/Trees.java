package algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
            if (node.left != null) {
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
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(a);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static List<Integer> inOrder(TreeNode a) {
        if (a == null)
            return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(a);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                result.add(node.val);
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(new TreeNode(node.val));
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return result;
    }

    public static boolean equals(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        } else {
            return equals(a.left, b.left) && equals(a.right, b.right);
        }
    }

    public static boolean equals2(TreeNode a, TreeNode b) {
        // without recursion
        // use pre-order traversal on both trees
        if (a == null || b == null) {
            return a == b;
        }

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        stack1.push(a);
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack2.push(b);

        while (!stack1.isEmpty()) {
            if (stack2.isEmpty()) {
                return false;
            } else {
                TreeNode node1 = stack1.pop();
                TreeNode node2 = stack2.pop();
                if (node1 == null && node2 != null) {
                    return false;
                } else if (node1 != null && node2 == null) {
                    return false;
                } else if (node1 == null && node2 == null) {
                    // is ok
                } else {
                    // both present
                    if (node1.val != node2.val) {
                        return false;
                    } else {
                        if (node1.left == null && node2.left != null) {
                            return false;
                        } else if (node1.left != null && node2.left == null) {
                            return false;
                        } else if (node1.right == null && node2.right != null) {
                            return false;
                        } else if (node1.right != null && node2.right == null) {
                            return false;
                        } else {
                            if (node1.right != null) {
                                stack1.push(node1.right);
                            }
                            if (node1.left != null) {
                                stack1.push(node1.left);
                            }
                            if (node2.right != null) {
                                stack2.push(node2.right);
                            }
                            if (node1.left != null) {
                                stack2.push(node2.left);
                            }
                        }
                    }
                }
            }
        }
        return stack2.isEmpty();
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
        assertEquals(Arrays.asList(4, 5, 2, 6, 3, 1), postOrder(createTree()));
        assertTrue(postOrder(null).isEmpty());
        assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), preOrder(createTree()));
        assertTrue(preOrder(null).isEmpty());
        assertEquals(Arrays.asList(4, 2, 5, 1, 3, 6), inOrder(createTree()));
        assertTrue(inOrder(null).isEmpty());

        assertTrue(equals(createTree(), createTree()));
        assertTrue(equals(null, null));
        assertTrue(equals2(createTree(), createTree()));
        assertFalse(equals2(createTree(), new TreeNode(1)));
        assertTrue(equals2(null, null));
        System.out.println("passed");
    }

}
