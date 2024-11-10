package Queue;

import Excepciones.EmptyException;
import Excepciones.FullException;


public interface IQueue<T> {
    void add(T element) throws FullException;

    T element() throws EmptyException;

    boolean offer(T element) throws FullException;

    T peek();

    T pull() throws EmptyException;

    T remove();

    boolean isEmpty() throws EmptyException;

    boolean isFull() throws FullException;

}
