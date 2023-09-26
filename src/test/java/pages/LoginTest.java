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
import static org.junit.Assert.*;


public class LoginTest {

    WebDriver driver;

    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;

        driver = createWebdriver();
        driver.get(HomePage.getURL());
    }

    @Test
    public void loginHomePageLoginButtonMiddle() {


        JUser user = GenerateUser.randomUser();
        String login = user.getEmail();
        String password = user.getPassword();
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.createUser(user);

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushLoginButtonMiddle();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEnterButton();
        loginPage.fillEmail(login);
        loginPage.fillPassword(password);
        loginPage.waitForLoadEnterButton();
        loginPage.enterButtonClick();

        homePage.pushLKButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.checkVisibilityExitButton();

        JUser userForDelete = new JUser(login,password);
        Response res = userGenerator.userDelete(userGenerator.getToken(userGenerator.loginForDeleteUser(userForDelete)));
        assertEquals(202,res.statusCode());



    }

    @Test
    public void loginHomePageLKButton() {


        JUser user = GenerateUser.randomUser();
        String login = user.getEmail();
        String password = user.getPassword();
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.createUser(user);

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushLKButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEnterButton();
        loginPage.fillEmail(login);
        loginPage.fillPassword(password);
        loginPage.waitForLoadEnterButton();
        loginPage.enterButtonClick();

        homePage.pushLKButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.checkVisibilityExitButton();

        JUser userForDelete = new JUser(login,password);
        Response res = userGenerator.userDelete(userGenerator.getToken(userGenerator.loginForDeleteUser(userForDelete)));
        assertEquals(202,res.statusCode());

    }

    @Test
    public void loginFromRegistrationPage() {


        JUser user = GenerateUser.randomUser();
        String login = user.getEmail();
        String password = user.getPassword();
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.createUser(user);

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushLKButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEnterButton();
        loginPage.registrationButtonClick();

        ReigstrationPage reigstrationPage = new ReigstrationPage(driver);
        reigstrationPage.waitForLoadEnterR();
        reigstrationPage.pushLoginButtonR();

        loginPage.fillEmail(login);
        loginPage.fillPassword(password);
        loginPage.waitForLoadEnterButton();
        loginPage.enterButtonClick();

        homePage.pushLKButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.checkVisibilityExitButton();

        JUser userForDelete = new JUser(login,password);
        Response res = userGenerator.userDelete(userGenerator.getToken(userGenerator.loginForDeleteUser(userForDelete)));
        assertEquals(202,res.statusCode());

    }

    @Test
    public void loginFromForgotPassPage() {


        JUser user = GenerateUser.randomUser();
        String login = user.getEmail();
        String password = user.getPassword();
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.createUser(user);

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushLKButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEnterButton();
        loginPage.restorePasswordClick();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.waitForLoadEnterF();
        forgotPasswordPage.pushLoginButtonF();

        loginPage.fillEmail(login);
        loginPage.fillPassword(password);
        loginPage.waitForLoadEnterButton();
        loginPage.enterButtonClick();

        homePage.pushLKButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.checkVisibilityExitButton();

        JUser userForDelete = new JUser(login,password);
        Response res = userGenerator.userDelete(userGenerator.getToken(userGenerator.loginForDeleteUser(userForDelete)));
        assertEquals(202,res.statusCode());

    }

    @Test
    public void logout() {


        JUser user = GenerateUser.randomUser();
        String login = user.getEmail();
        String password = user.getPassword();
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.createUser(user);

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushLoginButtonMiddle();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEnterButton();
        loginPage.fillEmail(login);
        loginPage.fillPassword(password);
        loginPage.waitForLoadEnterButton();
        loginPage.enterButtonClick();

        homePage.pushLKButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.checkVisibilityExitButton();
        profilePage.exitButtonClick();

        loginPage.checkEnterButton();

        JUser userForDelete = new JUser(login,password);
        Response res = userGenerator.userDelete(userGenerator.getToken(userGenerator.loginForDeleteUser(userForDelete)));
        assertEquals(202,res.statusCode());

    }

    @After
    public void teardown () {
        driver.quit();
    }




}