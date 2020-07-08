package com.softserve.sprint06.task4;

import java.util.ArrayList;
import java.util.List;

class Person{
    String name;
    Person(String name){
        this.name = name;
    }
    DecisionMethod goShopping = (product, discount) ->
        product.equals("product1") && discount > 10;
}

@FunctionalInterface
interface DecisionMethod {
    boolean decide(String product, int discount);
}

class Shop{
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        return (int)clients.stream().filter(clients -> clients.decide(product, percent)).count();
    }
}

/**
 * Suppose, we have the Person class with fields name and goShopping.
 *
 * The goShopping field defines if Person will do shopping based on product name and discount that come as parameters.
 * You should define the next default behavior for goShopping:
 * return true if product name = "product1"  and discount > 10, otherwise return false.
 * Define the type for goShopping field and name it DecisionMethod and define a method decide in it.
 *
 * Also, we have the class Shop with method sale().
 * This method informs users about a discount product
 * and a percentage of discount by using their goShopping values (which are stored in clients field).
 * The method should return the count of users that will go shopping.
 */
public class Task4 {
    public static void main(String[] args) {
        Person oleg = new Person("Oleg");
        System.out.println(oleg.goShopping.decide("bread", 15));
        System.out.println(oleg.goShopping.decide("product1", 10));
        System.out.println(oleg.goShopping.decide("product1", 15));
        Shop shop = new Shop();
        shop.clients = new ArrayList<DecisionMethod>() {{

        }};
    }
}
