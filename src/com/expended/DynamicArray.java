package com.expended;

public class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;

    // tmpArray[] - временный массив для вставки/удаления значений

    // создание массива без ввода размера и добавление 10 доп. ячеек памяти
    public DynamicArray() {
        this.size = 0;
        this.capacity = 10;
        this.array = new int[this.capacity];
    }

    // создание массива с вводом размера и прибавление доп. места в размере 10 ячеек памяти
    public DynamicArray(int size) {
        this.capacity = size + 10;
        this.size = size;
        this.array = new int[this.capacity];
    }

    public final int getSize() {
        return this.size;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    // добавить данные в массив по индексу
    public void add(int value, int index) {
        if (index == this.size) {
            this.addToEnd(value);
        }
        else if ((index > this.size) || (index < 0)) {
            throw new ArrayIndexOutOfBoundsException("Index out of range\n");
        }
        else {
            if (this.size + 1 > this.capacity) {
                this.capacity = Math.round((capacity * 3) / 2 + 1);
                int[] tmpArray = new int[this.capacity];
                System.arraycopy(array, index, tmpArray, index + 1, this.capacity);
                (this.size)++;
                tmpArray[index] = value;
                this.array = tmpArray;
            }
            else {
                System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
                this.array[index] = value;
                (this.size)++;
            }
        }
    }

    // удалить данные с определенной позиции
    public void remove(int index) {
        if ((index >= 0) & (index < this.size)) {
            System.arraycopy(array, index + 1, array, index, this.size - index - 1);
            (this.size)--;
        }
    }

    // выдать данные с определенной ячейки
    public int get(int index) {
        if ((index < 0) || (index >= this.size)) {
            throw new ArrayIndexOutOfBoundsException("Index out of range\n");
        }

        return array[index];
    }

    // очистить данные
    public void clear() {
        this.size = this.capacity = 0;
    }

    // изменить размер массива
    public void resize(int n) {
        if (n < 0) {
            throw new ArrayIndexOutOfBoundsException("Size out of allowed range\n");
        }
        else if (n > this.capacity) {
            int[] tmpArray = new int[n];
            System.arraycopy(array, 0, tmpArray, 0, this.size);
            this.capacity = this.size = n;
            this.array = tmpArray;
        }
        else if (n >= this.size) {
            this.size = n;
        }
        else {
            int[] tmpArray = new int[n];
            System.arraycopy(array, 0, tmpArray, 0, n);
            this.capacity = this.size = n;
            this.array = tmpArray;
        }
    }

    // изменить capacity для массива
    public void reserve(int n) {
        if (n < 0) {
            throw new ArrayIndexOutOfBoundsException("Capacity out of allowed range\n");
        }
        else if (n > this.capacity) {
            int[] tmpArray = new int[n];
            System.arraycopy(array, 0, tmpArray, 0, this.capacity);
            this.capacity = n;
            this.array = tmpArray;
        }
        else if (n >= this.size) {
            int[] tmpArray = new int[n];
            System.arraycopy(array, 0, tmpArray,0, n);
            this.capacity = n;
            this.array = tmpArray;
        }
        else {
            int[] tmpArray = new int[n];
            System.arraycopy(array, 0, tmpArray, 0, n);
            this.size = this.capacity = n;
            this.array = tmpArray;
        }
    }

    // добавить данные в конец массива
    public void addToEnd(int value) {
        if (this.size + 1 > this.capacity) {
            this.capacity = Math.round((capacity * 3) / 2 + 1);
            int[] tmpArray = new int[this.capacity];
            System.arraycopy(array, 0, tmpArray, 0, this.capacity);
            this.array = tmpArray;
        }
        array[this.size] = value;
        (this.size)++;
    }

    // удалить данные в конце массива
    public void removeFromEnd() {
        array[this.size - 1] = 0;
        (this.size)--;
    }

    // установить значение в определенной ячейке массива
    public void setValue(int index, int value) {
        array[index] = value;
    }

    // вывод массива в консоль
    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }
}
