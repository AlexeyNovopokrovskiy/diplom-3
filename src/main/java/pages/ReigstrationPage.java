package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ReigstrationPage {
    private WebDriver driver;


    By loginButtonR = By.xpath(".//a [text()='Войти']");

    By incorrectPass = By.xpath(".//p [text()='Некорректный пароль']");

    By nameR = By.xpath(".//fieldset[1]//input");

    By emailR = By.xpath(".//fieldset[2]//input");

    By passwordR = By.xpath(".//fieldset[3]//input");

    By registrationButtonR = By.xpath(".//div/form/button");

    ReigstrationPage(WebDriver driver){
        this.driver=driver;
    }

    public void pushLoginButtonR(){
        driver.findElement(loginButtonR).click();
    }

    public void waitForLoadEnterR(){
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButtonR))
        ;
    }

    public void fillNameR(String name){
        driver.findElement(nameR).sendKeys(name);

    }
    public void fillEmailR(String email){
        driver.findElement(emailR).sendKeys(email);

    }

    public void fillPasswordR(String password){
        driver.findElement(passwordR).sendKeys(password);
    }

    public void registrationButtonRClick(){
        driver.findElement(registrationButtonR).click();
    }

    public void checkIncorrectPass(){
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(incorrectPass))
        ;
    }
}
