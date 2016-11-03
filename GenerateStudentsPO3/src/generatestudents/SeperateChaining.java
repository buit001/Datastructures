/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatestudents;

/**
 *
 * @author Leon
 * @param <Key>
 * @param <Value>
 */
public class SeperateChaining<Key, Value> {

    private int totalKeys; //Total key Value
    private int tableSize; //Size of linear probing table
    private Node[] array;
    private int collisions = 0;
    private HashFunction hashFunction = new HashFunction();

    public int getCollisions() {
        return collisions;
    }

    public void setCollisions(int collisions) {
        this.collisions = collisions;
    }

    public SeperateChaining(int tableSize) {
        this.tableSize = tableSize;
        Node[] arr = new Node[tableSize];
        array = arr;
        arr = null;
    }

    public void put(Key key, Value val) {
        int hash = hashFunction.hash(key);

        if (array[hash] == null) {
            Node node = new Node(key, val);
            array[hash] = node;
        } else {
            Node node = new Node(key, val);
            node.prev = array[hash];
            array[hash].next = node;
            array[hash] = node;

            collisions++;
        }
        totalKeys++;
    }

    public Value get(Key key) {
        int hash = hashFunction.hash(key);
        Node temp = array[hash];

        if (array[hash].key != key) {
            while (temp.key != key) {
                temp = temp.prev;
            }

            return (Value) temp.val;
        } else {
            return (Value) array[hash].val;
        }
    }
}
