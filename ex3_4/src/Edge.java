package src;

public class Edge<V, L> implements AbstractEdge<V, L> {
	private V start;
	private V end;
	private L label;

	/** label field can be set to null if has to be used in a non-labeled graph. */
	public Edge(V start, V end, L label){
		if(start == null || end == null)
			throw new GraphException("Unexpected null parameter in Edge() constructor.");
		this.start = start;
		this.end = end;
		this.label = label;
	}

	@Override
	public V getStart() {
		return start;
	}

	public void setStart(V start) {
		if(start == null)
			throw new GraphException("Unexpected null parameter in setFrom() method.");
		this.start = start;
	}

	@Override
	public V getEnd() {
		return end;
	}

	public void setEnd(V end) {
		if(end == null)
			throw new GraphException("Unexpected null parameter in setTo() method.");
		this.end = end;
	}

	@Override
	public L getLabel() {
		return label;
	}

	public void setLabel(L label) {
		if(label != null)
			this.label = label;
	}

	@Override
	public boolean equals(Object obj) {	// se ho start ed end uguale, non ha senso che abbia labels diverse.
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge<?, ?> e = (Edge<?, ?>) obj;
		return e.getStart().equals(getStart()) && e.getEnd().equals(getEnd());
	}

	public String toString(){
		if(label != null)
			return "[" + start + " {" + label + "} " + end + "]";
		return "[" + start + " - " + end + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		return result;
	}

}