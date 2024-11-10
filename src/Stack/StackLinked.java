package Stack;

import Excepciones.FullException;
import Gadgets.DLinkedList;
import Gadgets.Stack;
import Gadgets.Nodo;

import java.util.EmptyStackException;
import java.util.Iterator;

public class StackLinked<T extends Comparable<T>> extends DLinkedList<T> implements Stack<T>, Iterable<T> {
    private long _top, _maxLength;
    private final static int SIZE = 10;

    public StackLinked() {
        super();
        _top = -1;
        _maxLength = SIZE;
    }

    public StackLinked(long size) {
        super();
        _top = -1;
        _maxLength = size;
    }

    @Override
    public boolean isFull() throws FullException {
        return (getLength() >= _maxLength);
    }

    public boolean isEmpty() {
        return getLength() <= 0 || root.getRight() == null;
    }

    @Override
    public boolean push(T element) {
        try {
            if (!isFull()) {
                this.add(element);
                _top++;
                return true;
            }
            return false;
        } catch (FullException e) {
            System.out.println("Stack is full: " + e.getMessage());
            return false;
        }
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T element = this.getLastElement().getValue();

        if (getLength() == 1) {
            root.setRight(null);
            tail.setLeft(null);
        } else {
            Nodo<T> newLast = tail.getLeft().getLeft();
            if (newLast != null) {
                newLast.setRight(null);
                tail.setLeft(newLast);
            }
        }

        _top--;
        setLength(getLength() - 1);
        return element;
    }

    @Override
    public T peek() throws EmptyStackException {
        T element = this.getLastElement().getValue();
        return element;
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Nodo<T> current = root.getRight();
        while (current != null) {
            sb.append(current.getValue());
            if (current.getRight() != null) {
                sb.append(", ");
            }
            current = current.getRight();
        }

        sb.append("]");
        return sb.toString();
    }


    public StackLinked<T> sort() {
        StackLinked<T> tmpSort = new StackLinked<T>();
        while (!this.isEmpty()) {
            T element = this.pop();
            while (!tmpSort.isEmpty() && tmpSort.peek().compareTo(element) < 0) {
                this.push(tmpSort.pop());
            }
            tmpSort.push(element);
        }
        return tmpSort;
    }


    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }


    @Override
    public int search(T element) throws EmptyStackException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public long getTop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTop'");
    }


}