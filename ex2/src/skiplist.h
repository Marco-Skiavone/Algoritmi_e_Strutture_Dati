#ifndef _SKIPLIST_H
#define _SKIPLIST_H
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/** SkipList: list of nodes, with different speeds.
 * @param heads is the array of pointers (speeds) of the SkipList;
 * @param max_level is the max number of pointers actually presents, for every single node of the SkipList;
 * @param max_height is a constant representing the max number of pointers that can be in every single node of the SkipList;
 * @param compare function for the element comparison. */
typedef struct SkipList {
  struct Node **heads;
  size_t max_level;
  size_t max_height;
  int (*compare)(const void*, const void*);
}SkipList;

/** Node: element of a list.
 * @param next is the pointers array of the given node of the SkipList;
 * @param size is the pointers number of the given node of the SkipList;
 * @param item is the data of the given node of the SkipList. */
typedef struct Node {
  struct Node **next;
  size_t size;
  void *item;
}Node;

/** It allocates a new skiplist, given MAX_HEIGHT and COMPAR function pointer, it saves the structure in *LIST. 
 * @param list the pointer in which the struct is returned . 
 * @param max_height is the max height (of speed) for the nodes of the struct.
 * @param compar is a function pointer to use for the comparison between elements of the array. */
void new_skiplist(struct SkipList **list, size_t max_height, int (*compar)(const void *, const void*));

/** It frees correctly ALL the memory used by the struct.
 * @param list list to free. */
void clear_skiplist(struct SkipList **list);

/** Inserts the element ITEM in the ordered skiplist.
 * @param item is a pointer to void because it could be every possible type of item. */
void insert_skiplist(struct SkipList *list, void *item);

/** It searches the ITEM element in the struct, using the differents speeds to be more efficient.
 * @param item is a pointer to void because it could be every possible type of item. 
 * @returns NULL if item isn't present, otherwise the pointer to the item is returned. */
const void* search_skiplist(struct SkipList *list, void *item);

#endif