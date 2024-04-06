import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import steps.OrderSteps;

import static constants.BasicDate.URL;


public class GetOrderListTest {
    OrderSteps orderSteps;

    @Before
    public void setUp() {
        RestAssured.baseURI = URL;
        orderSteps = new OrderSteps();
    }

    @Test
    @DisplayName("Get list order  - list not null")
    @Description("Get list order  - status 200, \"orders\", notNull")
    public void getOrderListNotNull() {
        Response response = orderSteps.getOrders();
        orderSteps.checkOrderListNotNull(response);
    }
}

