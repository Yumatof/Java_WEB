package org.example.HW6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;


public class AbstractTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static Logger logger;
    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito")
                .addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger = LoggerFactory.getLogger(AbstractTest.class);
    }
    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow(()-> driver.navigate().to("https://author.today/"),
                "Page not found");
    }
    @AfterAll
    static void close(){
        //driver.quit();
    }
    public static WebDriver getWebDriver(){
        return driver;
    }
    public static WebDriverWait getWait(){
        return wait;
    }
    public static boolean checkModalWindow(){
        WebElement registrationLink = driver.findElement(By.xpath(".//a[@href=\"/account/register\"]"));
        return registrationLink.isEnabled();
    }
}
