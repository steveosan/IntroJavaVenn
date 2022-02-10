package edu.wctc;

import java.util.*;

public class VennDiagram<T> {
    private String label1;
    private String label2;
    private String label3;
    private Set<T> carby;
    private Set<T> tomatoey;
    private Set<T> cheesy;


    public VennDiagram(String label1, String label2, String label3){
        this.label1=label1;
        this.label2=label2;
        this.label3=label3;
        carby = new HashSet<>();
        tomatoey =new HashSet<>();
        cheesy = new HashSet<>();
    }

    private Set<T> getCircleForLabel(String label){
        if (label==label1){
            return carby;
        }
        else if (label == label2){
            return tomatoey;
        }
        else{
            return cheesy;
        }
    }

    public void add(T item, String ... labels){

        for(String i: labels){
            if(i==label1) {
                carby.add(item);
            }
            else if (i==label2){
                tomatoey.add(item);
            }
            else{
                cheesy.add(item);
            }


        }

    }


    public Set<T> unionOf(String first, String second) {
        if (first == label1 || first == label2 && second == label2 || second == label1) {
            Set<T> carbyOrTomatoey = new HashSet<>(carby);
            carbyOrTomatoey.addAll(tomatoey);
            return carbyOrTomatoey;
        } else if (first == label1 || first == label3 && second == label3 || second == label1) {
            Set<T> carbyOrCheesy = new HashSet<>(carby);
            carbyOrCheesy.addAll(cheesy);
            return carbyOrCheesy;
        } else {
            Set<T> tomatoeyOrCheesy = new HashSet<>(tomatoey);
            tomatoeyOrCheesy.addAll(cheesy);
            return tomatoeyOrCheesy;
        }
    }


    public Set<T> intersectionOf(String first, String second){
        if (first == label1 || first == label2 && second == label2 || second==label1){
            Set<T> carbyAndTomatoey=new HashSet<>(carby);
            carbyAndTomatoey.retainAll(tomatoey);
            return carbyAndTomatoey;
        }
        else if (first == label1 || first == label3 && second == label3 || second==label1){
            Set<T> carbyAndCheesy=new HashSet<>(carby);
            carbyAndCheesy.retainAll(cheesy);
            return carbyAndCheesy;
        }
        else{
            Set<T> tomatoeyAndCheesy=new HashSet<>(tomatoey);
            tomatoeyAndCheesy.retainAll(cheesy);
            return tomatoeyAndCheesy;
        }
    }

    public Set<T> complementOf(String first, String second){
        if (first == label1 || first == label2 && second == label2 || second == label1) {
            Set<T> carbyButNotTomatoey = new HashSet<>(carby);
            carbyButNotTomatoey.removeAll(tomatoey);
            return carbyButNotTomatoey;
        } else if (first == label1 || first == label3 && second == label3 || second == label1) {
            Set<T> carbyButNotCheesy = new HashSet<>(carby);
            carbyButNotCheesy.removeAll(cheesy);
            return carbyButNotCheesy;
        } else {
            Set<T> tomatoeyButNotCheesy = new HashSet<>(tomatoey);
            tomatoeyButNotCheesy.removeAll(cheesy);
            return tomatoeyButNotCheesy;
        }
    }

    public Set<T> diagramCenter(){
        Set<T> allThree = new HashSet<>(cheesy);
        allThree.retainAll(carby);
        allThree.retainAll(tomatoey);
        return allThree;
    }
}
