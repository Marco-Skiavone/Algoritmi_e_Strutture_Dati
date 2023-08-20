#include "compare.h"

int compare_int(const void *a, const void *b){
	if(a == NULL)
		return b == NULL ? 0 : -1;
	if(b == NULL)
		return 1;
	int A = *((int*)a), B = *(( int*)b);
	return A == B ? 0 : A < B ? -1 : 1;
}

int compare_string(const void *a, const void *b){
	/* se a finisce prima, ritorno -1 */
	if(a == NULL)
		return b == NULL ? 0 : -1;
	if(b == NULL)
		return 1;
	if(a == b)
		return 0;
	int ret = strcmp((char*)a, (char*)b);
	return (ret < 0) ? -1 : (ret > 0) ? 1 : ret;
}

int compare_float(const void *a, const void *b){
	if(a == NULL)
		return b == NULL ? 0 : -1;
	if(b == NULL)
		return 1;
	float d1 = *((float*)a), d2 = *((float*)b);
	float tol = (d1 < d2) ? d1 : d2;
	if(((tol > -0.0000000001f) && (tol < 0.0000000001f)) || tol > __FLT_MAX__ || tol < __FLT_MIN__)
		tol = 0.0000000001f;
	if(d1-d2 < (-1)*TOLERANCE(tol))
		return -1;
	else if(d2-d1 < (-1)*TOLERANCE(tol))
		return 1;
	return 0;
}