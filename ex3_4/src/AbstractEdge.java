package src;

public interface AbstractEdge<V,L> {
	/** starting node of the edge */
	public V getStart();
	/** arriving node of the edge */
	public V getEnd();
	/** label of the edge */
	public L getLabel();
}