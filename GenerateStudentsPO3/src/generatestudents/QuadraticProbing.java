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
public class QuadraticProbing<Node, Key, Value> {

    private int totalKeys; //Total key Value
    private int tableSize; //Size of linear probing table

    private Key[] keys;
    private Value[] vals;
    private int collisions = 0;
    private HashFunction hashFunction = new HashFunction();

    public QuadraticProbing(int tableSize) {
        this.tableSize = tableSize;
        keys = (Key[]) new Object[tableSize];
        vals = (Value[]) new Object[tableSize];
    }

    public void put(Key key, Value val) {
        int power = 1;
        int i = hashFunction.hash(key);

        if (keys[i] != null) {
            while (keys[i] != null) {
                i = (i + power * power) % tableSize;
                collisions++;
                power++;
            }

            keys[i] = key;
            vals[i] = val;
        } else {

            keys[i] = key;
            vals[i] = val;
        }
        totalKeys++;
    }

    public Value get(Key key) {
        int power = 1;
        int i = hashFunction.hash(key);

        if (keys[i] != key) {
            while (keys[i] != key) {
                i = (i + power * power) % tableSize;
                collisions++;
                power++;
            }

            return vals[i];
        } else {
            return vals[i];
        }
    }

    public void print() {
        for (int i = 0; i < tableSize; i++) {
            System.out.println("Key: " + keys[i] + " Value " + vals[i]);
        }
    }

    public int getCollisions() {
        return collisions;
    }

    public int getTableSize() {
        return tableSize;
    }
}
