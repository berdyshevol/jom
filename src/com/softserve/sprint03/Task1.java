package com.softserve.sprint03;

class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() { }

    public String getCheese() {
        return cheese;
    }
    public String getMeat() {
        return meat;
    }
    public String getSeafood() {
        return seafood;
    }
    public String getVegetable() {
        return vegetable;
    }
    public String getMushroom() {
        return mushroom;
    }

    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }

    public static class PizzaBuilder {
        private Pizza pizza;
        private PizzaBuilder() {
            this.pizza = new Pizza();
        }
        public PizzaBuilder addCheese(String cheese) {
            pizza.cheese = cheese;
            return this;
        }
        public PizzaBuilder addMeat(String meet) {
            pizza.meat = meet;
            return this;
        }
        public PizzaBuilder addSeafood(String seefood) {
            pizza.seafood = seefood;
            return this;
        }
        public PizzaBuilder addVegetable(String vagitable) {
            pizza.vegetable = vagitable;
            return this;
        }
        public PizzaBuilder addMushroom(String mushroom) {
            pizza.mushroom = mushroom;
            return this;
        }
        public Pizza build() {
            return this.pizza;
        }
    }
}

class Oven {
    public static Pizza cook() {
        return Pizza.base().addMeat("beef").addSeafood("crab").addMushroom("mushroom").build();
    }
}


public class Task1 {
    Pizza my = Oven.cook();
}

