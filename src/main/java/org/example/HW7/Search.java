package org.example.HW7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Search extends AbstractPage {

    @FindBy(css = "a > .icon-search")
    private WebElement elementSearch;
    @FindBy(xpath = ".//input[@class=\"form-control\"]")
    private WebElement inputTxtArea;
    @FindBy(xpath = ".//div[@class=\"col-xs-6\"]")
    private List <WebElement> listAuthors;
    @FindBy(xpath = ".//div[@class=\"bookcard\"]")
    private List <WebElement> listArtworks;
    @FindBy(xpath = ".//div[@class=\"bookcard\"]")
    private List <WebElement> listPosts;
    @FindBy(xpath = ".//div[@class=\"art-wrapper\"]")
    private List <WebElement> listIllustrations;
    @FindBy(xpath = ".//div[@class=\"collection\"]")
    private List <WebElement> listCollections;

    public Search(WebDriver driver){
        super(driver);
    }

    public Search elementSearchClick(){
        elementSearch.click();
        return this;
    }
    public Search inputTxtArea (String searchTXT){
        inputTxtArea.sendKeys(searchTXT);
        return this;
    }
    public boolean checkListAuthors(){
        if(listAuthors.size() == 0){
            MyUtils.makeScreenshot(getDriver(),
                    "failure- org.example.bbc.EventListenerTest.test" + System.currentTimeMillis() + ".png");
            return false;
        }
        return true;
    }
    public boolean checkListArtworks(){
        if(listArtworks.size() == 0) {
            MyUtils.makeScreenshot(getDriver(),
                    "failure- org.example.bbc.EventListenerTest.test" + System.currentTimeMillis() + ".png");
            return false;
        }
        return true;
    }
    public boolean checkListPosts(){
        if(listPosts.size() == 0){
            MyUtils.makeScreenshot(getDriver(),
                    "failure- org.example.bbc.EventListenerTest.test" + System.currentTimeMillis() + ".png");
            return false;
        }
        return true;
    }
    public boolean checkListIllustrations(){
        if(listIllustrations.size() == 0){
            MyUtils.makeScreenshot(getDriver(),
                    "failure- org.example.bbc.EventListenerTest.test" + System.currentTimeMillis() + ".png");
            return false;
        }
        return true;
    }
    public boolean checkListCollections(){
        if(listCollections.size() == 0){
            MyUtils.makeScreenshot(getDriver(),
                    "failure- org.example.bbc.EventListenerTest.test" + System.currentTimeMillis() + ".png");
            return false;
        }
        return true;
    }
}
