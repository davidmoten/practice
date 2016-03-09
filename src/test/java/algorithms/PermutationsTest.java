package algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class PermutationsTest {

	@Test
	public void test() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		for (List<Integer> t:Permutations.permutations(set)){
			System.out.println(t);
		}
			
	}
	
}
