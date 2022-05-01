package ru.yandex.praktikum;

import io.qameta.allure.Allure;

public class BaseTest {
    public static void step(String info) {
        Allure.step(info);
    }
}
