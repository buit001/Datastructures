/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generatestudents;

/**
 *
 * @author Tim
 */
public class Node<Key, Value>
{
        public Key key;
        public Value val;
        public Node next;
        public Node prev;
        
        public Node(Key key, Value val)
        {
            this.key = key;
            this.val = val;
        }
}
