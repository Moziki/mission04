package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.Deque;
import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.impl.LinkedDeque;
import edu.isu.cs.cs3308.structures.impl.LinkedStack;
import edu.isu.cs.cs3308.structures.impl.RedBlueDoubleStackImpl;
import edu.isu.cs.cs3308.structures.RedBlueDoubleStack;

/**
 *
 * @author Isaac Griffith
 * @author Dan Walker (line #81 - #100)
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deque<String> deque = new LinkedDeque<>();

        deque.offer("Hello");
        deque.offerFirst("World");
        deque.printQueue();

        System.out.println("\n");
        System.out.println(deque.poll());
        deque.offer("GoodBye");
        deque.printQueue();
        System.out.println(deque.pollLast());

        deque.offer("Another");
        deque.offer("Dust");
        deque.printQueue();

        System.out.println("\n");
        System.out.println("Reversed:");
        deque.printQueue();

        System.out.println("\n");
        System.out.println("Transfered:");
        Deque<String> temp = new LinkedDeque<>();
        deque.transfer(temp);
        temp.printQueue();

        System.out.println("\n");
        System.out.println("Merged Back:");
        deque.merge(temp);

        System.out.println("\n");
        Stack<Integer> stack1 = new LinkedStack<>();
        Stack<Integer> stack2 = new LinkedStack<>();
        for (int i = 4; i > 0; i--)
            stack1.push(i);
        for (int i = 8; i > 5; i--)
            stack2.push(i);

        System.out.println("Stack1:");
        stack1.printStack();
        System.out.println("\nStack2:");
        stack2.printStack();

        System.out.println("\nMerged Stacks");
        DequeStackMerge.dequeStackMerge(stack1, stack2);
        stack1.printStack();

        System.out.println("\nDestack:");
        RedBlueDoubleStack<Integer> redBlue = new RedBlueDoubleStackImpl<>();

        redBlue.pushBlue(1);
        redBlue.pushRed(1);
        redBlue.pushRed(2);

        System.out.println("Red Size: " + redBlue.sizeRed());
        System.out.println("Blue Size: " + redBlue.sizeBlue());

        System.out.println("Red Peek: " + redBlue.peekRed());
        System.out.println("Blue Peek: " + redBlue.peekBlue());

        LinkedStack<String> check1 = new LinkedStack<>();
        LinkedStack<String> check2 = new LinkedStack<>();
        int i;
        for (i = 5; i > 0; i-- ) {
            check1.push(String.valueOf(i));
        }
        check2.push("e");
        check2.push("d");
        check2.push("c");
        check2.push("b");
        check2.push("a");


        DequeStackMerge.dequeStackMerge(check1, check2);
        int marker = check1.size();
        for (int y = 0; y < marker; y++) {
            System.out.println(check1.pop());
        }
        System.out.println ("The size of check1 was " + marker);
    }


}
