#ifndef _UNIT_TEST_H
#define _UNIT_TEST_H
#ifndef _STDIO_H
#include <stdio.h>
#endif
#include <assert.h>

#define K_VAL 27

/** @param base array to check;
 * @param nitems elements of the array to check;
 * @param size bytes of the element type of the array;
 * @param compar is the function pointer to use for the comparison between elements.
 * @return 1 if sorted, 0 otherwise. */
int is_sorted(void *base, size_t nitems, size_t size, int (*compar)(const void*, const void*));

/* tests: integers */
void test_sort_empty_int();
void test_sort_null_int();
void test_sort_oneEl_int();
void test_sort_2El_int0();
void test_sort_2El_int1();
void test_sort_moreEls_int0();
void test_sort_moreEls_int1();
void test_sort_moreEls_int2();
void test_sort_moreEls_int3();
void test_sort_moreEls_int4();
void test_sort_more_Arrays_int();
void test_sort_100_int();

/* strings */
void test_sort_empty_string();
void test_sort_null_string();
void test_sort_oneEl_string();
void test_sort_2El_long_string();
void test_sort_moreEls_string();

/* floats */
void test_sort_empty_float();
void test_sort_null_float();
void test_sort_oneEl_float();
void test_sort_oneEl_float_compare_test();
void test_sort_2El_float_test();

#endif