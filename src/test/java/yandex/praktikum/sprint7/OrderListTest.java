package yandex.praktikum.sprint7;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.yandex.praktikum.sprint7.order.OrderAssert;
import ru.yandex.praktikum.sprint7.order.OrderList;

public class OrderListTest {
    OrderList orderClient = new OrderList();
    OrderAssert assertOrders = new OrderAssert();

    @Test
    @DisplayName("Get order list")
    @Description("Order list get successful")
    public void getOrderList() {
        ValidatableResponse orderList =  orderClient.getOrderList();
        assertOrders.successfulGetListOrders(orderList);
    }

}
