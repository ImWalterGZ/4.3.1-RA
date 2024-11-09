package Queue;

import Excepciones.EmptyException;
import Excepciones.FullException;

import java.util.Iterator;

public class QueueArray<T> implements IQueue<T>, Iterable<T> {
    private final static int SIZE = 10;
    private T[] _queue;
    private int _back, _count, _size, _front;

    public QueueArray() {
        this(SIZE);
    }

    public QueueArray(int size) {
        _queue = (T[]) new Object[size <= 0 ? SIZE : size];
        _front = -1;
        _size = _queue.length;
        _count = _back = 0;
    }

    @Override
    public boolean add(T element) throws FullException {
        try {
            if (isFull()) ;
            _count++;
            _queue[_back++ % _size] = element;
            return true;
        } catch (FullException e) {
            System.out.println(e.getMessage());

        }
        return true;
    }
    @Override
    public T element() {
        try {
            isEmpty();
            return _queue[(_back - 1) % _size];
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean offer(T element) throws FullException {
        return false;
    }

    @Override
    public T peek() {
        try {
            isEmpty();
            return _queue[(_front + 1) % _size];
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public T pull() throws EmptyException {
        try {
            isEmpty();
            _count--;
            return _queue[++_front % _size];
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean isEmpty() throws EmptyException {
        if (_count == 0) throw new EmptyException("La cola esta vacia");
        return false;
    }

    @Override
    public boolean isFull() throws FullException {
        if (_count == _size) throw new FullException("La cola esta llena");
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = _front;
            int counter = _count;

            @Override
            public boolean hasNext() {
                return counter-- != 0;
            }

            @Override
            public T next() {
                return _queue[++index % _size];
            }
    };

    }
}
