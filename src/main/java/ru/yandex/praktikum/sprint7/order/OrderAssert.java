package ru.yandex.praktikum.sprint7.order;

import io.restassured.response.ValidatableResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class OrderAssert {
    public void successfulCreation(ValidatableResponse response) {
        response.assertThat()
                .statusCode(201)
                .body("track", is(notNullValue()));
    }

    public void successfulGetListOrders(ValidatableResponse response) {
        response.assertThat()
                .statusCode(200)
                .body("orders", is(notNullValue()));
    }
}
