import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Stack;

public class Reverse {
  public static void main(String[] args){

    Stack<Integer> stack = new Stack<Integer>();
    while (!StdIn.isEmpty()) {
      stack.push(StdIn.readInt());
    }
    for(int c: stack) {
      StdOut.println(c);
    }
  }
}
