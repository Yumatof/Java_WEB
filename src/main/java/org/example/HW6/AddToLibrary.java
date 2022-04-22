package org.example.HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToLibrary extends AbstractPage {
    @FindBy(css = "#mostPopularWorks .bookcard:nth-child(7) .lazyloaded")
    private WebElement popularBook;
    @FindBy(css = ".btn > span")
    private WebElement addToLibrary;
    @FindBy(css = ".dropdown-menu-links > li:nth-child(1) > .pl")
    private WebElement readButton;

    public AddToLibrary(WebDriver driver){
        super(driver);}

    public AddToLibrary popularBookClick(){
        popularBook.click();
        return this;
    }
    public AddToLibrary addToLibraryClick(){
        addToLibrary.click();
        return this;
    }
    public AddToLibrary readButtonClick(){
        readButton.click();
        return this;
    }

}
