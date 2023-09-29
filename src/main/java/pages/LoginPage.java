package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    private WebDriver driver;


    By loginInput = By.xpath(".//input [@type='text']");
    By passwordInput = By.xpath(".//input [@type='password']");
    By enterButton = By.xpath(".//div/form/button");
    By registrationButton = By.xpath(".//a [text()='Зарегистрироваться']");
    By restorePasswordButton = By.xpath(".//a [text()='Восстановить пароль']");
    By lkButton = By.xpath(".//p [text()='Личный Кабинет']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadEnterButton(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(enterButton));
    }

    public void fillEmail(String email){
        driver.findElement(loginInput).click();
        driver.findElement(loginInput).sendKeys(email);

    }

    public void fillPassword(String password){
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterButtonClick(){
        driver.findElement(enterButton).click();
    }

    public void registrationButtonClick(){
        driver.findElement(registrationButton).click();
    }

    public void restorePasswordClick(){
        driver.findElement(restorePasswordButton).click();
    }

    public void checkEnterButton(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(enterButton));
    }

    public void pushLKButton(){
        driver.findElement(lkButton).click();
    }






}
