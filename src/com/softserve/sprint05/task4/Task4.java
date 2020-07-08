package com.softserve.sprint05.task4;

class Person {
    private String firstName;
    private String lastName;
    private String idCode;

    public void setFirstName(String firstName) throws NameException {
        if (validName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new NameException("Incorrect value " +
                    firstName +
                    " for firstName (should start from upper case and contains only alphabetic characters and -, space symbol;)");
        }
    }

    public void setLastName(String lastName) throws NameException {
        if (validName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new NameException("Incorrect value " +
                    lastName +
                    " for lastName (should start from upper case and contains only alphabetic characters and -, space symbol;)");
        }
    }

    public void setIdCode(String idCode) throws CodeException {
        if (validId(idCode)) {
            this.idCode = idCode;
        } else {
            throw new CodeException("Incorrect value " + idCode +" for code (should contains exactly 10 digits)");
        }
    }

    private boolean validId(String idCode) {
        if (idCode == null
                || idCode.length() != 10
                || !idCode.matches("[0-9]+")
        ) {
            return false;
        }
        return true;
    }

    private boolean validName(String name) {
        if (name == null) return false;
        if (name.matches("^[A-Z]([a-zA-Z-\\s])*$")) return true;
        return false;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + idCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        return idCode != null ? idCode.equals(person.idCode) : person.idCode == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (idCode != null ? idCode.hashCode() : 0);
        return result;
    }

    public static Person buildPerson(String firstName, String lastName, String idCode) {
        Person person = new Person();
        Handler firstNameHandler = new Handler(
                new Callback() {
                    @Override
                    public void setter(String data) throws NameException, CodeException {
                        person.setFirstName(data);
                    }
                },
                firstName,
                "Incorrect value " +firstName+" for firstName (should start from upper case and contains only alphabetic characters and symbols -, _)"
        );
        Handler lastNameHandler = new Handler(
                new Callback() {
                    @Override
                    public void setter(String data) throws NameException, CodeException {
                        person.setLastName(data);
                    }
                },
                lastName,
                "Incorrect value " +lastName+" for lastName (should start from upper case and contains only alphabetic characters and symbols -, _)"
        );

        Handler idCodeHandler = new Handler(
                new Callback() {
                    @Override
                    public void setter(String data) throws NameException, CodeException {
                        person.setIdCode(data);
                    }
                },
                idCode,
                "Incorrect value " +idCode+ " for code (should contains exactly 10 digits)"
        );

        firstNameHandler.setNextHandler(lastNameHandler);
        lastNameHandler.setNextHandler(idCodeHandler);

        String message = firstNameHandler.handleMessage(null);
        if (message != null) throw new IllegalArgumentException(message);
        else return person;
    }
}

class NameException extends RuntimeException {
    public NameException(String m) {
        super(m);
    }
}

class CodeException extends RuntimeException {
    public CodeException(String m) {
        super(m);
    }
}

interface Callback {
    void setter(String data) throws NameException, CodeException;
}

class Handler {
    private Handler nextHandler;
    private Callback callback;
    private String data;
    private String message;

    public Handler(Callback callback, String data, String message) {
        this.callback = callback;
        this.data = data;
        this.message = message;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public String handleMessage(String message) {
        try {
            callback.setter(data);
        } catch (NameException | CodeException e) {
            if (message == null) {
                message = this.message;
            } else message += "; " + this.message;

        } finally {
            if (this.nextHandler != null) {
                return nextHandler.handleMessage(message);
            } else {
                return message;
            }
        }
    }
}


public class Task4 {
    public static void main(String[] args) {
//        Person p = new Person();
//        p.setFirstName("Oleg");
//        p.setFirstName(null);
//        p.setLastName("Berd");
//        p.setIdCode("1234567890");
        Person p = Person.buildPerson("Oleg", "Berd", "1234567890");
//        Person p = Person.buildPerson("io", "Oros", "23");
        System.out.println(p);
//        Person p = null;
//        try {
//            p = Person.buildPerson("Oleg", "Berd", "1234567890");
//        } catch (Exception e) {
//            System.out.println("Bad params");
//        } finally {
//            System.out.println(p);
//        }
    }
}
