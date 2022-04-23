package org.example.HW6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CantDownloadBookTest extends AbstractTest{
    @Test
    void CantDownloadBookTest(){
        CantDownloadBook cantDownloadBook = new CantDownloadBook(getWebDriver());
        cantDownloadBook.choiceGenreClick()
                .choiceDownloadClick()
                .downloadAllowedClick()
                .choiceBookToDownloadClick()
                .buttonToDownloadClick();
        Assertions.assertTrue(checkModalWindow());
    }
}
