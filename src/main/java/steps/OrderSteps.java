package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import object.CreateOrder;

import static constants.OrderAPI.CREATE_ORDER;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class OrderSteps {
    @Step("create order")
    public Response createOrder(CreateOrder order) {
        return given().relaxedHTTPSValidation()
                .log().all()
                .header("Content-type", "application/json")
                .body(order)
                .when()
                .post(CREATE_ORDER)
                .then().log().all().extract().response();
    }

    @Step("successful create order - status 201, track notNullValue")
    public void checkAnswerCreateOrder(Response response) {
        response.then()
                .statusCode(201).and().assertThat().body("track", notNullValue());
    }

    @Step("get orders")
    public Response getOrders() {
        return given().relaxedHTTPSValidation()
                .log().all()
                .header("Content-type", "application/json")
                .when()
                .get(CREATE_ORDER)
                .then().log().all().extract().response();
    }

    @Step("getOrders body contains list - status 200, list notNullValue")
    public void checkOrderListNotNull(Response response) {
        response.then()
                .statusCode(200).and().assertThat().body("orders", notNullValue());
    }

}