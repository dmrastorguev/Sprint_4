package ru.yandex.praktikum;

public class Praktikum {

    static String cardName;

    public Praktikum(String cardName) {
        this.cardName = cardName;
    }

    public static void main(String[] args) {

            Account account = new Account(cardName);
            account.checkNameToEmboss();
    }
}
