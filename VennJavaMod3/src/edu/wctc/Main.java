package edu.wctc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Integer> even=new HashSet<>();
        Set<Integer> prime=new HashSet<>();
        Set<Integer> Fibonacci=new HashSet<>();
        for(int i=1; i!=11; i++){
            if(i%2==0){
                even.add(i);
            }
            for (int e = 2; e <= i / 2; ++e) {

                if (i % e == 0) {
                    prime.add(i);
                }
            }
            if(i == 0 || i == 1 || i ==2 || i==3 || i==5 || i==8){
                Fibonacci.add(i);
            }
        }
        Set<Integer> primeOrEven = new HashSet<>(even);
        primeOrEven.addAll(prime);
        System.out.println(primeOrEven);

        Set<Integer> primeAndFibonacci=new HashSet<>(Fibonacci);
        primeAndFibonacci.retainAll(prime);
        System.out.println(primeAndFibonacci);

        Set<Integer> fibbonacciButNotEven = new HashSet<>(Fibonacci);
        fibbonacciButNotEven .removeAll(even);
        System.out.println(fibbonacciButNotEven );

        Set<Integer> allThree = new HashSet<>(Fibonacci);

        allThree.retainAll(even);
        allThree.retainAll(prime);
        System.out.println(allThree);
    }
    public static void Diagram(String[] args){
        String carby = "carby";

        String tomatoey = "tomatoey";
        String cheesy = "cheesy";

        VennDiagram<String> foodDiagram = new VennDiagram<>(carby, tomatoey, cheesy);

        foodDiagram.add("Croissant", carby);
        foodDiagram.add("Roll", carby);
        foodDiagram.add("Toast", carby);
        foodDiagram.add("Grilled Cheese", carby, cheesy);
        foodDiagram.add("Mac and Cheese", carby, cheesy);
        foodDiagram.add("Cheese and Crackers", carby, cheesy);
        foodDiagram.add("Bagel and Cream Cheese", carby, cheesy);
        foodDiagram.add("Spaghetti Marinara", carby, tomatoey);
        foodDiagram.add("Tomato Sandwich", carby, tomatoey);
        foodDiagram.add("Lasagna", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato Soup and Goldfish Crackers", carby, tomatoey, cheesy);
        foodDiagram.add("Pizza Margherita", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato and Mozzarella Sandwich", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato Slices", tomatoey);
        foodDiagram.add("Tomato Wedges", tomatoey);
        foodDiagram.add("Grape Tomatoes", tomatoey);
        foodDiagram.add("Caprese Salad", tomatoey, cheesy);
        foodDiagram.add("Greek Salad", tomatoey, cheesy);
        foodDiagram.add("Mozzarella Sticks", cheesy);
        foodDiagram.add("String Cheese", cheesy);
        foodDiagram.add("Cheese Cubes", cheesy);
        foodDiagram.add("Fresh Mozzarella", cheesy);


        System.out.println(foodDiagram.unionOf(carby, tomatoey));

        System.out.println(foodDiagram.intersectionOf(tomatoey, cheesy));

        System.out.println(foodDiagram.complementOf(cheesy, carby));



        System.out.println(foodDiagram.diagramCenter());}
}