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
public class NavigationTest {
    WebDriver driver;

    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;

        driver = createWebdriver();
        driver.get(HomePage.getURL());
    }

    @Test
    public void checkLKToConstructorSwitch(){
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
        profilePage.constructorButtonClick();
        homePage.waitForLoadHeader();


        JUser userForDelete = new JUser(login,password);
        Response res = userGenerator.userDelete(userGenerator.getToken(userGenerator.loginForDeleteUser(userForDelete)));
        assertEquals(202,res.statusCode());

    }

    @Test
    public void checkHomePageToLKSwitch(){
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
    public void checkFeedPageToLKSwitch(){
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

        homePage.feedButtonClick();

        FeedPage feedPage = new FeedPage(driver);
        feedPage.lkButtonWait();
        feedPage.lkButtonClick();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.checkVisibilityExitButton();


        JUser userForDelete = new JUser(login,password);
        Response res = userGenerator.userDelete(userGenerator.getToken(userGenerator.loginForDeleteUser(userForDelete)));
        assertEquals(202,res.statusCode());
    }
    @Test
    public void checkOrderHistoryPageToLKSwitch(){
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
        profilePage.historyButtonClick();

        HistoryPage historyPage = new HistoryPage(driver);
        historyPage.lkButtonWait();
        historyPage.lkButtonClick();

        profilePage.checkVisibilityExitButton();

        JUser userForDelete = new JUser(login,password);
        Response res = userGenerator.userDelete(userGenerator.getToken(userGenerator.loginForDeleteUser(userForDelete)));
        assertEquals(202,res.statusCode());
    }

    @After
    public void teardown () {
        driver.quit();
    }
}