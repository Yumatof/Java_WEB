package org.example.HW6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends AbstractTest{

    @Test
    public void searchTxtTest(){
        Search search = new Search(getWebDriver());
        search.elementSearchClick()
                .inputTxtArea("кошка\n");
        assertTrue(search.checkListAuthors(), String.valueOf(true));
        assertTrue(search.checkListArtworks(), String.valueOf(true));
        assertTrue(search.checkListPosts(), String.valueOf(true));
        assertTrue(search.checkListIllustrations(),String.valueOf(true));
        assertTrue(search.checkListCollections(),String.valueOf(true));
    }

}
