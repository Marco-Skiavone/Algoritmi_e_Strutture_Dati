#include <stdio.h>
#include "../merge-binInsertion-sort.h"
#include "unit_test.h"
#include "../../../libs/compare/compare.h"

int main() {
	/* test esecution */
	test_sort_empty_int();
	test_sort_null_int();
	test_sort_oneEl_int();
	test_sort_2El_int0();
	test_sort_2El_int1();
	test_sort_moreEls_int0();
	test_sort_moreEls_int1();
	test_sort_moreEls_int2();
	test_sort_moreEls_int3();
	test_sort_moreEls_int4();
	test_sort_more_Arrays_int();
	test_sort_100_int();
//
	test_sort_empty_string();
	test_sort_null_string();
	test_sort_oneEl_string();
	test_sort_2El_long_string();
	test_sort_moreEls_string();
//
	test_sort_empty_float();
	test_sort_null_float();
	test_sort_oneEl_float();
	test_sort_oneEl_float_compare_test();
	test_sort_2El_float_test();

	puts("\nAll test passed!");
}

/* tests: integers */
void test_sort_empty_int(){
	int a[] = {}, b[] = {};
	merge_binary_insertion_sort(a, 0, sizeof(int), K_VAL, compare_int);
	assert(compare_int(b,a) == 0);
}

void test_sort_null_int(){
	int *a = NULL;
	merge_binary_insertion_sort(a, 0, sizeof(int), K_VAL, compare_int);
	assert(is_sorted(a, 0, sizeof(int), compare_int));
}

void test_sort_oneEl_int(){
	int a[] = {1};
	merge_binary_insertion_sort(a, 1, sizeof(int), K_VAL, compare_int);
	assert(is_sorted(a, 1, sizeof(int), compare_int));
}

void test_sort_2El_int0(){
	int SIZE = 2;
	int a[] = {2, 1};
	merge_binary_insertion_sort(a, SIZE, sizeof(int), K_VAL, compare_int);
	assert(is_sorted(a, SIZE, sizeof(int), compare_int));
}

void test_sort_2El_int1(){
	int SIZE = 2;
	int a[] = {1, 2};
	merge_binary_insertion_sort(a, SIZE, sizeof(int), K_VAL, compare_int);
	assert(is_sorted(a, SIZE, sizeof(int), compare_int));
}

void test_sort_moreEls_int0(){
	int SIZE = 5;
	int a[] = {2, 1, 4, 2, 3};
	merge_binary_insertion_sort(a, SIZE, sizeof(int), K_VAL, compare_int);
	assert(is_sorted(a, SIZE, sizeof(int), compare_int));
}

void test_sort_moreEls_int1(){
	int SIZE = 5;
	int a[] = {1, 2, 2, 3, 4};
	merge_binary_insertion_sort(a, SIZE, sizeof(int), K_VAL, compare_int);
	assert(is_sorted(a, SIZE, sizeof(int), compare_int));
}

void test_sort_moreEls_int2(){
	int SIZE = 10;
	int a[] = {2, 1, 4, -4, 0, 11, 2, 3, 6, 5};
	merge_binary_insertion_sort(a, SIZE, sizeof(int), K_VAL, compare_int);
	assert(is_sorted(a, SIZE, sizeof(int), compare_int));
}

void test_sort_moreEls_int3(){
	int SIZE = 20;
	int a[] = {30, 8, 18, -12, 2, 1, 4, 7, 0, 10, 23, 12, 11, 6, 7, 4, 2, 3, -1, 5};
	merge_binary_insertion_sort(a, SIZE, sizeof(int), K_VAL, compare_int);
	assert(is_sorted(a, SIZE, sizeof(int), compare_int));
}

void test_sort_moreEls_int4(){
	int SIZE = 20;
	int a[] = {30, 8, 18, -12, 2, 1, 4, 7, 0, 10, 23, 12, 11, 2, 3, 4, 5, 6, 7, -1};
	merge_binary_insertion_sort(a, SIZE, sizeof(int), K_VAL, compare_int);
	assert(is_sorted(a, SIZE, sizeof(int), compare_int));
}

void test_sort_more_Arrays_int(){
	int SIZE = 2;
	int a[2][2] = {{2,1},{4,3}};
	int b[2][2] = {{1, 2},{3,4}};
	for(int i = 0; i < SIZE; i++)
		merge_binary_insertion_sort(a[i], SIZE, sizeof(int), K_VAL,compare_int);
	merge_binary_insertion_sort(a, SIZE, sizeof(int)*2, K_VAL, compare_int);
	for(int i = 0; i < SIZE; i++)
		assert(compare_int(b[i],a[i]) == 0);
}

void test_sort_100_int(){
	int SIZE = 100;
	int a[SIZE];
	for (int i = 0; i < SIZE; i++)
		a[i] = (rand() % 1000) * ((-1) * (rand() % 2));
	merge_binary_insertion_sort(a, SIZE, sizeof(int), K_VAL, compare_int);
	assert(is_sorted(a, SIZE, sizeof(int), compare_int));
}

/* strings */
void test_sort_empty_string(){
	char a[] = {}, b[] = {};
	merge_binary_insertion_sort(a, 0, sizeof(char*), K_VAL, compare_string);
	assert(compare_string(b,a) == 0);
}

void test_sort_null_string(){
	char *a = NULL;
	merge_binary_insertion_sort(a, 0, sizeof(char*), K_VAL, compare_string);
	assert(is_sorted(a, 0, sizeof(char*), compare_string));
}

void test_sort_oneEl_string(){
	int SIZE = 1;
	char *a  = "asdfg";
	merge_binary_insertion_sort(a, SIZE, sizeof(char*), K_VAL, compare_string);
	assert(is_sorted(a, SIZE, sizeof(char*), compare_string));
}

void test_sort_2El_long_string(){
	int SIZE = 2;
	char **a = (char **)malloc(sizeof(char*)*SIZE);
	a[0] = "asdfg"; a[1] = "aSdfg"; 
	merge_binary_insertion_sort(a, SIZE, sizeof(char**), K_VAL, compare_string);
	assert(is_sorted(a, SIZE, sizeof(char*), compare_string));
	free(a);
}

void test_sort_moreEls_string(){
	int SIZE = 5;
	char **a = (char **)malloc(sizeof(char*)*SIZE);
	a[0] = "tyuids"; a[1] = "eGduADwh";	a[2] = "opAaiAAdsAud"; a[3] = "asyrdtdy"; a[4] = "Akdlasnd";
	merge_binary_insertion_sort(a, SIZE, sizeof(char*), K_VAL, compare_string);
	assert(is_sorted(a, SIZE, sizeof(char*), compare_string));
	free(a);
}

/* floats */
void test_sort_empty_float(){
	float a[] = {}, b[] = {};
	merge_binary_insertion_sort(a, 0, sizeof(float), K_VAL, compare_float);
	assert(is_sorted(a, 0, sizeof(float), compare_float));
}

void test_sort_null_float(){
	float *a = NULL;
	merge_binary_insertion_sort(a, 0, sizeof(float), K_VAL, compare_float);
	assert(is_sorted(a, 0, sizeof(float), compare_float));
}

void test_sort_oneEl_float(){
	int SIZE = 1;
	float a[] = {1.25f};
	merge_binary_insertion_sort(a, SIZE, sizeof(float), K_VAL, compare_float);
	assert(is_sorted(a, SIZE, sizeof(float), compare_float));
}

void test_sort_oneEl_float_compare_test(){
	int SIZE = 1;
	float a[] = {1.3f};
	merge_binary_insertion_sort(a, SIZE, sizeof(float), K_VAL, compare_float);
	assert(is_sorted(a, SIZE, sizeof(float), compare_float));
}

void test_sort_2El_float_test(){
	int SIZE = 2;
	float a[] = {1.3f, 1.25f};
	merge_binary_insertion_sort(a, SIZE, sizeof(float), K_VAL, compare_float);
	assert(is_sorted(a, SIZE, sizeof(float), compare_float));
}

/* is_sorted */
int is_sorted(void *base, size_t nitems, size_t size, int (*compar)(const void*, const void*)){
	if(base == NULL || nitems == 0 || size == 0)
		return 1;
	for(int i = 0; i < nitems-1; i++)
		if(compar(base+(i*size), base+((i+1)*size)) > 0)
			return 0;
	return 1;
}