package ru.yandex.praktikum.sprint7.order;

public class OrderData {
    public Order baseOrderVariableColor(String[] colors) {
        return new Order("FirstNameExample", "LastNameExample", "AddressExample",
                8, "+79999999999", 5,"2023-08-03", "Some_comment", colors);
    }
}
