import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import object.CreateOrder;
import steps.OrderSteps;


import static constants.BasicDate.URL;

@RunWith(Parameterized.class)
public class CreateOrderTest {

    static Faker faker = new Faker();

    private static final String FIRST_NAME = faker.name().firstName();
    private static final String LAST_NAME = faker.name().lastName();
    private static final String ADDRESS = faker.address().fullAddress();
    private static final String METRO_STATION = "4";
    private static final String PHONE_NUMBER = faker.phoneNumber().phoneNumber();
    private static final int RENT_TIME = 5;
    private static final String DELIVERY_DATE = "2024-04-04";
    private static final String COMMENT = RandomStringUtils.randomAlphabetic(12);
    private final String[] color;
    OrderSteps orderSteps;

    public CreateOrderTest(String[] color) {
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getColor() {
        return new Object[][] {
                { new String[]{"BLACK"} },
                { new String[]{"GREY"} },
                { new String[]{"BLACK", "GREY"} },
                { new String[]{} },
        };
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = URL;
        orderSteps = new OrderSteps();
    }

    @Test
    @DisplayName("Successful creating order")
    @Description(value = "Check creating order with different list of color.")
    public void creatingOrderSuccess() {
        CreateOrder order = new CreateOrder(FIRST_NAME, LAST_NAME, ADDRESS, METRO_STATION, PHONE_NUMBER, RENT_TIME, DELIVERY_DATE, COMMENT, color);
        Response responseCreateOrder = orderSteps.createOrder(order);
        orderSteps.checkAnswerCreateOrder(responseCreateOrder);
    }

}

