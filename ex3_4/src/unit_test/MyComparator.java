package src.unit_test;
import java.util.*;

public class MyComparator<T extends Comparable<T>> implements Comparator<T> {

	@Override
	public int compare(T arg0, T arg1) {
		return arg0.compareTo(arg1);
	}
}