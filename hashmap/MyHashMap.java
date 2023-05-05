package hashmap;

import java.io.IOException;
import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    @Override
    public Iterator<K> iterator() {
        return this.keysets.iterator();
    }

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }

    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    // You should probably define some more!
    private double maxload;
    private int size;
    private int length;
    private Set<K> keysets;
    /** Constructors */
    public MyHashMap() {
        length = 16;
        buckets = createTable(length);
        size = 0;
        maxload = 0.75;
        keysets = new HashSet<>();
    }

    public MyHashMap(int initialSize) {
        length = initialSize;
        buckets = createTable(length);
        size = 0;
        maxload = 0.75;
        keysets = new HashSet<>();
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        length = initialSize;
        buckets  = createTable(length);
        size = 0;
        maxload = maxLoad;
        keysets = new HashSet<>();
    }
    public Set<K> keySet(){
        return keysets;
    };

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key, value);
    }

    @Override
    public void clear() {
        size = 0;
        length = 16;
        buckets = createTable(length);
        keysets = new HashSet<>();
    }

    @Override
    public boolean containsKey(K key){
        return get(key) != null;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public V get(K key){
        int indext = Math.floorMod(key.hashCode(),length);
        if (buckets[indext] == null){
            return null;
        }
        Iterator<Node> it = buckets[indext].iterator();
        for (int i = 0; i < buckets[indext].size(); i++) {
            Node now = it.next();
            if (now.key.equals(key)) {
                return now.value;
            }
        }
        return null;
    }
    @Override
    public void put(K key, V value){
        int indext = Math.floorMod(key.hashCode(),length);
        boolean change = true;
        if (buckets[indext] == null){
            buckets[indext] = createBucket();
        }
        Iterator<Node> it = buckets[indext].iterator();
        for (int i = 0; i < buckets[indext].size(); i++) {
            Node now = it.next();
            if (now.key.equals(key)) {
                now.value = value;
                change = false;
            }
        }
        if (change) {
            Node n = createNode(key, value);
            buckets[indext].add(n);
            size++;
            keysets.add(key);
        }
        if ((float)size/(float)length >= maxload) {
            resize();
        }
        keysets.add(key);
    }
    private void resize() {
        Collection<Node>[] newBuckets  = createTable(length*2);
        for (int i = 0; i < length; i++){
            if (buckets[i] != null) {
                Iterator<Node> it = buckets[i].iterator();
                for (int j = 0; j < buckets[i].size(); j++) {
                    Node now = it.next();
                    int index = Math.floorMod(now.key.hashCode(), length*2);
                    if (newBuckets[index] == null) {
                        newBuckets[index] = createBucket();
                    }
                    newBuckets[index].add(now);
                }
            }
        }
        length = length*2;
        buckets = newBuckets;
    }
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }
    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new ArrayList<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        return new Collection[tableSize];
    }


    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!

}
