package yandex.praktikum.sprint7;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.sprint7.order.OrderData;
import ru.yandex.praktikum.sprint7.order.OrderAssert;
import ru.yandex.praktikum.sprint7.order.OrderList;

@RunWith(Parameterized.class)
public class OrderCreationTest {
    OrderData ordersData = new OrderData();
    OrderList ordersList = new OrderList();
    OrderAssert assertOrders = new OrderAssert();
    private final String[] colors;
    int track;


    public OrderCreationTest(String[] colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters(name = "Scooter color: {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {new String[]{}}
        };
    }

    @Test
    @DisplayName("Create order")
    @Description("Scooter single color/double color/raw order creation")
    public void CreatingOrderWithDifferentColors() {
        ValidatableResponse createOrder = ordersList.createNewOrder(ordersData.baseOrderVariableColor(colors));
        assertOrders.successfulCreation(createOrder);
        track = createOrder.extract().path("track");
    }

    @After
    public void CancelTestOrder() {
        ordersList.cancelOrder(track);
    }
}
