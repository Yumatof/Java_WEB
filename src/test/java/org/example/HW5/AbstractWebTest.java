package org.example.HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.HW5.MyEception.ListIsNull;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractWebTest {

    private static WebDriver driver;
    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito")
                     .addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
    public static WebDriver getDriver(){
        return driver;
    }
    public static<T> void checkListIsNull(String msg, List<T> InputList) throws ListIsNull {
        if(InputList.size() == 0) throw new ListIsNull(msg);
    }
}
