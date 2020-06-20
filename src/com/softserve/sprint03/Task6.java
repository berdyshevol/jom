package com.softserve.sprint03;

import java.util.Arrays;
import java.util.*;
import java.util.stream.IntStream;

enum SortOrder {
    ASC (1),
    DESC (-1);
    private int order;
    SortOrder(int order) {
        this.order = order;
    }
    public int getOrder() {
        return this.order;
    }
}

class AddressBook implements Iterable {
    private NameAddressPair[] addressBook;
    private int counter;

    public AddressBook(int capacity) {
        this.addressBook = new NameAddressPair[capacity];
        this.counter = 0;
    }

    public boolean create(String firstName, String lastName, String address) {
        NameAddressPair.Person newPerson = new NameAddressPair.Person(firstName, lastName);
        if (include(newPerson)) {
            return false;
        } else {
            if (this.counter == this.addressBook.length) {
                enlargeAddressBook();
            }
            add(newPerson, address);
            return true;
        }
    }

    private boolean include(NameAddressPair.Person newPerson) {
        return Arrays.stream(this.addressBook).anyMatch(pair -> pair != null && pair.person.equals(newPerson));
    }

    private void enlargeAddressBook() {
        NameAddressPair[] newAddressBook = Arrays.copyOf(this.addressBook, this.addressBook.length * 2);
        this.addressBook = newAddressBook;
    }

    private void add(NameAddressPair.Person person, String address) {
        this.addressBook[this.counter] = new NameAddressPair(person, address);
        this.counter++;
    }

    public String read (String firstName, String lastName) {
        int i = findIndexOf(new NameAddressPair.Person(firstName, lastName));
        return (i == -1) ? null : this.addressBook[i].getAddress();
    }

    public boolean update(String firstName, String lastName, String address) {
        NameAddressPair.Person newPerson = new NameAddressPair.Person(firstName, lastName);
        int index = findIndexOf(newPerson);
        if (index == -1) {
            return false;
        }
        this.addressBook[index] = new NameAddressPair(newPerson, address);
        return true;
    }

    public int findIndexOf(NameAddressPair.Person newPerson) {
        return IntStream.range(0, this.counter).filter(i ->
                  newPerson.equals(this.addressBook[i].getPerson())
               ).findFirst().orElse(-1);
    }

    public boolean delete(String firstName, String lastName) {
        NameAddressPair.Person newPerson = new NameAddressPair.Person(firstName, lastName);
        int i = findIndexOf(newPerson);
        if ( i == -1) {
            return false;
        }
        for (int j = i; j < this.counter - 1; j++) {
            this.addressBook[j] = this.addressBook[j + 1];
        }
        this.counter--;
        return true;
    }

    public int size() {
        return this.counter;
    }

    public void sortedBy(SortOrder order) {
        Arrays.sort(this.addressBook, new Comparator<NameAddressPair>() {
            public int compare(NameAddressPair p1, NameAddressPair p2) {
                int compareNames = order.getOrder() * p1.person.firstName.compareTo(p2.person.firstName);
                return compareNames != 0
                        ? compareNames
                        : order.getOrder() * p1.person.lastName.compareTo(p2.person.lastName);
            }
        });
    }

    public Iterator<String> iterator() {
        return new AddressBookIterator();
    }

    private class AddressBookIterator implements Iterator<String> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter < AddressBook.this.counter;
        }

        @Override
        public String next() {
            if (hasNext()) {
                return String
                        .format(
                                "First name: %s, Last name: %s, Address: %s",
                                addressBook[this.counter].getPerson().getFirstName(),
                                addressBook[this.counter].getPerson().getLastName(),
                                addressBook[this.counter++].getAddress()
                        );
            } else throw new NoSuchElementException();
        }
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }
        public Person getPerson() {
            return person;
        }
        public String getAddress() {
            return address;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            return person.equals(o);
        }

        @Override
        public int hashCode() {
            return person.hashCode();
        }

        private static class Person {
            private String firstName;
            private String lastName;
            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }
            public String getFirstName() {
                return this.firstName;
            }
            public String getLastName() {
                return this.lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null) return false;
                Person person = (Person) o;
                if (!firstName.equals(person.firstName)) return false;
                return lastName.equals(person.lastName);
            }

            @Override
            public int hashCode() {
                int result = firstName.hashCode();
                result = 31 * result + lastName.hashCode();
                return result;
            }
        }
    }
}

public class Task6 {
    public static void main(String[] args) {
        String[] actual = new String[4];
         AddressBook addressBook = new AddressBook(4);
         addressBook.create("John", "Brown", "Address #1");
         addressBook.create("Susan", "Brown", "Address # 4");
         addressBook.create("Karen", "Davis", "Address #2");
         addressBook.create("John", "Taylor", "Address #1");
         addressBook.sortedBy(SortOrder.DESC);
         addressBook.forEach(System.out::println);
    }
}
