package org.example.HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    @FindBy(css = ".mds")
    private WebElement search;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        public MainPage clickSearch(){
            search.click();
            return this;
        }

    }
}
