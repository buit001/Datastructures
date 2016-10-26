/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresopdracht2;

import java.util.Arrays;
import java.util.LinkedList;
import nl.hva.dmci.ict.inf.ads.lib.StdOut;
import nl.hva.dmci.ict.inf.ads.lib.StdRandom;
import nl.hva.dmci.ict.inf.ads.lib.Stopwatch;

/**
 *
 * @author Leon
 */
public class DatastructuresOpdracht2 {
    public static final int AANTALLEERLINGEN = 50;
    public static final int MAXKLASGROOTTE = 32;
    public static int LEERLINGNUMMER = 50060001;
    public static final String[] RICHTING = {"B", "G", "N", "S", "T"};
    //public static final double MAX_CLASSES_PREFIX = Math.ceil((double) AANTALLEERLINGEN / (double) / MAXKLASGROOTTE / (double) RICHTING.length);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int aantalKlassen = (int) Math.ceil((double) AANTALLEERLINGEN / MAXKLASGROOTTE / RICHTING.length) 
                * RICHTING.length;
        Student[] studenten = new Student[AANTALLEERLINGEN];
        String[] klassen = new String[aantalKlassen];  

        Stopwatch stopwatch = new Stopwatch();
        double t0;
        double t1;
        double lapTime;
        
        Student std = new Student();

        for(int i = 0; i < aantalKlassen; i++) {
             String klasNaam = "I" + RICHTING[i % RICHTING.length] + "2" + 
                     ((i / RICHTING.length) < 10 ? "000" : "") + (i / RICHTING.length + 1);
             klassen[i] = klasNaam;
        }
        
        
        
        for(int i = 0; i < studenten.length; i++){
            double cijfer = (double)(9*Math.random()) + 1;
            double finalValue = Math.round( cijfer * 10.0 ) / 10.0;
            Student student = new Student(LEERLINGNUMMER += 1, klassen[i % klassen.length], finalValue);
            studenten[i] = student;
        }
      
        
        StdRandom.shuffle(studenten);      
        
        t0 = stopwatch.elapsedTime();
        
        //std.insertionSort(studenten);
        
//        for(Student s: studenten) {
//            System.out.println(s);
//        }
        LinkedList studentList = new LinkedList(Arrays.asList(studenten));
        
        LinkedList studentListBucketSort = std.bucketSort(studentList);
        
        for(int i = 0; i < studentListBucketSort.size(); i++) {
            System.out.println(studentListBucketSort.get(i).toString());
        } 
        
        
        
//        for(int i = 0; i < studenten.length; i++) {
//            if(studenten[i].getCijfer() == 1.2){
//                System.out.println(studenten[i].getCijfer() + " " + i);
//            }
//        }
        
//        int counter = 0;
//        for(double i = 1.0; i < 10.0; i += 0.1) {
//            double j = Math.round(i * 10.0 ) / 10.0;
//            for(int k = 0; k < studenten.length; k++) {
//                if(studenten[k].getCijfer() == j) {
//                    counter++;
//                }             
//            }
//            System.out.println(j + " : " + counter);
//            counter = 0;
//        }
        
        t1 = stopwatch.elapsedTime();
        lapTime = (1000*t1-1000*t0)/1000;
        StdOut.println(" (" + lapTime + "\t " + t1 +")");
   
    }
    
//    public static void createClasses() {
//        for(int i = 0; i < 5; i++) {
//            for(int j = 1; j <= (aantalKlassen); j++) {
//                
//            }
//        }
//    }

}
