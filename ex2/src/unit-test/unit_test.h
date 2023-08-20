#ifndef _UNIT_TEST_H
#define _UNIT_TEST_H
#ifndef _STDIO_H
#include <stdio.h>
#endif
#include <assert.h>

#define STR_LENGTH 15

enum Type {
	INT, STRING, 
};

#define STAMPA_DEB fprintf(stderr, "%s: DEB#%d\n", __FILE__, __LINE__);
void stampa_lista(enum Type t, SkipList *list);

/* integers */
void test_sl_new_clear_int();
void test_sl_clear();
void test_sl_insert_int0();
void test_sl_insert_int1();
void test_sl_insert_int2();
void test_sl_search_int();
void test_sl_search_100el_int();

/* strings */
void test_sl_new_clear_string();
void test_sl_insert_string0();
void test_sl_insert_string1();
void test_sl_search_string();
void test_sl_search_10el_string();

#endif