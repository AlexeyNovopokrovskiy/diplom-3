package pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static driver.DriverCreate.createWebdriver;

public class ConstructorTest {

    WebDriver driver;


    @Before
    public void setUp() {

        driver = createWebdriver();
        driver.get(HomePage.getURL());
    }

    @Test
    public void checkBunsSousesSwitch(){
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushFillingsButton();
        homePage.pushBunsButton();
        homePage.pushSauseButton();
        homePage.checkSausesMenuJump();
    }

    @Test
    public void checkBunsFillingsSwitch(){
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushFillingsButton();
        homePage.pushBunsButton();
        homePage.pushFillingsButton();
        homePage.checkFillingsMenuJump();

    }


    @Test
    public void checkSousesFillingsSwitch(){
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushSauseButton();
        homePage.pushFillingsButton();
        homePage.checkFillingsMenuJump();
    }


    @Test
    public void checkSousesBunsSwitch(){
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushSauseButton();
        homePage.pushBunsButton();
        homePage.checkBunsMenuJump();
    }

    @Test
    public void checkFillingsBunsSwitch(){
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushFillingsButton();
        homePage.pushBunsButton();
        homePage.checkBunsMenuJump();
    }

    @Test
    public void checkFillingsSousesSwitch(){
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHeader();
        homePage.pushFillingsButton();
        homePage.pushSauseButton();
        homePage.checkSausesMenuJump();
    }
    @After
    public void teardown () {
        driver.quit();
    }


}