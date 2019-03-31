#include <stdio.h>              /*Standard library, var types, macros and functions for input  and output*/

void reverse(void) {            /*Declaration of 'reverse' (Tells compiler about  name, return type and parameters)*/
  char c = getchar();           /*Declaration of the variable c - Assigning it the value off 'stdin' (standard input stream)*/
  if(c != '\n') {reverse();}    /*Base case: if enter is pressed (equal to '\n', 'newline')*/
  putchar(c);                   /*Put the whole sequence of  char's on the 'stdout' (standard output stream)*/
  return;                       /*In some compilers default return is int, therefore we specify an empty return*/
}

int main (void) {               /*main method*/
  printf("Enter a word: ");     /*Functions defined in the <stdio.h> - lib*/
  reverse();                    /*Calling our recursive function*/
}
