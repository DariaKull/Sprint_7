package ru.yandex.praktikum.sprint7.courier;
import com.github.javafaker.Faker;

public class CourierData {
    public Registration baseCourier() {
        return new Registration("Big Head", "qwerty","Tree");
    }
    public Registration registeredCourier() {
        return new Registration("earth0808","12345678","Queener");
    }
    public Registration firstCourier() {
        return new Registration("bbtheoRRRRRY", "onth3web", "Hero");
    }

    public Registration secondCourier() {
        return new Registration(login,password,name);
    }

    public Registration emptyLoginCourier() {
        return new Registration(null, password, name);
    }

    public Registration emptyPasswordCourier() {
        return new Registration(login, "", name);
    }

    Faker faker = new Faker();

    String login = faker.name().name();
    String password = faker.internet().password();
    String name = faker.name().firstName();
}
