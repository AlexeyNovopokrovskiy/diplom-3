package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ForgotPasswordPage {
    private WebDriver driver;


    By loginButtonF = By.xpath(".//a [text()='Войти']");

    ForgotPasswordPage(WebDriver driver){
        this.driver=driver;
    }

    public void pushLoginButtonF(){
        driver.findElement(loginButtonF).click();
    }

    public void waitForLoadEnterF(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButtonF));
    }
}
