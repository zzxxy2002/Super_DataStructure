<<<<<<< HEAD
package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> com;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        com = c;
    }

    public T max() {
        if (size() == 0) {
            return null;
        } else {
            int maxi = 0;
            for (int i = 0; i < size(); i++) {
                if (com.compare(get(i), get(maxi)) > 0) {
                    maxi = i;
                }
            }
            return get(maxi);
        }
    }

    public T max(Comparator<T> c) {
        if (size() == 0) {
            return null;
        } else {
            int maxi = 0;
            for (int i = 0; i < size(); i++) {
                if (c.compare(get(i), get(maxi)) > 0) {
                    maxi = i;
                }
            }
            return get(maxi);
        }
    }
}
=======
package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> com;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        com = c;
    }

    public T max() {
        if (size() == 0) {
            return null;
        } else {
            int maxi = 0;
            for (int i = 0; i < size(); i++) {
                if (com.compare(get(i), get(maxi)) > 0) {
                    maxi = i;
                }
            }
            return get(maxi);
        }
    }

    public T max(Comparator<T> c) {
        if (size() == 0) {
            return null;
        } else {
            int maxi = 0;
            for (int i = 0; i < size(); i++) {
                if (c.compare(get(i), get(maxi)) > 0) {
                    maxi = i;
                }
            }
            return get(maxi);
        }
    }
}
>>>>>>> bc93099c96ebffc9ebd67f516fc5e9506a962550
