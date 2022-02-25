package com.expended;

public class Main {

    public static void main(String[] args) {
        // динамический массив:
        System.out.println("--------Динамический массив--------");

        DynamicArray da = new DynamicArray(10);
        DynamicArray f_da = new DynamicArray();
        System.out.println("Размер массива с размером: " + da.getSize() + " и без рамера: " + f_da.getSize());
        System.out.println("Capacity массива с размером: " + da.getCapacity() + " и без рамера: " + f_da.getCapacity());

        for (int i = 0; i < 10; i++) {
            da.setValue(i,i);
        }
        da.output();

        da.add(111,4);
        da.output();

        da.add(5555, 11);
        da.output();

        da.reserve(13);
        da.add(6666,12);
        da.output();

        da.removeFromEnd();
        da.output();

        da.resize(19);
        da.output();

        System.out.println(da.get(4));
        da.remove(6);
        da.output();

        // односвязный список:
        System.out.println("--------Односвязный список--------");
        ForwardList fl = new ForwardList();

        for (int i = 0; i < 10; i++) {
            fl.addToEnd(i);
        }
        fl.output();

        System.out.println("Начало = " + fl.getHead() + ", и конец = " + fl.getBack());

        fl.addToHead(1111);
        fl.addToEnd(6666);
        fl.output();

        fl.add(5555, 5);
        fl.output();

        for (int i = 0; i < 10; i++) {
            fl.remove(i);
        }
        fl.output();

        System.out.println("Значение по индексу 1: " + fl.get(1));
    }

}
