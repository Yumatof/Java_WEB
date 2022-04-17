//Checking not authorization user can't download book from site


package org.example.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Test4 {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized")
                .addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://author.today/");

        WebElement choiceGenre = driver.findElement(By.cssSelector(".category-btn:nth-child(3)"));
        choiceGenre.click();

        WebElement choiceDownload = driver.findElement(By.xpath(".//select[@data-bind=\"valueWithInit: download\"]"));
        choiceDownload.click();

        WebElement downloadAllowed = driver.findElement(By.xpath(".//select[@data-bind=\"valueWithInit: download\"]/option[@value=\"allowed\"]"));
        downloadAllowed.click();

        WebElement choiceBookToDownload = driver.findElement(By.cssSelector(".book-row:nth-child(4) img"));
        choiceBookToDownload.click();

        WebElement buttonToDownload = driver.findElement(By.xpath(".//i[@class=\"icon-download\"]/.."));
        buttonToDownload.click();

        try {
            WebElement modalWindow = driver.findElement(By.cssSelector(".modal-title"));
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }

        //driver.quit();
    }

}
