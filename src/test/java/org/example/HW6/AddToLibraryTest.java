package org.example.HW6;

import org.junit.jupiter.api.Test;

public class AddToLibraryTest extends AbstractTest{
    @Test
    void checkAddToLibraryTest(){
        AddToLibrary addToLibrary = new AddToLibrary(getWebDriver());
        addToLibrary.popularBookClick()
                .addToLibraryClick()
                .readButtonClick();
    }
}
