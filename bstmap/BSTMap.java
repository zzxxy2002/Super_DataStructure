package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V> {
    private  int size;
    private Node structure;

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K current_key,V current_value) {
            this.key = current_key;
            this.value = current_value;
        }
    }
    public BSTMap() {
        size = 0;
    }

    @Override
    public void clear() {
        structure = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return contain(structure,(K) key);
    }
    private boolean contain(Node x, K key) {
        if (x == null) return false;
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            return contain(x.left, key);
        }
        else if (compare > 0) {
            return contain(x.right, key);
        }
        else {
            return true;
        }
    }
    @Override
    public V get(K key) {
        return get(structure, (K) key);
    }

    private V get(Node x, K key) {
        if (x == null) return null;
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            return get(x.left, key);
        }
        else if (compare > 0) {
            return get(x.right, key);
        }
        else {
            return x.value;
        }
    }


    @Override
    public int size() {
        if (structure == null) {
            return 0;
        }
        return size;
    }

    @Override
    public void put(K key, V value) {
        structure = put(structure, key, value);
        size++;
    }




    private Node put(Node x, K key, V val) {
        if (x == null){
            Node n = new Node(key,val);
            x = n;
            return x;
        }
        int cmp = key.compareTo(x.key);
        if    (cmp < 0) {
            if (x.left != null) {
                put(x.left, key, val);
            }
            else {
                Node n = new Node(key,val);
                x.left = n;
                return n;
            }
        }
        else if (cmp > 0) {
            if (x.right != null) {
                put(x.right, key, val);
            }
            else {
                Node n = new Node(key,val);
                x.right = n;
                return n;
            }
        }
        else {
            x.value = val;
        }
        return x;
    }


    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public void printInOrder(){
        print(structure);
    }
    private void print(Node node){
        if (node != null) {
            System.out.println(node.key);
            System.out.println(node.key);
            print(node.left);
            print(node.right);
        }
    }

    @Override
    public Iterator<K> iterator(){
        throw new UnsupportedOperationException();
    }
}

