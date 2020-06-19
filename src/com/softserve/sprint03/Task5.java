package com.softserve.sprint03;

enum ClientType {
    NEW (0),
    SILVER (12),
    GOLD (30),
    PLATINUM (60);

    private final int months;

    ClientType(int number) {
        this.months = number;
    }
    public int countOfMonths() {
        return this.months;
    }
    public double discount() {
        return (100 - this.months * 0.35) / 100;
    }
}

public class Task5 {
    public static void main(String[] args) {
        ClientType newClient = ClientType.NEW;
        System.out.println(newClient.discount());

        ClientType newSILVER = ClientType.SILVER;
        System.out.println(newSILVER.discount());

        ClientType clientGOLD = ClientType.GOLD;
        System.out.println(clientGOLD.discount());

        ClientType clientPLATINUM = ClientType.PLATINUM;
        System.out.println(clientPLATINUM.discount());
    }
}
