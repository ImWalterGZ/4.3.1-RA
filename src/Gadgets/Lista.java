package Gadgets;

public interface Lista <T> {

    boolean isEmpty();

    Nodo<T> getLastElement();

    Nodo<T> getPrevElement(T value);

    long getElement(T element);

    Nodo<T> getElementAt();


    boolean isThere(T value);
    boolean isThere(Nodo<T> node);

    void add(T value);
    void add(Nodo<T> node);

    void remove(T value);
    void remove(Nodo<T> node);

    void addAt(int position, T value);
    void addAt(int position, Nodo<T> node);

    void addAfter(int position, T value);
    void addAfter(int position, Nodo<T> node);

    void addBefore(int position, Nodo<T> node);
    void addBefore(int position, T value);

    void removeAfter(int position, T value);
    void removeAfter(int position, Nodo<T> node);

    void removeBefore(int position, T value);
    void removeBefore(int position, Nodo<T> node);

    void addStart(T value);
    void addStart(Nodo<T> node);

    long getLength();

    void removeAll(T value);
    void removeAll(Nodo<T> value);
    String toString();
}
