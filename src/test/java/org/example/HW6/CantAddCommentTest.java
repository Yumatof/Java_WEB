package org.example.HW6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CantAddCommentTest extends AbstractTest{
    private final String FIND_TEXT_RU ="Только зарегистрированные пользователи могут оставлять комментарии.";
    @Test
    void cantAddCommentTest(){
        CantAddComment cantAddComment = new CantAddComment(getWebDriver());
        cantAddComment.discussionClick()
                .choicePostClick();
        assertEquals(getWebDriver().getPageSource().contains(FIND_TEXT_RU), true);
    }

}
