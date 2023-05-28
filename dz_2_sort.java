/**
 * Реализовать сортировку подсчетом
 * [1 2 3 3 2 3 4 2 1 1 2 3 4 4 2 3 1 4 2 3 4 2 1 2 3 4 2 1 3 4 2 1 2 3 4 4 2 3 3 2 4]
 * Подсчитываем, сколько раз встречается конкретный элемент
 * 1 -> 5 (количество единиц в массиве: число взято с потолка!)
 * 2 -> 7 (количество двоек в массиве)
 * 3 -> 3
 * 4 -> 4
 *        * Вставляем единицу 5 раз
 * Вставляем двойку 7 раз
 * Вставялем тройку 3 раза
 * Вставляем четверку 4 раза
 * */

import java.util.Arrays;

public class dz_2_sort {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 3, 2, 3, 4, 2, 1, 1, 2, 3, 4, 4, 2, 3, 1, 4, 2, 3, 4, 2, 1, 2, 3, 4, 2, 1, 3, 4, 2, 1, 2, 3, 4, 4, 2, 3, 3, 2, 4 };
        countingSort(array);
        System.out.println(Arrays.toString(array));
    }
 
    public static void countingSort( int[] arr) {
        int min = 0, max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;
        int[] count = new int[range];
  
        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;
  
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
 
        int j = 0;
        for (int i = 0; i < range; i++)        
            while (j < count[i])
                arr[j++] = i; 
    } 
}