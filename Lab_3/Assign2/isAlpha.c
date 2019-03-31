/**
* Author: Sam Florin
* Created: 2018-09-26
* Description: Remove newline, blank and non-alphabetic characters from the text
* A Tale Of Two Cities - Charles Dickens
**/

#include <stdio.h>
#include <ctype.h>

int main() {
  char c;
  do {
    c = getchar();
    if(isalpha(c) || isspace(c)) {
      putchar(c);
    } else {
      putchar(' ');
    }
  } while(c != EOF);

  return 0;
}
