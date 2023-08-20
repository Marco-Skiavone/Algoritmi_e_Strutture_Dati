#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <errno.h>
#include <time.h>
#include "skiplist.h"
#include "../../libs/compare/compare.h"
#include <assert.h>

#define STR_LEN 35

#define STAMPA_LISTA 	puts("\n");										\
	for(Node *n = dictionary->heads[0]; n != NULL; n = n->next[0]){		\
		printf("%s->", ((char*)(n->item)));								\
	} printf("NULL\n");

#define END clear_skiplist(&dictionary); assert(dictionary == NULL); exit(0);

/** list to store the elements of the dictionary, it prints what it cannot be found in the skiplist. */
void find_errors(FILE *dictfile, FILE *textfile, size_t max_height){
	SkipList *dictionary;
	new_skiplist(&dictionary, max_height, compare_string);
	int continue_scanf = 0;
	char *str;
	printf("Processing... ");
	do {
		str = (char*)malloc(STR_LEN*sizeof(char));
		if((continue_scanf = fscanf(dictfile, "%s", str)) > 0){
			insert_skiplist(dictionary, str);
		}
	} while(continue_scanf > 0);
	printf("Done.\n");
	/* insertions done. Now we run through textfile and print the errors*/
	char *str2 = (char*)malloc(STR_LEN*sizeof(char));
	int ret_scan;
	int j = 0;
	clock_t before = clock();
	while((ret_scan = fscanf(textfile, "%s[a-zA-Z]", str2)) != -1){
		for(int i = 0; i < STR_LEN && str2[i] != '\0'; ++i){
			if(!isalpha(str2[i]))
				str2[i] = isalpha(str2[i+1]) ? str2[i+1] : '\0';
			else if(isupper(str2[i]))
				str2[i] += 32;
		} 
		/* fine parola */
		if(search_skiplist(dictionary, str2) == NULL)
		 	printf("%s\n", str2);
	}
	clock_t after = clock();
	printf("time used: %f.\n", (double)(after-before)/CLOCKS_PER_SEC);
	clear_skiplist(&dictionary);
	assert(dictionary == NULL);
}

int main(int argc, char *argv[]){
	if(argc != 4){
		fprintf(stderr, "Error in the number of the arguments passed at launch.\nPassed %d/%d.\n", argc, 4);
	}
	size_t max_height = atoi(argv[3]);
	FILE *dictfile = fopen(argv[1], "r"), *textfile = fopen(argv[2], "r");
	if(dictfile != NULL && textfile != NULL)
		find_errors(dictfile, textfile, max_height);
	else
		fprintf(stderr, "Error occurred while opening the files!\n");
	fclose(dictfile);
	fclose(textfile);
}