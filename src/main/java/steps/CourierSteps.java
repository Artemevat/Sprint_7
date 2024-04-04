package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import object.CreateCourier;
import object.LoginCourier;

import static constants.CourierAPI.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class CourierSteps {

    //пришлось добавить метод relaxedHTTPSValidation в связи с ошибкой сертифката
    @Step("create courier")
    public Response createCourier(String login, String pass, String name) {
        CreateCourier courier = new CreateCourier(login, pass, name);
        return given().relaxedHTTPSValidation()
                .log().all()
                .header("Content-type", "application/json")
                .body(courier)
                .when()
                .post(CREATE_COURIER)
                .then().log().all().extract().response();
    }

    @Step("login in the system")
    public Response loginCourier(String login, String pass) {
        LoginCourier loginCourier = new LoginCourier(login, pass);
        return given().relaxedHTTPSValidation()
                .log().all()
                .header("Content-type", "application/json")
                .body(loginCourier)
                .when()
                .post(LOGIN_COURIER)
                .then().log().all().extract().response();
    }

    @Step("get id courier")
    public Integer getCourierId(String login, String pass) {
        return loginCourier(login, pass)
                .body()
                .as(LoginCourier.class).getId();
    }

    @Step("delete courier")
    public Response deleteCourier(String login, String pass) {
        return given().relaxedHTTPSValidation()
                .log().all()
                .header("Content-type", "application/json")
                .when()
                .delete(PreparingDelete(getCourierId(login, pass)))
                .then().log().all().extract().response();
    }

    @Step("preparing delete")
    public String PreparingDelete(Integer courierID) {
        return DELETE_COURIER + courierID;
    }

    @Step("successful createCourier - (ok: true), status 201")
    public void checkAnswerValidCreateCourier(Response response) {
        response
                .then()
                .statusCode(201)
                .and().assertThat().body("ok", equalTo(true));
    }

    @Step("successful deleteCourier - (ok: true), status 200")
    public void checkAnswerValidDeleteCourier(Response response) {
        response
                .then()
                .statusCode(200)
                .and().assertThat().body("ok", equalTo(true));
    }

    @Step("duplicate createCourier - status 409")
    public void checkAnswerDuplicateCreateCourier(Response response) {
        response.then()
                .statusCode(409)
                .and().assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    @Step("not enough data createCourier - status 400")
    public void checkAnswerNotEnoughData(Response response) {
        response.then()
                .statusCode(400)
                .and().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Step("successful loginCourier returns id notNullValue - status 200")
    public void checkAnswerGetId(Response response) {
        response.then()
                .statusCode(200).and().assertThat().body("id", notNullValue());
    }

    @Step("incorrect username or password loginCourier - status 404")
    public void checkAnswerWithIncorrectData(Response response) {
        response.then()
                .statusCode(404).assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    @Step("not enough data loginCourier - status 400")
    public void checkAnswerWithoutData(Response response) {
        response.then()
                .statusCode(400).assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }
}
