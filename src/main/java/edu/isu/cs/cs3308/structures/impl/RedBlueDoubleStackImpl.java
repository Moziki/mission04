package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.RedBlueDoubleStack;

public class RedBlueDoubleStackImpl<E> implements RedBlueDoubleStack<E> {
    LinkedStack<E> red;
    LinkedStack<E> blue;

    public RedBlueDoubleStackImpl() {
        red = new LinkedStack<>();
        blue = new LinkedStack<>();
    }

    public void pushRed(E element) {
        red.push(element);
    }

    public void pushBlue(E element) {
        blue.push(element);
    }

    public E popRed() {
        return red.pop();
    }

    public E popBlue() {
        return blue.pop();
    }

    public E peekRed() {
        return red.peek();
    }

    public E peekBlue() {
        return blue.peek();
    }

    public int sizeRed() {
        return red.size();
    }

    public int sizeBlue() {
        return blue.size();
    }

    public boolean isRedEmpty() {
        return red.isEmpty();
    }

    public boolean isBlueEmpty() {
        return blue.isEmpty();
    }
}
