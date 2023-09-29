package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private WebDriver driver;

    By exitButton = By.xpath(".//button [text()='Выход']");
    By constructorButton = By.xpath(".//p [text()='Конструктор']");
    By historyButton = By.xpath(".//ul/li[2]/a");
    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }
    public void checkVisibilityExitButton(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));

    }

    public void exitButtonClick(){
        driver.findElement(exitButton).click();
    }

    public void constructorButtonClick(){
        driver.findElement(constructorButton).click();
    }

    public void historyButtonClick(){
        driver.findElement(historyButton).click();
    }


}
