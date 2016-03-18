package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Lists {

    public static class RandomListNode {

        String label;
        RandomListNode next;
        RandomListNode random;

        public RandomListNode(String label) {
            this.label = label;
        }
    }

    public RandomListNode copyRandomList(RandomListNode node) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        Deque<RandomListNode> stack = new ArrayDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            RandomListNode n = stack.pop();
            RandomListNode n2 = fromMap(map, n);
            n2.next = fromMap(map, n.next);
            n2.random = fromMap(map, n.random);
            if (n.next != null) {
                stack.push(n.next);
            }
        }
        return map.get(node);
    }

    private static RandomListNode fromMap(Map<RandomListNode, RandomListNode> map,
            RandomListNode n) {
        if (n == null) {
            return null;
        } else {
            RandomListNode m = map.get(n);
            if (m != null) {
                return m;
            } else {
                RandomListNode r = new RandomListNode(n.label);
                map.put(n, r);
                return r;
            }
        }
    }

}
