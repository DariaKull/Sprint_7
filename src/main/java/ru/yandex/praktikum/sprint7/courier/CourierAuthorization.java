package ru.yandex.praktikum.sprint7.courier;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.sprint7.servicedata.ServiceData.*;

public class CourierAuthorization {
    @Step("Courier system log in")
    public ValidatableResponse authorizationCourier(Authorization courier){
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(courier)
                .when()
                .post(AUTHORIZATION_COURIER)
                .then();
    }
}
