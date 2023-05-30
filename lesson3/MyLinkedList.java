package lesson3;

import java.util.ArrayList;


public class MyLinkedList<T> {                      // произведена замена на дженерик T, (задание 4)

    private Node head;

    /**
     * Реализоват в классе MyLinkedList следующие методы
     * 1. public int size() - получение размера списка, проитерировався по всей структуре
     * 1.1 * Можно завести переменную size, поддерживать ее и использовать ее.
     * 2. public boolean contains(int value) - проверка наличия элемента по значению
     * 3. public int popLast() - удаление последнего элемента. Если список пустой - то ошибка
     * 4. * Переделать все int значения на дженерик T, чтобы можно было хранить значения любых типов
     * 5. * public MyLinkedList reversed() - создать НОВЫЙ список, порядок в котором обратный текущему
     */

    private class Node {
        T value;
        Node next;
        
        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(T value) {
        Node last = findLast();
        if (last == null) {
            head = new Node(value);
        } else {
            last.next = new Node(value);
        }
    }

    public T getFirst() {
        return get(0);
    }

    public T get(int index) {
        if (head == null) {
            throw new IllegalStateException("Список пустой");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        Node cursor = head;
        int indexCursor = 0;
        while (cursor != null) {
            if (indexCursor == index) {
                return cursor.value;
            }

            cursor = cursor.next;
            indexCursor++;
        }

        throw new IndexOutOfBoundsException(index);
    }

    public T popFirst() {
        return pop(0);
    }

    public T pop(int index) {
        if (head == null) {
            throw new IllegalStateException("Список пустой");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            T pop = head.value;
            head = head.next;
            return pop;
        }

        Node cursor = head;
        int indexCursor = 1;
        while (cursor.next != null) {
            if (indexCursor == index) {
                T pop = cursor.next.value;
                cursor.next = cursor.next.next;
                return pop;
            }

            cursor = cursor.next;
            indexCursor++;
        }

        throw new IndexOutOfBoundsException(index);
    }

    private Node findLast() {
        if (head == null) {
            return null;
        }

        Node cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        return cursor;
    }

    @Override
    public String toString() {
        // [1 -> 2 -> 3 -> 4 -> 5 -> ]
        StringBuilder result = new StringBuilder("[");
        Node cursor = head;
        while (cursor != null) {
            result.append(cursor.value).append(" -> ");
            cursor = cursor.next;
        }

        int length = result.length();
        if (length > 4) {
            result.delete(length - 4, length);
        }

        result.append("]");
        return result.toString();
    }
 

    public int size() {                                 // добавлен метод (задание 1)
        if (head == null) {
            throw new IllegalStateException("Список пустой");
    }
        Node cursor = head;
        int indexCursor = 0;
        while (cursor.next != null) {
            cursor = cursor.next;
            indexCursor++;
        }
        return indexCursor+1;       
    }

    public boolean contains(T value) {                 // добавлен метод (задание 2)
        Node cursor = head;
        while (cursor != null) {
            if (cursor.value.equals(value)) {      
                return true;
            }
            cursor = cursor.next;
        }
        return false;       
    }

    public T popLast() {                                 // добавлен метод (задание 3)         
        if (head == null) {
                throw new IllegalStateException("Список пустой");
        }       
        Node cursor = head;
        int indexCursor = 0;
        while (cursor.next != null) {
            cursor = cursor.next;
            indexCursor++;
        }
        return pop(indexCursor);        
    }

    public MyLinkedList<T> reversed() {                   // добавлен метод (задание 5) 
        MyLinkedList array = new MyLinkedList();
        int size = size();
        ArrayList arrays = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrays.add(0);
        }
      
        Node cursor = head;
        int index = size -1; 
        while (cursor != null) {
            arrays.set(index, cursor.value);
            index--;          
            cursor = cursor.next;
        }

        int arrayIndex = 0;
        for (int i = 0; i < size; i++) {
            array.add(arrays.get(arrayIndex));
            arrayIndex++;
        }
        return array;
    }

}

