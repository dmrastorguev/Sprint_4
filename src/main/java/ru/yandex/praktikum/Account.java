package ru.yandex.praktikum;




public class Account {

    final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

            String str = name;
            if (name == null) {
              return false;
            }
//      Считаем количество символов, передаваемых в переменной name
            int countSymbolsName = 0;
            for (int i = 0; i < str.length(); i++) {
                countSymbolsName++;
            }

//      Считаем количество пробелов, передаваемых в переменной name
            int spacesQuantity = str.length() - str.replace(" ", "").length();

            if (
                    str.startsWith(" ") | str.endsWith(" ") | countSymbolsName > 19 | countSymbolsName < 3 | spacesQuantity != 1 | str.isEmpty()
            )
            {
                return false;
            }
            else
            {
                return true;
            }
    }
}

