package org.example.HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CantDownloadBook extends AbstractPage{
    @FindBy(css = ".category-btn:nth-child(3)")
    private WebElement choiceGenre;
    @FindBy(xpath = ".//select[@data-bind=\"valueWithInit: download\"]")
    private WebElement choiceDownload;
    @FindBy(xpath = ".//select[@data-bind=\"valueWithInit: download\"]/option[@value=\"allowed\"]")
    private WebElement downloadAllowed;
    @FindBy(css = ".book-row:nth-child(4) img")
    private WebElement choiceBookToDownload;
    @FindBy(xpath = ".//i[@class=\"icon-download\"]/..")
    private WebElement buttonToDownload;

    public CantDownloadBook(WebDriver driver) {
        super(driver);
    }
    public CantDownloadBook choiceGenreClick(){
        choiceGenre.click();
        return this;
    }
    public CantDownloadBook choiceDownloadClick(){
        choiceDownload.click();
        return this;
    }
    public CantDownloadBook downloadAllowedClick(){
        downloadAllowed.click();
        return this;
    }
    public CantDownloadBook choiceBookToDownloadClick(){
        choiceBookToDownload.click();
        return this;
    }
    public CantDownloadBook buttonToDownloadClick(){
        buttonToDownload.click();
        return this;
    }
}
