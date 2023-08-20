#include "skiplist.h"

#define STAMPA_DEB fprintf(stderr, "%s: DEB#%d\n", __FILE__, __LINE__);

Node* createNode(void *item, size_t lvl){
	Node *new = (Node*)calloc(1, sizeof(Node));
	new->item = item;
	new->size = lvl;
	new->next = (Node**)calloc(lvl, sizeof(Node*));
	return new;
}

void new_skiplist(struct SkipList **list, size_t max_height, int (*compar)(const void *, const void*)){
	srand(time(NULL));
	if(compar == NULL || max_height == 0){
		fprintf(stderr, "Line %d: Error! *compar is NULL or max_height is 0.\n", __LINE__);
		return;
	}
	(*list) = (SkipList*)malloc(sizeof(SkipList));
	(*list)->heads = (Node**)calloc(max_height, sizeof(Node*));
	(*list)->max_level = 0;
	(*list)->max_height = max_height;
	(*list)->compare = compar;
}

void clear_skiplist(struct SkipList **list){
	if(list == NULL || *list == NULL)
		return;
	Node *n = ((*list)->heads[0]), *x;
	while(n != NULL){
		if(n->item != NULL)
			free(n->item);
		x = n;
		n = n->next[0];
		free(x);
	}
	free(*list);
	(*list) = NULL;
}

/** @returns A random value in [0...1). */
float get_random(){
	float value = 0 + ((float)(rand() % 1000)) / 1000;
	return value;
}

int randomLevel(size_t max_height){
	int lvl = 1; float val;
	while(val = get_random() < 0.5 && lvl < max_height) {
		++lvl;
	}
	return lvl;
}

void insert_skiplist(struct SkipList *list, void *item){
	if(list == NULL || item == NULL){
		fprintf(stderr, "insert_skiplist: Line %d: Error! Passed NULL *list or *item.\n", __LINE__);
		return;
	}
	Node *new = createNode(item, randomLevel(list->max_height));
	if(new->size > list->max_level)
		list->max_level = new->size;
	Node **x = list->heads;
	for(int k = list->max_level-1; k >= 0; --k){
		if(x[k] == NULL || ((list->compare)(item, x[k]->item)) < 0){
			if(k < new->size){
				new->next[k] = x[k];
				x[k] = new;
			}
		} else {
			x = x[k]->next;
			k++;
		}
	}
/*insertSkipList(list, item):
    new = createNode(item, randomLevel(list->max_height))
    if new->size > list->max_level:
        list->max_level = new->size

    x = list->heads
    for k = list->max_level downto 1:
        if x[k] == NULL or item < x[k]->item:
            if k < new->size:
              new->next[k] = x[k]
              x[k] = new
        else:
            x = x[k]->next
            k++
*/
}

const void* search_skiplist(struct SkipList *list, void *item){
	if(list == NULL || item == NULL)
		return NULL;
	Node **x = list->heads;
	for(int i = list->max_level-1; i >= 0; --i)
		while(x[i]->next[i] != NULL && list->compare(x[i]->next[i]->item, item) <= 0)
			x = x[i]->next;
	
	if(list->compare(x[0]->item, item) == 0)
		return x[0]->item;
	else 
		return NULL;
/*searchSkipList(list, item):
    x = list->heads

    // loop invariant: x[i]->item <= item or item < first element of level i in list
    for i = list->max_level downto 1:
        while x[i]->next[i] != NULL and x[i]->next[i]->item <= item:
            x = x[i]->next

    // loop end: x[1]->item <= item or item < first element in list
    if x[1]->item == item then
        return x[1]->item
    else
        return failure
*/
}