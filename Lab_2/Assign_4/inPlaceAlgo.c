/* Loop-Invariant - A statement about the variables in a program:
   1. True before exec of loop
   2. True before and after each loop iteration
   3. Tell us something useful when loop stops, helps us understand the algo */

/*Invariant: a[0..len-1] contains the same elements as the original array
  a[0..len-1], but all the negative values first. [i < len]*/

#include <stdio.h>

void arrangeSign(int a[], int len) {
  int i, temp;
  int j = 0;
  for(i=0; i < len; i++) {
    if(a[i] < 0) {
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      j++;
    }
  }
  return;
}

void buildString(int a[], int len) {
  int i;
  for(i=0; i < len; i++) {
    printf("|%d|", a[i]);
  }
  return;
}

int main(void) {
  int arr[5] = {-9, -2, -2, -7, -3};
  int len = sizeof(arr) / sizeof(arr[0]);
  arrangeSign(arr, len);
  buildString(arr, len);

  return 1;
}
