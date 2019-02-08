package edu.isu.cs.cs3308.structures;

//Dan Walker
//CS3308
//Mission04
// 2/9/2019
/**
 * RedBlueDoubleStack is a Doubly Ended Stack that has two colors representing the
 * ends. Red is the top of the DeStack and Blue is the Bottom.
 *
 * @author Isaac Griffith
 * @param <E> The Type of element stored in the RedBlueDoubleStack.
 */
public interface RedBlueDoubleStack<E> {

    /**
     * Adds the element to the top of the Red Stack, unless the element is null.
     *
     * @param element Element to add.
     */
    void pushRed(E element);

    /**
     * Adds the element to the top of the Blue Stack, unless the element is
     * null.
     *
     * @param element Element to add.
     */
    void pushBlue(E element);

    /**
     * Removes the element at the top of the Red Stack and returns its value,
     * unless the Red Stack is empty.
     *
     * @return Element at the top of the Red Stack, or null if the Red Stack is
     * empty
     */
    E popRed();

    /**
     * Removes the element at the top of the Blue Stack and returns its value,
     * unless the Blue Stack is empty.
     *
     * @return Element at the top of the Red Stack, or null if the Blue Stack is
     * empty
     */
    E popBlue();

    /**
     * Returns the value at the top of the Red Stack.
     *
     * @return The value at the top of the Red Stack, or null if the Red Stack
     * is emtpy
     */
    E peekRed();

    /**
     * Returns the value at the top of the Blue Stack.
     *
     * @return The value at the top of the Blue Stack, or null if the Blue Stack
     * is emtpy
     */
    E peekBlue();

    /**
     * @return Current size of the Blue Stack
     */
    int sizeBlue();

    /**
     * @return Current size of the Red Stack
     */
    int sizeRed();

    /**
     * @return True if the Blue Stack is empty, false otherwise
     */
    boolean isBlueEmpty();

    /**
     * @return True if the Red Stack is empty, false otherwise
     */
    boolean isRedEmpty();
}
