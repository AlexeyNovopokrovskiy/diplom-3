package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private final static String url = "https://stellarburgers.nomoreparties.site";

    By lkButton = By.xpath(".//p [text()='Личный Кабинет']");
    By loginButtonMiddle = By.xpath(".//button [text()='Войти в аккаунт']");
    By bunsButton = By.xpath("//span [text()='Булки']");
    By sauseButton = By.xpath("//span [text()='Соусы']");
    By fillingsButton = By.xpath("//span [text()='Начинки']");

    By bunsMenuCheck = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']/div[1]/div[1]");
    By sausesMenuCheck = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']/div[1]/div[2]");
    By fillingsMenuCheck = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']/div[1]/div[3]");

    By logo = By.className("AppHeader_header__logo__2D0X2");
    By feed = By.xpath(".//p [text()='Лента Заказов']");

    //----------------------------------------------------------------------
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //----------------------------------------------------------------------
    public void pushLKButton(){
        driver.findElement(lkButton).click();
    }

    public void waitForLoadHeader(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(logo));
    }

    public void pushLoginButtonMiddle(){
        driver.findElement(loginButtonMiddle).click();
    }

    public void pushBunsButton(){
        driver.findElement(bunsButton).click();
    }

    public void pushSauseButton(){
        driver.findElement(sauseButton).click();
    }

    public void pushFillingsButton(){
        driver.findElement(fillingsButton).click();
    }

    public void checkBunsMenuJump(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeContains(bunsMenuCheck,"class", "current"));
    }

    public void checkSausesMenuJump(){

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeContains(sausesMenuCheck, "class", "current"));
    }

    public void checkFillingsMenuJump(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeContains(fillingsMenuCheck, "class", "current"));
    }

    public void feedButtonClick(){
        driver.findElement(feed).click();
    }



    public static String getURL(){
        return url;
    }

}
