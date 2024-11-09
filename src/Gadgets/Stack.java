package Gadgets;

import Excepciones.FullException;

import java.util.EmptyStackException;

public interface Stack<T> {

    int getTop();

    boolean isEmpty() throws EmptyStackException;

    boolean isFull() throws FullException;

    boolean push(T element);

    T pop() throws EmptyStackException;

    T peek() throws EmptyStackException;

    int search(T element) throws EmptyStackException;
}
