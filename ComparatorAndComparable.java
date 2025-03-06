
// Java's sorting algorithm (TimSort, based on Merge Sort and Insertion Sort) relies on the compareTo method:

// During sorting, two elements are repeatedly compared using compareTo.

// Based on the return value of compareTo, the algorithm decides:

// Negative: Keep the order as-is.
// Positive: Swap the positions of the two elements.
import java.util.*;
class ComparatorAndComparable {
    public static void main(String[] args) {
        // **************************************************************
        // sort a string on the basis of length using comparator
        
        String arr[]= {"Adarsh","joey","Battie","Money"};
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return a.length() - b.length();
            }
        });
        
        for(String m :arr) System.out.println(m);
        
        // **************************************************************

        // Use Comparable to sort person class on basis of their age
        List<Person> list = new ArrayList<>();
        list.add(new Person("A",12));
        list.add(new Person("B",22));
        list.add(new Person("C",62));
        list.add(new Person("D",24));
        
        Collections.sort(list);
        
        list.forEach(x -> System.out.println(x.name + " " + x.age));
    }
    static class Person implements Comparable<Person>{
        String name;
        int age;
        Person(String name,int age){
            this.name = name;
            this.age = age;
        }
        
        @Override
        public int compareTo(Person p1){
            return this.age - p1.age;
        }
    }
}