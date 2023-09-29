package pages;

import Utils.GenerateUser;
import Utils.JUser;
import Utils.UserGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static driver.DriverCreate.createWebdriver;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    WebDriver driver;
    String login;
    String password;
    String name;
    String loginBadPass;
    String passwordBadPass;
    String nameBadPass;

    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;

        driver = createWebdriver();
        driver.get(HomePage.getURL());

        JUser user = GenerateUser.randomUser();
        login = user.getEmail();
        password = user.getPassword();
        name = user.getName();

        JUser userBadPass = GenerateUser.randomUserBadPassword();
        loginBadPass = userBadPass.getEmail();
        passwordBadPass = userBadPass.getPassword();
        nameBadPass = userBadPass.getName();
    }

    @Test
    public void registerUser() {

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushLoginButtonMiddle();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEnterButton();
        loginPage.registrationButtonClick();

        ReigstrationPage reigstrationPage = new ReigstrationPage(driver);
        reigstrationPage.fillNameR(name);
        reigstrationPage.fillEmailR(login);
        reigstrationPage.fillPasswordR(password);
        reigstrationPage.registrationButtonRClick();

        loginPage.waitForLoadEnterButton();
        loginPage.pushLKButton();
        loginPage.fillEmail(login);
        loginPage.fillPassword(password);
        loginPage.waitForLoadEnterButton();
        loginPage.enterButtonClick();

        homePage.pushLKButton();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.checkVisibilityExitButton();

        JUser userForDelete = new JUser(login,password);
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.userDelete(userGenerator.getToken(userGenerator.loginForDeleteUser(userForDelete)));
    }

    @Test
    public void registerWrongUser() {

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushLoginButtonMiddle();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEnterButton();
        loginPage.registrationButtonClick();

        ReigstrationPage reigstrationPage = new ReigstrationPage(driver);
        reigstrationPage.fillNameR(nameBadPass);
        reigstrationPage.fillEmailR(loginBadPass);
        reigstrationPage.fillPasswordR(passwordBadPass);
        reigstrationPage.registrationButtonRClick();
        reigstrationPage.checkIncorrectPass();

    }
    @After
    public void teardown () {
        driver.quit();
    }

}