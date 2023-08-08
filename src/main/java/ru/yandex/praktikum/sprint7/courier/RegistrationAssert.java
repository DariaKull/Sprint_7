package ru.yandex.praktikum.sprint7.courier;

import io.restassured.response.ValidatableResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class RegistrationAssert {
    public void successfulCreation(ValidatableResponse response) {
        ValidatableResponse ok = response.assertThat()
                .statusCode(201)
                .body("ok", is(true));
    }

    public void failedCreation(ValidatableResponse response) {
        response.assertThat()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    public void creatingExistingAccount(ValidatableResponse response) {
        response.assertThat()
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }
}
