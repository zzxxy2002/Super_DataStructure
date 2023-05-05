<<<<<<< HEAD
package deque;

public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
    default boolean isEmpty() {
        return size() == 0;
    }
}
=======
package deque;

public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
    default boolean isEmpty() {
        return size() == 0;
    }
}
>>>>>>> bc93099c96ebffc9ebd67f516fc5e9506a962550
