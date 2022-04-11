//Checking the search in all sections of the site


package org.example.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.HW3.MyException.ListIsNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 {
    private static final String AUTHORS_IS_NULL = "The search result in the authors section turned up nothing.";
    private static final String ARTWORKS_IS_NULL = "The search result in the work section turned up nothing.";
    private static final String POST_IN_BLOG_IS_NULL = "The search result in the blog post section turned up nothing.";
    private static final String ILLUSTRATION_IS_NULL = "The search result in the illustration section turned up nothing.";
    private static final String COLLECTION_IS_NULL = "The search result in the selection section turned up nothing.";

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito")
                     .addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://author.today/");

        WebElement search = driver.findElement(By.xpath(".//li[@class=\"nav-icon\"]/a/i"));
        search.click();

        WebElement textInputArea = driver.findElement(By.xpath(".//input[@class=\"form-control\"]"));
        textInputArea.sendKeys("кошка\n");

        List<WebElement> listAuthors = driver.findElements(By.xpath(".//div[@class=\"col-xs-6\"]"));
        try{
            checkListIsNull(AUTHORS_IS_NULL, listAuthors);
        } catch (ListIsNull e) {
            System.out.println(e.getMessage());;
        }

        List<WebElement> listArtworks = driver.findElements(By.xpath(".//div[@class=\"bookcard\"]"));
        try{
            checkListIsNull(ARTWORKS_IS_NULL, listArtworks);
        } catch (ListIsNull e) {
            System.out.println(e.getMessage());
        }

        List<WebElement> listPosts = driver.findElements(By.xpath(".//div[@class=\"bookcard\"]"));
        try{
            checkListIsNull(POST_IN_BLOG_IS_NULL, listPosts);
        } catch (ListIsNull e) {
            System.out.println(e.getMessage());
        }

        List<WebElement> listIllustrations = driver.findElements(By.xpath(".//div[@class=\"art-wrapper\"]"));
        try{
            checkListIsNull(ILLUSTRATION_IS_NULL, listIllustrations);
        } catch (ListIsNull e) {
            System.out.println(e.getMessage());
        }

        List<WebElement> listCollections = driver.findElements(By.xpath(".//div[@class=\"collection\"]"));
        try{
            checkListIsNull(COLLECTION_IS_NULL, listCollections);
        } catch (ListIsNull e) {
            System.out.println(e.getMessage());
        }

        //driver.quit();
    }
    public static void checkListIsNull(String msg, List<WebElement> InputList) throws ListIsNull {
       if(InputList.size() == 0) throw new ListIsNull(msg);
    }

}
