package org.example.HW6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.HW5.MyEception.ListIsNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.List;

public class AbstractTest {
    static WebDriver driver;
    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito")
               .addArguments("star-maximizes")
               .setPageLoadTimeout(Duration.ofSeconds(10));

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow(()-> driver.navigate().to("https://author.today/"),
                "Page not found");
    }
    @AfterAll
    static void close(){
        if(driver != null) driver.quit();
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static<T> void checkListIsNull(String msg, List<T> InputList) throws ListIsNull {
        if(InputList.size() == 0) throw new ListIsNull(msg);
    }


}
