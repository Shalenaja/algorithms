package lesson4;

import java.util.TreeSet;

public class Lesson4 {

    public static void main(String[] args) {
        // TreeSet
        // TreeMap

        Tree tree = new Tree();
        System.out.println(tree.add(8));
        System.out.println(tree.add(2));
        System.out.println(tree.add(3));
        System.out.println(tree.add(12));
        System.out.println(tree.add(12));
        System.out.println(tree.add(1));
        System.out.println(tree.add(14));

        System.out.println();

        System.out.println(tree.contains(8)); // true
        System.out.println(tree.contains(1)); // true
        System.out.println(tree.contains(3)); // true
        System.out.println(tree.contains(12)); // true

        System.out.println(tree.contains(4)); // false
        System.out.println(tree.contains(2)); // false
        System.out.println(tree.contains(14)); // false
        System.out.println();


        System.out.println(tree.dfs());
        System.out.println(tree.bfs());
    }
}
