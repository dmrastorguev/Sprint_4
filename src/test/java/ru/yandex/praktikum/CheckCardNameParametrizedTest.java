package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckCardNameParametrizedTest extends BaseTest {
    private final String name;
    private final Boolean expectedResult;

    public CheckCardNameParametrizedTest(String name, Boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        step("Создаем набор тестовых данных");
        return new Object[][]{
                {" Ложкин", false},               //  пробел в начале строки
                {"Ложкин ", false},               //  пробел в коне строки
                {"f  o", false},                  //  2 пробела
                {"1234567890123456789", false},   //  19 символов без пробела
                {"12", false},                    //  2 символа
                {"f o", true},                    //  3 символа
                {"123456789 123456789", true},    //  19 символов
                {"123456789 1234567890", false},  //  20 символов
                {"", false},                      //  0 символов
                {null, false},                    //  null
        };
    }

    @Test
    @DisplayName("Тест на проверку возможности печати имени владельца на выпускаемой карте")
    @Description("Тест проверяет различные варианты имени владельца для возможности печати на выпускаемой карте и так же проверка метода на null")
    public void checkCardNameParametrized() {

        Account account = new Account(name);
        step("Вызываем для проверки метод checkNameToEmboss");
        boolean actualResult = account.checkNameToEmboss();
        step("Делаем сравнение ожидаемого и реального результата вызова метода checkNameToEmboss");
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("Имя Владельца " +"\"" + name + "\""+ " - карта  может быть выпущена? - " + actualResult);

    }
}