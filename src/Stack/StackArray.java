import Excepciones.FullException;
import Gadgets.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class StackArray<T> implements Stack<T>, Iterable<T> {
    private int _size, _top;
    private final static int SIZE = 10;
    private T[] _stack;

    public StackArray() {
        this(SIZE);
    }

    public StackArray(int size) {
        _stack = (T[]) new Object[size <= 0 ? SIZE : size];
        _top = 0;
        _size = _stack.length;


    }


    public StackArray(StackArray<T> stack) {
        this._stack = Arrays.copyOf(stack._stack, stack._stack.length);
        this._size = stack._size;
        this._top = stack._top;
    }

    @Override
    public int getTop() {
        return _top;
    }

    @Override
    public boolean isEmpty() throws EmptyStackException {
        if (_top < 0) throw new EmptyStackException();
        else {
            return false;
        }
    }

    @Override
    public boolean isFull() throws FullException {

        if (_top + 1 == _size) throw new FullException();
        return false;

    }

    @Override
    public boolean push(T element) {
        try {
            isFull();
            _stack[++_top] = element;
            return true;

        } catch (FullException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public T pop() throws EmptyStackException {
        try {
            isEmpty();
            return _stack[_top--];
        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public T peek() throws EmptyStackException {
        try {
            isEmpty();
            return _stack[_top];
        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
// Al integrar el iterator a la clase, le damos la facultad de recorrer el arreglo stack al hacer una llamada de for mejorado
    @Override
    public int search(T element) throws EmptyStackException {
        int counter = _top;
        try {
            isEmpty();
            for (T value : this) {
                if (value.equals(element)) {
                    return counter;
                }
                counter--;
            }

        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }

        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pico = _top;

            @Override
            public boolean hasNext() {
                return (pico >= 0);
            }

            @Override
            public T next() {

                return _stack[pico--];
            }
        };
    }
}