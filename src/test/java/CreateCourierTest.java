import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import steps.CourierSteps;

import static constants.BasicDate.URL;
import static constants.CourierRandomDate.*;

public class CreateCourierTest {
    CourierSteps courierSteps;

    @Before
    public void setUp(){
        RestAssured.baseURI = URL;
        courierSteps = new CourierSteps();
    }

    @Test
    @DisplayName("Successful creating new courier and successful delete courier")
    @Description("Creating with correct login/password, check successful create, delete Courier")
    public void creatingCourierSuccessful() {
        Response responseCreatingCourier = courierSteps.createCourier(LOGIN, PASSWORD, FIRSTNAME);
        courierSteps.checkAnswerValidCreateCourier(responseCreatingCourier);
        Response responseDelete = courierSteps.deleteCourier(LOGIN, PASSWORD);
        courierSteps.checkAnswerValidDeleteCourier(responseDelete);
    }

    @Test
    @DisplayName("Error creating full duplicate courier")
    @Description("Creating courier with duplicate login/password/firstname, check error, delete Courier")
    public void creatingErrorDuplicateLoginPasswordFirstName() {
        courierSteps.createCourier(LOGIN_DUPLICATE, PASSWORD_DUPLICATE, FIRSTNAME_DUPLICATE);
        Response responseDuplicateLoginAndPasswordAndFirstname = courierSteps.createCourier(LOGIN_DUPLICATE, PASSWORD_DUPLICATE, FIRSTNAME_DUPLICATE);
        courierSteps.checkAnswerDuplicateCreateCourier(responseDuplicateLoginAndPasswordAndFirstname);
        Response responseDelete = courierSteps.deleteCourier(LOGIN_DUPLICATE, PASSWORD_DUPLICATE);
        courierSteps.checkAnswerValidDeleteCourier(responseDelete);
    }

    @Test
    @DisplayName("Error creating courier duplicate login")
    @Description("Creating courier with duplicate login, check error, delete Courier")
    public void creatingErrorDuplicateLogin() {
        courierSteps.createCourier(LOGIN_DUPLICATE, PASSWORD_DUPLICATE, FIRSTNAME_DUPLICATE);
        Response responseDuplicateLoginAndPassword = courierSteps.createCourier(LOGIN_DUPLICATE, PASSWORD, FIRSTNAME);
        courierSteps.checkAnswerDuplicateCreateCourier(responseDuplicateLoginAndPassword);
        Response responseDelete = courierSteps.deleteCourier(LOGIN_DUPLICATE, PASSWORD_DUPLICATE);
        courierSteps.checkAnswerValidDeleteCourier(responseDelete);
    }

    @Test
    @DisplayName("Error creating courier without login")
    @Description("Creating a courier without login, check error")
    public void creatingErrorCourierWithoutLogin() {
        Response responseWithoutLogin = courierSteps.createCourier("", PASSWORD, FIRSTNAME);
        courierSteps.checkAnswerNotEnoughData(responseWithoutLogin);
    }

    @Test
    @DisplayName("Error creating courier without password")
    @Description("Creating a courier without password, check error")
    public void creatingErrorCourierWithoutPassword() {
        Response responseWithoutPassword = courierSteps.createCourier(LOGIN, "", FIRSTNAME);
        courierSteps.checkAnswerNotEnoughData(responseWithoutPassword);
    }

    @Test
    @DisplayName("Successful creating courier without firstName and successful delete courier")
    @Description("Creating with correct login/password without firstName, check successful create, delete Courier")
    public void creatingCourierWithoutFirstNAme() {
        Response responseWithoutFirstName = courierSteps.createCourier(LOGIN_WITHOUT_FIRSTNAME, PASSWORD_WITHOUT_FIRSTNAME, "");
        courierSteps.checkAnswerValidCreateCourier(responseWithoutFirstName);
        Response responseDelete = courierSteps.deleteCourier(LOGIN_WITHOUT_FIRSTNAME, PASSWORD_WITHOUT_FIRSTNAME);
        courierSteps.checkAnswerValidDeleteCourier(responseDelete);
    }

}
