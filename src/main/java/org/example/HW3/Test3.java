//Reset filter settings to default


package org.example.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito")
                .addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://author.today/");

        WebElement choiceAllGenre = driver.findElement(By.cssSelector(".category-btn:nth-last-child(1)"));
        choiceAllGenre.click();

        WebElement choiceGenre = driver.findElement(By.xpath(".//div[@class=\"genre-title\"]/a"));
        choiceGenre.click();

        WebElement choiceForm = driver.findElement(By.xpath(".//select[@data-bind=\"valueWithInit: form\"]"));
        choiceForm.click();

        WebElement addFilterFromForm = driver.findElement(By.xpath(".//select[@data-bind=\"valueWithInit: form\"]/option[@value=\"novel\"]"));
        addFilterFromForm.click();

        //Thread.sleep(1000l);//костыль
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".book-row:nth-child(4) img")));

        WebElement resetFilter = driver.findElement(By.xpath(".//a[@class=\"special-link ml-lg\"]"));
        resetFilter.click();

        //driver.quit();
    }
}
