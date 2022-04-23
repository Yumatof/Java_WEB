package org.example.HW6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CantAddToLibraryTest extends AbstractTest{
    @Test
    void checkAddToLibraryTest(){
        CantAddToLibrary cantAddToLibrary = new CantAddToLibrary(getWebDriver());
        cantAddToLibrary.popularBookClick()
                .addToLibraryClick()
                .readButtonClick();
        Assertions.assertTrue(checkModalWindow());
    }
}
