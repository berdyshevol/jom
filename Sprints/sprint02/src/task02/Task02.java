package task02;

/*
ok 1. Create interface DrinkReceipt with methods String getName() and DrinkReceipt addComponent(String componentName, int componentCount).
ok 2. Create interface DrinkPreparation with method Map<String, Integer> makeDrink() to return a drink components.
ok 3. Create interface Rating with method int getRating().
4. Class Caffee contains
fields String name, int rating,
Map of ingredients and implements interfaces DrinkReceipt, DrinkPreparation and Rating.
Method makeDrink() prepare coffee with typically components: {Water=100, Arabica=20}.
5. Espresso and Cappuccino classes extends the Caffee Class and override method makeDrink(). Espresso caffee has 50 g. of Water.
Cappuccino caffee has an additional of 50 g. of Milk.
Create a averageRating() method of the MyUtils class to return a Map with coffee name as key and coffee average rating as value.
For example, for a given list
[Espresso [name=Espresso, rating=8], Cappuccino [name=Cappuccino, rating=10], Espresso [name=Espresso, rating=10], Cappuccino [name=Cappuccino, rating=6], Caffee [name=Caffee, rating=6]]

you should get
{Espresso=9.00, Cappuccino=8.00, Caffee=6.00}

Answer:(penalty regime: 0 %)

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface DrinkReceipt {
    public String getName();
    public DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    public Map<String, Integer> makeDrink();
}
interface Rating {
    public int getRating();
}
class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients;

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.ingredients = new HashMap<>();
        this.addComponent("Water", 100)
                .addComponent("Arabica", 20);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        this.ingredients.put(componentName, componentCount);
        return this; // ??? what should it return to be DrinkReceipt type????
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 100)
                .addComponent("Arabica", 20);
        return this.ingredients;
    }

    @Override
    public int getRating() {
        return this.rating;
    }

    public Map<String, Integer> getIngredients() {
        return this.ingredients;
    }
}
class Espresso extends Caffee {
    public Espresso(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        super.makeDrink();
        this.addComponent("Water", 50);
        return this.getIngredients();
    }
}
class Cappuccino extends Caffee {
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        super.makeDrink();
        this.addComponent("Milk", 50);
        return this.getIngredients();
    }
}

/*public*/ class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        return coffees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Caffee::getName,
                                Collectors.averagingInt(Caffee::getRating)
                        )
                );
    }
}

public class Task02 {
    public static void main(String[] args) {
        Espresso e1 = new Espresso("Espresso", 8);
        Cappuccino c1 = new Cappuccino("Cappuccino", 10);
        Espresso e2 = new Espresso("Espresso", 10);
        Cappuccino c2 = new Cappuccino("Cappuccino", 6);
        Caffee cf = new Caffee("Caffee", 6);
        Caffee cf1 = new Caffee("Caffee", 6);
        ArrayList<Caffee> list = new ArrayList<Caffee>();
        list.add(e1);
        list.add(c1);
        list.add(e2);
        list.add(c2);
        list.add(cf);
        list.add(cf1);
        Map<String, Double> util= new MyUtils().averageRating(
                list
        );
        System.out.println(list);
    }
}


