
#ifndef _MERGE_BININSERTION_SORT_H
#define _MERGE_BININSERTION_SORT_H
#ifndef _STDIO_H
#include <stdio.h>
#endif
#ifndef _STDLIB_H
#include <stdlib.h>
#endif
#ifndef _COMPARE_H
#include "../../libs/compare/compare.h"
#endif

/** Uses the parameter k to define the size below which it will start using the binary-insertion sorting algorithm.
 * @param base is the array to be sort.
 * @param nitems is the size of elements in base.
 * @param size is the size in bytes of every element (type).
 * @param k is the parameter under which the binary insertion is called, otherwise the merge-sort starts.
 * @param compar is a pointer to the function we need to compare the elements. */
void merge_binary_insertion_sort(void *base, size_t nitems, size_t size, size_t k, int (*compar)(const void *, const void*));

/** Function that runs the binary-insertion sorting algorithm,
 * with recursive descent for the binary search of the index. 
 * @param base is the array to be sort.
 * @param nitems is the size of elements in base.
 * @param size is the size in bytes of every element (type).
 * @param compar is a pointer to the function we need to compare the elements. */
void bin_insertion_sort(void *base, size_t nitems, size_t size, int (*compar)(const void *, const void*));

/** Function that runs the merge sorting algorithm with bottom-up approach. 
 * @param base is the array to be sort.
 * @param nitems is the size of elements in base.
 * @param size is the size in bytes of every element (type).
 * @param compar is a pointer to the function we need to compare the elements.
 * @note Instead of recurring down from the array recursevely, the idea is to start with ranges of size 1.
 * It merges all pairs of subsequences of the given range, untill the array ends.
 * The merge operation will place them in order, sorting them, then it doubles the sizes of the ranges and
 * repeat until we have a range the size of the full array. */
void merge_sort(void *base, size_t nitems, size_t size, size_t k, int (*compar)(const void *, const void*));
#endif