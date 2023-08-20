#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <time.h>
#include "merge-binInsertion-sort.h"
#include "../../libs/compare/compare.h"

/** Defines the point at which the array of records must stop reading from the input file. */
#define ARRAY_SIZE 10000000

/** Defines how long can be the (char *) field of each record. */
#define MAX_STRING_LEN 100

typedef struct {
	unsigned int id;
	char field1[40];	/* max is 34 letters */
	int field2;
	float field3;
} record;

int compare_record_int(const void *a, const void *b);
int compare_record_string(const void *a, const void *b);
int compare_record_float(const void *a, const void *b);
void sort_records(const char *infile, const char *outfile, size_t k, size_t field);

int main(int argc, char *argv[]) {
	/* qui avvengono le prove sui 20 milioni di record! */
	/* "Qui si fa il grosso" .*/
	if(argc != 5){
		fprintf(stderr, "Error occurred during parameter count! \
			Please launch again the program with the following pattern:\tmake run var=\"[path/records.csv] [path/sorted.csv] [k] [field]\"\n");
		exit(EXIT_FAILURE);
	}
	int field = atoi(argv[4]);
	if(field < 1 || field > 3){
		fprintf(stderr, "Error occurred! 'field' parameter has invalid value. Found: %d, needed 1, 2 or 3.\n", field);
		exit(EXIT_FAILURE);
	}
	sort_records(argv[1], argv[2], atoi(argv[3]), field);
	puts("Sorted.");
	exit(EXIT_SUCCESS);
}

/**
 * This function requires two string paths of files, to be considered as input and output and needs
 * a 'k' parameter (free choice of value) and a 'field' value which can be 1, 2 or 3. */
void sort_records(const char *infile, const char *outfile, size_t k, size_t field){
	FILE *f_read = fopen(infile, "r");
	FILE *f_write = fopen(outfile, "w+");
	if(errno || f_read == NULL || f_write == NULL){
		fprintf(stderr, "Error occurred while opening the files!\n");
		exit(EXIT_FAILURE);
	}
	record *array = (record*) malloc(sizeof(record) * ARRAY_SIZE);
	for(int i = 0; i < ARRAY_SIZE; ++i)
		if(fscanf(f_read, "%d, %[^,], %d, %f", &(array[i].id), array[i].field1, &(array[i].field2), &(array[i].field3)) == 0){
			fprintf(stderr, "Line %d: Error occured while reading!\n", __LINE__);
			break;
		}
	fclose(f_read);
	for(int i = 0; i < ARRAY_SIZE; i++ )
		printf("[%d, \"%s\", %d, %f]\n", array[i].id, array[i].field1, array[i].field2, array[i].field3);
	clock_t before = clock();
	printf("----------------------------\nTime before: %ld.\n", before);
	switch(field) {
		case 1:
			merge_binary_insertion_sort(array, ARRAY_SIZE, sizeof(record), k, compare_record_string);
			break;
		case 2:
			merge_binary_insertion_sort(array, ARRAY_SIZE, sizeof(record), k, compare_record_int);
			break;
		case 3:
			merge_binary_insertion_sort(array, ARRAY_SIZE, sizeof(record), k, compare_record_float);
			break;
		default: /* this case is checked by the main_ex1, but to a little bit more compatibility it's checked here too. */
			fprintf(stderr, "Error occurred while calling sort_records()!\n");
			exit(EXIT_FAILURE);
	}
	clock_t after = clock();
	printf("Time after: %ld.\nTime to sort: %.3f seconds.\n", after, ((double)(after-before)/CLOCKS_PER_SEC));
	/* writing on outfile.. */
	for(int i = 0; i < ARRAY_SIZE; i++){
		fprintf(f_write, "%d,", array[i].id);
		fprintf(f_write, "%s,", array[i].field1);
		fprintf(f_write, "%d,", array[i].field2);
		fprintf(f_write, "%g\n", array[i].field3);
	}
	/* de-allocation */
	free(array);
	fclose(f_write);
}

/** It compares 2 records depending on FIELD2.
 * @returns 1 if a > b, -1 if a < b, 0 otherwise. */
int compare_record_int(const void *a, const void *b){
	return compare_int(&((*((record*)a)).field2), &((*((record*)b)).field2));
}

/** It compares 2 records depending on FIELD1.
 * @returns 1 if a > b, -1 if a < b, 0 otherwise. */
int compare_record_string(const void *a, const void *b){

	int ret = strcmp(((record*)a)->field1, ((record*)b)->field1);
	return (ret > 0) ? 1 : (ret < 0) ? -1 : 0;
}

/** It compares 2 records depending on FIELD3.
 * @returns 1 if a > b, -1 if a < b, 0 otherwise. */
int compare_record_float(const void *a, const void *b){
	return compare_float(&((*((record*)a)).field3), &((*((record*)b)).field3));
}