package yandex.praktikum.sprint7;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.sprint7.courier.Authorization;
import ru.yandex.praktikum.sprint7.courier.CourierAuthorization;
import ru.yandex.praktikum.sprint7.courier.CourierCreation;
import ru.yandex.praktikum.sprint7.courier.CourierData;
import ru.yandex.praktikum.sprint7.courier.RegistrationAssert;

public class CourierCreationTest {
    CourierData courierData = new CourierData();
    CourierCreation creatingCourier = new CourierCreation();
    RegistrationAssert assertsRegistration = new RegistrationAssert();
    CourierAuthorization authCourier = new CourierAuthorization();
    ValidatableResponse authBaseCourier;
    ValidatableResponse createBaseCourier;
    Authorization auth;
    private int courierId;

    @Test
    @DisplayName("Create new courier account")
    @Description("Creation of a new courier account, code 201")
    public void creatingCourier(){
        createBaseCourier = creatingCourier.createCourier(courierData.baseCourier());
        assertsRegistration.successfulCreation(createBaseCourier);
    }

    @Test
    @DisplayName("Create new courier account, empty login")
    @Description("Check error handling when login is null")
    public void creatingCourierWithNullLogin(){
        createBaseCourier = creatingCourier.createCourier(courierData.emptyLoginCourier());
        assertsRegistration.failedCreation(createBaseCourier);
    }

    @Test
    @DisplayName("Create new courier account, empty password")
    @Description("Check error handling when password is null")
    public void creatingCourierWithNullPassword(){
        createBaseCourier = creatingCourier.createCourier(courierData.emptyPasswordCourier());
        assertsRegistration.failedCreation(createBaseCourier);
    }


    @Test
    @DisplayName("Registration with same courier credentials")
    @Description("Check case of registration with already existing credentials")
    public void reRegistrationOfCourier(){
        createBaseCourier = creatingCourier.createCourier(courierData.registeredCourier());
        assertsRegistration.creatingExistingAccount(createBaseCourier);
    }

    @After
    public void deleteCourier() {
        if (createBaseCourier.extract().statusCode() == 201) {
            auth = Authorization.fromRegistrationCourier(courierData.baseCourier());
            authBaseCourier = authCourier.authorizationCourier(auth);
            courierId = authBaseCourier.extract().path("id");
            creatingCourier.deleteCourier(courierId);
        }
    }
}
