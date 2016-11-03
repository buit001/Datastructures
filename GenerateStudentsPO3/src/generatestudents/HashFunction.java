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
public class HashFunction<Key, Value> {
    private Key[] keys;
    
    public int hash(Key keyTemp) {
        long hash = 0;
        String key = (String) keyTemp;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash << 5) - hash + key.charAt(i);
        }

        hash = hash % 97;
        return (int) hash;
    }
}
