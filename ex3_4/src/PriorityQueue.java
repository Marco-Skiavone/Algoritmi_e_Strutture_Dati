package src;
import java.util.*;

public class PriorityQueue<E> implements AbstractQueue<E> {
	private ArrayList<E> queue;
	private HashMap<E, Integer> finder;
	private Comparator<E> comparator;

	public PriorityQueue(Comparator<E> comparator) {
		if (comparator == null)
			throw new PriorityQueueException("Constructor: null comparator is not allowed!");
		this.queue = new ArrayList<>();
		this.comparator = comparator.reversed();
		this.finder = new HashMap<E, Integer>();
	}
	
	/** The method bases its comparison on the hashCode() method. */
	@Override
	public boolean contains(E e) { // DONE
		if (e == null)
			return false;
		return finder.containsKey(e);
	}

	@Override
	public boolean empty() { // DONE
		return queue.isEmpty();
	}

	@Override
	public void pop() { // DONE
		if (queue.isEmpty())
			throw new PriorityQueueException("Invoked pop() on empty object.");
		int last = queue.size()-1;
		swap(0, last);
		if(!finder.remove(queue.get(last), last))
			throw new PriorityQueueException("Failed finder.remove in method pop().");
		if(queue.remove(last) == null)
			throw new PriorityQueueException("Tried to pop null object from the queue.");
		heapify(0);
	}

	@Override
	public boolean push(E e) { // DONE
		if (e == null || contains(e))
			return false;
		int i = queue.size();
		queue.add(i, e);
		finder.put(e, i);
		while (i >= 0 && comparator.compare(queue.get(parent(i)), queue.get(i)) < 0) {
			swap(i, parent(i));
			i = parent(i);
		}
		return true;
	}

	@Override
	public boolean remove(E e) { // DONE
		if (e == null || !contains(e)){
			return false;
		}
		int i = finder.get(e);
		swap(finder.get(e), queue.size()-1);
		if (!finder.remove(e, finder.get(e)) || !(queue.remove(queue.size()-1)).equals(e))
			return false;
		while (i >= 0 && comparator.compare(queue.get(parent(i)), queue.get(i)) < 0) {
			swap(i, parent(i));
			i = parent(i);
		}
		return true;
	}

	@Override
	public E top() { // DONE
		if (queue.isEmpty())
			return null;
		return queue.get(0);
	}

	@Override
	public boolean increasePriority(E e1, E e2) { // DONE
		if (e1 == null || e2 == null || queue.isEmpty() || !contains(e1))
			return false;
		if(comparator.compare(e1, e2) >= 0 || (contains(e2) && !e2.equals(e1)))
			return false;
		if (!remove(e1))
			return false;
		return push(e2);
	}

	private void heapify(int i) { // DONE
		if(empty() || i >= queue.size())
			return;
		int largest = i, l = left(i), r = right(i);
		if (comparator.compare(queue.get(i), queue.get(l)) > 0)
			largest = (comparator.compare(queue.get(i), queue.get(r)) > 0) ? i : r;
		else
			largest = (comparator.compare(queue.get(l), queue.get(r)) > 0) ? l : r;
		if (largest != i) {
			swap(i, largest);
			heapify(largest);
		} else {
			finder.replace(queue.get(i), i);
		}
	}
	
	// --------- aux. methods -----------

	/** @return index of the parent */
	private int parent(int pos) { 						// DONE
		if(pos % 2 == 0)
			return pos > 1 ? (pos / 2) - 1 : 0;
		return pos > 1 ? (pos / 2) : 0;
	}	

	/** @return index of the left son */
	private int left(int pos) { 						// DONE
		int ret = (pos * 2) + 1;
		return ret < queue.size() ? ret : pos;
	}	

	/** @returns index of the right son. */
	private int right(int pos) { 						// DONE
		int ret = (pos * 2) + 2;
		return ret < queue.size() ? ret : pos;
	}		

	private void swap(int i, int j) { 							// DONE 
		if(i == j)
			return;
		if(!contains(queue.get(i)) || !contains(queue.get(j))){
			throw new PriorityQueueException("swap invoked on element null: .i=" + queue.get(i) + ", j=" + queue.get(j) + "\nfinder:\n" + finder);
		}
		if(i < queue.size() && j < queue.size() && i >= 0 && j >= 0){
			E element = queue.get(i);
			queue.set(i, queue.get(j));
			queue.set(j, element);
			finder.replace(queue.get(j), j);
			finder.replace(queue.get(i), i);
		}
	}

	@Override
	public String toString() {
		if (empty())
			return "{}";
		String s = "{\n";
		for (E e : queue) {
			s += e.toString() + ", " + finder.get(e) + "\n";
		}
		return s + "}";
	}
}