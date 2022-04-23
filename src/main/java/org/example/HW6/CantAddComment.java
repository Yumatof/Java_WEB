package org.example.HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CantAddComment extends AbstractPage{
    @FindBy(xpath = ".//a[@href=\"/discussions\"]")
    private WebElement discussion;
    @FindBy(xpath = ".//h3[@class=\"post-title\"]/a")
    private WebElement choicePost;

    public CantAddComment(WebDriver driver) {
        super(driver);
    }
    public CantAddComment discussionClick(){
        discussion.click();
        return this;
    }
    public CantAddComment choicePostClick(){
        choicePost.click();
        return this;
    }
}
