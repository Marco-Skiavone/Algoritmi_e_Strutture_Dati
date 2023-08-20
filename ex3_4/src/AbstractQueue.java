package src;

public interface AbstractQueue<E> {
	/** Controlla se la coda è vuota -- O(1)*/
	public boolean empty();
	
	/** Aggiunge un elemento alla coda -- O(logN)*/
	public boolean push(E e); 

	/** Controlla se un elemento è in coda -- O(1)*/
	public boolean contains(E e); 

	/** Accede all'elemento in cima alla coda -- O(1)*/
	public E top(); 

	/** Rimuove l'elemento in cima alla coda -- O(logN)*/
	public void pop(); 

	/** Rimuove un elemento se presente in coda -- O(logN)*/
	public boolean remove(E e); 

	/** In generale, il metodo sostituisce l'elemento e1, con un elemento e2 avente priorità maggiore, 
	 * garantendo che, dopo la sostituzione, nella coda continuino a non esserci elementi ripetuti.
	 * @param e1 è un elemento presente nella coda; 
	 * @param e2 è un elemento che può essere uguale a e1 (ma non ad altri elementi della coda); 
	 * la priorità di e2 è più alta di quella di e1. */
	public boolean increasePriority(E e1, E e2);
};