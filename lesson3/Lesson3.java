package lesson3;

import java.util.LinkedList;

public class Lesson3 {

    public static void main(String[] args) {
       
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
       
        System.out.println(myLinkedList); // [1 -> 2 -> 3]

        System.out.println(myLinkedList.size());                     // задание 1
        System.out.println(myLinkedList.contains(2));         //задание 2
        System.out.println(myLinkedList.contains(5));         //задание 2
        MyLinkedList reversed = myLinkedList.reversed();             //задание 5
        System.out.println(reversed); // [3 -> 2 -> 1]               //задание 5
        System.out.println(myLinkedList.popLast());           // задание 3
    }
}

