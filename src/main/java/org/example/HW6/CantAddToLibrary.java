package org.example.HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CantAddToLibrary extends AbstractPage {
    @FindBy(css = "#mostPopularWorks .bookcard:nth-child(7) .lazyloaded")
    private WebElement popularBook;
    @FindBy(css = ".btn > span")
    private WebElement addToLibrary;
    @FindBy(css = ".dropdown-menu-links > li:nth-child(1) > .pl")
    private WebElement readButton;

    public CantAddToLibrary(WebDriver driver){
        super(driver);}

    public CantAddToLibrary popularBookClick(){
        popularBook.click();
        return this;
    }
    public CantAddToLibrary addToLibraryClick(){
        addToLibrary.click();
        return this;
    }
    public CantAddToLibrary readButtonClick(){
        readButton.click();
        return this;
    }

}
