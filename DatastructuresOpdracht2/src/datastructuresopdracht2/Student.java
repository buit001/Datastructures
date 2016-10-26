/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresopdracht2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Leon
 */
public class Student {
    private int studentnummer;
    private String klas;
    private double cijfer;
    
    LinkedList<Student> Klas = new LinkedList<>();
   
    
    
    public Student(int studentnummer, String klas, double cijfer) {
        this.studentnummer = studentnummer;
        this.cijfer = cijfer;
        this.klas = klas;
    }
    
    public Student() {
        
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    public String getKlas() {
        return klas;
    }

    public void setKlas(String klas) {
        this.klas = klas;
    }

    public double getCijfer() {
        return cijfer;
    }

    public void setCijfer(double cijfer) {
        this.cijfer = cijfer;
    }
   
    public void insertionSort(Student[] studenten) {
        for (int i = 0; i < studenten.length; i++) {
            for(int j = 0; j < studenten.length - 1; j++) {
                
                if(studenten[i].getCijfer() > studenten[j + 1].getCijfer())
                {
                       Student student = studenten[j + 1];
                       studenten[j + 1] = studenten[i];
                       studenten[i] = student;
                }
                
            }
        }
    }
    
    /*
    De methode dd krijgt een arraylist mee. dan loopt de methode door deze arraylist heen
    en dan loopt die per element in de arraylist nog een keer door de arraylist. Dan maak je twee tijdelijke variable aan
    om te kunnen vergelijken welk getal er eerst komt. dat doe je met getal1 > getal2
    dan maak je een tijdelijke student aan zodat je de oude student voor de nieuwe kunt verwisellen en de nieuwe op de oude plek
    kan zetten in de array. De methode moet daarna nog binnen in de klas zelf sorteren op studentnummer
    
    */
    
    public void bucketSortArray(List<Student> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - 1; j++) {

                int klasNummer1 = Integer.parseInt(array.get(j).getKlas().substring(getKlas().length()-1, getKlas().length()));
                int klasNummer2 = Integer.parseInt(array.get(j + 1).getKlas().substring(getKlas().length()-1, getKlas().length()));

                if (klasNummer1 > klasNummer2) {
                    Student student = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, student);
                } else if (klasNummer1 == klasNummer2) {
                    Student student = array.get(j);
                    if (array.get(j).getStudentnummer() > array.get(j + 1).getStudentnummer()) {
                        array.set(j, array.get(j + 1));
                        array.set(j + 1, student);
                    }
                }
            }
        }
    }
    
    public void bucketSort2(LinkedList<Student> studenten) {
         
         LinkedList linked = bucketSort(studenten);            
        
        
     
        
        for(int i = 0; i < linked.size(); i++) {
            System.out.println(linked.get(i).toString());
        } 
    }
    
//    public void studentNummerSort(Student[] num) {
//        int j;
//        boolean flag = true;
//        Student temp;
//        
//        while(flag) {
//            flag = false;
//            for(j = 0; j < num.length - 1; j++) {
//                if
//            }
//        }
//    }
    
    public LinkedList bucketSort(LinkedList<Student> studenten) {
        Student temp;

        for (int i = 0; i < studenten.size(); i++) {
            for (int j = 1; j < (studenten.size() - i); j++) {
                //sorteer klas op klascode
                if (studenten.get(j - 1).getKlas().compareTo(studenten.get(j).getKlas()) > 0) {
                    temp = studenten.get(j - 1);
                    studenten.set(j - 1, studenten.get(j));
                    studenten.set(j, temp);
                    //binnen in een klas sorteren op studentnummer
                } else if (studenten.get(j - 1).getKlas().equals(studenten.get(j).getKlas())) {
                    Student student = studenten.get(j);
                    if (studenten.get(j - 1).getStudentnummer() > studenten.get(j).getStudentnummer()) {
                        studenten.set(j, studenten.get(j - 1));
                        studenten.set(j - 1, student);
                    }
                }
            }
        }
        return studenten;
    }
    
    @Override
    public String toString() {
        return studentnummer + "," + klas + "," + cijfer;
    }
}
