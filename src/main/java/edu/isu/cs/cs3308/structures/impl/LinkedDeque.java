package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Deque;
import edu.isu.cs.cs3308.structures.Queue;
//Dan Walker
//CS3308
//Mission04
// 2/9/2019
public class LinkedDeque<E> implements Deque<E> {
    DoublyLinkedList<E> data;

    public LinkedDeque() {data = new DoublyLinkedList<>();}

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void offer(E element) {
        data.addLast(element);
    }

    public void offerFirst(E element) { data.addFirst(element); }

    public E peek() {
        return data.first();
    }

    public E peekLast() { return data.last(); }

    public E poll() {
        return data.removeFirst();
    }

    public E pollLast() { return data.removeLast(); }

    public void printQueue() {
        data.printList();
    }

    /**
     *
     * @param into The new queue onto which the reversed order of contents from
     * this queue are to be transferred to the top of, unless the provided queue
     */
    public void transfer(Queue<E> into) {
        if (into == null){}
        else {
            LinkedStack<E> reverse = new LinkedStack<>();

            //@param thisQueue & paramQueue: thess are used in the for loops, acting as indexes.
            // Ensures accurate original size through the steps
            int thisQueue = this.size();
            int paramQueue = into.size();
            if (this.size() == 0) {
            } else {
                //reverses order of called upon stack
                for (int i = 0; i < thisQueue; i++) {
                    reverse.push(this.poll());
                }
                //stores param queue into called queue
                if (paramQueue != 0) {
                    for (int i = 0; i < paramQueue; i++) {
                        this.offer(into.poll());
                    }
                }
                //@param stac : called here because the size is not known until first for loop
                int stac = reverse.size();
                //puts stack into param queue (called on stack in reverse)
                for (int i = 0; i < stac; i++) {
                    into.offer(reverse.pop());
                }
                //puts original param queue back on the bottom of param queue
                if (paramQueue != 0) {
                    for (int i = 0; i < thisQueue; i++) {
                        into.offer(this.poll());
                    }
                }
            }
        }
    }
    //Reverses queue by polling into stack and popping back out
    public void reverse() {
        LinkedStack<E> reverse = new LinkedStack<>();
        while (!(this.isEmpty())) {
            reverse.push(this.poll());
        }
        while (!reverse.isEmpty()) {
            this.offerFirst(reverse.pop());
        }
    }

    /**
     *
     * @param from Queue whose contents are to be merged onto the bottom of
     * this queue
     */
    public void merge(Queue<E> from) {
        if (from == null) {}
        else {
            int index = from.size();
            for (int i = 0; i < index; i++) {
                this.offer(from.peek());
                from.offer(from.poll());
            }
        }
    }
}
