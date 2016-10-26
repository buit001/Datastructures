/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresopdracht2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Leon
 * @param <Student>
 */
public class ResultList <Student> extends ArrayList<Student> {
    public void sortCijfer(Student value) {
        add(value);
        Comparable<Student> cmp = (Comparable<Student>) value;
        for (int i = size()-1; i > 0 && cmp.compareTo(get(i-1)) < 0; i--)
            Collections.swap(this, i, i-1);
    }
}
