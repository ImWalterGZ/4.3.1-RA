package Queue;

import Excepciones.EmptyException;
import Excepciones.FullException;
import Gadgets.DLinkedList;
import Gadgets.Nodo;

import java.util.Iterator;

public class QueueLinked<T> extends DLinkedList<T> implements IQueue<T>, Iterable<T> {
    private long _front, _back, _maxLength;
    private final static int SIZE = 10;

    public QueueLinked() {
        super();
    }

    public QueueLinked(long size){
        super();
    }


    @Override
    public void add(T element){
        super.add(element);
    }

    @Override
    public T element() {
        T element = root.getRight().getValue();
        return element;
    }


    @Override
    public boolean offer(T element) {
        super.add(element);
        return true;
    }



    @Override
    public T peek() {
        return element();
    }



    @Override
    public T pull() {
        T element = root.getRight().getValue();
        root.setRight(root.getRight().getRight());
        return element;
    }



    @Override
    public T remove() {
        if (isEmpty()){
            try {
                throw new EmptyException("Its empty");
            } catch (EmptyException e) {
                System.out.println(e.getMessage());
            }
        }
        return pull();
    }


    @Override
    public boolean isEmpty() {
        return getLength() <= 0 || root.getRight() == null;
    }

    @Override
    public boolean isFull() {
        return getLength() >= _maxLength;
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Nodo<T> current = root.getRight();

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.getValue();
                current = current.getRight();
                return value;
            }
        };
    }


}
