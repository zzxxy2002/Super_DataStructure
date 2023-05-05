package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private T[] item;
    private int size;
    private int front;
    private int back() {
        return size + front - 1;
    }

    public ArrayDeque() {
        item = (T []) new Object[8];
        size = 0;
        front = 4;
    }

    @Override
    public void addFirst(T t) {
        if (front - 2 <= 0) {
            frontexpand();
        }
        item[front - 1] = t;
        size++;
        front--;
    }

    @Override
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        T t = item[front];
        item[front] = null;
        front++;
        size--;
        if (userate() < 0.25 && item.length > 16) {
            backextract();
        }
        return t;
    }


    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        T a = item[back()];
        item[back()] = null;
        size--;
        if (userate() < 0.25 && item.length > 16) {
            backextract();
        }
        return a;
    }

    @Override
    public void addLast(T t) {
        if (back() + 2 >= item.length) {
            backexpand();
        }
        item[back() + 1] = t;
        size++;
    }

    private void frontexpand() {
        front = front + item.length;
        T[] array = (T []) new Object[2 * item.length];
        System.arraycopy(item, 0, array, item.length, item.length);
        item = array;
    }

    private void backexpand() {
        T[] array = (T []) new Object[item.length * 2];
        System.arraycopy(item, 0, array, 0, item.length);
        item = array;
    }


    private double userate() {
        return (double) size / (double) item.length;
    }

    private void backextract() {
        T[] array = (T []) new Object[item.length - (item.length - back()) / 2 - (front - 1) / 2];
        System.arraycopy(item, (front - 1) / 2, array, 0, back() - (front - 1) / 2 + 1);
        front = front - (front - 1) / 2;
        item = array;
    }


    @Override
    public T get(int i) {
        return item[i + front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(item[i]);
        }
    }

    public Iterator<T> iterator() {
        return new ArrayIter();
    }

    private class ArrayIter implements Iterator<T> {
        private int position;
        private ArrayIter() {
            position = 0;
        }
        public boolean hasNext() {
            return position < size;
        }
        public T next() {
            position++;
            return get(position - 1);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        if (o == null) {
            return false;
        }
        Deque<T> n = (Deque<T>) o;
        if (!(size == n.size())) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!n.get(i).equals(get(i))) {
                return false;
            }
        }
        return true;
    }

}

