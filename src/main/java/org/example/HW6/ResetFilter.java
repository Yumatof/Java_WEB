package org.example.HW6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetFilter extends AbstractPage{
    @FindBy(css = ".category-btn:nth-last-child(1)")
    private WebElement choiceAllGenre;
    @FindBy(xpath = ".//div[@class=\"genre-title\"]/a")
    private WebElement choiceGenre;
    @FindBy(xpath = ".//select[@data-bind=\"valueWithInit: form\"]")
    private WebElement choiceForm;
    @FindBy(xpath = ".//select[@data-bind=\"valueWithInit: form\"]/option[@value=\"novel\"]")
    private WebElement addFilterFromForm;
    @FindBy(xpath = ".//a[@class=\"special-link ml-lg\"]")
    private WebElement elementResetFilter;
    private String expectedElement = ".book-row:nth-child(4) img";

    public ResetFilter(WebDriver driver) {
        super(driver);
    }

    public ResetFilter choiceAllGenreClick(){
        choiceAllGenre.click();
        return this;
    }
    public ResetFilter choiceGenreClick(){
        choiceGenre.click();
        return this;
    }
    public ResetFilter choiceFormClick(){
        choiceForm.click();
        return this;
    }
    public void elementResetFilterClick(WebDriverWait wait){
        addFilterFromForm.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(expectedElement)));
        elementResetFilter.click();

    }
}
