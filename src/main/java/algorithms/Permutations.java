package algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Permutations {

	public static <T> Iterable<List<T>> permutations(Set<T> set) {
		return new Iterable<List<T>>() {

			@Override
			public Iterator<List<T>> iterator() {
				return new Iterator<List<T>>() {

					List<T> prefix = new ArrayList<T>();
					Set<T> s = set;
					Iterator<T> it = set.iterator();

					@Override
					public boolean hasNext() {
						return (s.isEmpty() && it.hasNext())
								//
								|| !set.isEmpty();
					}

					@Override
					public List<T> next() {
						if (!it.hasNext()) {
							T first = set.iterator().next();
							prefix.add(first);
							set.remove(first);
							it = set.iterator();
						}
						List<T> list = new ArrayList<T>(prefix);
						list.add(it.next());
						return list;
					}
				};
			}
		};
	}

}
