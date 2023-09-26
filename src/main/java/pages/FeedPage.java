package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class FeedPage {
    private WebDriver driver;
    By lkButton = By.xpath(".//p [text()='Личный Кабинет']");
    FeedPage(WebDriver driver){
        this.driver=driver;
    }

    public void lkButtonClick(){
        driver.findElement(lkButton).click();
    }

    public void lkButtonWait(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(lkButton));
    }

}
