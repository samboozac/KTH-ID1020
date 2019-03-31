/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description: Modified example from Robert Sedgewick's and Kevin Wayne's book, Algorithms: https://algs4.cs.princeton.edu/code/
***/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stack {
    char stack[] = new char[50];
    int top = 0;

    public void push(char input) {
        stack[top] = input;
        top++;
    }

    public void pop() {
        stack[top] = '\0';
        top--;
    }

    public void printString() {
        for(int i = 0; i < top; i++) {
            System.out.print("|" + stack[i] + "|");
        }
    }

    public void printStringRev() {
        for(int i = top; 0 <= i; i--) {
            System.out.print("|" + stack[i] + "|");
        }
    }

    public static void main(String[] args) throws IOException {

        Stack lifo = new Stack();
        BufferedReader br = new
        BufferedReader(new InputStreamReader(System.in));
        char c;
        while((c = (char)br.read()) != '\n'){
            lifo.push(c);
        }
        lifo.printString();
        System.out.println();
        lifo.printStringRev();
    }
}
