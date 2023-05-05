package  deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {


    // helper class//
    private class Link {
        private T item;
        private Link front;
        private Link rest;

        Link(Link f, T it, Link res) {
            item = it;
            rest = res;
            front = f;
        }
    }

    private Link frontsenti;
    private Link backsenti;

    private int size;

    public LinkedListDeque() {
        frontsenti = new Link(null, null, null);
        backsenti = new Link(frontsenti, null, null);
        frontsenti.rest = backsenti;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        frontsenti.rest = new Link(frontsenti, item, frontsenti.rest);
        frontsenti.rest.rest.front = frontsenti.rest;
        size += 1;
    }

    @Override
    public T removeFirst() {
        if (size != 0) {
            T f = frontsenti.rest.item;
            frontsenti.rest = frontsenti.rest.rest;
            frontsenti.rest.front = frontsenti;
            size -= 1;
            return f;
        }
        return null;
    }

    @Override
    public void addLast(T item) {
        backsenti.front = new Link(backsenti.front, item, backsenti);
        backsenti.front.front.rest = backsenti.front;
        size += 1;
    }

    @Override
    public T removeLast() {
        if (size != 0) {
            T f = backsenti.front.item;
            backsenti.front = backsenti.front.front;
            backsenti.front.rest = backsenti;
            size -= 1;
            return f;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }



    public T getRecursive(int index) {
        return helper(index, frontsenti.rest);
    }

    private T helper(int index, Link l) {
        if (index == 0) {
            return l.item;
        }
        return helper(index - 1, l.rest);
    }

    @Override
    public T get(int i) {
        if (i >= size) {
            return null;
        }
        Link now = frontsenti.rest;
        for (int index = 0; index < i; index++) {
            now = now.rest;
        }
        return now.item;
    }

    @Override
    public void printDeque() {
        if (frontsenti.rest != null) {
            frontsenti = frontsenti.rest;
        }
        while (frontsenti.rest != null) {
            if (frontsenti.item != null) {
                System.out.print(frontsenti.item);
                frontsenti = frontsenti.rest;
            }
        }

    }
    public Iterator<T> iterator() {
        return new LinkIter();
    }

    private class LinkIter implements Iterator<T> {
        private int position;
        LinkIter() {
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
