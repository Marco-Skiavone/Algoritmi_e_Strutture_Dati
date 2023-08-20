#ifndef _COMPARE_H
#define _COMPARE_H
#ifndef _STDLIB_H
#include <stdlib.h>
#endif
#ifndef _STRING_H
#include <string.h>
#endif

/** To compare 2 integers. 
 * 
 * RETURNS: 0 if a == b, 1 if a greater then b, -1 otherwise. */
int compare_int(const void *a, const void *b);

/** To compare 2 strings. 
 * 
 * RETURNS: 0 if a == b, 1 if a greater then b, -1 otherwise. */
int compare_string(const void *a, const void *b);

/* Sets the tolerance of the equality case for the compare_float. */
#define TOLERANCE(tol) ((tol) * 0.00001f)

/** To compare 2 float precision floating point numbers. 
 * @return 0 if a == b, 1 if a greater then b, -1 otherwise. */
int compare_float(const void *a, const void *b);

#endif