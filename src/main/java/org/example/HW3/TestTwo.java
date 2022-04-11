//Checking not authorization user can't add to library from button "Read"


package org.example.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestTwo {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized")
                     .addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://author.today/");

        WebElement oneOfPopularBook = driver.findElement(By.cssSelector("#mostPopularWorks .bookcard:nth-child(7) .lazyloaded"));
        oneOfPopularBook.click();

        WebElement addToLibrary = driver.findElement(By.cssSelector(".btn > span"));
        addToLibrary.click();

        WebElement read = driver.findElement(By.cssSelector(".dropdown-menu-links > li:nth-child(1) > .pl"));
        read.click();

        try {
            WebElement modalWindow = driver.findElement(By.cssSelector(".modal-title"));
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }


        //driver.quit();
    }
}
