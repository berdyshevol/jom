package com.softserve.sprint03;

import java.util.NoSuchElementException;

class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter;
        private Iterator() {
            counter = 0;
        }
        public boolean hasNext() {
            return this.counter < names.length;
        }
        public String next() {
            if (hasNext()) {
                return names[counter++];
            } else throw new NoSuchElementException();
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        NameList.Iterator iterator = new NameList().getIterator();

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }
}
