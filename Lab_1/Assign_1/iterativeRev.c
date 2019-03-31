#include <stdio.h>

void reverseString(char str[], int len) {
  int i,j;
  char hold;

  for(i = 0, j = len-1; i < j; i++, j--) {
    hold = str[i];
    str[i] = str[j];
    str[j] = hold;
  }

  for(i=0; putchar(str[i]) != '\0'; i++);
  putchar('\n');
}

int main(void) {
  char str[30];
  int len;

  printf("Enter a string: ");
  for(len = 0; (str[len] = getchar()) != '\n'; len++);
  str[len+1] = '\0';

  reverseString(str, len);

  return 0;
}
