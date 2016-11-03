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
public class LinearProbing<Key, Value> {

    private int n; //Total key Value
    private int sizeTable; //Size of linear probing table

    private Key[] keys;
    private Value[] value;
    private int collisions = 0;
    private HashFunction hashFunction = new HashFunction();

    public LinearProbing(int sizeTable) {
        this.sizeTable = sizeTable;
        keys = (Key[]) new Object[sizeTable];
        value = (Value[]) new Object[sizeTable];
    }

    public void put(Key key, Value val) {
        int hash = hashFunction.hash(key);

        if (keys[hash] != null) {
            while (keys[hash] != null) {
                collisions++;
                hash++;
                if (hash == keys.length) {
                    hash = 0;
                }
            }
        }
        keys[hash] = key;
        value[hash] = val;
        n++;
    }

    public Value get(Key key) {
        int i = hashFunction.hash(key);

        if (keys[i] != key) {
            while (keys[i] != key) {
                i++;
                if (i == keys.length) {
                    i = 0;
                }

            }
            return value[i];
        } else {
            return value[i];
        }
    }

    public void print() {
        for (int i = 0; i < sizeTable; i++) {
            System.out.println("Key: " + keys[i] + " Value " + value[i]);
        }
    }

    public int getCollisions() {
        return collisions;
    }

    public int getTableSize() {
        return sizeTable;
    }
}
