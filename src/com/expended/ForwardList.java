package com.expended;

public class ForwardList {
    private class Node {  // элемент списка
        Node next;
        int data;
    }

    private Node head;    // указатели на первый и последний элементы списка
    private Node tail;


    // добавление элемента в начало списка
    public void addToHead(int value) {
        Node element = new Node();
        element.data = value;

        if (head == null) {
            head = element;
            tail = element;
        }
        else {
            element.next = head;
            head = element;
        }
    }

    // добавление элемента в конец списка
    public void addToEnd(int value) {
        Node element = new Node();
        element.data = value;

        if (tail == null) {
            head = element;
            tail = element;
        }
        else {
            tail.next = element;
            tail = element;
        }
    }

    // добавление элемента в середину списка
    public void add(int value, int index) {
        int position = 0;
        Node current = head;
        while ((current != tail) && (current.next != null) && (position != index)) {
            current = current.next;
            position++;
        }

        if (index != position) {
            throw new IndexOutOfBoundsException("Index out of range\n");
        }

        Node element = new Node();
        element.data = value;

        if (current == null) {
            head = element;
            tail = element;
        }
        else if (current == tail) {
            tail.next = element;
            tail = tail.next;
        }
        else {
            element.next = current.next;
            current.next = element;
        }
    }

    // возврат первого элемента списка
    public int getHead() {
        Node digital = head;
        return digital.data;
    }

    // возврат последнего элемента списка
    public int getBack() {
        Node digital = tail;
        return digital.data;
    }

    // удаление элемента в списке
    public void remove(int value) {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node element = head;
        while (element.next != null) {
            if (element.next.data == value) {
                if (tail == element.next) {
                    tail = element;
                }
                element.next = element.next.next;
                return;
            }
            element = element.next;
        }
    }

    // очистка списка
    public void clear() {
        Node element = head;
        while (element != null) {
            head = head.next;
        }
    }

    // возврат значения по индексу
    public int get(int index) {
        int position = 0;
        Node current = head;
        while ((current != tail) && (current.next != null) && (position != index)) {
            current = current.next;
            position++;
        }

        if (index != position) {
            throw new IndexOutOfBoundsException("Index out of range\n");
        }

        return current.data;
    }

    // вывод списка на экран
    public void output() {
        Node element = head;
        while (element != null) {
            System.out.print(element.data + " ");
            element = element.next;
        }
        System.out.print("\n");
    }
}
