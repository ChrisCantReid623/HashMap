/** Author: Christopher Reid
 * CSC 210
 * PA 5: Models a HashMap data structure by based on a Hash Table. */

import java.util.*;

public class MyHashMap<K, V> {
    HashTable<K, V> map;

    /**
     * Constructor
     */
    public MyHashMap() {
        map = new HashTable<>();
    }

    /**
     * Associates the specified value with the specified key in this map.
     */
    public V put(K key, V value) {
        return map.put(key, value);
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     */
    public V remove(K key) {
        return map.remove(key);
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    /**
     * Returns true if this hashmap maps one or more keys to the specified value.
     */
    public boolean containsValue(V value) {
        return map.containsValue(value);
    }

    /**
     * Returns true if this map contains no key-value mappings.
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public V get(K key) {
        return map.getValue(key);
    }

    /**
     * Returns the number of key-value mappings in this map.
     */
    public int size() {
        return map.size();
    }

    /**
     * Removes all the mappings from this map.
     */
    public void clear() {
        map.clear();
    }

    /**
     * Returns a Set view of the keys contained in this map.
     */
    public java.util.Set<K> keySet() {
        return map.keySet();
    }

    /**
     * Outputs how many conflicts occur at each bucket and list the keys in that bucket.
     */
    public void printTable() {
        map.printTable();
    }
}

/** Models a linked list node able to store key, value pairs. */
class Node<K, V> {
    K key;
    V value;
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

/** Models a HashTable. Handles collisions using chaining implemented with a linked list. */
class HashTable<K, V> {
    final static int TABLE_SIZE = 8;
    ArrayList<LinkedList<Node<K, V>>> hashTable = new ArrayList<>(TABLE_SIZE);
    HashSet<K> keySet = new HashSet<>();
    HashSet<V> valueSet = new HashSet<>();

    public HashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTable.add(new LinkedList<>());
        }
    }

    /** Associates the specified value with the specified key in this map. */
    public V put(K key, V value) {
        if (hashTable.get(hash(key)).size() != 0) {
            var list = hashTable.get(hash(key));
            for (Node<K, V> node: list) {
                if (node.key.equals(key)) {
                    var oldValue = node.value;
                    valueSet.remove(oldValue); valueSet.add(value);
                    node.value = value;
                    return oldValue;
                }
            }
        }
        hashTable.get(hash(key)).addFirst(new Node<>(key, value));
        keySet.add(key); valueSet.add(value);
        return null;
    }

    /** Hash function used to generate the index for array storage. */
    private int hash(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % TABLE_SIZE;
        return Math.abs(index);
    }

    /** Removes the mapping for the specified key from this map if present. */
    public V remove(K key) {
        if (hashTable.get(hash(key)).size() != 0) {
            var list = hashTable.get(hash(key));
            for (Node<K, V> node: list) {
                if (key.equals(node.key)) {
                    var oldValue = node.value;
                    list.remove(node);
                    keySet.remove(key); valueSet.remove(oldValue);
                    return oldValue;
                }
            }
        }
        return null;
    }

    /** Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        return keySet.contains(key);
    }

    /** Returns true if this hashmap maps one or more keys to the specified value. */
    public boolean containsValue(V value) {
        return valueSet.contains(value);
    }

    /** Returns true if this map contains no key-value mappings. */
    public boolean isEmpty() {
        return (keySet.isEmpty() && valueSet.isEmpty());
    }

    /** Returns the value to which the specified key is mapped, or null if this map contains no mapping for the
     * key. */
    public V getValue(K key) {
        var list = hashTable.get(hash(key));
        for (Node<K, V> node: list) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    /** Returns the number of key-value mappings in this map. */
    public int size() {
        int total = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            var list = hashTable.get(i);
            total += list.size();
        }
        return total;
    }

    /** Removes all the mappings from this map. */
    public void clear() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            var list = hashTable.get(i);
            list.clear();
        }
        keySet.clear(); valueSet.clear();
    }

    /** Returns a Set view of the keys contained in this map. */
    public Set<K> keySet() {
        return keySet;
    }

    /** Outputs how many conflicts occur at each bucket and list the keys in that bucket. */
    public void printTable() {
        int totalConflicts = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            var list = hashTable.get(i);
            var conflicts = new ArrayList<>();
            for (Node<K, V> node: list) {
                conflicts.add(node.key.toString());
            }
            if (conflicts.size() > 0) {
                conflicts.set(conflicts.size() - 1, conflicts.get(conflicts.size() - 1) + ", ");
            }
            if (conflicts.size() <= 1) {
                System.out.println("Index " +i+ ": (" +0+ " conflicts)," +conflicts);
            } else {
                System.out.println("Index " + i + ": (" + (list.size() - 1) + " conflicts)," + conflicts);
                totalConflicts += (list.size() - 1);
            }
        }
        System.out.println("Total # of conflicts: " + totalConflicts);

    }
}