#include "merge-binInsertion-sort.h"

/**
 * This function copies n_bytes bytes of memory from src to dest.
 * @returns A pointer to dest. */
void * byte_copy(void *dest, void *src, size_t n_bytes){
	for(unsigned int i = 0; i < n_bytes; i++)
		((char*)(dest))[i] = ((char*)(src))[i];
	return dest;
}

//binSearch_Ric è una funzione interna, non va dichiarata nell'header

/** Generally described, returns the index of the position in which to insert the val. @param base is the array to be sort.
 * @param val is the value to compare with the elements of the array.
 * @param base is the array to be sort.
 * @param size is the size in bytes of every element (type).
 * @param j is the length of the array recursively descending.
 * @param compar is a pointer to the function we need to compare the elements. 
 * @return the index at which insert the value. */
int BinSearch(void *val, void *base, int size, int j, int (*compar)(const void *, const void*)) {
	int i = 0;
	do {
		int m = (i+j)/2;
		if(compar(base+(m*size), val) == 0)
			return m+1;
		else if(compar(base+(m*size), val) < 0){
			if(i == j)
				return m+1;
			i = m+1;
		} else {
			if(i == j)
				return m;
			j = m;
		} 
	} while (i <= j);
}

void bin_insertion_sort(void *base, size_t nitems, size_t size, int (*compar)(const void *, const void*)){
	int index;
	void *value = malloc(size);
	for(int i = 1; i < nitems; i++){
		value = byte_copy(value, (base+(size*i)), size);
		index = BinSearch(value, base, size, i, compar);
		if(index > i)	// altrimenti ritrovo:    index > j
			index = i;
		for(int k = i-1; k >= index; k--){		// eseguo gli (i-index) spostamenti
			byte_copy(base+((k+1)*size), base+(k*size), size);	// base+((k+1)*size) = base+(k*size);
		}
		byte_copy(base+(index*size), value, size);	// base+(index*size) = value;
	}
	free(value);
}

void merge(void *base, void *aux, size_t low, size_t mid, size_t high, size_t size, int (*compar)(const void *, const void*)){
	for(int k = low; k <= high; k++)
		byte_copy(aux+(k*size), base+(k*size), size);
	int i = low, j = mid + 1;
	for (int k = low; k <= high; k++){
		if(i > mid){
			byte_copy(base+(k*size), aux+(j*size), size);
			j++;
		} else if(j > high){
			byte_copy(base+(k*size), aux+(i*size), size);
			i++;
		} else if(compar(aux+(j*size), aux+(i*size)) < 0){
			byte_copy(base+(k*size), aux+(j*size), size);
			j++;
		} else {
			byte_copy(base+(k*size), aux+(i*size), size);
			i++;
		}
	}
}

void merge_sort(void *base, size_t nitems, size_t size, size_t k, int (*compar)(const void *, const void*)){
	if(nitems > k){
		void *aux = malloc(nitems*size);
		for(int sr = 1; sr <= nitems; sr *= 2){	/* outer loop: subsequence of length range */
			for(int i = 0; i < nitems - sr; i += 2*sr){
				int min = ((i+(2*sr)-1) <  nitems - 1) ? (i+(2*sr)-1) : nitems-1;
				if((min-i) < k){
					bin_insertion_sort(base+i, min-i, size, compar);
				} else 
					merge(base, aux, i, i+sr-1, min, size, compar); 	/* merges subsequeces */
			}
		}
	} else {
		bin_insertion_sort(base, nitems, size, compar);
	}
}

void merge_binary_insertion_sort(void *base, size_t nitems, size_t size, size_t k, int (*compar)(const void *, const void*)){
	if(base == NULL || nitems == 0)
		return;
	if(nitems <= k)
		bin_insertion_sort(base, nitems, size, compar);
	else
		merge_sort(base, nitems, size, k, compar);
}