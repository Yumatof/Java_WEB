package org.example.HW6;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Story("Проверка функционала сайта")
public class CantAddCommentTest extends AbstractTest{
    private final String FIND_TEXT_RU ="Только зарегистрированные пользователи могут оставлять комментарии.";
    @Test
    @DisplayName("cantAddComment")
    @Description("Не можем добавить комментарий")
    @Link("https://author.today/")
    @Issue("https://bs.jira.com")
    @TmsLink("https://ts.jira.com")
    @Severity(SeverityLevel.NORMAL)
    void cantAddCommentTest(){
        CantAddComment cantAddComment = new CantAddComment(getWebDriver());
        cantAddComment.discussionClick()
                .choicePostClick();
        assertEquals(getWebDriver().getPageSource().contains(FIND_TEXT_RU), true);
    }

}
