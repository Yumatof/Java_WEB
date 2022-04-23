package org.example.HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CantBuyBook extends AbstractPage{
    @FindBy(xpath = ".//div/a[@href=\"/work/discounts\"]")
    private  WebElement discounts;
    @FindBy(css = ".book-row:nth-child(4) img")
    private  WebElement choiceBookToBuy;
    @FindBy(css = ".btn-buy-book .btn")
    private  WebElement buttonBuy;

    public CantBuyBook(WebDriver driver) {
        super(driver);
    }
    public CantBuyBook discountsClick(){
        discounts.click();
        return this;
    }
    public CantBuyBook choiceBookToBuyClick(){
        choiceBookToBuy.click();
        return this;
    }
    public CantBuyBook buttonBuyClick(){
        buttonBuy.click();
        return this;
    }
}
