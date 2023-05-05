package deque;

import jh61b.junit.In;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayDequeTest {


    @Test
    public void TestFirst(){
        ArrayDeque<Integer> ard1 = new ArrayDeque<>();
        ard1.addFirst(8);
        ard1.addFirst(3);
        Integer a = ard1.get(0);
        Integer b = ard1.get(1);
        int s = ard1.size();
        Integer c = ard1.removeFirst();
        Integer d = ard1.get(0);
        ard1.removeFirst();
        int j = ard1.size();
        boolean r = ard1.isEmpty();
        assertEquals(3, a.intValue());
        assertEquals(8,b.intValue());
        assertEquals(3,c.intValue());
        assertEquals(8,d.intValue());
        assertEquals(2,s);
        assertEquals(0,j);
        assertEquals(true, r);
    }

    @Test
    public void TestLast(){
        ArrayDeque<Integer> ard2 = new ArrayDeque<>();
        ard2.addLast(8);
        ard2.addLast(3);
        Integer a = ard2.get(0);
        Integer b = ard2.get(1);
        int s = ard2.size();
        boolean r = ard2.isEmpty();
        Integer c = ard2.removeLast();
        Integer d = ard2.get(0);
        ard2.removeLast();
        int j = ard2.size();
        assertEquals(8, a.intValue());
        assertEquals(3,b.intValue());
        assertEquals(3,c.intValue());
        assertEquals(8,d.intValue());
        assertEquals(2,s);
        assertEquals(0,j);
        assertEquals(false, r);
    }

    @Test
    public void test(){
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 50; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 99; i > 50; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    public void test2() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addFirst(0);
        ArrayDeque.addLast(1);
        ArrayDeque.addLast(2);
        ArrayDeque.addLast(3);
        int x = ArrayDeque.get(0);
        ArrayDeque.addLast(5);
        ArrayDeque.addFirst(6);
        ArrayDeque.addFirst(7);
        ArrayDeque.addFirst(8);
        ArrayDeque.addFirst(9);
        ArrayDeque.removeFirst();

    }

    @Test
    public void equation(){
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addFirst(0);
        ArrayDeque.addLast(1);
        ArrayDeque.addLast(2);
        ArrayDeque.addLast(3);
        int x = ArrayDeque.get(0);
        ArrayDeque.addLast(5);
        ArrayDeque.addFirst(6);
        ArrayDeque.addFirst(7);
        ArrayDeque.addFirst(8);
        ArrayDeque.addFirst(9);
        ArrayDeque.removeFirst();
        LinkedListDeque<Integer> Al = new LinkedListDeque<>();
        Al.addFirst(0);
        Al.addLast(1);
        Al.addLast(2);
        Al.addLast(3);

        Al.addLast(5);
        Al.addFirst(6);
        Al.addFirst(7);
        Al.addFirst(8);
        Al.addFirst(9);
        Al.removeFirst();
        assertTrue(ArrayDeque.equals(Al));
        assertTrue(Al.equals(ArrayDeque));
    }

}
