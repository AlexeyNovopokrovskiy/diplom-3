package Utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserGenerator {

    private static final String BASE_URL = "/api/auth/register";
    private static final String BASE_URL_LOGIN = "api/auth/login";
    private static final String BASE_URL_UPDATE = "api/auth/user";

    public Response createUser(JUser testUser){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(testUser)
                .when()
                .post(BASE_URL);
    }

    public Response loginForDeleteUser(JUser testUser) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(testUser)
                .when()
                .post(BASE_URL_LOGIN);
    }

    public Response userDelete(String token){
        return given()
                .header("Authorization",  token)
                .delete(BASE_URL_UPDATE);
    }

    public String getToken(Response response){
        String token = response.then().extract().path("accessToken");
        return token;
    }


}
