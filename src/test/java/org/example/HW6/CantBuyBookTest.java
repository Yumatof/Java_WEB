package org.example.HW6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CantBuyBookTest extends AbstractTest{
    @Test
    void cantBuyBook(){
        CantBuyBook cantBuyBook = new CantBuyBook(getWebDriver());
        cantBuyBook.discountsClick()
                .choiceBookToBuyClick()
                .buttonBuyClick();
        Assertions.assertTrue(checkModalWindow());
    }
}
