package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;

public class DoublyLinkedList<E> implements List<E> {
    private static class Node<E> {
        //@element the information or object in the node
        private E element;
        //@next reference to next node
        private Node<E> next;
        //@prev reference to previous node
        private Node<E> prev;

        //@param e - the information or object to be stored in node
        public Node(E e) {
            element = e;
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public Node<E> getPrev() { return prev; }
        public void setNext(Node<E> n) { next = n; }
        public void setPrev(Node<E> n) { prev = n;}
    }
    //@head & @tail - SENTRY nodes
    protected Node<E> head;
    protected Node<E> tail;
    //@size - size of stack
    protected int size = 0;


    //CONSTRUCTOR
    //builds head and tail sentry nodes and sets references to each other
    public DoublyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        tail.setPrev(head);
        head.setNext(tail);
    }

    //METHODS
    public E first() {
        if (isEmpty()) return null;
        return head.getNext().getElement();
    }


    public E last() {
        if (isEmpty()) return null;
        return tail.getPrev().getElement();
    }

    public void addLast(E element) {
        if (element == null) {}
        else {
            Node<E> newNode = new Node<>(element);
            newNode.setNext(tail);
            newNode.setPrev(tail.getPrev());
            tail.setPrev(newNode);
            newNode.getPrev().setNext(newNode);

            size++;
        }
    }

    public void addFirst(E element){
        if (element == null){}

        else {
            Node<E> newNode = new Node<>(element);
            newNode.setNext(head.getNext());
            newNode.setPrev(head);
            head.setNext(newNode);
            newNode.getNext().setPrev(newNode);

            size++;
        }
    }

    public E removeFirst() {
        if (isEmpty()) { return null; }

        Node<E> temp = head.getNext();
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        temp.setNext(null);
        temp.setPrev(null);
        size--;
        return temp.getElement();
    }

    public E removeLast(){
        if (isEmpty()){ return null;}

        Node<E> temp = tail.getPrev();
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        temp.setNext(null);
        temp.setPrev(null);
        size--;
        return temp.getElement();
    }

    public void insert(E element, int index){
        if (index < 0 || element == null) {

        }
        else if (index >= size ){
            addLast(element);
        }
        else{
            Node<E> newNode = new Node<>(element);
            Node<E> current = head.getNext();
            for (int i = 0; i < index -1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            current.setNext(newNode);
            size++;


        }

    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = head.getNext();
        for (int i = 0; i < index - 1; i++)
            current = current.getNext();

        Node<E> toRemove = current.getNext();
        current.setNext(toRemove.getNext());
        toRemove.getNext().setPrev(toRemove.getPrev());
        toRemove.setNext(null);
        toRemove.setPrev(null);
        size--;
        return toRemove.getElement();
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            return null;
        Node<E> current = head.getNext();
        for (int i = 0; i < index; i++)
            current = current.getNext();

        return current.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);

    }

    public void printList(){
        Node<E> current = head.getNext();
        for (int i = 0; i < size; i++){
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

}
