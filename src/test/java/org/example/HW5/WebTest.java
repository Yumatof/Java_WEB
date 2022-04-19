package org.example.HW5;

import org.example.HW4.TriangleTest;
import org.example.HW5.MyEception.ListIsNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebTest extends AbstractWebTest {

    private static final String AUTHORS_IS_NULL = "The search result in the authors section turned up nothing.";
    private static final String ARTWORKS_IS_NULL = "The search result in the work section turned up nothing.";
    private static final String POST_IN_BLOG_IS_NULL = "The search result in the blog post section turned up nothing.";
    private static final String ILLUSTRATION_IS_NULL = "The search result in the illustration section turned up nothing.";
    private static final String COLLECTION_IS_NULL = "The search result in the selection section turned up nothing.";

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Check unauthorized user can add to library from button Read")
    public void webTest1(){
        logger.info("Run test - check unauthorized user can add to library from button Read");
        WebElement oneOfPopularBook = getDriver().findElement(By.cssSelector("#mostPopularWorks .bookcard:nth-child(7) .lazyloaded"));
        oneOfPopularBook.click();

        Actions addToLibrary = new Actions(getDriver());
        addToLibrary.click(getDriver().findElement(By.cssSelector(".btn > span")))
                //.pause(1000l)
                .click(getDriver().findElement(By.cssSelector(".dropdown-menu-links > li:nth-child(1) > .pl")))
                .build()
                .perform();

        checkModalWindow();
    }

    @Test
    @DisplayName("Check unauthorized user can download book")
    void webTest2(){
        logger.info("Run test - Check unauthorized user can download book");
        WebElement choiceGenre = getDriver().findElement(By.cssSelector(".category-btn:nth-child(3)"));
        choiceGenre.click();

        WebElement choiceDownload = getDriver().findElement(By.xpath(".//select[@data-bind=\"valueWithInit: download\"]"));
        choiceDownload.click();

        WebElement downloadAllowed = getDriver().findElement(By.xpath(".//select[@data-bind=\"valueWithInit: download\"]/option[@value=\"allowed\"]"));
        downloadAllowed.click();

        WebElement choiceBookToDownload = getDriver().findElement(By.cssSelector(".book-row:nth-child(4) img"));
        choiceBookToDownload.click();

        WebElement buttonToDownload = getDriver().findElement(By.xpath(".//i[@class=\"icon-download\"]/.."));
        buttonToDownload.click();

        checkModalWindow();
    }

    @Test
    @DisplayName("Reset filter settings to default")
    void webTest3(){
        logger.info("Run test - Reset filter settings to default");
        WebElement choiceAllGenre = getDriver().findElement(By.cssSelector(".category-btn:nth-last-child(1)"));
        choiceAllGenre.click();

        WebElement choiceGenre = getDriver().findElement(By.xpath(".//div[@class=\"genre-title\"]/a"));
        choiceGenre.click();

        WebElement choiceForm = getDriver().findElement(By.xpath(".//select[@data-bind=\"valueWithInit: form\"]"));
        choiceForm.click();

        WebElement addFilterFromForm = getDriver().findElement(By.xpath(".//select[@data-bind=\"valueWithInit: form\"]/option[@value=\"novel\"]"));
        addFilterFromForm.click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".book-row:nth-child(4) img")));

        WebElement resetFilter = getDriver().findElement(By.xpath(".//a[@class=\"special-link ml-lg\"]"));
        resetFilter.click();
    }

    @Test
    @DisplayName("Check search in all sections")
    public void webTest4(){
        logger.info("Run test - Check search in all sections");
        Actions search = new Actions(getDriver());
        search.click(getDriver().findElement(By.xpath(".//li[@class=\"nav-icon\"]/a/i")))
              //.pause(1000l)
              .sendKeys(getDriver().findElement(By.xpath(".//input[@class=\"form-control\"]")),"кошка\n")
              .build()
              .perform();

        List<WebElement> listAuthors = getDriver().findElements(By.xpath(".//div[@class=\"col-xs-6\"]"));
        try{
            checkListIsNull(AUTHORS_IS_NULL, listAuthors);
        } catch (ListIsNull e) {
            logger.info(e.getMessage());
        }
        List<WebElement> listArtworks = getDriver().findElements(By.xpath(".//div[@class=\"bookcard\"]"));
        try{
            checkListIsNull(ARTWORKS_IS_NULL, listArtworks);
        } catch (ListIsNull e) {
            logger.info(e.getMessage());
        }
        List<WebElement> listPosts = getDriver().findElements(By.xpath(".//div[@class=\"bookcard\"]"));
        try{
            checkListIsNull(POST_IN_BLOG_IS_NULL, listPosts);
        } catch (ListIsNull e) {
            logger.info(e.getMessage());
        }
        List<WebElement> listIllustrations = getDriver().findElements(By.xpath(".//div[@class=\"art-wrapper\"]"));
        try{
            checkListIsNull(ILLUSTRATION_IS_NULL, listIllustrations);
        } catch (ListIsNull e) {
            logger.info(e.getMessage());
        }
        List<WebElement> listCollections = getDriver().findElements(By.xpath(".//div[@class=\"collection\"]"));
        try{
            checkListIsNull(COLLECTION_IS_NULL, listCollections);
        } catch (ListIsNull e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @DisplayName("Check unauthorized user can buy a book")
    void webTest5(){
        logger.info("");
        WebElement discounts = getDriver().findElement(By.xpath(".//div/a[@href=\"/work/discounts\"]"));
        discounts.click();

        WebElement choiceBookToBuy = getDriver().findElement(By.cssSelector(".book-row:nth-child(4) img"));
        choiceBookToBuy.click();

        //WebElement buttonBuy = getDriver().findElement(By.cssSelector(".btn-buy-book .btn"));
        //buttonBuy.click();

        checkModalWindow();
    }

    //6 тест - https://stackoverflow.com/questions/25733877/selenium-how-do-you-check-scroll-position
    //@Test
    @DisplayName("")
    void webTest6(){
        logger.info("");
    }

    public static<T> void checkListIsNull(String msg, List<T> InputList) throws ListIsNull {
        if(InputList.size() == 0) throw new ListIsNull(msg);
    }
    public static void checkModalWindow(){
        try {
            WebElement modalWindow = getDriver().findElement(By.cssSelector(".modal-title"));
        } catch (ElementNotInteractableException e){
            logger.info(e.getSupportUrl());
        }
    }
}
