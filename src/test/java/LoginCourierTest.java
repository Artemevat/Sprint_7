import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import steps.CourierSteps;

import static constants.BasicDate.URL;
import static constants.CourierRandomDate.*;

public class LoginCourierTest {
    CourierSteps courierSteps;

    @Before
    public void setUp() {
        RestAssured.baseURI = URL;
        courierSteps = new CourierSteps();
        courierSteps.createCourier(LOGIN, PASSWORD, FIRSTNAME);
    }

    @Test
    @DisplayName("successful courier login")
    @Description("login courier with correct login/password, check successful request returns id, delete courier")
    public void loginCourierSuccess() {
        Response loginResponse = courierSteps.loginCourier(LOGIN, PASSWORD);
        courierSteps.checkAnswerGetId(loginResponse);
        Response responseDelete = courierSteps.deleteCourier(LOGIN, PASSWORD);
        courierSteps.checkAnswerValidDeleteCourier(responseDelete);
    }

    @Test
    @DisplayName("error login courier with incorrect login")
    @Description("login courier with incorrect login, check error, delete courier")
    public void loginErrorCourierWithIncorrectLogin() {
        Response errorLoginCourierWithIncorrectLogin = courierSteps.loginCourier(LOGIN_DUPLICATE, PASSWORD);
        courierSteps.checkAnswerWithIncorrectData(errorLoginCourierWithIncorrectLogin);
        Response responseDelete = courierSteps.deleteCourier(LOGIN, PASSWORD);
        courierSteps.checkAnswerValidDeleteCourier(responseDelete);
    }

    @Test
    @DisplayName("error login courier with incorrect password")
    @Description("login courier with incorrect password, check error, delete courier")
    public void loginErrorCourierWithIncorrectPassword() {
        Response errorLoginCourierWithIncorrectPassword = courierSteps.loginCourier(LOGIN, PASSWORD_DUPLICATE);
        courierSteps.checkAnswerWithIncorrectData(errorLoginCourierWithIncorrectPassword);
        Response responseDelete = courierSteps.deleteCourier(LOGIN, PASSWORD);
        courierSteps.checkAnswerValidDeleteCourier(responseDelete);
    }

    @Test
    @DisplayName("error login courier without login")
    @Description("login courier without login, check error, delete courier")
    public void loginCourierWithoutLoginError() {
        Response loginCourierWithoutLoginError = courierSteps.loginCourier("", PASSWORD);
        courierSteps.checkAnswerWithoutData(loginCourierWithoutLoginError);
        Response responseDelete = courierSteps.deleteCourier(LOGIN, PASSWORD);
        courierSteps.checkAnswerValidDeleteCourier(responseDelete);
    }

    @Test
    @DisplayName("Error login courier without password")
    @Description("login courier without password, check check error, delete courier")
    public void loginCourierWithoutPasswordError() {
        Response loginCourierWithoutPasswordError = courierSteps.loginCourier(LOGIN, "");
        courierSteps.checkAnswerWithoutData(loginCourierWithoutPasswordError);
        Response responseDelete = courierSteps.deleteCourier(LOGIN, PASSWORD);
        courierSteps.checkAnswerValidDeleteCourier(responseDelete);
    }

    @Test
    @DisplayName("Error login unknown courier")
    @Description("login courier with unknown login/password, check error, delete courier")
    public void loginCourierUnknownLoginAndPassword() {
        Response errorLoginCourierWithoutPassword = courierSteps.loginCourier(LOGIN_DUPLICATE, PASSWORD_DUPLICATE);
        courierSteps.checkAnswerWithIncorrectData(errorLoginCourierWithoutPassword);
        Response responseDelete = courierSteps.deleteCourier(LOGIN, PASSWORD);
        courierSteps.checkAnswerValidDeleteCourier(responseDelete);
    }
}

