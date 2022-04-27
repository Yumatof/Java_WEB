package org.example.HW7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends AbstractTest {

    @Test
    public void searchTxtTest(){
        org.example.HW6.Search search = new Search(getWebDriver());
        search.elementSearchClick()
                .inputTxtArea("коjjjшка\n");
        assertTrue(search.checkListAuthors(), String.valueOf(true));
        assertTrue(search.checkListArtworks(), String.valueOf(true));
        assertTrue(search.checkListPosts(), String.valueOf(true));
        assertTrue(search.checkListIllustrations(),String.valueOf(true));
        assertTrue(search.checkListCollections(),String.valueOf(true));
    }

}

