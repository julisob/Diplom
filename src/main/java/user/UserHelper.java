package user;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserHelper extends Helper {
    @Step("Создание пользователя через API")
    public static Response postCreateUser(User user) {
        RestAssured.baseURI = Helper.BASE_URL;
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(Helper.POST_CREATE_USER);
    }

    @Step("Удалить пользователя через API")
    public static void deleteUser(String accessToken) {
        RestAssured.baseURI = Helper.BASE_URL;
        given()
                .header("Authorization", accessToken)
                .when()
                .delete(Helper.DELETE_USER);
    }

    @Step("Залогинить пользователя через API")
    public static Response postLoginUser(Credentials userCredentials) {
        RestAssured.baseURI = Helper.BASE_URL;
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userCredentials)
                .when()
                .post(Helper.POST_LOGIN_USER);
    }

    @Step("Разлогиниться пользователю через API")
    public static Response postLogoutUser(String refreshToken) {
        RestAssured.baseURI = Helper.BASE_URL;
        return given()
                .header("Authorization", refreshToken)
                .when()
                .post(Helper.POST_LOGOUT_USER);
    }
}
