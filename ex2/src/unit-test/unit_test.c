#include <stdio.h>
#include "../skiplist.h"
#include "unit_test.h"
#include "../../../libs/compare/compare.h"
#include <time.h>

/** The max height speed that is possible to reach. */
#define MAX_HEIGHT 20

int main(int argc, char *argv[]){
	srand(time(NULL));
	/* tests esecution */
	test_sl_new_clear_int();
	test_sl_clear();
	test_sl_insert_int0();
	test_sl_insert_int1();
	test_sl_insert_int2();
	test_sl_search_int();
	test_sl_search_100el_int();
//
	test_sl_new_clear_string();
	test_sl_insert_string0();
	test_sl_insert_string1();
	test_sl_search_string();
	test_sl_search_10el_string();
	puts("\nAll test passed!");
}

/* integers */
void test_sl_new_clear_int(){
	SkipList *list = NULL;
	new_skiplist(&list, MAX_HEIGHT, compare_int);
	assert(list != NULL);
	clear_skiplist(&list);
	assert(list == NULL);
}

void test_sl_clear(){
	SkipList *list = NULL;
	clear_skiplist(&list);
	assert(list == NULL);
}

void test_sl_insert_int0(){
	int SIZE = 10;
	SkipList *list = NULL;
	new_skiplist(&list, MAX_HEIGHT, compare_int);
	int *val;
	for(int i = 0; i < SIZE; i++){
		val = (int*)malloc(sizeof(int));
		*val = rand() % 10000;
		insert_skiplist(list, val); 
	}
	assert(list != NULL);
	clear_skiplist(&list);
	assert(list == NULL);
}

void test_sl_insert_int1(){
	SkipList *list = NULL;
	int *val= (int*)malloc(sizeof(int));
	*val = 10;
	insert_skiplist(list, val);
	assert(search_skiplist(list, val) == NULL);
}

void test_sl_insert_int2(){
	SkipList *list = NULL;
	new_skiplist(&list, MAX_HEIGHT, compare_int);
	int *val = (int*)malloc(sizeof(int));
	*val = 10;
	insert_skiplist(list, val);
	assert(search_skiplist(list, val) != NULL);
	assert(search_skiplist(list, val) == val);
	clear_skiplist(&list);
	assert(list == NULL);
}

void test_sl_search_int(){
	SkipList *list = NULL;
	new_skiplist(&list, MAX_HEIGHT, compare_int);
	int *val1 = (int*)malloc(sizeof(int)), *val2 = (int*)malloc(sizeof(int));
	*val1 = 10; *val2 = 5;
	int val3 = (*val1)+(*val2);
	insert_skiplist(list, val1); 
	insert_skiplist(list, val2); 

	assert(search_skiplist(list, val1) != NULL);
	assert(search_skiplist(list, val2) != NULL);
	assert(search_skiplist(list, &val3) == NULL);
	clear_skiplist(&list);
	assert(list == NULL);
}

void test_sl_search_100el_int(){
	int SIZE = 100;
	SkipList *list = NULL;
	new_skiplist(&list, MAX_HEIGHT, compare_int);
	assert(list != NULL);
	int *val;
	for(int i = 0; i < SIZE; i++){
		val = (int*)malloc(sizeof(int));
		*val = i;
		insert_skiplist(list, val); 
	}
	// stampa_lista(INT, list);
	*val = 71;
	assert(search_skiplist(list, val) != NULL);
	clear_skiplist(&list);
	assert(list == NULL);
}

/* strings */
void test_sl_new_clear_string(){
	SkipList *list = NULL;
	new_skiplist(&list, MAX_HEIGHT, compare_string);
	assert(list != NULL);
	clear_skiplist(&list);
	assert(list == NULL);
}

void test_sl_insert_string0(){
	int SIZE = 10;
	SkipList *list = NULL;
	new_skiplist(&list, MAX_HEIGHT, compare_string);
	char **val = (char**)calloc(SIZE, sizeof(char*));
	for(int i = 0; i < SIZE; ++i)
		val[i] = (char*)calloc(STR_LENGTH, sizeof(char*));
	val[0] = strcpy(val[0], "asdfgh");
	val[1] = strcpy(val[1], "Ajkdav");
	val[2] = strcpy(val[2], "asdFGp");
	val[3] = strcpy(val[3], "dasadD");
	val[4] = strcpy(val[4], "aSDASi");
	val[5] = strcpy(val[5], "AsCfgh");
	val[6] = strcpy(val[6], "UJDASI");
	val[7] = strcpy(val[7], "hhmdaO");
	val[8] = strcpy(val[8], "OdasoO");
	val[9] = strcpy(val[9], "ASDfgh");

	for(int i = 0; i < SIZE; i++)
		insert_skiplist(list, val[i]); 
	//stampa_lista(STRING, list);
	assert(list != NULL);
	clear_skiplist(&list);
	assert(list == NULL);
}

void test_sl_insert_string1(){
	SkipList *list = NULL;
	char *val= (char*)malloc(STR_LENGTH);
	val = "sdadnajs";
	insert_skiplist(list, val);
	assert(search_skiplist(list, val) == NULL);
}

void test_sl_search_string(){
	int SIZE = 1;
	SkipList *list = NULL;
	new_skiplist(&list, MAX_HEIGHT, compare_string);
	char *val = (char*)malloc(STR_LENGTH);
	strcpy(val, "asdfgh");
	insert_skiplist(list, val);
	assert(search_skiplist(list, val) != NULL);
	assert(search_skiplist(list, val) == val);
	clear_skiplist(&list);
	assert(list == NULL);
}

void test_sl_search_10el_string(){
	int SIZE = 10;
	SkipList *list = NULL;
	new_skiplist(&list, MAX_HEIGHT, compare_string);
	assert(list != NULL);
	char **val = (char**)malloc(SIZE*sizeof(char*));
	for(int i = 0; i < SIZE; i++)
		val[i] = (char*)malloc(STR_LENGTH);
	val[0] = strcpy(val[0], "asdfgh");
	val[1] = strcpy(val[1], "Ajkdav");
	val[2] = strcpy(val[2], "asdFGp");
	val[3] = strcpy(val[3], "dasadD");
	val[4] = strcpy(val[4], "aSDASi");
	val[5] = strcpy(val[5], "AsCfgh");
	val[6] = strcpy(val[6], "UJDASI");
	val[7] = strcpy(val[7], "hhmdaO");
	val[8] = strcpy(val[8], "OdasoO");
	val[9] = strcpy(val[9], "ASDfgh");
	for(int i = 0; i < SIZE; i++)
		insert_skiplist(list, val[i]);
	// stampa_lista(STRING, list);
	char *value = "OdasoO";
	assert(search_skiplist(list, val[6]) != NULL);
	assert(search_skiplist(list, value) != NULL);
	assert(search_skiplist(list, value) == val[8]);
	clear_skiplist(&list);
	assert(list == NULL);
}

void stampa_lista(enum Type t, SkipList *list){
	puts("\nStampo la lista:");
	for(Node *k = list->heads[0]; k != NULL; k = k->next[0])
		if(t == STRING)
			printf("%s->", (char*)(k->item));
		else
			printf("%d->", *((int*)(k->item)));
	puts("NULL\n");
}