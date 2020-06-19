package com.softserve.sprint03;

import java.util.Arrays;
import java.util.*;

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

class AddressBook {
    private NameAddressPair[] addressBook;
    private int counter;

    public AddressBook(int capacity) {
        this.addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName) {
        return true; // TODO:
    }

    public String read (String firstName, String lastName) {
        return null; // TODO:
    }

    public boolean update(String firstName, String lastName, String address) {
        return true; // TODO:
    }

    public boolean delete(String firstName, String lastName) {
        return true; // TODO:
    }

    public int size() {
        return this.addressBook.length;
    }

    public void sortBy(SortOrder person) {
        // TODO:
    }

    public AddressBookIterator iterator() {
        return new AddressBookIterator();
    }

    public class AddressBookIterator implements Iterator {
        private int counter;

        public AddressBookIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter < addressBook.length;
        }

        @Override
        public String next() {
            if (hasNext()) {
                this.counter++;
                return String
                        .format(
                                "First name: %s, Last name: %s, Address: %s",
                                addressBook[this.counter].getPerson().getFirstName(),
                                addressBook[this.counter].getPerson().getLastName(),
                                addressBook[this.counter].getAddress()
                        );
            } else throw new NoSuchElementException();
        }
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        public NameAddressPair(Person person, String address) {
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
            if (this == o) return true;
            if (!(o instanceof NameAddressPair)) return false;
            NameAddressPair that = (NameAddressPair) o;
            return person.equals(that.person);
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
                if (!(o instanceof Person)) return false;
                Person person = (Person) o;
                if (!Objects.equals(firstName, person.firstName)) return false;
                return Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode() {
                int result = firstName != null ? firstName.hashCode() : 0;
                result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
                return result;
            }
        }
    }
}

public class Task6 {
}
