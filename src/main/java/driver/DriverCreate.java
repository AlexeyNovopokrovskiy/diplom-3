package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverCreate {

    public static WebDriver createWebdriver(){
        String browser = System.getProperty("browser");
        //browser = "yandex";
        if (browser == null) {
            return createChromeDriver();
        }

        switch (browser) {
            case "yandex":
                return createYandexBrowser();
            case "chrome":
            default:
                return createChromeDriver();
        }
        }

        public static WebDriver createChromeDriver(){
            System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
            return new ChromeDriver();
        }

        public static WebDriver createYandexBrowser(){
            System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/yandexdriver.exe");
            return new ChromeDriver();

        }

}
